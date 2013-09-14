package Writer;


import Util.Aplicacao;
import Util.Variavel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Formatter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */

public class Writer {
    
   Formatter writer;
   Aplicacao app;
   String caminho;
   
   public Writer(Aplicacao app, String caminho)
   {
      this.app = app;
      this.caminho = caminho;
   }
   
   public void abrir(String nomeDoFicheiro)
   {
        try 
        {
            writer  = new Formatter(nomeDoFicheiro);
        } 
        catch (Exception ex) 
        {
            System.err.println(ex.getMessage());
        }
   }
   
   public void write(String codigo)
   {
       writer.format(codigo);
   }
   
   public void fechar()
   {
       //compilador.close();
       writer.close();
   }
   
   public String setSpace()
   {
       return "    ";
   }
   
   public String writeClass(String nomeClass, String code)
   {
       String str="";
       str+= "public class " + nomeClass + " \n"
              + "{\n"
               + code
              + "}\n"; 
       return str;
   }
   
   public String writeClass(String nomeClass, String superClass, String code)
   {
       String str="";
       str+= "public class " + nomeClass + " extends "+ superClass +"\n"
              + "{\n"
               + code
              + "}\n"; 
       return str;
   }
   
   public String writeClass(String nomeClass, String implementedClasses[], String code)
   {
       String str="";
       str+= "public class " + nomeClass + " implements ";
       for(int i = 0; i<implementedClasses.length; i++)
       {
           if(i==0)
           {
               str+=implementedClasses[i];
           }
           else
           {
               str+=", " + implementedClasses[i];
           }
       }
           
       str+="\n"
              + "{\n"
               + code
              + "}\n"; 
       return str;
   }
   
   public String writeClass(String nomeClass, String superClass , String implementedClasses[], String code)
   {
       String str="";
       str+= "public class " + nomeClass + " extends " + superClass + " implements ";
       for(int i = 0; i<implementedClasses.length; i++)
       {
           if(i==0)
           {
               str+=implementedClasses[i];
           }
           else
           {
               str+=", " + implementedClasses[i];
           }
       }
           
       str+="\n"
              + "{\n"
               + code
              + "}\n"; 
       return str;
   }
   
   public String writeCostructor(String nomeClass, String code)
   {
       String str="";
       str+= "public " + nomeClass + "() \n"
              + "{\n"
               + code
              + "}\n"; 
       return str;
   }
   
   public String writeCostructor(String nomeClass,String [] parametros, String code)
   {
       String str="";
       str+= "public " + nomeClass + "(";
       if(parametros!=null)
        {
            for(int i=0; i<parametros.length; i++)
            {
                if(i==0)
                {
                    str+=parametros[i];
                }
                else
                {
                    str+=", " + parametros[i];
                }
            }
        }
             str+=") \n"
              + "{\n"
               + code
              + "}\n"; 
       return str;
   }
   
   public String writeMain(String code)
   {
       String str="";
       str+= "public static void main(String args[])\n"
              + "{\n"
               + code + "\n"
              +"}\n";
             
       return str;
   }
    
    public String writePrint(String code)
    {
        String str="";
        str =  "        System.out.println(\""
                  + code 
                  + "\");\n";
        return str;
    }
    
    public String writeSetter(Variavel variavel)
    {
        String str;
        if(variavel.getTipo().equalsIgnoreCase("StringBufferModelo"))
        {
            str = "public void " + variavel.getSetterName() + "(String " + variavel.getNome() + ")\n"
                + "{\n"
                + "this." + variavel.getNome() + " = new " + variavel.getTipo() + "("+ variavel.getNome() +".trim(), "+ variavel.getTamanhoMaximo() +");\n"
                + "}\n";
        }
        else
        {
            str = "public void " + variavel.getSetterName() + "(" + variavel.getTipo() + " " + variavel.getNome() + ")\n"
                + "{\n"
                + "this." + variavel.getNome() + " = " + variavel.getNome() + ";\n"
                + "}\n";
        }
        
        return str;
    }
    
    public String writeGetter(Variavel variavel)
    {
        String str;
        if(variavel.getTipo().equalsIgnoreCase("StringBufferModelo"))
        {
           str = "public String " + variavel.getGetterName() + "()\n"
                + "{\n"
                + "return " + variavel.getNome() + ".toStringEliminatingSpaces();\n"
                + "}\n"; 
        }
        else
        {
            str = "public "+ variavel.getTipo() + " " + variavel.getGetterName() + "()\n"
                + "{\n"
                + "return " + variavel.getNome() + ";\n"
                + "}\n";
        }
        
        return str;
    }
    
