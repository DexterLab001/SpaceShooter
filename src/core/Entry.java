package core;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import objects.BackGround;
import objects.EnemySpawner;
import objects.Spaceship;
import render.Renderer;
import update.Updater;

public class Entry {

	public static void main(String[] args) throws IOException,UnsupportedAudioFileException,LineUnavailableException {
		Window window = new Window("SpaceShooter",Window.getWinWidth(),Window.getWinHeight());
		
		Renderer renderer=new Renderer();
		Updater updater=new Updater();
		
		window.addKeyListener(new input());
		window.add(renderer);
		window.packWindow();
		window.setVisible(true);
		boolean runGame=true;
		
		new Spaceship(Window.getWinWidth()/2 - (Spaceship.width /2 ), Window.getWinHeight() - 150);
		new BackGround(-Window.getWinHeight());
		new EnemySpawner();		
		FPS.calcBeginTime();
		while(runGame) {
			updater.update();
			renderer.repaint();
			//update
			//render
			//recalculate
			FPS.calcDeltaTime();
		}

	}

}
