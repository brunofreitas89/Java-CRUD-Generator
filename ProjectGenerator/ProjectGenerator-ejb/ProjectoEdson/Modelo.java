import SwingComponents.*;
import java.io.*;
public class Modelo implements Gravavel
{
StringBufferModelo nome;
StringBufferModelo apelido;
int altura;
StringBufferModelo sexo;
int idade;
StringBufferModelo descricao;
public Modelo() 
{
nome = new StringBufferModelo("", 100);
apelido = new StringBufferModelo("", 100);
altura = 0;
sexo = new StringBufferModelo("", 100);
idade = 0;
descricao = new StringBufferModelo("", 100);
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
public void setAltura(int altura)
{
this.altura = altura;
}
public int getAltura()
{
return altura;
}
public void setSexo(String sexo)
{
this.sexo = new StringBufferModelo(sexo.trim(), 100);
}
public String getSexo()
{
return sexo.toStringEliminatingSpaces();
}
public void setIdade(int idade)
{
this.idade = idade;
}
public int getIdade()
{
return idade;
}
public void setDescricao(String descricao)
{
this.descricao = new StringBufferModelo(descricao.trim(), 100);
}
public String getDescricao()
{
return descricao.toStringEliminatingSpaces();
}
public Gravavel getNovaInstancia()
{
    return new Modelo();
}
public int getSizeof()
{
    return 808;
}
public Object getChave()
{
    return getNome();
}
public void gravarRegisto(RandomAccessFile stream) throws IOException
{
    nome.write(stream);
apelido.write(stream);
stream.writeInt(altura);
sexo.write(stream);
stream.writeInt(idade);
descricao.write(stream);

}
public void gravarRegistoVazio(RandomAccessFile stream) throws IOException
{
    new StringBufferModelo("", 100).write(stream);
new StringBufferModelo("", 100).write(stream);
stream.writeInt(0);
new StringBufferModelo("", 100).write(stream);
stream.writeInt(0);
new StringBufferModelo("", 100).write(stream);

}
public void lerRegisto(RandomAccessFile stream) throws IOException
{
    nome.read(stream);
apelido.read(stream);
altura = stream.readInt();
sexo.read(stream);
idade = stream.readInt();
descricao.read(stream);

}
}
