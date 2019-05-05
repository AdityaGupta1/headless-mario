package nintaco.api.server;

import nintaco.api.*;
import static nintaco.api.local.EventTypes.*;

public class ServerFrameListener extends ServerListener 
    implements FrameListener {
  
  public ServerFrameListener(final ListenerLocker locker, 
      final DataStream stream, final int listenerID) {
    super(locker, stream, Frame, listenerID);
  }

  @Override
  public void frameRendered() {
    listenerInvoked();
  }  
}
