package nintaco.api.local;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import java.util.jar.*;
import nintaco.util.*;
import static nintaco.util.CollectionsUtil.*;

public class JarClassLoader extends URLClassLoader {

  private static final Class[] mainArgs = { String[].class };
  
  private final URL url;
  
  public JarClassLoader(final String fileName) throws Throwable {
    this(Paths.get(fileName));
  }
  
  public JarClassLoader(final Path path) throws Throwable {
    this(path.toUri().toURL());
  }
  
  public JarClassLoader(final File file) throws Throwable {
    this(file.toURI().toURL());
  }

  public JarClassLoader(final URL url) {
    super(new URL[] { url });
    this.url = url;
  }
  
  public String[] getMainClassNames() throws Throwable {
    
    final List<String> classNames = new ArrayList<>();    
    try (final JarInputStream in = new JarInputStream(url.openStream())) {    
      JarEntry entry = null;
      while((entry = in.getNextJarEntry()) != null) {
        final String className = getMainClassName(entry.getName());
        if (className != null) {
          classNames.add(className);
        }
      }
    }
    
    final String defaultClassName = getDefaultMainClassName();
    if (defaultClassName != null && classNames.contains(defaultClassName)) {
      classNames.remove(defaultClassName);
      classNames.add(0, defaultClassName);
    }
    
    return convertToArray(classNames);
  }
  
  private String getMainClassName(final String entryName) {
    if (entryName != null && entryName.endsWith(".class")) {
      final String result = entryName.substring(0, entryName.length() - 6)
          .replaceAll("/", ".");
      if (result.isEmpty() || result.endsWith(".") || !isMainClass(result)) {
        return null;
      } else {
        return result;
      }
    } else {
      return null;
    }
  }
  
  private boolean isMainClass(final String className) {    
    try {
      final Method m = loadClass(className).getMethod("main", mainArgs);
      m.setAccessible(true);

      final int modifiers = m.getModifiers();
      if (m.getReturnType() != void.class || !Modifier.isStatic(modifiers)
          || !Modifier.isPublic(modifiers)) {
        return false;
      }
    } catch(final Throwable t) {      
      return false;
    }
    return true;
  }

  private String getDefaultMainClassName() throws IOException {
    JarURLConnection connection = null;
    try {
      connection = (JarURLConnection)new URL("jar", "", url + "!/")
          .openConnection();
      final Attributes attr = connection.getMainAttributes();
      final String className = attr != null 
          ? attr.getValue(Attributes.Name.MAIN_CLASS) : null;
      return StringUtil.isBlank(className) ? null : className;
    } finally {
      if (connection != null) {
        try {
          connection.getJarFile().close();
        } catch(final Throwable t) {          
        }
      }
    }
  }
  
  public void runMain(final String className, final String[] arguments)
      throws Throwable {
    
    final Method m = loadClass(className).getMethod("main", mainArgs);
    m.setAccessible(true);
    
    final int mods = m.getModifiers();
    if (m.getReturnType() != void.class || !Modifier.isStatic(mods)
        || !Modifier.isPublic(mods)) {
      throw new NoSuchMethodException("main");
    }
    
    m.invoke(null, new Object[] { arguments } );
  }  

  @Override
  public void close() throws IOException {
    super.close();    
    for(final URL url : getURLs()) {
      if ("jar".equals(url.getProtocol())) {
        try {
          ((JarURLConnection)url.openConnection()).getJarFile().close();
        } catch(final Throwable t) {          
        }
      }
    }
  }
}
