package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.MainController;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BillPage extends JFrame {
	
	private JPanel billPanel;
	private JLabel Name;
	private JLabel Surname;
	private JLabel Camera;
	private JLabel listExtra;
	private JLabel NB1;
	private JLabel DataA;
	private JLabel DataP;
	private JLabel costocam;
	private JLabel costotot;
	private JLabel incamera;
	
	private JButton calcola;
	
	private JTextField NameOut;
	private JTextField SurnameOut;
	private JTextField CameraOut;
	private JTextField DataAOut;
	private JTextField DataPOut;
	private JTextField costocamO;
	private JTextField costototO;
	private JTextField incameraO;
	private JList<Object> ExtraOut;
	
public BillPage(MainController controller, int index){
    	
        super("Calcolo del Conto");
        billPanel = new JPanel();
        setSize(500, 410);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Name = new JLabel("Nome:");
        Surname = new JLabel("Cognome:");
        Camera = new JLabel("Camera:");
        listExtra = new JLabel("Lista di extra:");
        NB1 = new JLabel("Si ricorda che il servizio in camera ha un addebito di 2 euro a prodotto.");
        DataA = new JLabel("Data arrivo:");
        DataP = new JLabel("Data partenza:");
        costocam = new JLabel("Costo totale camera:");
        costotot = new JLabel("Conto finale:");
        incamera = new JLabel("In Camera:");
        
        calcola = new JButton("Calcola conto");
    	
        NameOut = new JTextField();
        SurnameOut = new JTextField();
        CameraOut = new JTextField();
        DataAOut = new JTextField();
        DataPOut = new JTextField();
        costocamO = new JTextField();
        costototO = new JTextField();
        incameraO = new JTextField();
    	ExtraOut = new JList<Object>();
    	
    	Name.setBounds(30, 20, 80, 30);
        Surname.setBounds(210, 20, 80, 30);
        Camera.setBounds(30, 60, 80, 30);
        DataA.setBounds(210, 60, 100, 30);
        DataP.setBounds(210, 100, 100, 30);
        NB1.setBounds(30, 340, 420, 20);
        listExtra.setBounds(30, 100, 120, 30);
        incamera.setBounds(210, 150, 120, 30);
        costocam.setBounds(210, 200, 150, 30);
        costotot.setBounds(210, 240, 90, 30);
        
        NameOut.setBounds(90, 20, 100, 30);
        SurnameOut.setBounds(300, 20, 100, 30);
        CameraOut.setBounds(90, 60, 100, 30);
        DataAOut.setBounds(300, 60, 100, 30);
        DataPOut.setBounds(300, 100, 100, 30);
        ExtraOut.setBounds(30, 130, 150, 200);
        ExtraOut.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        incameraO.setBounds(300, 150, 100, 30);
        costocamO.setBounds(340, 200, 100, 30);
        costototO.setBounds(340, 240, 100, 30);
    	
    	calcola.setBounds(260, 300, 120, 30);
    	
    	billPanel.setLayout(null);
    	
    	billPanel.add(Name);
    	billPanel.add(Surname);
    	billPanel.add(Camera);
    	billPanel.add(listExtra);
    	billPanel.add(NB1);
    	billPanel.add(DataA);
    	billPanel.add(DataP);
    	billPanel.add(costocam);
    	billPanel.add(costotot);
    	billPanel.add(incamera);
    	
    	billPanel.add(NameOut);
    	billPanel.add(SurnameOut);
    	billPanel.add(CameraOut);
    	billPanel.add(DataAOut);
    	billPanel.add(DataPOut);
    	billPanel.add(costocamO);
    	billPanel.add(costototO);
    	billPanel.add(ExtraOut);
    	billPanel.add(incameraO);
    	
    	load(controller, index);
    	
    	billPanel.add(calcola);
    	
    	add(billPanel);
        
    	ExtraOut.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    if (ExtraOut.getSelectedIndex() != -1) {
                    	if(controller.getExtraInRoom(ExtraOut.getSelectedIndex(), index))
                    		incameraO.setText("SI");
                    	else
                    		incameraO.setText("NO");
                    }
                }
            }
        
        });
    	
    	calcola.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                double tmp = controller.getHotel().getGuests().get(index).getStayAccount().getCost();
                costocamO.setText(Double.toString(tmp) + "€");
                costototO.setText(Double.toString(tmp + controller.getHotel().getGuests().get(index).getStayAccount().getCostExtra()) + "€");
            }
        });
    }

	public void load(MainController controller, int index) {
		ExtraOut.setListData(controller.getExtraChoose(index));
		NameOut.setText(controller.getGuestName(index));
		SurnameOut.setText(controller.getGuestSurname(index));
		CameraOut.setText(Integer.toString(controller.getHotel().getGuests().get(index).getStayAccount().getRoom().code_room));
		DataAOut.setText(controller.getHotel().getGuests().get(index).getStayAccount().getDateArrive().toString());
        DataPOut.setText(controller.getHotel().getGuests().get(index).getStayAccount().getDateDeparture().toString());
	}
}