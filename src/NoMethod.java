import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class NoMethod extends JDialog{
    public static void main(String[] args){
        CodePanel input = new CodePanel();
        input.setLocationRelativeTo(null);
        input.setVisible(true);
    }

    public NoMethod(){
        super(new JFrame(""), "");
        this.setModalityType(DEFAULT_MODALITY_TYPE);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(200, 100));
        JLabel text = new JLabel("<html><div style='text-align: center;'>Указанный метод<br/>не реализован<div></html>", SwingConstants.CENTER);




        this.add(text);

        this.pack();
    }
    public boolean ifClosed() {
        setVisible(true);
        return true;
    }

}