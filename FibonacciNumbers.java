
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class FibonacciNumbers extends JFrame 
{
   
   private final JPanel workerJPanel =  
      new JPanel(new GridLayout(2, 2, 5, 5));
   private final JTextField numberJTextField = new JTextField();
   private final JButton goJButton = new JButton("Go");
   private final JLabel fibonacciJLabel = new JLabel();

   
   private final JPanel eventThreadJPanel =  
      new JPanel(new GridLayout(2, 3, 5, 5));
   private long n1 = 0; 
   private long n2 = 1; 
   private int count = 1;
   private final JLabel nJLabel = new JLabel("Fibonacci of 1: ");
   private final JLabel nFibonacciJLabel = 
      new JLabel(String.valueOf(n2));
   private final JButton nextNumberJButton = new JButton("Next Number");
   private final JButton previousNumberJButton = new JButton("Previous Number");
   
   //Previous  

   public FibonacciNumbers()
   {
      super("Fibonacci Numbers");
      setLayout(new GridLayout(2, 1, 10, 10));
      
      workerJPanel.setBorder(new TitledBorder(
         new LineBorder(Color.BLACK), "With SwingWorker"));
      workerJPanel.add(new JLabel("Get Fibonacci of:"));
      workerJPanel.add(numberJTextField);
      goJButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int n;

               try
               {
                  
                  n = Integer.parseInt(numberJTextField.getText());
               } 
               catch(NumberFormatException ex)
               {
                  
                  fibonacciJLabel.setText("Enter an integer.");
                  return;
               } 
               
               fibonacciJLabel.setText("Calculating...");

               BackgroundCalculator task = 
                  new BackgroundCalculator(n, fibonacciJLabel);         
               task.execute(); 
            } 
         } 
      );        
      workerJPanel.add(goJButton);
      workerJPanel.add(fibonacciJLabel);
      
      eventThreadJPanel.setBorder(new TitledBorder(
         new LineBorder(Color.BLACK), "Without SwingWorker"));
      eventThreadJPanel.add(nJLabel);
      eventThreadJPanel.add(nFibonacciJLabel); 
      nextNumberJButton.addActionListener(
      
         new ActionListener()
      
         {
            public void actionPerformed(ActionEvent event)
            {
            
               long temp = n1 + n2;
               n1 = n2;
               n2 = temp;
               ++count;

               
               nJLabel.setText("Fibonacci of " + count + ": ");
               nFibonacciJLabel.setText(String.valueOf(n2));
            }
         } 
      );

      workerJPanel.add(goJButton);
      workerJPanel.add(fibonacciJLabel);
      
      eventThreadJPanel.setBorder(new TitledBorder(
         new LineBorder(Color.BLACK), "Without SwingWorker"));
      eventThreadJPanel.add(nJLabel);
      eventThreadJPanel.add(nFibonacciJLabel); 
      previousNumberJButton.addActionListener(
      
         new ActionListener()
      
         {
            public void actionPerformed(ActionEvent event)
            {
              if (count>1) {
               long temp = n2 - n1;
               n2 = n1;
               n1 = temp;
               --count;

               
               nJLabel.setText("Fibonacci of " + count + ": ");
               nFibonacciJLabel.setText(String.valueOf(n2));
            }
          } 
         }   
      );

      eventThreadJPanel.add(nextNumberJButton);
      eventThreadJPanel.add(previousNumberJButton);
      

      add(workerJPanel);
      add(eventThreadJPanel);
      setSize(275, 200);
      setVisible(true);
   } 

   
   public static void main(String[] args)
   {
      FibonacciNumbers application = new FibonacciNumbers();
      application.setDefaultCloseOperation(EXIT_ON_CLOSE);
   } 
} 
