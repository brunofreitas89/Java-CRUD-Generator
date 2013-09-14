import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brunofreitas
 */
public class Gravador 
{
    RandomAccessFile fileStream;
    String nomeFicheiro;
    boolean apagado = false;
    Gravavel tmp;

    public Gravador(String nomeFicheiro, Gravavel gv) 
    {
            this.nomeFicheiro = nomeFicheiro;
            tmp = gv;
    }
    
    public boolean gravar(Gravavel modelo)
    {
        boolean gravou = false;
        try
        {
            abrirFicheiro();
            fileStream.seek(fileStream.length());
            fileStream.writeBoolean(apagado);
            modelo.gravarRegisto(fileStream);
            gravou = true;
        } 
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            fecharFicheiro();
        }
        return gravou;
    }
    
    public ArrayList<Gravavel> lerTodos()
    {
        ArrayList <Gravavel> modelos = new ArrayList<Gravavel>();
        try
        {
            abrirFicheiro();
            
            while(fileStream.getFilePointer()<fileStream.length())
            {
                Gravavel tmp = this.tmp.getNovaInstancia();
                if(!fileStream.readBoolean())
                {
                    tmp.lerRegisto(fileStream);
                    modelos.add(tmp);
                }
                else
                {
                    //tmp.lerRegisto(fileStream);
                    fileStream.seek(fileStream.getFilePointer()+tmp.getSizeof());
                    continue;
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            fecharFicheiro();
        }
        
        return modelos;
    }
    
    public Gravavel lerRegisto(Object chave)
    {
        Gravavel modelo = tmp.getNovaInstancia();
        boolean encontrou = false;
        try
        {
            abrirFicheiro();
            
            while(fileStream.getFilePointer()<fileStream.length() && encontrou==false)
            {
                if(fileStream.readBoolean())
                {
                     fileStream.seek(fileStream.getFilePointer()+tmp.getSizeof());
                     continue;
                }
                else
                {
                     modelo.lerRegisto(fileStream);
                     if(areEqual(chave, modelo.getChave()))
                         encontrou=true;
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            fecharFicheiro();
        }
        
        if(encontrou)
            return modelo;
        else
            return null;
    }
    
    public boolean editarRegisto(Object chave, Gravavel modelo)
    {
        
        boolean editou = false;
        boolean encontrou = false;
        long posicaoAntesDaLeitura = 0;
        try
        {
            abrirFicheiro();
            
            
            while(fileStream.getFilePointer()<fileStream.length() && encontrou==false)
            {
                 posicaoAntesDaLeitura = fileStream.getFilePointer();
                 Gravavel tmp = this.tmp.getNovaInstancia();
                 if(fileStream.readBoolean())
                 {
                     fileStream.seek(fileStream.getFilePointer()+tmp.getSizeof());
                     continue;
                 }
                 else
                 {
                     tmp.lerRegisto(fileStream);
                     if(areEqual(chave, tmp.getChave()))
                     {
                        encontrou=true;
                        fileStream.seek(posicaoAntesDaLeitura);
                        fileStream.writeBoolean(apagado);
                        modelo.gravarRegisto(fileStream);
                        editou = true;
                     }
                 }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            fecharFicheiro();
        }
        
        return editou;
    }
    
    public boolean apagarRegisto(Object chave)
    {
        
        boolean apagou = false;
        boolean encontrou = false;
        long posicaoAntesDaLeitura = 0;
        try
        {
            abrirFicheiro();
            
            
            while(fileStream.getFilePointer()<fileStream.length() && encontrou==false)
            {
                 posicaoAntesDaLeitura = fileStream.getFilePointer();
                 Gravavel tmp = this.tmp.getNovaInstancia();
                 if(fileStream.readBoolean())
                 {
                     fileStream.seek(fileStream.getFilePointer()+tmp.getSizeof());
                     continue;
                 }
                 else
                 {
                     tmp.lerRegisto(fileStream);
                     if(areEqual(chave, tmp.getChave()))
                     {
                        encontrou=true;
                        fileStream.seek(posicaoAntesDaLeitura);
                        
                        fileStream.writeBoolean(true);
                        apagou = true;
                     }
                 }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            fecharFicheiro();
        }
        
        return apagou;
    }
    
    public void abrirFicheiro()
    {
        try 
        {
            fileStream = new RandomAccessFile(nomeFicheiro, "rw");
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Gravador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fecharFicheiro()
    {
        try 
        {
            fileStream.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Gravador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean areEqual(Object key, Object modeloKey)
    {
        boolean areEqual = false;
        if(tmp.getChave() instanceof String)
        {
            String chave = (String)key;
            String chaveModelo = (String)modeloKey;
            if(chave.equalsIgnoreCase(chaveModelo))
            {
                areEqual = true;
            }
        }
        else
        {
            if(tmp.getChave() instanceof Integer)
            {
                int chave = (Integer)key;
                int chaveModelo = (Integer)modeloKey;
                if(chave == chaveModelo)
                {
                    areEqual = true;
                }
            }
        }
        return areEqual;
    }
    
}
