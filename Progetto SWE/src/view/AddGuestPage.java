package view;

import javax.swing.*;

import controller.MainController;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class AddGuestPage extends JFrame {
	
    private JPanel mainPanel;
    private JTextField Name;
    private JTextField Surname;
    private JComboBox<Integer> BirthAge;
    private JTextField Nationality;
    private JTextField Address;
    private JButton button;
    private JButton add;
    private JLabel Ins_name;
    private JLabel Ins_surname;
    private JLabel Ins_BirthAge;
    private JLabel Ins_Nation;
    private JLabel Ins_Address;
    private JComboBox<String> room;
    private JLabel Ins_room;
    private JLabel Darrive;
    private JLabel Ddeparture;
    private JComboBox<String> DarriveIn;
    private JComboBox<String> DdepartureIn;
    
    private JFrame RelativesPage;

    public AddGuestPage(MainController controller){
    	
        super("Inserimento Cliente");
        mainPanel = new JPanel();
        setSize(530, 400);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Name = new JTextField();
        Surname = new JTextField();
        BirthAge = new JComboBox<Integer>();
        Nationality = new JTextField();
        Address = new JTextField();
		button = new JButton("SAVE");
		add = new JButton("AGGIUNGI FAMILIARE");
		room = new JComboBox<String>();
		

		Ins_name = new JLabel ("Inserisci Nome:"); 
    	Ins_surname = new JLabel (	"Inserisci Cognome:"); 
    	Ins_BirthAge = new JLabel ("Inserisci anno di nascita:"); 
    	Ins_Nation = new JLabel ("Inserisci nazionalità:");
    	Ins_Address = new JLabel ("Inserisci indirizzo:");
    	Ins_room = new JLabel("Assegna una camera:");
    	Darrive = new JLabel("Data arrivo:");
        Ddeparture = new JLabel("Data partenza:");
        DarriveIn = new JComboBox<String>();
        DdepartureIn = new JComboBox<String>();
    	
    	button.setBounds(310, 300, 90, 30);
    	add.setBounds(110, 300, 180, 30);
    	mainPanel.setLayout(null);
    	
    	Name.setBounds(170, 20, 200, 30);
    	Surname.setBounds(170, 60, 200, 30);
    	Nationality.setBounds(170, 100, 200, 30);
    	Address.setBounds(170, 140, 100, 30);
    	BirthAge.setBounds(170, 180, 100, 30);
    	room.setBounds(170, 240, 150, 30);
        DarriveIn.setBounds(380, 140, 110, 30);
        DdepartureIn.setBounds(380, 180, 110, 30);
    	
    	Ins_name.setBounds(20, 20, 150, 30);
    	Ins_surname.setBounds(20, 60, 150, 30);
    	Ins_Nation.setBounds(20, 100, 150, 30);
    	Ins_Address.setBounds(20, 140, 150, 30);
    	Ins_BirthAge.setBounds(20, 180, 150, 30);
    	Ins_room.setBounds(20, 240, 150, 30);
    	Darrive.setBounds(290, 140, 100, 30);
        Ddeparture.setBounds(290, 180, 100, 30);
    	
    	for(int i=1920; i<2005; i++) { 
    		BirthAge.addItem(i);
    	}
    	
    	for(int i=1; i<=31; i++) { 
    		DarriveIn.addItem(i + " Agosto 2020");
    	}
    	
    	for(int i=1; i<=31; i++) { 
    		DdepartureIn.addItem(i + " Agosto 2020");
    	}
    	
    	for(int i=0; i<controller.getHotel().getRoomsFree().size() ; i++) {
    		room.addItem(controller.getRoomFree(i));
    	}
    	
    	mainPanel.add(Name);
    	mainPanel.add(Surname);
    	mainPanel.add(BirthAge);
    	mainPanel.add(Nationality);
    	mainPanel.add(Address);
    	mainPanel.add(room);
    	mainPanel.add(DdepartureIn);
    	mainPanel.add(DarriveIn);
    	
    	mainPanel.add(Ins_name);
    	mainPanel.add(Ins_surname);
    	mainPanel.add(Ins_BirthAge);
    	mainPanel.add(Ins_Nation);
    	mainPanel.add(Ins_Address);
    	mainPanel.add(Ins_room);
    	mainPanel.add(Ddeparture);
    	mainPanel.add(Darrive);
    	
    	mainPanel.add(button);
    	mainPanel.add(add);
    	
    	add(mainPanel);
        
    	button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!Name.getText().equals("") && !Surname.getText().equals("") && !Nationality.getText().equals("") && !Address.getText().equals("")) {
                    //try {
                    controller.AddGuest(Name.getText(), Surname.getText(), (1920+BirthAge.getSelectedIndex()) , Nationality.getText(), Address.getText());
                	controller.getHotel().getGuests().get(controller.getHotel().getGuests().size()-1).getStayAccount().setRoom(controller.getHotel().getRoomsFree().get(room.getSelectedIndex()));
                	System.out.print(DarriveIn.getSelectedIndex());
                    controller.getHotel().getGuests().get(controller.getHotel().getGuests().size()-1).getStayAccount().setDateArrive(LocalDate.of(2020, 9, 1+DarriveIn.getSelectedIndex()));
                    controller.getHotel().getGuests().get(controller.getHotel().getGuests().size()-1).getStayAccount().setDateDeparture(LocalDate.of(2020, 9, 1+DdepartureIn.getSelectedIndex()));
                	/*} catch (NoRoomsException exception) {
                        JOptionPane.showMessageDialog(new JFrame(), exception.getMessage(), "Impossibile aggiungere cliente", JOptionPane.ERROR_MESSAGE);
                    }*/
                    AddGuestPage.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Input non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    	
    	add.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                RelativesPage = new AddRelativesPage(controller);
                RelativesPage.setVisible(true);
            }
        });
    }
}