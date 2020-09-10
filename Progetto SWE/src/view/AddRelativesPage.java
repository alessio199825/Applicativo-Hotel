package view;

import javax.swing.*;

import controller.MainController;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class AddRelativesPage extends JFrame {
	
    private JPanel mainPanel;
    private JTextField Name;
    private JTextField Surname;
    private JComboBox<Integer> BirthAge;
    private JButton button;
    private JLabel  Ins_name;
    private JLabel  Ins_surname;
    private JLabel  Ins_BirthAge;

    public AddRelativesPage(MainController controller){
    	
        super("Inserimento Familiare");
        mainPanel = new JPanel();
        setSize(450, 400);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Name = new JTextField();
        Surname = new JTextField();
        BirthAge = new JComboBox<Integer>();
		button = new JButton("SAVE");

		Ins_name = new JLabel ("Inserisci Nome:"); 
    	Ins_surname = new JLabel ("Inserisci Cognome:"); 
    	Ins_BirthAge = new JLabel ("Inserisci anno di nascita:"); 
    	
    	button.setBounds(300, 300, 90, 30);
    	mainPanel.setLayout(null);
    	
    	Name.setBounds(170, 100, 200, 30);
    	Surname.setBounds(170, 150, 200, 30);
    	BirthAge.setBounds(170, 200, 100, 30);
    	
    	Ins_name.setBounds(20, 100, 150, 30);
    	Ins_surname.setBounds(20, 150, 150, 30);
    	Ins_BirthAge.setBounds(20, 200, 150, 30);
    	
    	for(int i=1920; i<2005; i++) { 
    		BirthAge.addItem(i);
    	}
    	
    	mainPanel.add(Name);
    	mainPanel.add(Surname);
    	mainPanel.add(BirthAge);
    	
    	mainPanel.add(Ins_name);
    	mainPanel.add(Ins_surname);
    	mainPanel.add(Ins_BirthAge);

    	mainPanel.add(button);
    	
    	add(mainPanel);
        
    	button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!Name.getText().equals("") && !Surname.getText().equals("")) {
                    //try {
                    controller.addRelative(Name.getText(), Surname.getText(), (1920+BirthAge.getSelectedIndex()));
                    
                    /*} catch (NoRoomsException exception) {
                        JOptionPane.showMessageDialog(new JFrame(), exception.getMessage(), "Impossibile aggiungere cliente", JOptionPane.ERROR_MESSAGE);
                    }*/
                    AddRelativesPage.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Input non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
