package Cliente;
import org.example.Cliente;
import org.example.ClienteSocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestCliente
{
     ClienteSocket clienteSocket;

    @BeforeEach
    public  void configurarSocket() throws IOException
    {
        clienteSocket = Mockito.mock(ClienteSocket.class);
    }
    @Test
    public void testClienteSocketNull ()
    {
        assertThrows(IllegalArgumentException.class,() ->{
            Cliente cliente = new Cliente(null);
        });
    }
}
