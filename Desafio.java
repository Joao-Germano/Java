import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

  public class Desafio extends JPanel {
    @Override
   public void paintComponent(Graphics g)
   {
    super.paintComponent(g); 

      g.setColor(new Color(0,0,255));
    
      g.fillRect(20, 40, 100, 50 );


      g.setColor(Color.BLACK);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Senac", 35,70);
      
      

    
} 
  }
