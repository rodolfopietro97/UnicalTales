package unicaltales.graphics.simple;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author rodolfo
 * This class implements the mouse with awt framework
 */
public class MyAwtMouse extends MouseAdapter{
	
	private boolean click;
	
	public MyAwtMouse() {
		// TODO Auto-generated constructor stub
		click = false;
	}
	
	public boolean isClick() {
		return click;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		click = true;
		
		System.out.println(e.getX());
		System.out.println(e.getY());
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		
		System.out.println(e.getX());
		System.out.println(e.getY());
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
		
		click = false;
	}
	
	

	

}
