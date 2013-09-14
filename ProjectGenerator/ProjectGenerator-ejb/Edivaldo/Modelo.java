import SwingComponents.*;
import java.io.*;
public class Modelo implements Gravavel
{
StringBufferModelo nome;
StringBufferModelo apelido;
public Modelo() 
{
nome = new StringBufferModelo("", 100);
apelido = new StringBufferModelo("", 100);
}
public void setNome(String nome)
{
this.nome = new StringBufferModelo(nome.trim(), 100);
}
public String getNome()
{
return nome.toStringEliminatingSpaces();
}
public void setApelido(String apelido)
{
this.apelido = new StringBufferModelo(apelido.trim(), 100);
}
public String getApelido()
{
return apelido.toStringEliminatingSpaces();
}
public Gravavel getNovaInstancia()
{
    return new Modelo();
}
public int getSizeof()
{
    return 400;
}
public Object getChave()
{
    return getNome();
}
public void gravarRegisto(RandomAccessFile stream) throws IOException
{
    nome.write(stream);
apelido.write(stream);

}
public void gravarRegistoVazio(RandomAccessFile stream) throws IOException
{
    new StringBufferModelo("", 100).write(stream);
new StringBufferModelo("", 100).write(stream);

}
public void lerRegisto(RandomAccessFile stream) throws IOException
{
    nome.read(stream);
apelido.read(stream);

}
}
