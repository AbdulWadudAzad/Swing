package Menues;


import Menues.New;
import com.sun.org.apache.bcel.internal.generic.NEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class CommonMenu {

    public static void getCommonMenu(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);
        menuBar.add(new JMenu("About"));

        JMenu help = new JMenu("Help");
        menuBar.add(help);
        JMenuItem item1 = new JMenuItem("New");
        Object obj=new Object();
        item1.setIcon(new javax.swing.ImageIcon(obj.getClass().getResource("/image/logo.png")));
        item1.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        file.add(item1);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new New().setVisible(true);
            }
        });

        file.add(item1);
        file.add(new JMenuItem("Open"));
        file.add(new JMenuItem("Exit"));

        f.setJMenuBar(menuBar);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
