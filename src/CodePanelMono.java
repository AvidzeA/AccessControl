import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CodePanelMono extends JDialog
{
    private String returnValue;
    private boolean canceled;
    private JTextField name;

    public static void main(String[] args)
    {

        CodePanel input = new CodePanel();
        input.setLocationRelativeTo(null);
        input.setVisible(true);

    }
    public boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
    public CodePanelMono()
    {
        super(new JFrame("КЛЮЧ"), "КЛЮЧ");
        this.setModalityType(DEFAULT_MODALITY_TYPE);
        returnValue = "";
        canceled = false;
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(100, 100));
        this.name = new JTextField();
        CodePanelMono temp = this;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point point = new Point(screenSize.width / 2, screenSize.height / 2);
        JButton add = new JButton("OK");
        add.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent arg0) {
                        String checkInput = name.getText();
                        if (isInteger(checkInput)) {
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