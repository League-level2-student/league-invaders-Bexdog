import java.awt.Graphics;


public class GameObject {
	//remove randy later
	int randy=1;
	int x;
    int y;
    int width;
    int height;
   public GameObject(int x,int y,int width,int height) {
	   this.x=x;
	   this.y=y;
	   this.width=width;
	   this.height=height;
   }
   void update() {
	   if(randy%2==0) {	  
		   x+=60;
		   try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   else {
		   x-=30;  
		   try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   randy++;
   }
   void draw(Graphics g) {
	   g.fillRect(x, y, width, height);
   }
}
