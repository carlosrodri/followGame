package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import controllers.Controller;

public class PanelDrawing extends JPanel{

	private static final long serialVersionUID = 1L;
	private Rectangle rectangle, rectangleE;
	private Point point, enemyPoint;
	private ArrayList<Rectangle> list, enemyList;

	public PanelDrawing(Controller controller) {
		this.addKeyListener(controller);
		point = new Point(150, 40);
		enemyPoint = new Point(0, 0);
		rectangle = new Rectangle((int)point.getX(), (int)point.getY() ,50, 50);
		rectangle.setLocation(point);
		rectangleE = new Rectangle((int)enemyPoint.getX(), (int)enemyPoint.getY() ,50, 50);
		rectangleE.setLocation(enemyPoint);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		rectangle.setLocation(point);
		g.fillOval((int)point.getX(), (int)point.getY(), 50, 50);
		paintEnemy(g);
		paintShoot(g);
	}

	private void paintShoot(Graphics g) {
		if(list != null && list.size() != 0) {
			for (Rectangle rectangle : list) {
				Rectangle r = new Rectangle((int)rectangle.getX(), (int)rectangle.getY(), 15, 15);
				g.fillOval((int)r.getX(), (int)r.getY(), 15, 15);
			}
		}
	}

	public void paintEnemy(Graphics g) {
		g.setColor(Color.red);
		if(enemyList != null && enemyList.size() != 0) {
			for (Rectangle rectangle : enemyList) {
				g.fillOval((int)rectangle.getX(), (int)rectangle.getY(), 15, 15);
			}
		}
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void setEnemyPoint(ArrayList<Rectangle> list) {
		this.enemyList = list;
	}

	public Point getPoint() {
		return point;
	}

	public boolean validation() {
		return rectangle.intersects(rectangleE);
	}

	public void setShoot(ArrayList<Rectangle> list) {
		this.list = list;
	}

}
