import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import  javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener {
	 public static BufferedImage alienImg;

     public static BufferedImage rocketImg;

     public static BufferedImage bulletImg;

     public static BufferedImage spaceImg;


	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	public int currentState = 0;
	Font titleFont;
	Font otherFonts;
	boolean doiwanttobefixed=true;
	Rocketship ship = new Rocketship(250,700,50,50);
	ObjectManager manager = new ObjectManager(ship);
	public GamePanel() {
		timer=new Timer(1000/60,this);
		titleFont = new Font("Arial",Font.BOLD,50);
		otherFonts = new Font("Arial",Font.PLAIN,25);
		 try {

             alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

             rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

             bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

             spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

     } catch (IOException e) {

             // TODO Auto-generated catch block

             e.printStackTrace();

     }


	}
	void updateMenuState(){
		
	}
	void updateGameState(){
	
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		if(!ship.isAlive) {
			currentState = END_STATE;	
		}
	}
	void updateEndState(){
	
	}
	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);    
		g.setColor(Color.yellow);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 10, 200);
		g.setFont(otherFonts);
		g.drawString("Press ENTER To Start", 120, 325);
		g.drawString("Press SPACE For Instructions", 85, 450);
	}
	void drawGameState(Graphics g){
		
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);
		manager.draw(g);
		g.setFont(otherFonts);
		g.drawString(manager.getScore()+"", 400, 50);
		
	}
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString("Game Over", 100, 175);
		g.setFont(otherFonts);
		g.drawString("You killed "+manager.getScore()+" enemies", 120, 325);
		g.drawString("Press ENTER To Restart", 95, 450);
	}
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		if(currentState == MENU_STATE){

            updateMenuState();

    }else if(currentState == GAME_STATE){

            updateGameState();

    }else if(currentState == END_STATE){

            updateEndState();

    }
		
	}
	void startGame() {
		timer.start();
	}
	@Override

	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){

            drawMenuState(g);

    }else if(currentState == GAME_STATE){

            drawGameState(g);

    }else if(currentState == END_STATE){

            drawEndState(g);

    }
		
	        }
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode()==10) {		
			if(currentState==END_STATE) {
				ship = new Rocketship(250,700,50,50);
				manager = new ObjectManager(ship);
			}
			currentState++;
			
		}
		
		if(e.getKeyCode()==32) {
			if(currentState==0) {
				JOptionPane.showMessageDialog(null, "To play: use the wasd keys to move, "+"and the space bar to shoot, try not to get hit!");
			}
			manager.addProjectile(new Projectile(ship.x+20, ship.y, 10, 10));
		}
		if(currentState==3) {
			currentState=0;
		}
		if(e.getKeyCode()==87) {
			ship.up = true;
			
		}
		if(e.getKeyCode()==65) {
			ship.left = true;
			
		}
		if(e.getKeyCode()==83) {
			ship.down = true;
			
		}
		if(e.getKeyCode()==68) {
			ship.right = true;
			
		}
		//w:167 a:141 s:162 d:144
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==87) {
			ship.up = false;
			
		}
		if(e.getKeyCode()==65) {
			ship.left = false;
			
		}
		if(e.getKeyCode()==83) {
			ship.down = false;
			
		}
		if(e.getKeyCode()==68) {
			ship.right = false;
			
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
}