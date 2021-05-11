import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CodePanel extends JDialog
{
    private String[] alphabet = {"_","А","Б","В","Г","Д","Е","Ж","З","И","К","Л","М","Н","О","П","Р","С",
            "Т","У","Ф","Х","Ц","Ч","Ш","Щ","Ъ","Ы","Ь","Э","Ю","Я"};
    private String returnValue;
    private boolean canceled;
    private JTextField name;

    public static void main(String[] args)
    {

        CodePanel input = new CodePanel();
        input.setLocationRelativeTo(null);
        input.setVisible(true);

    }
    public boolean isCorrect( String input ) {
        String[] inputMas = input.split("");
        int l = input.length();
        for (int i=0; i<l; i++) {
            boolean wrong = true;
            for (int j = 0; j<32;j++) {
                if (alphabet[j].equals(inputMas[i])) {
                    wrong = false;
                    break;
                }
            }
            if (wrong) return false;
        }
        return true;
    }
    public CodePanel()
    {
        super(new JFrame("КЛЮЧ"), "КЛЮЧ");
        this.setModalityType(DEFAULT_MODALITY_TYPE);
        returnValue = "";
        canceled = false;
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(100, 100));
        this.name = new JTextField();
        CodePanel temp = this;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point point = new Point(screenSize.width / 2, screenSize.height / 2);
        JButton add = new JButton("OK");
        add.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent arg0) {
                        String checkInput = name.getText();
                        if (isCorrect(checkInput)) {
                            returnValue = name.getText();
                            dispose();
                        } else {
                            ErrorPopup checkErr = new ErrorPopup();
                            checkErr.setLocation(new Point(point.x-500,point.y-250));
                            if(checkErr.ifClosed()) {
                                name.setText("");
                            }
                        }

                    }
                });

        JButton takeInput = new JButton("ESC");
        takeInput.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        canceled = true;
                        setVisible(false);
                        dispose();
                    }
                }
        );
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0;
        constraints.gridx   = 0;
        constraints.gridy   = 0;
        constraints.gridwidth = 2;
        this.add(name,constraints);

        constraints.weightx = 0;
        constraints.gridx   = 0;
        constraints.gridy   = 1;
        constraints.gridwidth = 1;
        this.add(add,constraints);
        constraints.gridx   = 1;
        this.add(takeInput,constraints);
        this.pack();
    }

    private void close()
    {
        this.dispose();
    }
    private void hideIt()
    {
        this.setVisible(false);
    }

    public String getName()
    {
        setVisible(true);
        if(canceled) {
            return("Z");
        } else return returnValue;
    }
}