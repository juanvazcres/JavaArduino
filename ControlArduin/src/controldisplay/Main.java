package controldisplay;

import javax.swing.JFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.add(new MiPanel());
		f.setSize(200,200);
		f.setLocation(200,200);
		f.setDefaultCloseOperation(3);
		f.setVisible(true);
	}

}
