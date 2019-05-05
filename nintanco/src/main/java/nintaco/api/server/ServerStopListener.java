package nintaco.api.server;

import nintaco.api.*;
import static nintaco.api.local.EventTypes.*;

public class ServerStopListener extends ServerListener implements StopListener {

  public ServerStopListener(final ListenerLocker locker, 
      final DataStream stream, final int listenerID) {
    super(locker, stream, Stop, listenerID);
  }

  @Override
  public void dispose() {
    listenerInvoked();
  }  
}
