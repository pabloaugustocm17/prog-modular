package autor;

import java.util.ArrayList;
import java.util.List;

import app.Main;
import livro.Livro;

public class Autor {
    
    private String nome_autor;
    //private List<Livro> livros_autor;


    /* Métodos */

    public void imprimiAutor(){

        System.out.println("Nome autor: " + this.nome_autor);
        System.out.println("Livros do autor: ");

        for(Livro livro : Main.livros){

            livro.imprimiLivro();
            System.out.println("-------------------------");

        }

    }

    /* Construtores */

    private void init(String nome_autor){

        this.nome_autor = nome_autor;

    }

    public Autor(String nome_autor){
        init(nome_autor);
    }

    /* Getters and Setters */

    public String getNome_autor(){
        return this.nome_autor;
    }

}
