package org.example;
import java.io.IOException;


public class Cliente implements Runnable {

    private  String mensagemRecebida;
    private ClienteSocket  clienteSocket;
    private String mensagemEnviada;

    public Cliente(ClienteSocket clienteSocket)
    {
        this.clienteSocket = clienteSocket;
    }

    @Override
    public void run()
    {
        try {
            receberMensagem();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void receberMensagem() throws IOException {
        while((mensagemRecebida = this.clienteSocket.ReceberMensagem() )!=null )
        {
            System.out.println(mensagemRecebida);
        }
    }



}