    public String writeMethod(String tipo, String retorno, String nome, String parametros[], String code)
    {
        String str = "";
        str+= tipo + " " + retorno + " " + nome + "("; 
        if(parametros!=null)
        {
            for(int i=0; i<parametros.length; i++)
            {
                if(i==0)
                {
                    str+=parametros[i];
                }
                else
                {
                    str+=", " + parametros[i];
                }
            }
        }
        str+=")\n"
            + "{\n"
            + setSpace() + code + "\n"
            + "}\n";
        return str;
    }
    
    public String writeMethod(String tipo, String retorno, String nome, String parametros[], String exceptionClassName, String code)
    {
        String str = "";
        str+= tipo + " " + retorno + " " + nome + "("; 
        if(parametros!=null)
        {
            for(int i=0; i<parametros.length; i++)
            {
                if(i==0)
                {
                    str+=parametros[i];
                }
                else
                {
                    str+=", " + parametros[i];
                }
            }
        }
        str+=") throws "+ exceptionClassName +"\n"
            + "{\n"
            + setSpace() + code + "\n"
            + "}\n";
        return str;
    }
    
    public String writeMethodGravarRegisto(ArrayList<Variavel> variaveis)
    {
        String str = "";
        String code = "";
        String parametros[] = {"RandomAccessFile stream"};
        for(Variavel variavel : variaveis)
        {
            if(variavel.getTipo().equalsIgnoreCase("StringBufferModelo"))
            {
                code+=variavel.getNome() + ".write(stream);\n";
            }
            else
                if(variavel.getTipo().equalsIgnoreCase("int"))
                {
                    code+="stream.writeInt(" + variavel.getNome() + ");\n";
                }
        }
        
        return str+=writeMethod("public", "void", "gravarRegisto", parametros, "IOException" ,  code);
    }
    
    public String writeMethodLerRegisto(ArrayList<Variavel> variaveis)
    {
        String str = "";
        String code = "";
        String parametros[] = {"RandomAccessFile stream"};
        for(Variavel variavel : variaveis)
        {
            if(variavel.getTipo().equalsIgnoreCase("StringBufferModelo"))
            {
                code+=variavel.getNome() + ".read(stream);\n";
            }
            else
                if(variavel.getTipo().equalsIgnoreCase("int"))
                {
                    code+=variavel.getNome()+ " = stream.readInt();\n";
                }
        }
        
        return str+=writeMethod("public", "void", "lerRegisto", parametros, "IOException" ,  code);
    }
    
    public String writeMethodGravarRegistoVazio(ArrayList<Variavel> variaveis)
    {
        String str = "";
        String code = "";
        String parametros[] = {"RandomAccessFile stream"};
        for(Variavel variavel : variaveis)
        {
            if(variavel.getTipo().equalsIgnoreCase("StringBufferModelo"))
            {
                code+="new StringBufferModelo(\"\", "+ variavel.getTamanhoMaximo() +").write(stream);\n";
            }
            else
                if(variavel.getTipo().equalsIgnoreCase("int"))
                {
                    code+="stream.writeInt(" + 0 + ");\n";
                }
        }
        
        return str+=writeMethod("public", "void", "gravarRegistoVazio", parametros, "IOException" ,  code);
    }
    
    public String writeDeclare(Variavel variavel)
    {
        String str;
        str = variavel.getTipo() + " " + variavel.getNome() + ";\n";
        return str;
    }
    
    public String writeDeclare(String className, String objectName)
    {
        String str;
        str = className + " " + objectName + ";\n";
        return str;
    }
    
    public String writeDeclares(ArrayList<Variavel> variaveis)
    {
        String str = "";
        for(Variavel aux : variaveis)
        {
            str+=writeDeclare(aux);
        }
        return str;
    }
    
    public String writeDeclareLabel(Variavel variavel)
    {   
        return writeDeclare("JLabel", variavel.getLabelObjectName());
    }
    
    public String writeDeclareLabels(ArrayList<Variavel> variaveis)
    {   
        String str = "";
        for(Variavel variavel : variaveis)
        {
            str+=writeDeclareLabel(variavel);
        }
        return str;
        
    }
    
