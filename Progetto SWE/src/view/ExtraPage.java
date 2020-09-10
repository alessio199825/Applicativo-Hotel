package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.MainController;
import model.ExtraRoomException;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ExtraPage extends JFrame{
		
	    private JPanel mainPanel;
	    private JList<Object> ExtrasList;
	    private JButton roomButton;
	    private JButton inLocoButton;
	    private JLabel  titolo;
	    private JLabel  aggiunta;
	    private JLabel  NB1;
	    private JLabel  NB2;
	    
	    private int index; 

	    public ExtraPage(MainController controller, int selection) {
	    	
	    	super("AGGIUNTE EXTRA");
	    	mainPanel = new JPanel();
	    	setSize(500, 370);
	    	setResizable(false);
	    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    	setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	index = 0;
	    	
	    	roomButton = new JButton("Servizio in camera");
	    	inLocoButton = new JButton("Bar o Ristorante");
	    	titolo = new JLabel ("Lista di extra:"); 
	    	aggiunta = new JLabel ("Selezionare la tipologia di aggiunta:"); 
	    	NB1 = new JLabel ("Solo alcuni extra possono essere "); 
	    	NB2 = new JLabel ("consumati nelle rispettive camere."); 
	    	
	    	ExtrasList = new JList<Object>();
	    	
	    	inLocoButton.setBounds(270, 100, 150, 30);
	    	mainPanel.setLayout(null);
	    	
	    	titolo.setBounds(20, 20, 120, 30);
	    	aggiunta.setBounds(250, 40, 210, 30);
	    	NB1.setBounds(250, 220, 210, 30);
	    	NB2.setBounds(250, 240, 210, 30);
	    	
	    	ExtrasList.setBounds(20, 50, 200, 250);
	    	ExtrasList.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
	    	
	    	mainPanel.add(titolo);
	    	mainPanel.add(aggiunta);
	    	mainPanel.add(NB1);
	    	mainPanel.add(NB2);
	    	
	    	mainPanel.add(inLocoButton);
	    	
	    	LoadExtra(controller);
	    	
	    	mainPanel.add(ExtrasList);
	    	roomButton.setBounds(270, 160, 150, 30);
	        mainPanel.add(roomButton);
	    	add(mainPanel);
	    	
	    	ExtrasList.addListSelectionListener(new ListSelectionListener() {
	    		public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	index = ExtrasList.getSelectedIndex();
	                }
	    		}
	    	});
    		
	    	roomButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					super.mousePressed(e);
					if (index != -1) {
						try {
							controller.setExtraRoom(controller.getDrinkEFood(index), selection);
						} catch (ExtraRoomException exception) {
							JOptionPane.showMessageDialog(new JFrame(), exception.getMessage(), "Non è possibile il servizio in camera.", JOptionPane.ERROR_MESSAGE);
						}
						ExtraPage.this.dispose();
					}
					else {
						JOptionPane.showMessageDialog(new JFrame(), "Input non valido", "Errore", JOptionPane.ERROR_MESSAGE);
					}
				}
    		});
	        
        	inLocoButton.addMouseListener(new MouseAdapter() {
        		@Override
        		public void mousePressed(MouseEvent e) {
        			super.mousePressed(e);
        			System.out.print("contatore cibo:" + index);
        			if (index != -1) {
						controller.setExtraLoco(controller.getDrinkEFood(index), selection);
        				ExtraPage.this.dispose();
        			} else {
        				JOptionPane.showMessageDialog(new JFrame(), "Input non valido", "Errore", JOptionPane.ERROR_MESSAGE);
        			}
    			}
        	});
        }
	    
	    private void LoadExtra(MainController controller) {
	    	for(int i=0; i<controller.getHotel().getDrinksEfoods().size(); i++) {
	    		ExtrasList.setListData(controller.ExtrasList());
	    	}
	    }
}
