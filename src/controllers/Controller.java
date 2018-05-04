package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import models.Game;
import views.MainWindow;

public class Controller implements KeyListener{
	private Game game;
	private MainWindow mainWindow;
	private Timer timer;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		game = new Game(500, mainWindow.getWidth(), mainWindow.getHeight());
		game.start();
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.paint();
				mainWindow.setPointEnemy(game.getEnemyPoint());
				validate();
			}
		});
		timer.start();
	}
	
	private void validate() {
		if(mainWindow.validateColition()) {
			JOptionPane.showMessageDialog(null, "you Died");
			System.exit(0);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left();
			break;
		case KeyEvent.VK_RIGHT:
			right();
			break;
		case KeyEvent.VK_UP:
			up();
			break;
		case KeyEvent.VK_DOWN:
			down();
			break;
		} 
	}

	private void down() {
		mainWindow.setPoint(game.moveDown());
	}

	private void up() {
		mainWindow.setPoint(game.moveUp());
	}

	private void right() {
		mainWindow.setPoint(game.moveRigth());
	}

	private void left() {
		mainWindow.setPoint(game.moveleft());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	public static void main(String[] args) {
		new Controller();
	}
}
