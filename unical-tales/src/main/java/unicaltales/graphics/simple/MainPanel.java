/**
 * 
 */
package unicaltales.graphics.simple;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author rodolfo
 * MainPanel of Swing and Awt 2d Simple Graphics implementation
 */
public class MainPanel extends JPanel {
	
	
	/**
	 * Empty Constructor
	 */
	public MainPanel() {
		// setto il background
		setBackground(new Color(0, 0, 0));
		
		repaint();
	}

	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString("Weeeeeee", 10, 10);
		g.drawRect(100, 100, 300, 300);
		g.drawLine(0, 0, 150, 150); // linea di esempio
	}
	
	

}
