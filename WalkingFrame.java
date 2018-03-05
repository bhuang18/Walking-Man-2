import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private ArrayList<ball> balls;
	public WalkingFrame()
	{
	setBounds (100,100,600,400);
	setLayout(null);
	man = new Man (0,0);
	balls = new ArrayList<>();
	add (man);
	Timer timer = new Timer (10, this);
	timer.start();
	addKeyListener(new KeyListener()
	{
		public void keyPressed (KeyEvent e)
		{	
			if(e.getKeyCode()== e.VK_SPACE)
			{
				ball ball = new ball(man.getX(),man.getY());
				balls.add(ball);
				add(ball);
			}
			if (e.getKeyCode() == e.VK_W)
			{
				man.setDY(-2);
			}
			
			if (e.getKeyCode() == e.VK_S)
			{
				man.setDY(2);
			}

			if (e.getKeyCode() == e.VK_A)
			{
				man.setDX(-2);
			}
			
			if (e.getKeyCode() == e.VK_D)
			{
				man.setDX(2);
			}
		}
		public void keyReleased (KeyEvent e)
		{
			if (e.getKeyCode() == e.VK_W)
			{
				man.setDY(0);
			}
			
			if (e.getKeyCode() == e.VK_S)
			{
				man.setDY(0);
			}
			
			if (e.getKeyCode() == e.VK_A)
			{
				man.setDX(0);
			}
			
			if (e.getKeyCode() == e.VK_D)
			{
				man.setDX(0);
			}

		}

		@Override
		public void keyTyped(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

	}
	);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
	new WalkingFrame();	
	}

	public void actionPerformed(ActionEvent e)
	{
		man.update();
		if(balls.size() != 0)
		{
			for(int i = balls.size()-1; i>=0; i--)
			{
				balls.get(i).update();
				if(balls.get(i).getX() > getWidth())
				{
					remove(balls.get(i));
					balls.remove(balls.get(i));
				}
			}
		}
		repaint();
	}
	
}
