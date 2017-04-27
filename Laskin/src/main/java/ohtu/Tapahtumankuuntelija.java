package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {
    private final JTextField tuloskentta;
    private final JTextField syotekentta;
    private final CommandFactory commandFactory;
 
    public Tapahtumankuuntelija(JTextField tuloskentta, JTextField syotekentta) {
        commandFactory = new CommandFactory();
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        syotekentta.setText("");
        tuloskentta.setText("" + 
                commandFactory.get(((JButton)ae.getSource()).getText())
                        .execute(arvo));
    }
 
}