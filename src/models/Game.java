package models;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game extends MyThread{
	private Rectangle player;
	private List<Rectangle> shootList, enemyList;

	private int x, y;
	private int life, level;

	public Game(int sleep, int x, int y) {
		super(sleep);
		this.x = x;
		this.y = y;
		player = new Rectangle(0, 0, 50, 50);
		shootList = new ArrayList<>();
		enemyList = new ArrayList<>();
		life = 100;
		level = 1;
	}

	//	private int randomPosition() {
	//		return (int)(Math.random()*x);
	//	}

	private int randomPositionY() {
		return (int)(Math.random()*(y-50))+100;
	}

	private void quitLife() {
		life -= 5;
	}

	public int getLife() {
		return life;
	}

	@Override
	public void executeTask() {
		paintEnemy();
		paintShoot();
	}

	private void paintEnemy() {
		for (Rectangle rectangle : enemyList) {
			rectangle.setLocation((int)rectangle.getX()-15, (int)rectangle.getY());
		}
	}

	private void paintShoot() {
		for (Rectangle rectangle : shootList) {
			rectangle.setLocation((int)rectangle.getX()+15, (int)rectangle.getY());
		}
	}

	public void moveleft() {
		player.setLocation((int)player.getX()-20, (int)player.getY());
	}

	public void moveRigth() {
		player.setLocation((int)player.getX()+20, (int)player.getY());
	}

	public void moveUp() {
		player.setLocation((int)player.getX(), (int)player.getY()-20);
	}

	public void moveDown() {
		player.setLocation((int)player.getX(), (int)player.getY()+20);
	}

	public void addEnenmy() {
		if(level != 5) {
			for (int i = 0; i < level*5; i++) {
				enemyList.add(new Rectangle(x+10, randomPositionY(), 50, 50));
			}
			level ++;
		}else {
			enemyList.add(new Rectangle(x, randomPositionY(), 100, 100));
		}
	}
	
	public void addShoot() {
		shootList.add(new Rectangle((int)player.getX(), (int)player.getY(), 10, 10));
	}

	public List<Rectangle> getEnemyList(){
		return enemyList;
	}

	public List<Rectangle> getList(){
		return shootList;
	}

	public Rectangle getPlayer() {
		return player;
	}

	public void validate() {
		for (Iterator<Rectangle> shoot = shootList.iterator(); shoot.hasNext();) {
			Rectangle s = shoot.next();
			for (Iterator<Rectangle> enemy =  enemyList.iterator(); enemy.hasNext();) {
				Rectangle e = enemy.next();
				if(s.intersects(e)) {
					enemy.remove();
				}
			}
		}
	}

	public void validateLife() {
		for (Iterator<Rectangle> enemy =  enemyList.iterator(); enemy.hasNext();) {
			Rectangle e = enemy.next();
			if(player.intersects(e)) {
				enemy.remove();
				quitLife();
			}
		}
	}

	public boolean validateLevel() {
		if(enemyList == null && life > 0 || enemyList.size() == 0) {
			shootList.clear();
			return true;
		}else {
			return false;
		}
	}
	
	public void setEnemyList(List<Rectangle> enemyList) {
		this.enemyList = enemyList;
	}
}
