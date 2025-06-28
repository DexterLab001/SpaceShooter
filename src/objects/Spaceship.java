package objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import core.FPS;
import core.Sound;
import core.Timer;
import core.Window;
import core.input;
import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;

public class Spaceship implements Renderable, Updateable{
	public static double width = 75;
	private static double height = 75;
	private double x;
	private double y;
	
	private int layer=2;
	private static BufferedImage spaceShip;
	
	private double speed=200;
	
	private static int shootTimerMillis=500;
	Timer timer=new Timer(shootTimerMillis);
	
	public Spaceship(double x,double y) throws IOException{
		this.x=x;
		this.y=y;
		
		spaceShip=ImageIO.read(new File("res/Spaceship.png"));
		Renderer.addRenderableObjects(this);
		Updater.addUpdateableObjects(this);
	}
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	@Override
	public int getLayer() {
		return layer;
	}
	@Override
	public void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		if(input.keys[input.RIGHT] && x<= Window.getWinWidth()-width)
			x += speed * FPS.getDeltaTime();
		if(input.keys[input.LEFT] && x>=0)
			x -= speed * FPS.getDeltaTime();
		if(input.keys[input.UP] && y>=0)
			y -= speed * FPS.getDeltaTime();
		if(input.keys[input.DOWN] && y<=Window.getWinHeight()-height)
			y += speed * FPS.getDeltaTime();
		
		if(input.keys[input.SPACE]&& timer.isRinging()) {
			new bulleT(x+(getWidth()/2),y);
			timer.resetTimer();
			Sound.playsound("res/hit.wav");
			
	}
		
		Updateable collidingObject=isColliding(this,"enemy");
		if(collidingObject!=null) {
			Updater.removeUpdateableObjects(this);
		Renderer.removeRenderableObjects(this);
		
		Updater.removeUpdateableObjects(collidingObject);
		Renderer.removeRenderableObjects(collidingObject.getRenderable());
		
		Sound.playsound("res/DeathCall.wav");
	}
	}
	@Override
	public BufferedImage getBufferedImage() {
		
		return spaceShip;
	}
	@Override
	public String getID() {
		return "spaceShip";
	}
	@Override
	public Renderable getRenderable() {
		return this;
	}
	@Override
	public boolean drawCollisionBox() {
		return true;
	}
}
