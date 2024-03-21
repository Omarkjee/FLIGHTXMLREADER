package uta.cse.cse3310.JSBSimEdit;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.Marshaller;
import generated.FdmConfig;
import javax.swing.SwingUtilities;

public class App
{
  public static void main(String[] args) 
  {
    
     SwingUtilities.invokeLater(()-> {
        JSBSimEditGUI j = new JSBSimEditGUI();  
      });


  }
}
