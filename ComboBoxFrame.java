
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.w3c.dom.Text;

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; 
   private final JLabel label; 
   private static final String[] names = 
      { "Gustavo","Gabriel", "Lucas", "Matheus", "Daniel", "Julio", "Angelo", "Enrique", "Germano", "Farias", "Douglas", "Rafael", "Felipe"};
     
   public ComboBoxFrame()
   {
      super("Testing JComboBox");
      setLayout(new FlowLayout());     

      imagesJComboBox = new JComboBox<String>(names); 
      imagesJComboBox.setMaximumRowCount(3); 

      add(imagesJComboBox); 
      label = new JLabel(names[0]); 
      add(label); 
      imagesJComboBox.addItemListener(event -> { 
           if (event.getStateChange() == ItemEvent.SELECTED)
              label.setText(names[imagesJComboBox.getSelectedIndex()]);
           }); 
   } 
} 

