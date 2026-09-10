package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.IllegalFormatWidthException;

public class Servidor {
    public Servidor(){
        try (ServerSocket socketServidor = new ServerSocket(8089);
             Socket conexao = socketServidor.accept();
        ) {
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
        }
        catch(IOException e){
            e.printStackTrace();
        };
    }
}
