import SwingComponents.*;
import java.io.*;
public class Modelo implements Gravavel
{
StringBufferModelo alcunha;
StringBufferModelo apelido;
public Modelo() 
{
alcunha = new StringBufferModelo("", 100);
apelido = new StringBufferModelo("", 100);
}
public void setAlcunha(String alcunha)
{
this.alcunha = new StringBufferModelo(alcunha.trim(), 100);
}
public String getAlcunha()
{
return alcunha.toStringEliminatingSpaces();
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
    return getAlcunha();
}
public void gravarRegisto(RandomAccessFile stream) throws IOException
{
    alcunha.write(stream);
apelido.write(stream);

}
public void gravarRegistoVazio(RandomAccessFile stream) throws IOException
{
    new StringBufferModelo("", 100).write(stream);
new StringBufferModelo("", 100).write(stream);

}
public void lerRegisto(RandomAccessFile stream) throws IOException
{
    alcunha.read(stream);
apelido.read(stream);

}
}
