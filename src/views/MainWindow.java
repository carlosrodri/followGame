package views;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JFrame;
import controllers.Controller;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelDrawing panelDrawing;

	public MainWindow(Controller controller) {
		this.addKeyListener(controller);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelDrawing = new PanelDrawing(controller);

		add(panelDrawing, BorderLayout.CENTER);
		setVisible(true);
	}

	public void setPoint(Point point) {
		panelDrawing.setPoint(point);
	}

	public void setPointEnemy(ArrayList<Rectangle> list) {
		panelDrawing.setEnemyPoint(list);
	}

	public Point getPoint() {
		return panelDrawing.getPoint();
	}

	public void paint() {
		this.repaint();
	}

	public boolean validateColition() {
		return panelDrawing.validation();
	}

	public void setShoot() {
		// TODO Auto-generated method stub
		
	}

	public void setShootList(ArrayList<Rectangle> list) {
		panelDrawing.setShoot(list);
	}
}
