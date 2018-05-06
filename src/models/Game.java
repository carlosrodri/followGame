package models;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Game extends MyThread{
	private int value;
	private Point enemy, point;
	private ArrayList<Rectangle> shootList, enemyList;
	private int x, y;

	public Game(int sleep, int x, int y) {
		super(sleep);
		point = new Point(200, 25);
		enemy = new Point((int)point.getX()+50, (int)point.getY()+50);
		value = 500;
		shootList = new ArrayList<>();
		enemyList = new ArrayList<>();
	}

	private int randomPosition() {
		return (int)(Math.random()*x);
	}

	private int randomPositionY() {
		return (int)(Math.random()*y);
	}

	@Override
	public void executeTask() {
		enemy.setLocation(point.getX()-value, point.getY()-value);
		value -= 10;
		paintShoot();
	}

	private void paintShoot() {
		for (Rectangle rectangle : shootList) {
			rectangle.setLocation((int)rectangle.getX()+15, (int)rectangle.getY());
		}
	}

	public Point moveleft() {
		point.setLocation(point.getX()-20, point.getY());
		return point;
	}

	public Point moveRigth() {
		point.setLocation(point.getX()+20, point.getY());
		return point;
	}

	public Point moveUp() {
		point.setLocation(point.getX(), point.getY()-20);
		return point;
	}

	public Point moveDown() {
		point.setLocation(point.getX(), point.getY()+20);
		return point;
	}

	public Point getEnemyPoint() {
		return enemy;
	}

	public void addEnenmy() {
		enemyList.add(new Rectangle(randomPosition(), randomPositionY(), 50, 50));
	}
	
	public Point getPoint() {
		return point;
	}

	public void addShoot() {
		shootList.add(new Rectangle((int)point.getX(), (int)point.getY(), 10, 10));
	}

	public ArrayList<Rectangle> getEnemyList(){
		return enemyList;
	}
 	
	public ArrayList<Rectangle> getList(){
		return shootList;
	}
}