    public String writeDeclareUI(Variavel variavel)
    {   
        return writeDeclare(variavel.getInterfaceGrafica(), variavel.getUIObjectName());
    }
    
    public String writeDeclareUIs(ArrayList <Variavel> variaveis)
    {   
        String str = "";
        for(Variavel variavel : variaveis)
        {
            str+=writeDeclareUI(variavel);
        }
        return str;
    }
    
    public String writeMethodCall(String method)
    {
        String str = "";
        str+=method + ";\n";
        return str;
    }
    
    public String writeMethodCall(String variavel, String method)
    {
        String str = "";
        str+=variavel+"."+writeMethodCall(method);
        return str;
    }
    
    public String writeAttribution(String variable, String value)
    {
        String str = "";
        str+=variable + " = " + value + ";\n";
        return str;
    }
    
    public String writeIf(String condition, String code)
    {
        String str = "";
        str+="if(" + condition + ")\n"
                + "{\n"
                + code + "\n"
                + "}\n";
        return str;
    }
    
    public String writeElse(String code)
    {
        String str = "";
        str+="else\n"
                + "{\n"
                + code + "\n"
                + "}\n";
        return str;
    }
    
    public String writeInitialize(Variavel variavel)
    {
        String str;
        str = variavel.getNome() + " = " + variavel.getDefaultValue() + ";\n";
        return str;
    }
    
    public String writeInitializes(ArrayList<Variavel> variaveis)
    {
        String str = "";
        for(Variavel variavel : variaveis)
        {
            str+=writeInitialize(variavel);
        }
        
        return str;
    }
    
    public String writeUIInitialize(Variavel variavel)
    {
        String str = "";
        str+=writeAttribution(variavel.getUIObjectName(), variavel.getUIDefaultValue());
        return str;
    }
    
    public String writeUIInitializes(ArrayList<Variavel> variaveis)
    {
        String str = "";
        for(Variavel variavel : variaveis)
        {
            str+=writeUIInitialize(variavel);
        }
        return str;
    }
    
    public String writeLabelInitialize(Variavel variavel)
    {
        String str = "";
        str+=writeAttribution(variavel.getLabelObjectName(), variavel.getLabelDefaultValue());
        return str;
    }
    
    public String writeLabelInitializes(ArrayList<Variavel> variaveis)
    {
        String str = "";
        for(Variavel variavel : variaveis)
        {
            str+=writeLabelInitialize(variavel);
        }
        return str;
    }
    
    public String writeImport(String pacote)
    {
        String str = "";
        str+="import " + pacote + ";\n";
        return str;
    }
    
    public String writeImports(String ...pacotes)
    {
        String str = "";
        for(String aux : pacotes)
        {
            str+="import " + aux + ";\n";
        }
        return str;
    }
    
    public String writeSettersAndGetters(ArrayList<Variavel> variaveis)
    {
        String str = "";
        for(Variavel aux : variaveis)
        {
            str+=writeSetter(aux);
            str+=writeGetter(aux);
        }
        return str;
    }
    
    public String writeAddComponent(String component, Variavel variavel)
    {
        String str = "";
        str+=writeMethodCall(component, "add("+ variavel.getLabelObjectName() +")");
        str+=writeMethodCall(component, "add("+ variavel.getUIObjectName() +")");
        return str;
    }
    
    public String writeAddComponents(String component, ArrayList<Variavel> variaveis)
    {
        String str = "";
        for(Variavel variavel : variaveis)
        {
            str+=writeAddComponent(component, variavel);
        }
        return str;
    }
    
    public String writeAddActionListener(String componente, String code)
    {
        String str = "";
        str+=componente + ".addActionListener(new ActionListener()\n"
                + "{\n"
                + "public void actionPerformed(ActionEvent e)"
                + "{\n"
                + code
                + "}"
                + "});\n";
        return str;
    }
    
    public String writeShowMessageDialog(String message)
    {
        String str = "";
        str+="JOptionPane.showMessageDialog(null, \""+ message +"\");\n";
        return str;
    }
    
