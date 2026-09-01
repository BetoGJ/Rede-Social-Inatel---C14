package Sockets;

import java.net.Socket;

public class MockSocket extends Socket {

    public boolean fechado = true;

    @Override
    public boolean isClosed()
    {
        return fechado ;
    }
}
