import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class LeagueInvaders {
	JFrame frame;
	GamePanel panel;
	int width=500;
	int height=800;
	public LeagueInvaders() {
		frame=new JFrame();
		 panel = new GamePanel();
	}
	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
		invaders.setup();
	}
	void setup() {
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
        frame.pack();
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
	}
}


