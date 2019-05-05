package nintaco.api.server;

import nintaco.api.*;
import static nintaco.api.local.EventTypes.*;

public class ServerDeactivateListener extends ServerListener 
    implements DeactivateListener {

  public ServerDeactivateListener(final ListenerLocker locker, 
      final DataStream stream, final int listenerID) {
    super(locker, stream, Deactivate, listenerID);
  }
  
  @Override
  public void apiDisabled() {
    listenerInvoked();
  }  
}
