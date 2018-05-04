package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;

import controllers.Controller;

public class PanelDrawing extends JPanel{

	private static final long serialVersionUID = 1L;
	private Rectangle rectangle, rectangleE;
	private Point point, enemyPoint;
	
	public PanelDrawing(Controller controller) {
		this.addKeyListener(controller);
		point = new Point(150, 40);
		enemyPoint = new Point(0, 0);
		rectangle = new Rectangle((int)point.getX(), (int)point.getY() ,15, 15);
		rectangle.setLocation(point);
		rectangleE = new Rectangle((int)enemyPoint.getX(), (int)enemyPoint.getY() ,15, 15);
		rectangleE.setLocation(enemyPoint);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		rectangle.setLocation(point);
		g.fillOval((int)point.getX(), (int)point.getY(), 15, 15);
		paintEnemy(g);
	}
	
	public void paintEnemy(Graphics g) {
		rectangleE.setLocation(enemyPoint);
		g.setColor(Color.RED);
		g.fillOval((int)enemyPoint.getX(), (int)enemyPoint.getY(), 15, 15);
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}

	public void setEnemyPoint(Point point) {
		this.enemyPoint = point;
	}

	public Point getPoint() {
		return point;
	}
	
	public boolean validation() {
		return rectangle.intersects(rectangleE);
	}
	
}
