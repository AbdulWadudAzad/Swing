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

public class UtilFile {

    public static void writeToFile(String filename, List<Student> students) throws Exception {
        File bestFile = new File(filename + ".txt");
        try {
            if (bestFile.exists() == false) {
                System.out.println("We had to make a file");
                bestFile.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(bestFile,true));
            for (Student s : students) {
                out.append(s.getName() + ", " + s.getEmail() + ", " + s.getAge() + ", " + s.getGender() + ", " + s.getHobby()
                        + ", " + s.getRound() + ", " + s.getNote());
            }
            out.close();

        } catch (IOException e) {
            System.out.println("Could note Log! ");

        }
    }
    
    public static void displayStudentsdataFromFile(String filename, DefaultTableModel model) throws IOException {
        String line;
        BufferedReader reader;
        try{
            reader=new BufferedReader(new FileReader(filename+".txt"));
            
            while((line=reader.readLine())!=null){
                model.addRow(line.split(", "));
            }
            reader.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Buffer Reader issue.");
        }
    }

}
