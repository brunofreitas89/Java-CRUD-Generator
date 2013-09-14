import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Formulario extends JFrame
{
Modelo modelo;
Gravador gravador;
boolean editar;
JPanel painelCentro;
JPanel painelSul;
JButton btSalvar;
JButton btCancelar;
JButton btLimpar;
JLabel jLabelNome;
JLabel jLabelApelido;
JLabel jLabelAltura;
JLabel jLabelSexo;
JLabel jLabelIdade;
JLabel jLabelDescricao;
JTextField jTextFieldNome;
JTextField jTextFieldApelido;
JTextField jTextFieldAltura;
JTextField jTextFieldSexo;
JTextField jTextFieldIdade;
JTextField jTextFieldDescricao;
public Formulario(Modelo modelo, boolean editar) 
{
super("Janela De Formulario");
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
    gravador = new Gravador("ficheiro.dat", modelo);
painelCentro = new JPanel(new GridLayout(0,2));
painelSul = new JPanel();
btSalvar = new JButton("Salvar/Actualizar");
btCancelar = new JButton("Cancelar");
btLimpar = new JButton("Limpar");
jTextFieldNome = new JTextField();
jTextFieldApelido = new JTextField();
jTextFieldAltura = new JTextField();
jTextFieldSexo = new JTextField();
jTextFieldIdade = new JTextField();
jTextFieldDescricao = new JTextField();
jLabelNome = new JLabel("Introduza o seu nome");
jLabelApelido = new JLabel("Poe o apelido");
jLabelAltura = new JLabel("Insira a altura");
jLabelSexo = new JLabel("Poe o sexo");
jLabelIdade = new JLabel("Idade");
jLabelDescricao = new JLabel("Poe uma descricao randomica");

}
private void adicionarComponentes()
{
    painelCentro.add(jLabelNome);
painelCentro.add(jTextFieldNome);
painelCentro.add(jLabelApelido);
painelCentro.add(jTextFieldApelido);
painelCentro.add(jLabelAltura);
painelCentro.add(jTextFieldAltura);
painelCentro.add(jLabelSexo);
painelCentro.add(jTextFieldSexo);
painelCentro.add(jLabelIdade);
painelCentro.add(jTextFieldIdade);
painelCentro.add(jLabelDescricao);
painelCentro.add(jTextFieldDescricao);
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
if(gravador.editarRegisto(modelo.getNome(), modelo))
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
setSize(500, 200 + 50 * 6);
setVisible(true);
setLocationRelativeTo(null);

}
public void mostrarDados()
{
    jTextFieldNome.setText(modelo.getNome());
jTextFieldApelido.setText(modelo.getApelido());
jTextFieldAltura.setText(modelo.getAltura()+"");
jTextFieldSexo.setText(modelo.getSexo());
jTextFieldIdade.setText(modelo.getIdade()+"");
jTextFieldDescricao.setText(modelo.getDescricao());

}
public void limpar()
{
    jTextFieldNome.setText("");
jTextFieldApelido.setText("");
jTextFieldAltura.setText("");
jTextFieldSexo.setText("");
jTextFieldIdade.setText("");
jTextFieldDescricao.setText("");

}
public void carregarModelo()
{
    modelo.setNome(jTextFieldNome.getText());
modelo.setApelido(jTextFieldApelido.getText());
modelo.setAltura(Integer.parseInt(jTextFieldAltura.getText()));
modelo.setSexo(jTextFieldSexo.getText());
modelo.setIdade(Integer.parseInt(jTextFieldIdade.getText()));
modelo.setDescricao(jTextFieldDescricao.getText());

}
public static void main(String args[])
{
new Formulario(new Modelo(), false);
}
}
