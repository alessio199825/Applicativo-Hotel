package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.MainController;

import java.awt.*;
import java.awt.event.*;

public class Main_Frame{
	
    private MainController controller;
    private JFrame window;
    private JPanel mainPanel;
    private JFrame enterFrame;
    private JFrame guestPage;
    private JFrame extraPage;
    private JFrame billPage;
    
    private int indicatore = -1;
    
    private JList<Object> guestsList;
    private JList<Object> relativesList;
    
    private JTextField guestNameTextField = new JTextField();
    private JTextField guestSurnameTextField = new JTextField();
    private JTextField guestNationalityTextField = new JTextField();
    private JTextField guestAddressTextField = new JTextField();
    private JTextField guestBirthAgeTextField = new JTextField();
    private JTextField relativesAgeTextField = new JTextField();
    private JTextField room = new JTextField();
    private JTextField DataArrivo = new JTextField();
    private JTextField DataPartenza = new JTextField();
    
    private JLabel Name = new JLabel("Nome:");
    private JLabel Surname = new JLabel("Cognome:");
    private JLabel Nationality = new JLabel("Nazionalità:");
    private JLabel Address = new JLabel("Indirizzo:");
    private JLabel BirthAge = new JLabel("Anno di nascita:");
    private JLabel relativesAge = new JLabel("Anno di nascita del familiare:");
    private JLabel DataArrivoIn = new JLabel("Data arrivo:");
    private JLabel DataPartenzaIn = new JLabel("Data partenza:");
    
    private JLabel titolo1 = new JLabel("LISTA CLIENTI:");
    private JLabel titolo2 = new JLabel("LISTA FAMILIARI:");
    private JLabel titoloMain = new JLabel("HOME PAGE");
    private JLabel employeeName = new JLabel();
    private JLabel tit_room = new JLabel("Camera Cliente:");
    
    private JButton addGuest;
    private JButton addExtra;
    private JButton conto;
    private JButton delete;
    
    public Main_Frame() {
    	
    	this.controller = null;
		window = new JFrame("HOTEL PRIMULA ROSSA");
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setSize(800, 500);
    	window.setLocationRelativeTo(null);
    	mainPanel = new JPanel();
    	window.add(mainPanel);
    	controller = new MainController(this);
    	mainPanel.setLayout(null);
    	
    	guestsList = new JList<Object>();
    	relativesList = new JList<Object>();
    	
    	addGuest = new JButton("AGGIUNGI CLIENTE");
    	addGuest.setBounds(580, 400, 150, 30);
    	mainPanel.add(addGuest);
    	addExtra = new JButton("AGGIUNGI EXTRA");
    	addExtra.setBounds(410, 400, 150, 30);
    	mainPanel.add(addExtra);
    	conto = new JButton("CALCOLA CONTO");
    	conto.setBounds(220, 400, 150, 30);
    	mainPanel.add(conto);
    	delete = new JButton("ELIMINA CLIENTE");
    	delete.setBounds(50, 400, 150, 30);
    	mainPanel.add(delete);
    	
    	guestsList.setBounds(50, 80, 200, 300);
    	guestsList.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
    	relativesList.setBounds(500, 80, 200, 100);
    	relativesList.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
    	
    	Name.setBounds(300, 80, 150, 20);
    	guestNameTextField.setBounds(300, 100, 150, 30);
    	Surname.setBounds(300, 140, 150, 20);
    	guestSurnameTextField.setBounds(300, 160, 150, 30);
    	Nationality.setBounds(300, 200, 150, 20);
        guestNationalityTextField.setBounds(300, 220, 150, 30);
        Address.setBounds(300, 260, 150, 20);
        guestAddressTextField.setBounds(300, 280, 150, 30);
        BirthAge.setBounds(300, 320, 150, 20);
        guestBirthAgeTextField.setBounds(300, 340, 150, 30);
        relativesAge.setBounds(500, 200, 200, 20);
        relativesAgeTextField.setBounds(500, 220, 80, 30);
        tit_room.setBounds(500, 260, 150, 20);
        room.setBounds(500, 280, 150, 30);
        DataArrivo.setBounds(500, 340, 100, 30);
        DataPartenza.setBounds(630, 340, 100, 30);
        
        DataArrivoIn.setBounds(500, 320, 150, 20);
        DataPartenzaIn.setBounds(630, 320, 150, 20);
        titolo1.setBounds(50, 50, 150, 30);
        titolo2.setBounds(500, 50, 150, 30);
        titoloMain.setBounds(350, 0, 150, 40);
        titoloMain.setForeground(Color.red);
        employeeName.setBounds(50, 10, 250, 40);
        employeeName.setForeground(Color.blue);
    	
        controller.InstanceRoom();   //vengono istanziate le camere
        controller.InstanceExtra();	//viene istanziato il menù
        
        mainPanel.add(Name);
    	mainPanel.add(Surname);
    	mainPanel.add(Nationality);
    	mainPanel.add(Address);
    	mainPanel.add(BirthAge);
    	mainPanel.add(relativesAge);
    	
    	mainPanel.add(guestNameTextField);
    	mainPanel.add(guestSurnameTextField);
    	mainPanel.add(guestNationalityTextField);
    	mainPanel.add(guestAddressTextField);
    	mainPanel.add(guestBirthAgeTextField);
    	mainPanel.add(relativesAgeTextField);
    	mainPanel.add(room);
    	mainPanel.add(DataArrivo);
    	mainPanel.add(DataPartenza);
    	
    	mainPanel.add(DataArrivoIn);
    	mainPanel.add(DataPartenzaIn);
    	mainPanel.add(titolo1);
    	mainPanel.add(titolo2);
    	mainPanel.add(titoloMain);
    	mainPanel.add(employeeName);
    	mainPanel.add(tit_room);
    	
    	mainPanel.add(guestsList);
    	mainPanel.add(relativesList);
    	
    	setListeners();
    	
    	window.setVisible(true);
    	
    	enterFrame = new EnterFrame(controller);
    	enterFrame.setVisible(true);
    }

