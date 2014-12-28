package controldisplay;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import Arduino.Arduino;

public class MiPanel extends JPanel {
	
	JButton iniciar;
	JButton detener;
	JButton reiniciar;
	GridLayout l;
	Arduino arduino = new Arduino();
	SerialPortEventListener evento = new SerialPortEventListener() {
		
		public void serialEvent(SerialPortEvent arg0) {
			// TODO Auto-generated method stub
			if(arduino.MessageAvailable()){
				System.out.println(arduino.PrintMessage());
			}
		}
	};

	MiPanel(){
		addComponentes();
		addOyentes();
		try {
			this.arduino.ArduinoRXTX("COM4", 2000, 9600,evento);
	        } catch (Exception ex) {
	            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	private void addOyentes() {
		// TODO Auto-generated method stub
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				iniciar.setEnabled(false);
		        detener.setEnabled(true);
		        reiniciar.setEnabled(true);
		        Color c;
		        c = new Color(255, 204, 51);
		        reiniciar.setBackground(c);
		        c = new Color(255, 204, 51);
		        detener.setBackground(c);
		        c = new Color(204, 204, 204);
		        iniciar.setBackground(c);
		       
		        try {
		            arduino.SendData("1");
		            //System.out.println(arduino.ReceiveData());
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        
			}
		});
		
		detener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				iniciar.setEnabled(true);
		        detener.setEnabled(false);
		        reiniciar.setEnabled(true);
		        Color c;
		        c = new Color(255, 204, 51);
		        reiniciar.setBackground(c);
		        c = new Color(204, 204, 204);
		        detener.setBackground(c);
		        c = new Color(255, 204, 51);
		        iniciar.setBackground(c);
		       
		        try {
		            arduino.SendData("2");
		            //System.out.println(arduino.ReceiveData());
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        
			}
		});
		
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				iniciar.setEnabled(true);
		        detener.setEnabled(false);
		        reiniciar.setEnabled(false);
		        Color c;
		        c = new Color(204, 204, 204);
		        reiniciar.setBackground(c);
		        c = new Color(204, 204, 204);
		        detener.setBackground(c);
		        c = new Color(255, 204, 51);
		        iniciar.setBackground(c);
		       
		        try {
		            arduino.SendData("3");
		            //System.out.println(arduino.ReceiveData());
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        
			}
		});
		
	}

	private void addComponentes() {
		// TODO Auto-generated method stub
		this.iniciar = new JButton("Iniciar / Continuar");
		this.detener = new JButton("Detener");
		this.reiniciar = new JButton("Reiniciar");
		this.l = new GridLayout(3, 1);
		this.setLayout(l);
		this.add(iniciar);
		this.add(detener);
		this.add(reiniciar);
	}
	
}
