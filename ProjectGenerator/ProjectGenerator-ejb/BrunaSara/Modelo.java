import SwingComponents.*;
import java.io.*;
public class Modelo implements Gravavel
{
StringBufferModelo something;
StringBufferModelo qualquercoisa;
int idade;
public Modelo() 
{
something = new StringBufferModelo("", 100);
qualquercoisa = new StringBufferModelo("", 100);
idade = 0;
}
public void setSomething(String something)
{
this.something = new StringBufferModelo(something.trim(), 100);
}
public String getSomething()
{
return something.toStringEliminatingSpaces();
}
public void setQualquercoisa(String qualquercoisa)
{
this.qualquercoisa = new StringBufferModelo(qualquercoisa.trim(), 100);
}
public String getQualquercoisa()
{
return qualquercoisa.toStringEliminatingSpaces();
}
public void setIdade(int idade)
{
this.idade = idade;
}
public int getIdade()
{
return idade;
}
public Gravavel getNovaInstancia()
{
    return new Modelo();
}
public int getSizeof()
{
    return 404;
}
public Object getChave()
{
    return getSomething();
}
public void gravarRegisto(RandomAccessFile stream) throws IOException
{
    something.write(stream);
qualquercoisa.write(stream);
stream.writeInt(idade);

}
public void gravarRegistoVazio(RandomAccessFile stream) throws IOException
{
    new StringBufferModelo("", 100).write(stream);
new StringBufferModelo("", 100).write(stream);
stream.writeInt(0);

}
public void lerRegisto(RandomAccessFile stream) throws IOException
{
    something.read(stream);
qualquercoisa.read(stream);
idade = stream.readInt();

}
}