    private void setListeners() {
        guestsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    if (guestsList.getSelectedIndex() != -1) {
                    	
                    	if(!controller.getAlone(guestsList.getSelectedIndex())) {
                    		relativesList.setListData(controller.RelativesList(guestsList.getSelectedIndex()));
                        }
                        
                    	indicatore = guestsList.getSelectedIndex();
                    	
                        guestNameTextField.setText(controller.getGuestName(guestsList.getSelectedIndex()));
                        guestSurnameTextField.setText(controller.getGuestSurname(guestsList.getSelectedIndex()));
                        guestNationalityTextField.setText(controller.getGuestNationality(guestsList.getSelectedIndex()));
                        guestAddressTextField.setText(controller.getGuestAddress(guestsList.getSelectedIndex()));
                        guestBirthAgeTextField.setText(Integer.toString(controller.getGuestBirthAge(guestsList.getSelectedIndex())));
                        
                        room.setText(Integer.toString(controller.getHotel().getGuests().get(guestsList.getSelectedIndex()).getStayAccount().getRoom().code_room));
                        
                        DataArrivo.setText(controller.getHotel().getGuests().get(guestsList.getSelectedIndex()).getStayAccount().getDateArrive().toString());
                        DataPartenza.setText(controller.getHotel().getGuests().get(guestsList.getSelectedIndex()).getStayAccount().getDateDeparture().toString());
                    }
                }
            }
        
        });
        
        relativesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    if(relativesList.getSelectedIndex() != -1) {
                        relativesAgeTextField.setText(Integer.toString(controller.getRelativesBirthAge(guestsList.getSelectedIndex(), relativesList.getSelectedIndex())));                
                    }    
                }
            }
        });  

        addGuest.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                guestPage = new AddGuestPage(controller);
                guestPage.setVisible(true);
            }
        });
        
        addExtra.addMouseListener(new MouseAdapter() { 
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(indicatore != -1) {
                	extraPage = new ExtraPage(controller, guestsList.getSelectedIndex());
                	extraPage.setVisible(true);
                }
            }
        });
        
        conto.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(indicatore != -1) {
                	billPage = new BillPage(controller, guestsList.getSelectedIndex());
                	billPage.setVisible(true);
                }
            }
        });
        
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(indicatore != -1) {
                	controller.deleteGuest(guestsList.getSelectedIndex());
                	refresh();
                }
            }
        });
    }

    public void refresh() {
        guestsList.setListData(controller.GuestsList());
        relativesList.setListData(new String[0]);
        guestNameTextField.setText("");
        guestSurnameTextField.setText("");
        guestNationalityTextField.setText("");
        guestAddressTextField.setText("");
        guestBirthAgeTextField.setText("");
        relativesAgeTextField.setText(" ");
        room.setText(""); 
        DataArrivo.setText("");
        DataPartenza.setText("");
        employeeName.setText("Impiegato: " + controller.getEmploeeName() + " " + controller.getEmployeeSurname());
    }
}
