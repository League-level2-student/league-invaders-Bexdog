import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
long enemyTimer=0;
long enemySpawnTime=1000;
int score = 0;
Rocketship rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Aliens> aliens = new ArrayList<Aliens>();
ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}
public int getScore() {
	return score;
}
	void update() {
		rocket.update(1);
		for(int i = 0;i<projectiles.size();i++) {
			projectiles.get(i).update(1,1);
			
		}
		for(int i = 0;i<aliens.size();i++) {
			
			aliens.get(i).update(1,1,1);
		}
	}
	void draw(Graphics g) {
		rocket.draw(g,1);
		for(int i = 0;i<projectiles.size();i++) {
			projectiles.get(i).draw(g,1,1);
			
		}
		for(int i = 0;i<aliens.size();i++) {
			
			aliens.get(i).draw(g,1,1,1);
		}
		
	}
	void addProjectile(Projectile i) {
		projectiles.add(i);
	}
	void addAlien(Aliens alien) {
		aliens.add(alien);
	}
	public void manageEnemies(){		
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addAlien(new Aliens(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
        }
}
void purgeObjects() {
	for(int i = 0;i<aliens.size();i++) {
		if(!aliens.get(i).isAlive) {
			aliens.remove(aliens.get(i));
		}
	}
	for(int i = 0;i<projectiles.size();i++) {
		if(!projectiles.get(i).isAlive) {
			projectiles.remove(projectiles.get(i));
		}
	}
	if(!rocket.isAlive) {
		
	}
}
void checkCollision() {
	for(Aliens a : aliens){
		if(rocket.collisionBox.intersects(a.collisionBox)){
               rocket.isAlive = false;
               
        }
	}
        for(Aliens b : aliens){
        	for(Projectile c : projectiles){
        		if(c.collisionBox.intersects(b.collisionBox)) {
        			b.isAlive = false;
        			c.isAlive = false;
        			score++;
        			
        	}
        	}
        }

}
}

