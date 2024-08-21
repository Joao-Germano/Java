import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class MenuDesafio extends JFrame {
 private final JTextField idJTextField = new JTextField();
 private final JTextField nomeJTextField = new JTextField();
 private final JTextField emailJTextField = new JTextField();
 private final JTextField senhaJTextField = new JTextField();
 private final JButton updateJButton = new JButton(""); 
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
 //private final JLabel espacador3Label = new JLabel("");
 private final JLabel espacador4Label = new JLabel("");
 //private final JLabel espacador5Label = new JLabel("");
 private final JLabel espacador6Label = new JLabel("");
 //private final JLabel espacador7Label = new JLabel("");
 private final JButton deleteJButton = new JButton("Deletar");
 private final JButton novoJButton = new JButton("+");
 private final JButton verJButton = new JButton("");
 private final JButton excluirJButton = new JButton("🗑️");
 
 //private final String dbPadrao = "db_texte";
 //private final String tblPadrao = "tbl_texte";

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
                updateJButton.setEnabled(true);
                firstJButton.setEnabled(false);
                previousJButton.setEnabled(false);
                lastJButton.setEnabled(true);
                nextJButton.setEnabled(true);
                deleteJButton.setEnabled(true);
               // novoJButton.setEnabled(false);
                //verJButton.setEnabled(false);
                //editarJButton.setEnabled(false);
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
                updateJButton.setEnabled(true);
                lastJButton.setEnabled(false);
                nextJButton.setEnabled(false);
                firstJButton.setEnabled(true);
                previousJButton.setEnabled(true);
                deleteJButton.setEnabled(true);
                //novoJButton.setEnabled(false);
                //verJButton.setEnabled(false);
                //editarJButton.setEnabled(false);

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
                updateJButton.setEnabled(true);
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
  notificacaoJLabel.setText("Deletado com sucesso");
  
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
      public void actionPerformed(ActionEvent event)
{
String nome;
String email;
String senha;
String id;
try
{
  nome = nomeJTextField.getText();
  email = emailJTextField.getText();
  senha = senhaJTextField.getText();
  id = idJTextField.getText();
  NavegadorDeRegistro.updateRegistro("db_texte", "tbl_texte",id, nome, email, senha );
  notificacaoJLabel.setText("Atualização realizada com sucesso");
} 
catch(Exception e){
  System.out.println("Digite alguma coisa.");
  return;
   }     
  }
 }
);

novoJButton.addActionListener(
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
  NavegadorDeRegistro.novoRegistro("db_texte", "tbl_texte","nome", "email", "senha", nome, email, senha);
  updateJButton.setEnabled(true);
  lastJButton.setEnabled(false);
  nextJButton.setEnabled(false);
  firstJButton.setEnabled(false);
  previousJButton.setEnabled(false);
  deleteJButton.setEnabled(false);
  verJButton.setEnabled(false);
  excluirJButton.setEnabled(true);
  notificacaoJLabel.setText("Novo registro adicionado com sucesso");
} 
catch(Exception e){
  System.out.println("Digite alguma coisa.");
  return;
   }     
  }
 }
);

verJButton.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent event) {
      String nome;
      String email;
      String[] resultado;
      try {
          nome = nomeJTextField.getText();
          email = emailJTextField.getText();
          resultado = NavegadorDeRegistro.verRegistro("db_texte","tbl_texte","nome", "email","senha", nome, email);

        nomeJTextField.setText(resultado[0]);
        emailJTextField.setText(resultado[1]);
        senhaJTextField.setText(resultado[2]);
        updateJButton.setEnabled(true);
        lastJButton.setEnabled(false);
        nextJButton.setEnabled(false);
        firstJButton.setEnabled(false);
        previousJButton.setEnabled(false);
        deleteJButton.setEnabled(true);

          notificacaoJLabel.setText("Pesquisa realizada com sucesso");
      } catch (Exception e) {

          notificacaoJLabel.setText("Erro ao realizar a pesquisa: " + e);
      }
  }
});

excluirJButton.addActionListener(
  new ActionListener() {
      public void actionPerformed(ActionEvent event)
{
  nomeJTextField.setText("");
  emailJTextField.setText("");
  senhaJTextField.setText("");
  }
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
                updateJButton.setEnabled(true);
                nextJButton.setEnabled(true);
           }catch(Exception e) {
             System.out.println("Ops! Ocorreu um erro ao posicionar o registro para o anterior. Veja o erro"+ e);
             return;
           }
            
        };
       });
       
       
       
       updateJButton.setEnabled(false);  
       deleteJButton.setEnabled(false);
       
       firstJButton.setToolTipText("Primeiro");
       previousJButton.setToolTipText("Anterior");
       nextJButton.setToolTipText("Proximo");
       lastJButton.setToolTipText("Ultimo");
       updateJButton.setToolTipText("Atualizar");
       deleteJButton.setToolTipText("Deletar");
       novoJButton.setToolTipText("Adicionar");
       verJButton.setToolTipText("Pesquisar");
       excluirJButton.setToolTipText("Excluir");
       
       
       add(idJLabel);
       add(idJTextField);
       add(updateJButton);
       add(deleteJButton);
       // add(espacadorLabel);
       idJTextField.setEditable(false);
       
       add(nomeJLabel);
       add(nomeJTextField);
       add(espacador2Label);
       add(novoJButton);
       //add(espacador3JLabel);
       
       add(emailJLabel);
       add(emailJTextField);
       add(espacador4Label);
       add(verJButton);
       //add(espacador5Label);
       
       add(senhaJLabel);
       add(senhaJTextField);
       add(espacador6Label);
       add(excluirJButton);
       
       add(firstJButton);
       //add(espacador3JLabel);
       add(previousJButton);
       //add(espacador5Label);
       add(nextJButton);
       add(lastJButton);
       
       //add(espacador3Label);
       //add(espacador5Label);
       add(notificacaoJLabel);
       
       //add(espacador7Label);
       
       setSize(600, 300);
       setVisible(true);
      }
      public static void main(String[] args) {
        MenuDesafio application = new MenuDesafio();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    }
    