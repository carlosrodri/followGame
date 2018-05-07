package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controllers.Controller;
import contstants.ConstantsUI;

public class PanelDrawing extends JPanel{

	private static final long serialVersionUID = 1L;
	private Rectangle player;
	private List<Rectangle> list, enemyList;
	private int life;
	private Image bullet, enemy, boss, gunman;

	public PanelDrawing(Controller controller) {
		bullet = new ImageIcon(getClass().getResource(ConstantsUI.BULLET_IMG)).getImage();
		enemy = new ImageIcon(getClass().getResource(ConstantsUI.ENEMY_IMG)).getImage();
		boss = new ImageIcon(getClass().getResource(ConstantsUI.BOSS_IMG)).getImage();
		gunman = new ImageIcon(getClass().getResource(ConstantsUI.GUNMAN_IMG)).getImage();
		this.addKeyListener(controller);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		paintPlayer(g);
		paintEnemy(g);
		paintShoot(g);
		paintLife(g);
	}

	private void paintLife(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(100, 25, life, 20);
		g.drawRect(100, 25, 100, 20);
		g.setColor(Color.BLACK);
		g.drawString("LIFE: " + life, 125, 40);
	}

	private void paintPlayer(Graphics g) {
		g.drawImage(gunman,(int)player.getX(), (int)player.getY(), (int)player.getWidth(), (int)player.getHeight(), this);
	}

	private void paintShoot(Graphics g) {
		g.setColor(Color.RED);
		if(list != null && list.size() != 0) {
			for (Rectangle rectangle : list) {
				g.drawImage(bullet,(int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight(), this);
			}
		}
	}

	public void paintEnemy(Graphics g) {
		g.setColor(Color.BLUE);
		if(enemyList != null && enemyList.size() != 0) {
			for (Rectangle rectangle : enemyList) {
				g.drawImage(enemy,(int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight(), this);
			}
		}
	}

	public void setEnemyPoint(List<Rectangle> list) {
		this.enemyList = list;
	}

	public void setShoot(List<Rectangle> list) {
		this.list = list;
	}

	public void setPlayer(Rectangle player) {
		this.player = player;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
}
