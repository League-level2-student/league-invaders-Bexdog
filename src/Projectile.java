import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
int speed = 10;
	public Projectile(int x, int y, int width, int height) {
	
		super(x, y, width, height);
		
	}
void update(int hi,int i) {
	super.update();
	this.y-=speed;	
	if(y < 0) {
			isAlive = false;
		}
		
	}
	void draw(Graphics g,int hi,int i) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
