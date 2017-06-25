import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by jouns on 26.03.2017.
 */
public class Solution {
    JFrame frame;
    //static Font font = new Font();
    static JButton button;
    static JLabel label;
    static String nameSave = "";
    static File folderMain;// = new File("C:\\Users\\jouns\\Documents\\BioWare\\Mass Effect Andromeda\\Save");
    static File folderArtem;// = new File("C:\\Users\\jouns\\Documents\\BioWare\\Mass Effect Andromeda\\Save_A");
    static File folderJouns;// = new File("C:\\Users\\jouns\\Documents\\BioWare\\Mass Effect Andromeda\\Save_J");
    static
    {
        folderMain = new File("C:\\Users\\jouns\\Documents\\The Witcher 3\\gamesaves");
        folderArtem = new File("C:\\Users\\jouns\\Documents\\The Witcher 3\\Save_A");
        folderJouns = new File("C:\\Users\\jouns\\Documents\\The Witcher 3\\Save_J");

        if(folderArtem.exists())
        {
            nameSave = "Подключены сохранялки ПАПЫ!";
            button = new JButton("Переключить на сохранения: Артема");
        }
        else
        {
            nameSave = "Подключены сохранялки Артема";
            button = new JButton("Переключить на сохранения: ПАПЫ");
        }
        label = new JLabel(nameSave);

        //label.setText(nameSave);
    }

    public static void main(String[] args) throws IOException {
        Solution gui = new Solution();
        gui.go();


    }
    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JButton button = new JButton("Переключить на сохранения:");
        button.addActionListener(new ButtonListener());

        frame.getContentPane().add(BorderLayout.CENTER,button);
        frame.getContentPane().add(BorderLayout.NORTH,label);
        frame.setSize(300,200);
        frame.setVisible(true);
    }
//    class LabelListener implements ActionListener
//    {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            label.setText(nameSave);
//        }
//    }
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(folderArtem.exists())
            {
                folderMain.renameTo(folderJouns);
                folderArtem.renameTo(folderMain);
                nameSave = "Подключены сохранялки Артема!";
                button.setText("Переключить на сохранения: ПАПЫ");
            }
            else
            {
                folderMain.renameTo(folderArtem);
                folderJouns.renameTo(folderMain);
                nameSave = "Подключены сохранялки ПАПЫ";
                button.setText("Переключить на сохранения: Артема");
            }
            label.setText(nameSave);
        }
    }
}
