import java.awt.Color;
import java.awt.Graphics;

public class Aliens extends GameObject {
//add cool movements
	public Aliens(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	void update(int hi, int ih, int i) {
		y+=5;
	}
	void draw(Graphics g,int hi, int ih, int i) {
		g.setColor(Color.yellow);
		g.drawRect(x, y, width, height);
	}
}
