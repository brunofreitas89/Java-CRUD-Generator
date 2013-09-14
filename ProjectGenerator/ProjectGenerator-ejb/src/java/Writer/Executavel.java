/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Writer;

import Util.Aplicacao;
import Util.Variavel;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author brunofreitas
 */
public class Executavel
{
    Writer writer;
    Aplicacao app;
    String caminho;
    String nomeClassModelo;
    String nomeClassVisao;
    String nomeClassApresentacao;
    String nomeClassMenu;
    String nomeFicheiroDados;
    
    public Executavel()
    {
        app = new Aplicacao(app.CRUD_FP2);
        caminho = "BrunaSara/";
        nomeClassModelo = "Modelo";
        nomeClassVisao = "Visao";
        nomeClassMenu = "MenuPrincipal";
        nomeClassApresentacao = "Apresentacao";
        nomeFicheiroDados = "bruna.dat";
        
        ArrayList<Variavel> variaveis = new ArrayList<Variavel>();
        variaveis.add(new Variavel("something", "StringBufferModelo", "JTextField", "Introduza o seu something", true, 100));
        variaveis.add(new Variavel("qualquercoisa", "StringBufferModelo", "JTextField", "Poe o apelido", false, 100));
        variaveis.add(new Variavel("idade", "int", "JTextField","Insira a sua idade", false,100));
        //variaveis.add(new Variavel("sexo", "StringBufferModelo", "JTextField", "Poe o sexo", false, 100));
        //variaveis.add(new Variavel("idade", "int", "JTextField", "Idade", false,100));
        //variaveis.add(new Variavel("descricao", "StringBufferModelo", "JTextField", "Poe uma descricao randomica", false, 100));
        
        app.setVariaveis(variaveis);
        
        writer = new Writer(app, caminho);
        writer.writeModelo(nomeClassModelo);
        writer.writeVisao(nomeClassVisao, nomeClassModelo, "A bruna eh mah", nomeFicheiroDados);
        //writer.writeApresentacao(nomeClassApresentacao, nomeClassMenu, "Bem Vindo ao Programa", "Este software foi feito por bla bla bla bla etc etc etc", "");
    }
    
    public static void main(String[] args)
    {
        new Executavel();
    }
    
}