    public String writeShowModelData(ArrayList <Variavel> variaveis)
    {
        String str = "";
        for(Variavel aux : variaveis)
        {
            if(aux.getInterfaceGrafica().equalsIgnoreCase("JTextField"))
            {
                if(aux.getTipo().equalsIgnoreCase("StringBufferModelo"))
                {
                    str+=writeMethodCall(aux.getUIObjectName(), "setText(modelo."+ aux.getGetterName()+"()" +")");
                }
                else
                {
                    if(aux.getTipo().equalsIgnoreCase("int"))
                    {
                        str+=writeMethodCall(aux.getUIObjectName(), "setText(modelo."+ aux.getGetterName()+"()+\"\"" +")");
                    }
                }
            }
            else
            {
                continue;
            }
        }
        return str;
    }
    
    public String writeCleanInterface(ArrayList<Variavel> variaveis)
    {
        String str = "";
        for(Variavel aux : variaveis)
        {
            if(aux.getInterfaceGrafica().equalsIgnoreCase("JTextField"))
                str+=writeMethodCall(aux.getUIObjectName(), "setText(\"\")");
            else 
                continue;
        }
        return str;
    }
    
    public String writeLoadModel(ArrayList<Variavel> variaveis)
    {
        String str = "";
        for(Variavel aux : variaveis)
        {
            if(aux.getInterfaceGrafica().equalsIgnoreCase("JTextField"))
            {
                if(aux.getTipo().equalsIgnoreCase("int"))
                {
                    str+=writeMethodCall("modelo", aux.getSetterName()+"(Integer.parseInt("+ aux.getUIObjectName()+".getText()" +"))");
                }
                else
                {
                    str+=writeMethodCall("modelo", aux.getSetterName()+"("+ aux.getUIObjectName()+".getText()" +")");
                }
            }
        }
        return str;
    }
    
    public void writeModelo(String nomeClass)
    {
        String implementedClasses[] = {"Gravavel"};
        if(app.getTipoDeAplicacao()==app.CRUD_FP2)
        {
            new File(caminho).mkdir();
            abrir(caminho+nomeClass+".java");
            
            String codigoModelo = "";
            codigoModelo+=writeImports("SwingComponents.*", "java.io.*");
            
            codigoModelo+=writeClass(nomeClass, implementedClasses ,
                    writeDeclares(app.getVariaveis()) 
                    + writeCostructor(nomeClass, writeInitializes(app.getVariaveis()))
                    + writeSettersAndGetters(app.getVariaveis())
                    + writeMethod("public", "Gravavel", "getNovaInstancia", null, "return new " + nomeClass + "();")
                    + writeMethod("public", "int", "getSizeof", null, "return "+ app.getSizeOf() + ";")
                    + writeMethod("public", "Object", "getChave", null, "return "+ app.getChave().getGetterName() + "();")
                    + writeMethodGravarRegisto(app.getVariaveis())
                    + writeMethodGravarRegistoVazio(app.getVariaveis())
                    + writeMethodLerRegisto(app.getVariaveis())
                    );

            write(codigoModelo);
            copiarFicheiros(new File("files/Gravavel.java"), new File(caminho + "Gravavel.java"));
            copiarFicheiros(new File("files/Gravador.java"), new File(caminho + "Gravador.java"));
            copiarFicheiros(new File("files/SwingComponents"), new File(caminho + "SwingComponents"));
            fechar();
        }
    }
    
