import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ErrorPopup extends JDialog
{
    public static void main(String[] args)
    {
        CodePanel input = new CodePanel();
        input.setLocationRelativeTo(null);
        input.setVisible(true);
    }

    public ErrorPopup()
    {
        super(new JFrame("⊗"), "⊗");
        this.setModalityType(DEFAULT_MODALITY_TYPE);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(100, 100));
        JButton ok = new JButton("OK");
        ok.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        setVisible(false);
                        dispose();
                    }
                }
        );
        JLabel text = new JLabel("<html><div style='text-align: center;'>Значение ключа<br/>неправильное.<div></html>", SwingConstants.CENTER);


        this.setLayout(new VerticalFlowLayout());


        this.add(text);
        this.add(ok);
        this.pack();
    }
    public boolean ifClosed() {
        setVisible(true);
        return true;
    }

}