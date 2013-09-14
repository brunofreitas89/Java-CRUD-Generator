/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;

/**
 *
 * @author brunofreitas
 */
public class Aplicacao
{
    public static int CRUD_FP2 = 1;
    public static int CRUD_FP3 = 2;
    
    int tipoDeAplicacao;
    
    ArrayList<Variavel> variaveis = new ArrayList<Variavel>();

    public ArrayList<Variavel> getVariaveis()
    {
        return variaveis;
    }

    public void setVariaveis(ArrayList<Variavel> variaveis)
    {
        this.variaveis = variaveis;
    }

    public int getTipoDeAplicacao()
    {
        return tipoDeAplicacao;
    }

    public void setTipoDeAplicacao(int tipoDeAplicacao)
    {
        this.tipoDeAplicacao = tipoDeAplicacao;
    }

    public Aplicacao(int tipoDeAplicacao)
    {
        this.tipoDeAplicacao = tipoDeAplicacao;
    }
    
    public int getSizeOf()
    {
        int sizeOf = 0;
        for(Variavel variavel : getVariaveis())
        {
            if(variavel.getTipo().equalsIgnoreCase("StringBufferModelo"))
            {
                sizeOf+=variavel.getTamanhoMaximo()*2;
            }
            else
            {
                if(variavel.getTipo().equalsIgnoreCase("int"))
                {
                    sizeOf+=4;
                }
            }
            
        }
        return  sizeOf;
    }
    
    public Variavel getChave()
    {
        for(Variavel variavel : getVariaveis())
        {
            if(variavel.isChave())
            {
                return variavel;
            }
                
        }
        return null;
    }
    
    
    
}
