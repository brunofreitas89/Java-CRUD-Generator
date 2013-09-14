import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Visao extends JFrame
{
Modelo modelo;
Gravador gravador;
boolean editar;
JPanel painelCentro;
JPanel painelSul;
JButton btSalvar;
JButton btCancelar;
JButton btLimpar;
JLabel jLabelAlcunha;
JLabel jLabelApelido;
JTextField jTextFieldAlcunha;
JTextField jTextFieldApelido;
public Visao(Modelo modelo, boolean editar) 
{
super("Interface");
this.editar = editar;
this.modelo = modelo;
inicializarComponentes();
adicionarComponentes();
definirPropriedades();
if(this.editar)
{
mostrarDados();

}
mostrarGUI();
}
private void inicializarComponentes()
{
    gravador = new Gravador("fabioFicheiro.dat", modelo);
painelCentro = new JPanel(new GridLayout(0,2));
painelSul = new JPanel();
btSalvar = new JButton("Salvar/Actualizar");
btCancelar = new JButton("Cancelar");
btLimpar = new JButton("Limpar");
jTextFieldAlcunha = new JTextField();
jTextFieldApelido = new JTextField();
jLabelAlcunha = new JLabel("Introduza o sua alcunha");
jLabelApelido = new JLabel("Poe o apelido");

}
private void adicionarComponentes()
{
    painelCentro.add(jLabelAlcunha);
painelCentro.add(jTextFieldAlcunha);
painelCentro.add(jLabelApelido);
painelCentro.add(jTextFieldApelido);
painelSul.add(btSalvar);
painelSul.add(btLimpar);
painelSul.add(btCancelar);
add(painelCentro, BorderLayout.CENTER);
add(painelSul, BorderLayout.SOUTH);

}
private void definirPropriedades()
{
    btSalvar.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
if(editar)
{
carregarModelo();
if(gravador.editarRegisto(modelo.getAlcunha(), modelo))
{
JOptionPane.showMessageDialog(null, "Dados actualizados com sucesso!");
limpar();

}
else
{
JOptionPane.showMessageDialog(null, "Erro ao actualizar o registo!");

}

}
else
{
carregarModelo();
if(gravador.gravar(modelo))
{
JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
limpar();

}
else
{
JOptionPane.showMessageDialog(null, "Erro ao gravar o registo!");

}

}
}});
btLimpar.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
limpar();
}});
btCancelar.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
dispose();
}});

}
public void mostrarGUI()
{
    setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(500, 200 + 50 * 2);
setVisible(true);
setLocationRelativeTo(null);

}
public void mostrarDados()
{
    jTextFieldAlcunha.setText(modelo.getAlcunha());
jTextFieldApelido.setText(modelo.getApelido());

}
public void limpar()
{
    jTextFieldAlcunha.setText("");
jTextFieldApelido.setText("");

}
public void carregarModelo()
{
    modelo.setAlcunha(jTextFieldAlcunha.getText());
modelo.setApelido(jTextFieldApelido.getText());

}
public static void main(String args[])
{
new Visao(new Modelo(), false);
}
}
