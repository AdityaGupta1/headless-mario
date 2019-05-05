package nintaco.logger;

import java.io.*;
import java.util.logging.*;
import static nintaco.files.FileUtil.*;

// https://blogs.oracle.com/nickstephen/entry/java_redirecting_system_out_and

public final class LogUtil {

  private static final String LOG_OFF = "-log=off";
  
  private LogUtil() {    
  }
  
  public static void init(final String... args) throws Throwable {
    for (final String arg : args) {
      if (LOG_OFF.equalsIgnoreCase(arg)) {
        return;
      }
    }

    final LogManager logManager = LogManager.getLogManager();
    logManager.reset();

//    final String systemDir = getWorkingDirectory("system");
//    mkdir(systemDir);
//
//    final Handler fileHandler = new FileHandler(systemDir + File.separator
//        + "nintaco-%g.log", 0x100000, 10, true);
//    fileHandler.setFormatter(new LogFormatter());
//    Logger.getLogger("").addHandler(fileHandler);
//
//    System.setOut(new PrintStream(new LogOutputStream(Logger
//        .getLogger("stdout"), StdOutErrLevel.STDOUT), true));
//    System.setErr(new PrintStream(new LogOutputStream(Logger
//        .getLogger("stderr"), StdOutErrLevel.STDERR), true));
//  }
  }
}
