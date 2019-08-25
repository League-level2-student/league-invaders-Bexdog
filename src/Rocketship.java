import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject {
	int speed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=5;
	}
	void update(int hi) {
		
		if(up) {
			y-=speed;
		}
		if(down) {
			y+=speed;
		}
		if(left) {
			x-=speed;
		}
		if(right) {
			x+=speed;
		}
	}
	void draw(Graphics g,int hi) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
}
