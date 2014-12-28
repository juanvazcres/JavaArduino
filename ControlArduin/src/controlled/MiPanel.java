package controlled;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Arduino.Arduino;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiPanel extends JPanel {
	Arduino arduino = new Arduino();
	JButton encender;
	JButton apagar;
	JLabel comentario;
	GridLayout l;
		
	MiPanel(){
		comentario = new JLabel("LED Apagado");
		encender = new JButton("Encender");
		apagar = new JButton("Apagar");
		addComponentes();
		addEvents();
	}
	
	private void addComponentes() {
		// TODO Auto-generated method stub
		l = new GridLayout(3, 1);
		setLayout(l);
		this.add(encender);
		this.add(apagar);
		this.add(comentario);
		try {
	        arduino.ArduinoTX("COM4", 2000, 9600);
	        } catch (Exception ex) {
	            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		encender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				encender.setEnabled(false);
		        apagar.setEnabled(true);
		        Color c;
		        c = new Color(255, 204, 51);
		        apagar.setBackground(c);
		        c = new Color(204, 204, 204);
		        encender.setBackground(c);
		       
		        try {
		            arduino.SendData("1");
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
				comentario.setText("LED Encendido :) ");
			}
		});
		
		apagar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				encender.setEnabled(true);
		        apagar.setEnabled(false);
		        Color c;
		        c = new Color(255, 204, 51);
		        encender.setBackground(c);
		        c = new Color(204, 204, 204);
		        apagar.setBackground(c);
		       
		        try {
		            arduino.SendData("0");
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
				comentario.setText("LED Apagado ¬¬ ");
			}
		});
		
	}

		
}
