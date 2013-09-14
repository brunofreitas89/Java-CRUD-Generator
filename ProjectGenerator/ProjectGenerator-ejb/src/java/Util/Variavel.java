/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author brunofreitas
 */
public class Variavel
{

    String nome, tipo, interfaceGrafica, label;
    String [] selectionValues;
    boolean chave;
    int tamanhoMaximo;

    public Variavel()
    {
        this.nome = "";
        this.tipo = "";
        this.interfaceGrafica = "";
        this.chave = false;
        this.tamanhoMaximo = 0;
    }

    public Variavel(String nome, String tipo, String interfaceGrafica, String label, boolean chave, int tamanhoMaximo)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.interfaceGrafica = interfaceGrafica;
        this.label = label;
        this.chave = chave;
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public String[] getSelectionValues()
    {
        return selectionValues;
    }

    public void setSelectionValues(String[] selectionValues)
    {
        this.selectionValues = selectionValues;
    }
    
    public Variavel(String nome, String tipo, String interfaceGrafica, boolean chave)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.interfaceGrafica = interfaceGrafica;
        this.chave = chave;
    }

    public Variavel(String nome, String tipo, String interfaceGrafica, boolean chave, int tamanhoMaximo)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.interfaceGrafica = interfaceGrafica;
        this.chave = chave;
        this.tamanhoMaximo = tamanhoMaximo;
    }
    
    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public int getTamanhoMaximo()
    {
        return tamanhoMaximo;
    }

    public void setTamanhoMaximo(int tamanhoMaximo)
    {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public boolean isChave()
    {
        return chave;
    }

    public void setChave(boolean chave)
    {
        this.chave = chave;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getInterfaceGrafica()
    {
        return interfaceGrafica;
    }

    public void setInterfaceGrafica(String interfaceGrafica)
    {
        this.interfaceGrafica = interfaceGrafica;
    }

    public String getGetterName()
    {
        String getterName = getNome().charAt(0) + "";
        getterName = getterName.toUpperCase();
        getterName += getNome().substring(1);
        return "get" + getterName;
    }

    public String getSetterName()
    {
        String setterName = getNome().charAt(0) + "";
        setterName = setterName.toUpperCase();
        setterName += getNome().substring(1);
        return "set" + setterName;
    }

    public String getDefaultValue()
    {
        String str = "";

        if (getTipo().equalsIgnoreCase("int"))
        {
            str = "0";
        } 
        else
        {
            if (getTipo().equalsIgnoreCase("String"))
            {
                str = "\"\"";
            } 
            else
            {
                if (getTipo().equalsIgnoreCase("StringBufferModelo"))
                {
                    str = "new StringBufferModelo(\"\", " + getTamanhoMaximo() + ")";
                } 
                else
                {
                    str = "null";
                }
            }
        }

        return str;
    }

    public String getLabelObjectName()
    {
        String str = "";
        str+="jLabel" + ((getNome().charAt(0)+"").toUpperCase()) + getNome().substring(1);
        return str;
    }

    public String getUIObjectName()
    {
        String str = "";
        str+=((getInterfaceGrafica().charAt(0)+"").toLowerCase()) + getInterfaceGrafica().substring(1) + ((getNome().charAt(0)+"").toUpperCase()) + getNome().substring(1);
        return str;
    }
    
    public String getLabelDefaultValue()
    {
        String str = "";
        str+="new JLabel(\"" + getLabel() + "\")";
        return str;
    }
    
    public String getUIDefaultValue()
    {
        String str = "";
        str+="new " + getInterfaceGrafica() + "()";
        return str;
    }
    
    
    
}
