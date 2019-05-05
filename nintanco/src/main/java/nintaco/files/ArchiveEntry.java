package nintaco.files;

import java.util.*;

public class ArchiveEntry {
  
  public static List<String> toNames(final List<ArchiveEntry> archiveEntries) {
    
    if (archiveEntries == null) {
      return null;
    }
    
    final List<String> names = new ArrayList<>();
    for(int i = 0, length = archiveEntries.size(); i < length; ++i) {
      names.add(archiveEntries.get(i).name);
    }
    
    return names;
  }
  
  public static final Comparator<ArchiveEntry> CASE_INSENSITIVE_ORDER 
      = (a, b) -> String.CASE_INSENSITIVE_ORDER.compare(a.name, b.name);
  
  private final String name;
  private final long size;
  private final int hash;

  public ArchiveEntry(final String name, final long size) {
    this.name = name;
    this.size = size;
    
    hash = 89 * (623 + Objects.hashCode(name)) + (int)(size ^ (size >>> 32));
  }

  public String getName() {
    return name;
  }

  public long getSize() {
    return size;
  }

  @Override public int hashCode() {
    return hash;
  }

  @Override public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    final ArchiveEntry entry = (ArchiveEntry)obj;
    return size == entry.size && Objects.equals(name, entry.name);
  }
  
  @Override public String toString() {
    return String.format("[ %s %d ]", name, size);
  }
}
