import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import  javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	GameObject object;
	public GamePanel() {
		timer=new Timer(1000/60,this);
		object = new GameObject(50,50,100,100);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		object.update();
		
	}
	void startGame() {
		timer.start();
	}
	@Override

	public void paintComponent(Graphics g){
		object.draw(g);
		
	        }
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed");
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("realeased");
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
		
	}
}
