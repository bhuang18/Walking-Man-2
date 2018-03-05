import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class ball extends JComponent
{

	public ball (int x, int y)
	{
		setLocation (x,y);
		setSize(40,40);
	}

	public void paintComponent (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		Ellipse2D.Double ball = new Ellipse2D.Double(4,0,10,10);
		g2.fill(ball);
	}
	private int dy = 0;
	private int dx = 4;
	
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
		
	}	

	
}