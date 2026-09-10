package org.example;

import crud.Usuario;
import java.util.ArrayList

public class Sala {
    private int capacidadeMaxima;
    private int quantidadeUsuarios;
    private static int quantidadeSalas;
    private ArrayList<Usuario> usuariosAtivos = new ArrayList<>();
    public void Sala(capacidadeMaxima){
        quantidadeUsuarios=0;
        quantidadeSalas+=1;
        this.capacidadeMaxima = capacidadeMaxima;
    }
    public void addUsuario(Usuario usuarioNovo){
        if(quantidadeUsuarios<capacidadeMaxima) {
            quantidadeUsuarios += 1;
        }
        usuariosAtivos.add(usuarioNovo);
    }
}
