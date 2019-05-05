package nintaco.gui;

import javax.swing.event.*;

public class ListChangedAdapter implements ListDataListener {

  private final Runnable target;
  
  public ListChangedAdapter(final Runnable target) {
    this.target = target;
  }
  
  @Override
  public void intervalAdded(ListDataEvent e) {
    target.run();
  }

  @Override
  public void intervalRemoved(ListDataEvent e) {
    target.run();
  }

  @Override
  public void contentsChanged(ListDataEvent e) {
    target.run();
  }  
}
