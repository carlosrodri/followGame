package models;

import java.awt.Point;

public class Game extends MyThread{
	private int x;
	private int y;
	
	public Game(int sleep, int x, int y) {
		super(sleep);
		point = new Point(200, 25);
		enemy = new Point((int)point.getX()+50, (int)point.getY()+50);
		this.x = x;
		this.y = y;
	}

	Point enemy, point;


	public int randomPosition() {
		return (int)(Math.random()*x);
	}
	
	public int randomPositionY() {
		return (int)(Math.random()*y);
	}
	
	@Override
	public void executeTask() {
//		System.out.println(point.getX()-randomPosition()+"   x");
		enemy.setLocation(randomPosition(),randomPositionY());
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

	public Point getPoint() {
		return point;
	}
}
