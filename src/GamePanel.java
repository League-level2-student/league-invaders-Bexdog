import java.awt.Color;
import java.awt.Font;
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
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = 0;
	Font titleFont;
	Font otherFonts;
	boolean doiwanttobefixed=true;
	Rocketship ship = new Rocketship(250,700,50,50);
	ObjectManager manager = new ObjectManager(ship);
	public GamePanel() {
		timer=new Timer(1000/60,this);
		titleFont = new Font("Arial",Font.BOLD,50);
		otherFonts = new Font("Arial",Font.PLAIN,25);
	}
	void updateMenuState(){
		
	}
	void updateGameState(){
	
		manager.update();
		manager.manageEnemies();
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
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		manager.draw(g);
	}
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString("Game Over", 100, 175);
		g.setFont(otherFonts);
		g.drawString("You killed "+" enemies", 120, 325);
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
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==10) {
			currentState++;
		}
		if(e.getKeyCode()==32) {
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