    public void writeVisao(String nomeClass, String nomeClassModelo, String tituloJanela, String nomeFicheiro)
    {
        String parametrosConstructor[] = {nomeClassModelo+" modelo","boolean editar"};
        
        if(app.getTipoDeAplicacao()==app.CRUD_FP2)
        {
            new File(caminho).mkdir();
            abrir(caminho+nomeClass+".java");
            
            String codigoVisao = "";
            codigoVisao+=writeImports("java.awt.*", "java.awt.event.*", "java.util.*", "javax.swing.*");
            
            codigoVisao+=
            writeClass(nomeClass, "JFrame" ,
                writeDeclare(nomeClassModelo, "modelo") 
                + writeDeclare("Gravador", "gravador") 
                + writeDeclare("boolean", "editar") 
                + writeDeclare("JPanel", "painelCentro") 
                + writeDeclare("JPanel", "painelSul") 
                + writeDeclare("JButton", "btSalvar") 
                + writeDeclare("JButton", "btCancelar") 
                + writeDeclare("JButton", "btLimpar") 
                + writeDeclareLabels(app.getVariaveis())
                + writeDeclareUIs(app.getVariaveis())
                + writeCostructor(nomeClass,parametrosConstructor ,
                    writeMethodCall("super(\"" + tituloJanela + "\")")
                    + writeAttribution("this.editar", "editar")
                    + writeAttribution("this.modelo", "modelo")
                    + writeMethodCall("inicializarComponentes()")
                    + writeMethodCall("adicionarComponentes()")
                    + writeMethodCall("definirPropriedades()")
                    + writeIf("this.editar",
                        writeMethodCall("mostrarDados()")
                    )
                    + writeMethodCall("mostrarGUI()")
                )
                + writeMethod("private", "void", "inicializarComponentes", null, 
                    writeAttribution("gravador", "new Gravador(\""+ nomeFicheiro +"\", modelo)")
                    + writeAttribution("painelCentro", "new JPanel(new GridLayout(0,2))")
                    + writeAttribution("painelSul", "new JPanel()")
                    + writeAttribution("btSalvar", "new JButton(\"Salvar/Actualizar\")")
                    + writeAttribution("btCancelar", "new JButton(\"Cancelar\")")
                    + writeAttribution("btLimpar", "new JButton(\"Limpar\")")
                    + writeUIInitializes(app.getVariaveis())
                    + writeLabelInitializes(app.getVariaveis())
                )
                + writeMethod("private", "void", "adicionarComponentes", null, 
                    writeAddComponents("painelCentro", app.getVariaveis())
                    + writeMethodCall("painelSul", "add(btSalvar)")
                    + writeMethodCall("painelSul", "add(btLimpar)")
                    + writeMethodCall("painelSul", "add(btCancelar)")
                    + writeMethodCall("add(painelCentro, BorderLayout.CENTER)")
                    + writeMethodCall("add(painelSul, BorderLayout.SOUTH)")
                )
                + writeMethod("private", "void", "definirPropriedades", null, 
                    writeAddActionListener("btSalvar", 
                        writeIf("editar", 
                            writeMethodCall("carregarModelo()")
                            + writeIf("gravador.editarRegisto(modelo."+ app.getChave().getGetterName() +"(), modelo)", 
                                writeShowMessageDialog("Dados actualizados com sucesso!")
                                + writeMethodCall("limpar()")
                            )
                            + writeElse(
                                writeShowMessageDialog("Erro ao actualizar o registo!")
                            )
                        )
                        + writeElse(
                            writeMethodCall("carregarModelo()")
                            + writeIf("gravador.gravar(modelo)",
                                writeShowMessageDialog("Dados gravados com sucesso!")
                                + writeMethodCall("limpar()")
                            )
                            + writeElse(
                                writeShowMessageDialog("Erro ao gravar o registo!")
                            )
                        )
                    )
                    + writeAddActionListener("btLimpar", 
                        writeMethodCall("limpar()")
                    )
                    + writeAddActionListener("btCancelar", 
                        writeMethodCall("dispose()")
                    )
                )
                + writeMethod("public", "void", "mostrarGUI", null, 
                    writeMethodCall("setDefaultCloseOperation(EXIT_ON_CLOSE)")
                    + writeMethodCall("setSize(500, 200 + 50 * "+app.getVariaveis().size()+")")
                    + writeMethodCall("setVisible(true)")
                    + writeMethodCall("setLocationRelativeTo(null)")
                )
                + writeMethod("public", "void", "mostrarDados", null, 
                    writeShowModelData(app.getVariaveis())
                )
                + writeMethod("public", "void", "limpar", null, 
                    writeCleanInterface(app.getVariaveis())
                )
                + writeMethod("public", "void", "carregarModelo", null, 
                    writeLoadModel(app.getVariaveis())
                )
                + writeMain("new "+nomeClass+"(new "+nomeClassModelo+"(), false);")
                    
            );

            write(codigoVisao); 
            
            fechar();
        }
    }
    
