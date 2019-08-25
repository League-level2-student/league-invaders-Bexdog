import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
long enemyTimer=0;
long enemySpawnTime=1000;
Rocketship rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Aliens> aliens = new ArrayList<Aliens>();
ObjectManager(Rocketship rocket){
		this.rocket = rocket;
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
}

}

