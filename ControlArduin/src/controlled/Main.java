package controlled;

import javax.swing.JFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setSize(300, 300);
		f. setLocation(200, 200);
		f.add(new MiPanel());
		f.setDefaultCloseOperation(3);
		
		f.setVisible(true);
	}

}
