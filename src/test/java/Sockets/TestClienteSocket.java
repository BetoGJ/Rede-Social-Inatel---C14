package Sockets;
import org.example.ClienteSocket;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestClienteSocket {

    @Test
    public void testsocketnull ()
    {
        assertThrows(IllegalArgumentException.class,() ->{
            ClienteSocket clienteSocket = new ClienteSocket(null);
        });
    }

    @Test
    public void testsocketclose ()
    {
        MockSocket socket = new MockSocket();
        assertThrows(IOException.class,() ->{
            ClienteSocket clienteSocket = new ClienteSocket(socket);
        });
    }

}
