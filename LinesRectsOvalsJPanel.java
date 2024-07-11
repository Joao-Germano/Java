
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;

public class LinesRectsOvalsJPanel extends JPanel 
{
   
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.WHITE);

      g.setColor(Color.RED);
      g.drawLine(5, 30, 380, 30);
      g.setColor(Color.RED);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Linha", 10,25);

      g.setColor(Color.BLUE);
      g.drawRect(5, 40, 90, 55);
      g.setColor(Color.BLUE);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Senac", 20,72);

      g.fillRect(100, 40, 90, 55);
      g.setColor(Color.BLACK);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Senac", 115,72);

      g.setColor(Color.BLACK);
      g.fillRoundRect(195, 40, 90, 55, 50, 50);
      g.setColor(Color.RED);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Senac", 210,72);

      g.drawRoundRect(290, 40, 90, 55, 20, 20);
      g.setColor(Color.RED);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Senac", 305,72);

      g.setColor(Color.GREEN);   
      g.draw3DRect(5, 100, 90, 55, true);
      g.setColor(Color.GREEN);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Senac", 20,135);

      g.fill3DRect(100, 100, 90, 55, false);
      g.setColor(Color.BLACK);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Senac", 112,135);

      g.setColor(Color.MAGENTA);
      g.drawOval(195, 100, 90, 55);
      g.setColor(Color.MAGENTA);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Senac", 210,135);

      g.fillOval(290, 100, 90, 55);
      g.setColor(Color.PINK);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Senac", 304,135);

   } 
} 
