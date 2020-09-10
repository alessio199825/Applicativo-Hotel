package view;

import javax.swing.*;

import controller.MainController;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class EnterFrame extends JFrame {
	
    private JPanel mainPanel;
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField registerCodeField;
    private JButton enterButton;
    private JLabel  nome;
    private JLabel  cognome;
    private JLabel  code;

    public EnterFrame(MainController controller) {
    	
    	super("Login");
    	mainPanel = new JPanel();
    	setSize(400, 300);
    	setResizable(false);
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	enterButton = new JButton("ENTER");
    	nameTextField = new JTextField();
    	surnameTextField = new JTextField();
    	registerCodeField = new JTextField();
    	nome = new JLabel ("Nome:"); 
    	cognome = new JLabel ("Cognome:"); 
    	code = new JLabel ("Matricola:"); 
    	
    	enterButton.setBounds(250, 200, 90, 30);
    	mainPanel.setLayout(null);
    	nameTextField.setBounds(90, 50, 200, 30);
    	surnameTextField.setBounds(90, 100, 200, 30);
    	registerCodeField.setBounds(90, 150, 100, 30);
    	
    	nome.setBounds(20, 50, 70, 30);
    	cognome.setBounds(20, 100, 70, 30);
    	code.setBounds(20, 150, 70, 30);
    	
    	mainPanel.add(nameTextField);
    	mainPanel.add(surnameTextField);
    	mainPanel.add(registerCodeField);
    	
    	mainPanel.add(nome);
    	mainPanel.add(cognome);
    	mainPanel.add(code);
    	
    	mainPanel.add(enterButton);
    	
    	add(mainPanel);
    	
        enterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!nameTextField.getText().equals("") && !surnameTextField.getText().equals("") && !registerCodeField.getText().equals("")) {
                    controller.setEmployee(nameTextField.getText(), surnameTextField.getText(), registerCodeField.getText());
                    EnterFrame.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Input non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
