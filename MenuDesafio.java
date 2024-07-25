import java.awt.*;
// import java.awt.event.*;
import javax.swing.*;

public class MenuDesafio extends JFrame {
 private final JTextField idJTextField = new JTextField();
 private final JTextField nomeJTextField = new JTextField();
 private final JTextField emailJTextField = new JTextField();
 private final JTextField senhalJTextField = new JTextField();
 private final JButton updateJButton = new JButton("^");
 private final JButton nextJButton = new JButton(">");
 private final JButton preveusJButton = new JButton("<");
 private final JButton firstJButton = new JButton("<<");
 private final JButton lastJButton = new JButton(">>");
 private final JLabel idJLabel = new JLabel("Id:");
 private final JLabel nomeJLabel = new JLabel("Digite um nome:");
 private final JLabel emailJLabel = new JLabel("Digite um email:");
 private final JLabel senhaJLabel = new JLabel("Digite uma senha:");
 private final JLabel notificacaoJLabel = new JLabel("Notificações...");
 private final JLabel espacadorLabel = new JLabel("");
 private final JLabel espacador2Label = new JLabel("");
 private final JLabel espacador3Label = new JLabel("");
 private final JLabel espacador4Label = new JLabel("");
 private final JLabel espacador5Label = new JLabel("");
 private final JLabel espacador6Label = new JLabel("");
 private final JLabel espacador7Label = new JLabel("");

 public MenuDesafio()
 {
 super("Cadastrar");
 setLayout(new GridLayout(6, 4, 10, 10));

 add(idJLabel);
 add(idJTextField);
 add(updateJButton);
 add(espacadorLabel);
 idJTextField.setEditable(false);

 add(nomeJLabel);
 add(nomeJTextField);
 add(espacador2Label);
 add(espacador3Label);

 add(emailJLabel);
 add(emailJTextField);
 add(espacador4Label);
 add(espacador5Label);

 add(senhaJLabel);
 add(senhalJTextField);
 add(espacador6Label);
 add(espacador7Label);

 add(firstJButton);
 add(preveusJButton);
 add(nextJButton);
 add(lastJButton);

 add(notificacaoJLabel);

 setSize(600, 300);
 setVisible(true);

 }
 public static void main(String[] args) {
 MenuDesafio application = new MenuDesafio();
 application.setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
}