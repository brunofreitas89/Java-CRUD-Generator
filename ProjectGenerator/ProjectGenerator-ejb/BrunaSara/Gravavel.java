/*
 *
 */
import java.io.IOException;
import java.io.RandomAccessFile;


public interface Gravavel
{

    
    

    public Gravavel getNovaInstancia();

    /**
     *
     * @return Tamanho do registo(sizeof).
     */
    public int getSizeof();


    /**
     *
     * @return Chave para calcular a posicao no ficheiro.
     */
    public Object getChave();


    /**
     *
     * @param posicao Posicao onde sera lido o registo
     * @param stream
     * @throws Exception Disparada quando a leitua nao for executada com sucesso.
     */
    public void lerRegisto(  RandomAccessFile stream ) throws IOException;


    /**
     *
     * @param posicao Posicao onde sera escrito o registo
     * @param stream
     * @throws Exception Disparada quando a escrita nao for executada com sucesso.
     */
    public void gravarRegisto(  RandomAccessFile stream ) throws IOException;


    public void gravarRegistoVazio( RandomAccessFile stream ) throws IOException;



}
