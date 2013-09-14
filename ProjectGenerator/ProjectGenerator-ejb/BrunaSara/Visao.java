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
JLabel jLabelSomething;
JLabel jLabelQualquercoisa;
JLabel jLabelIdade;
JTextField jTextFieldSomething;
JTextField jTextFieldQualquercoisa;
JTextField jTextFieldIdade;
public Visao(Modelo modelo, boolean editar) 
{
super("A bruna eh mah");
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
    gravador = new Gravador("bruna.dat", modelo);
painelCentro = new JPanel(new GridLayout(0,2));
painelSul = new JPanel();
btSalvar = new JButton("Salvar/Actualizar");
btCancelar = new JButton("Cancelar");
btLimpar = new JButton("Limpar");
jTextFieldSomething = new JTextField();
jTextFieldQualquercoisa = new JTextField();
jTextFieldIdade = new JTextField();
jLabelSomething = new JLabel("Introduza o seu something");
jLabelQualquercoisa = new JLabel("Poe o apelido");
jLabelIdade = new JLabel("Insira a sua idade");

}
private void adicionarComponentes()
{
    painelCentro.add(jLabelSomething);
painelCentro.add(jTextFieldSomething);
painelCentro.add(jLabelQualquercoisa);
painelCentro.add(jTextFieldQualquercoisa);
painelCentro.add(jLabelIdade);
painelCentro.add(jTextFieldIdade);
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
if(gravador.editarRegisto(modelo.getSomething(), modelo))
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
setSize(500, 200 + 50 * 3);
setVisible(true);
setLocationRelativeTo(null);

}
public void mostrarDados()
{
    jTextFieldSomething.setText(modelo.getSomething());
jTextFieldQualquercoisa.setText(modelo.getQualquercoisa());
jTextFieldIdade.setText(modelo.getIdade()+"");

}
public void limpar()
{
    jTextFieldSomething.setText("");
jTextFieldQualquercoisa.setText("");
jTextFieldIdade.setText("");

}
public void carregarModelo()
{
    modelo.setSomething(jTextFieldSomething.getText());
modelo.setQualquercoisa(jTextFieldQualquercoisa.getText());
modelo.setIdade(Integer.parseInt(jTextFieldIdade.getText()));

}
public static void main(String args[])
{
new Visao(new Modelo(), false);
}
}
