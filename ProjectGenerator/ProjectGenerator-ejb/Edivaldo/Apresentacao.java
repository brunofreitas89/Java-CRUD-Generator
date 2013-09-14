import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Apresentacao extends JFrame
{
JPanel painelCentral;
JPanel painelSul;
JTextArea texto;
JButton botaoOK;
JButton botaoCancelar;
String stringTexto;
ImageIcon img;
JLabel labelImagem;
public Apresentacao() 
{
super("Bem Vindo ao Programa");
inicializarComponentes();
adicionarComponentes();
definirPropriedades();
mostrarGUI();
stringTexto = "Este software foi feito por bla bla bla bla etc etc etc";
}
public void inicializarComponentes()
{
    painelCentral = new JPanel(new BorderLayout());
painelSul = new JPanel();
texto = new JTextArea(stringTexto);
botaoOK = new JButton("OK");
botaoCancelar = new JButton("Cancelar");
img = new ImageIcon("");
labelImagem = new JLabel(img);

}
public void adicionarComponentes()
{
    painelCentral.add(labelImagem, BorderLayout.CENTER);
painelCentral.add(texto, BorderLayout.SOUTH);
painelSul.add(botaoOK);
painelSul.add(botaoCancelar);
add(painelCentral, BorderLayout.CENTER);
add(painelSul, BorderLayout.SOUTH);

}
public void definirPropriedades()
{
    texto.setLineWrap(true);
botaoOK.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
new Menu();
dispose();
}});
botaoCancelar.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
dispose();
}});

}
public void mostrarGUI()
{
    setSize(labelImagem.getIcon().getIconWidth(), labelImagem.getIcon().getIconHeight() + 150);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);

}
public static void main(String args[])
{
new Apresentacao();

}
}
