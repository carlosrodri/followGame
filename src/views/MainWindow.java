package views;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.List;

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

	public void setPointEnemy(List<Rectangle> list) {
		panelDrawing.setEnemyPoint(list);
	}

	public void paint() {
		this.repaint();
	}

	public void setShootList(List<Rectangle> list) {
		panelDrawing.setShoot(list);
	}

	public void setPoint(Rectangle player) {
		panelDrawing.setPlayer(player);
	}

	public void setLife(int life) {
		panelDrawing.setLife(life);
	}
}
