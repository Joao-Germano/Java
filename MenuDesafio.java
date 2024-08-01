import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuDesafio extends JFrame {
 private final JTextField idJTextField = new JTextField();
 private final JTextField nomeJTextField = new JTextField();
 private final JTextField emailJTextField = new JTextField();
 private final JTextField senhaJTextField = new JTextField();
 private final JButton updateJButton = new JButton("^"); 
 private final JButton nextJButton = new JButton(">");
 private final JButton previousJButton = new JButton("<");
 private final JButton firstJButton = new JButton("<<");
 private final JButton lastJButton = new JButton(">>");
 private final JLabel idJLabel = new JLabel("Id:");
 private final JLabel nomeJLabel = new JLabel("Nome:");
 private final JLabel emailJLabel = new JLabel("Email:");
 private final JLabel senhaJLabel = new JLabel("Senha:");
 private final JLabel notificacaoJLabel = new JLabel("Notificações...");
 //private final JLabel espacadorLabel = new JLabel("");
 private final JLabel espacador2Label = new JLabel("");
 private final JLabel espacador3Label = new JLabel("");
 private final JLabel espacador4Label = new JLabel("");
 private final JLabel espacador5Label = new JLabel("");
 private final JLabel espacador6Label = new JLabel("");
 private final JLabel espacador7Label = new JLabel("");
 private final JButton deleteJButton = new JButton("Deletar");

 
 

 public MenuDesafio()
 {
 super("Cadastrar");
 setLayout(new GridLayout(6, 4, 10, 10));

 firstJButton.addActionListener(
    new ActionListener() {
        public  void actionPerformed(ActionEvent event) {
            String[] resultado;
            try {
                resultado = NavegadorDeRegistro.primeiroRegistro("db_texte","tbl_texte");
                notificacaoJLabel.setText("Primeiro registro posicionado com sucesso");
                idJTextField.setText(resultado [0]);
                nomeJTextField.setText(resultado [1]);
                emailJTextField.setText(resultado [2]);
                senhaJTextField.setText(resultado [3]);
                updateJButton.setEnabled(false);
                firstJButton.setEnabled(false);
                previousJButton.setEnabled(false);
                lastJButton.setEnabled(true);
                nextJButton.setEnabled(true);
           }catch(Exception e) {
             System.out.println("Ops! Ocorreu um erro ao posicionar o registro para o primeiro. Veja o erro"+ e);
             return;
           }
            
        };
    }
 );

 lastJButton.addActionListener(
    new ActionListener() {
        public  void actionPerformed(ActionEvent event) {
            String[] resultado;
            try {
                resultado = NavegadorDeRegistro.ultimoRegistro("db_texte","tbl_texte");
                notificacaoJLabel.setText("Ultimo registro posicionado com sucesso");
                idJTextField.setText(resultado [0]);
                nomeJTextField.setText(resultado [1]);
                emailJTextField.setText(resultado [2]);
                senhaJTextField.setText(resultado [3]);
                updateJButton.setEnabled(false);
                lastJButton.setEnabled(false);
                nextJButton.setEnabled(false);
                firstJButton.setEnabled(true);
                previousJButton.setEnabled(true);
           }catch(Exception e) {
             System.out.println("Ops! Ocorreu um erro ao posicionar o registro para o ultimo. Veja o erro"+ e);
             return;
           }
            
        };
    }
 );

 nextJButton.addActionListener(
    new ActionListener() {
        public  void actionPerformed(ActionEvent event) {
            String[] resultado;
            try {
                resultado = NavegadorDeRegistro.NextRegister("db_texte","tbl_texte", idJTextField.getText());
                notificacaoJLabel.setText("Proximo registro posicionado com sucesso");
                idJTextField.setText(resultado [0]);
                nomeJTextField.setText(resultado [1]);
                emailJTextField.setText(resultado [2]);
                senhaJTextField.setText(resultado [3]);
                updateJButton.setEnabled(false);
                previousJButton.setEnabled(true);
           }catch(Exception e) {
             System.out.println("Ops! Ocorreu um erro ao posicionar o registro para o proximo. Veja o erro"+ e);
             return;
           }
            
        };
    }
 );

 deleteJButton.addActionListener(
  new ActionListener() {
      public void actionPerformed(ActionEvent event)
{
String nome;
String senha;
String email;
try
{
  nome = nomeJTextField.getText();
  email = emailJTextField.getText();
  senha = senhaJTextField.getText();
  NavegadorDeRegistro.DeleteRegister("db_texte", "tbl_texte", "nome", "email", "senha", nome, email, senha);
  notificacaoJLabel.setText("Cadastro realizado com sucesso");
  
} 
catch(Exception e){
  System.out.println("Digite alguma coisa.");
  return;
}     
}
}
);

updateJButton.addActionListener(
    new ActionListener() {
        public  void actionPerformed(ActionEvent event) {
            String[] resultado;
            try {
                resultado = NavegadorDeRegistro.updateRegister("db_texte","tbl_texte", idJTextField.getText());
                notificacaoJLabel.setText("Proximo registro posicionado com sucesso");
                idJTextField.setText(resultado [0]);
                nomeJTextField.setText(resultado [1]);
                emailJTextField.setText(resultado [2]);
                senhaJTextField.setText(resultado [3]);
                updateJButton.setEnabled(false);
                previousJButton.setEnabled(true);
           }catch(Exception e) {
             System.out.println("Ops! Ocorreu um erro ao posicionar o registro para o proximo. Veja o erro"+ e);
             return;
           }
            
        };
    }
 );

 previousJButton.addActionListener(
    new ActionListener() {
        public  void actionPerformed(ActionEvent event) {
            String[] resultado;
            try {
                resultado = NavegadorDeRegistro.anteriorRegistro("db_texte","tbl_texte", idJTextField.getText());
                notificacaoJLabel.setText("Anterior registro posicionado com sucesso");
                idJTextField.setText(resultado [0]);
                nomeJTextField.setText(resultado [1]);
                emailJTextField.setText(resultado [2]);
                senhaJTextField.setText(resultado [3]);
                updateJButton.setEnabled(false);
                nextJButton.setEnabled(true);
           }catch(Exception e) {
             System.out.println("Ops! Ocorreu um erro ao posicionar o registro para o anterior. Veja o erro"+ e);
             return;
           }
            
        };
    }
 );

 

 add(idJLabel);
 add(idJTextField);
 add(updateJButton);
 add(deleteJButton);
// add(espacadorLabel);
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
 add(senhaJTextField);
 add(espacador6Label);
 add(espacador7Label);

 add(firstJButton);
 add(previousJButton);
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