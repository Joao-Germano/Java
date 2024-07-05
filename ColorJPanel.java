import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class ColorJPanel extends JPanel 
{
   
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.RED);

      
      g.setColor(new Color(0, 0, 255));
      g.fillRect(15, 25, 200, 20);
      g.drawString("Senac ", 230, 40);

      
      g.setColor(new Color(255, 255, 255));
      g.fillRect(15, 50, 200, 20);
      g.drawString("Curso de Java " , 230, 65);

      
      
      
      
   } 
} 