    public void writeApresentacao(String nomeClass, String nomeClassMenu, String tituloJanela, String textoApresentacao, String caminhoImagem)
    {
        if(app.getTipoDeAplicacao()==app.CRUD_FP2)
        {
            createFile(nomeClass);
            
            String codigoApresentacao = "";
            codigoApresentacao
            +=writeImports("java.awt.*", "java.awt.event.*", "java.util.*", "javax.swing.*")
            + writeClass(nomeClass, "JFrame", 
                    writeDeclare("JPanel", "painelCentral")
                    + writeDeclare("JPanel", "painelSul")
                    + writeDeclare("JTextArea", "texto")
                    + writeDeclare("JButton", "botaoOK")
                    + writeDeclare("JButton", "botaoCancelar")
                    + writeDeclare("String", "stringTexto")
                    + writeDeclare("ImageIcon", "img")
                    + writeDeclare("JLabel", "labelImagem")
                    + writeCostructor(nomeClass, 
                        writeMethodCall("super(\""+ tituloJanela +"\")")
                        + writeMethodCall("inicializarComponentes()")
                        + writeMethodCall("adicionarComponentes()")
                        + writeMethodCall("definirPropriedades()")
                        + writeMethodCall("mostrarGUI()")
                        + writeAttribution("stringTexto", "\"" + textoApresentacao + "\"")
                    )
                    + writeMethod("public", "void", "inicializarComponentes", null, 
                        writeAttribution("painelCentral", "new JPanel(new BorderLayout())")
                        + writeAttribution("painelSul", "new JPanel()")
                        + writeAttribution("texto", "new JTextArea(stringTexto)")
                        + writeAttribution("botaoOK", "new JButton(\"OK\")")
                        + writeAttribution("botaoCancelar", "new JButton(\"Cancelar\")")
                        + writeAttribution("img", "new ImageIcon(\""+ caminhoImagem +"\")")
                        + writeAttribution("labelImagem", "new JLabel(img)")
                    )
                    
                    + writeMethod("public", "void", "adicionarComponentes", null, 
                        writeMethodCall("painelCentral", "add(labelImagem, BorderLayout.CENTER)")
                        + writeMethodCall("painelCentral", "add(texto, BorderLayout.SOUTH)")
                        + writeMethodCall("painelSul", "add(botaoOK)")
                        + writeMethodCall("painelSul", "add(botaoCancelar)")
                        + writeMethodCall("add(painelCentral, BorderLayout.CENTER)")
                        + writeMethodCall("add(painelSul, BorderLayout.SOUTH)")
                    )
                    + writeMethod("public", "void", "definirPropriedades", null, 
                        writeMethodCall("texto", "setLineWrap(true)")
                        + writeAddActionListener("botaoOK", 
                            writeMethodCall("new "+ nomeClassMenu +"()")
                            + writeMethodCall("dispose()")
                        )
                        + writeAddActionListener("botaoCancelar", 
                            writeMethodCall("dispose()")
                        )
                    )
                    + writeMethod("public", "void", "mostrarGUI", null, 
                        writeMethodCall("setSize(labelImagem.getIcon().getIconWidth(), labelImagem.getIcon().getIconHeight() + 150)")
                        + writeMethodCall("setVisible(true)")
                        + writeMethodCall("setDefaultCloseOperation(EXIT_ON_CLOSE)")
                        + writeMethodCall("setLocationRelativeTo(null)")
                    )
                    + writeMain(
                        writeMethodCall("new " + nomeClass + "()")
                    )
                    
                    );
            
            write(codigoApresentacao);
            fechar();
        }
    }
    
    public void writeMenu()
    {
        
    }
    
    public void createFile(String nomeClass)
    {
        new File(caminho).mkdir();
        abrir(caminho+nomeClass+".java");
    }
    
    public void copiarFicheiros(File src, File dest)
    {
 
    	if(src.isDirectory())
        {
    		//if directory not exists, create it
    		if(!dest.exists())
                {
    		   dest.mkdir();
    		   System.out.println("Directorio copiado de " + src + "  para " + dest);
    		}
    		//list all the directory contents
    		String files[] = src.list();
    		for (String file : files)
                {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copiarFicheiros(srcFile,destFile);
    		}
    	}
        else
        {
            try
            {
                //if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
 
    	        byte[] buffer = new byte[1024];
 
    	        int length;
    	        //copy the file content in bytes 
    	        while ((length = in.read(buffer)) > 0)
                {
    	    	   out.write(buffer, 0, length);
    	        }
 
    	        in.close();
    	        out.close();
    	        System.out.println("Ficheiro copiado de " + src + " para " + dest);
            }
            catch(FileNotFoundException ex)
            {
                ex.printStackTrace();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
    	}
    }
    
    
}
