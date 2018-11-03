
package evidence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Util {

  public static void writeToFile(String filename, List<Student> students) throws Exception{
      
      File destFile=new File(filename+".txt");
      try{
          if(destFile.exists()==false){
              System.out.println("Create a new file");
              destFile.createNewFile();
          }    
          PrintWriter out=new PrintWriter(new FileWriter(destFile));
          for(Student s:students){
              out.append(s.getName()+", "+s.getEmail()+", "+s.getAge()+", "+s.getGender()+", "+
                      s.getRound()+", "+s.getHobby()+", "+s.getMessage()+"/n");
          }
          out.close();
      }catch(IOException e){
          
      }
     
  }
  
  public static void readFromFile(String filname,DefaultTableModel model){
      String line;
      BufferedReader reader;
      try{
      reader=new BufferedReader(new FileReader(filname+".txt"));
          while ((line=reader.readLine()) !=null) {
             model.addRow(line.split(", "));
              
          }
          reader.close(); 
  }catch(IOException e){
          JOptionPane.showMessageDialog(null, "Buffer reader issue");
  }
  }
}
