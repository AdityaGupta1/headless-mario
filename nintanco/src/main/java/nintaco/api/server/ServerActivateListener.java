package nintaco.api.server;

import nintaco.api.*;
import static nintaco.api.local.EventTypes.*;

public class ServerActivateListener extends ServerListener 
    implements ActivateListener {

  public ServerActivateListener(final ListenerLocker locker, 
      final DataStream stream, final int listenerID) {
    super(locker, stream, Activate, listenerID);
  }

  @Override
  public void apiEnabled() {
    listenerInvoked();
  }  
}
