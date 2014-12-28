package calculadora;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import javax.swing.*;
import Arduino.Arduino;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiPanel extends JPanel {

	// Declaracion Variables//
	private boolean fsOper = true, Punto = false;
	private char ope;
	private double primero, segundo, ans;
	private String show = "";
	private JTextField text;
	private JButton[] botones;
	public String[] n = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2",
			"3", "-", "0", ".", "=", "+" };
	public Arduino arduino = new Arduino();

	SerialPortEventListener evento = new SerialPortEventListener() {

		public void serialEvent(SerialPortEvent arg0) {
			// TODO Auto-generated method stub
			if (arduino.MessageAvailable()) {
				System.out.println(arduino.PrintMessage());
			}
		}
	};

	public MiPanel() {
		text = new JTextField();
		botones = new JButton[16];
		addComponentes();
		addEventos();
		try {
			this.arduino.ArduinoRXTX("COM8", 2000, 9600,evento);
	        } catch (Exception ex) {
	            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	public void addEventos() {

		botones[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "7";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "8";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "9";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fsOper) {
					primero = Double.parseDouble(text.getText());
					show = "";
					text.setText("/");
					try {
			            arduino.SendData("/");
			        } catch (Exception ex) {
			            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
			        }
					ope = 'd';
					fsOper = false;
				} else {
					dividir();
					primero = Double.parseDouble(text.getText());
				}
			}
		});

		botones[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "4";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "5";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "6";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fsOper) {
					primero = Double.parseDouble(text.getText());
					show = "";
					text.setText("*");
					try {
			            arduino.SendData("*");
			        } catch (Exception ex) {
			            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
			        }
					ope = 'm';
					fsOper = false;
				} else {
					multiplicar();
					primero = Double.parseDouble(text.getText());
				}
			}
		});

		botones[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "1";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "2";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "3";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fsOper) {
					primero = Double.parseDouble(text.getText());
					show = "";
					text.setText("-");
					try {
			            arduino.SendData("-");
			        } catch (Exception ex) {
			            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
			        }
					ope = 'r';
					fsOper = false;
				} else {
					restar();
					primero = Double.parseDouble(text.getText());
				}
			}
		});

		botones[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show += "0";
				text.setText(show);
				try {
		            arduino.SendData(show);
		        } catch (Exception ex) {
		            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});

		botones[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Punto) {
					show += ".";
					text.setText(show);
					try {
			            arduino.SendData(show);
			        } catch (Exception ex) {
			            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
			        }
					Punto = true;
				}
			}
		});

		botones[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (ope) {
				case 'd':
					dividir();
					break;

				case 'm':
					multiplicar();
					break;

				case 'r':
					restar();
					break;

				case 's':
					sumar();
				}
			}
		});

		botones[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fsOper) {
					primero = Double.parseDouble(text.getText());
					show = "";
					text.setText("+");
					try {
			            arduino.SendData("+");
			        } catch (Exception ex) {
			            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
			        }
					ope = 's';
					fsOper = false;
				} else {
					sumar();
					primero = Double.parseDouble(text.getText());
				}
			}
		});
	}

	public void sumar() {
		segundo = Double.parseDouble(text.getText());
		ans = primero + segundo;
		text.setText(String.valueOf(ans));
		try {
            arduino.SendData(String.valueOf(ans));
        } catch (Exception ex) {
            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
		show = "";
		fsOper = true;
	}

	public void restar() {
		segundo = Double.parseDouble(text.getText());
		ans = primero - segundo;
		text.setText(String.valueOf(ans));
		try {
            arduino.SendData(String.valueOf(ans));
        } catch (Exception ex) {
            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
		show = "";
		fsOper = true;
	}

	public void multiplicar() {
		segundo = Double.parseDouble(text.getText());
		ans = (primero * segundo);
		text.setText(String.valueOf(ans));
		try {
            arduino.SendData(String.valueOf(ans));
        } catch (Exception ex) {
            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
		show = "";
		fsOper = true;
	}

	public void dividir() {
		segundo = Double.parseDouble(text.getText());
		if (segundo > 0) {
			ans = primero / segundo;
			text.setText(String.valueOf(ans));
			try {
	            arduino.SendData(String.valueOf(ans));
	        } catch (Exception ex) {
	            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
	        }
			show = "";
			fsOper = true;
		} else {
			text.setText("Error: Division entre cero");
			try {
	            arduino.SendData("Math Error");
	        } catch (Exception ex) {
	            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
	        }
		}
	}

	public void addComponentes() {
		BorderLayout p1 = new BorderLayout();
		GridLayout p2 = new GridLayout(4, 4);
		JPanel pane = new JPanel();

		setLayout(p1);
		add(text, "North");
		add(pane, "Center");
		pane.setLayout(p2);

		for (int i = 0; i < 16; i++) {
			botones[i] = new JButton(n[i]);
			pane.add(botones[i]);
		}
		
		
	}
}