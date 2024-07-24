import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameNome extends JFrame {
    private final JTextField nomeJTextField = new JTextField();
    private final JButton cadastrarJButton = new JButton("Adicionar");
    private final JLabel nomeJLabel = new JLabel("Digite um nome abaixo");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");
    
    public FrameNome()
   {
      super("Cadatros");
      setLayout(new GridLayout(4, 1, 5, 5));

      cadastrarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event)
      {
        String nome;
        
         try
         {
            nome = nomeJTextField.getText();
            InserirRegistro.cadastar("db_texte", "tbl_texte", "nome", nome);
            notificacaoJLabel.setText("Cadastro realizado com sucesso");
            
         } 
         catch(NumberFormatException ex){
            System.out.println("Digite alguma coisa.");
            return;
      }     
     }
  }
   );
        add(nomeJLabel);
        add(nomeJTextField);
        add(cadastrarJButton);
        add(notificacaoJLabel);
        setSize(400, 200);
        setVisible(true);

   }
   public static void main(String[] args) {
    FrameNome application = new FrameNome();
    application.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}