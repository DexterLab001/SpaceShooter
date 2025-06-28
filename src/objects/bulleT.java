package objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import core.FPS;
import core.Sound;
import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;

public class bulleT implements Updateable,Renderable{
	
	private static double width=10;
	private static double height=10;
	private double x;
	private double y;

	public final int layer=1;
	
	private static BufferedImage bullet;
	private static double speed=800;
	public bulleT(double x,double y ) throws IOException{
		this.x=x-(getWidth()/2);
		this.y=y;
		bullet=ImageIO.read(new File("res/Bullet.png"));
		Renderer.addRenderableObjects(this);
		Updater.addUpdateableObjects(this);
	}
	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public int getLayer() {
		return layer;
	}

	@Override
	public BufferedImage getBufferedImage() {
		return bullet;
	}

	@Override
	public void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		y-= speed * FPS.getDeltaTime();
		if(y<-getHeight()) {
			Updater.removeUpdateableObjects(this);
			Renderer.removeRenderableObjects(this);
		}
		Updateable collidingObject=isColliding(this,"enemy");
		if(collidingObject!=null) {
			Updater.removeUpdateableObjects(this);
		Renderer.removeRenderableObjects(this);
		
		Updater.removeUpdateableObjects(collidingObject);
		Renderer.removeRenderableObjects(collidingObject.getRenderable());
		
		Sound.playsound("res/Shooting.wav");
	}
	}
	@Override
	public String getID() {
		return "bulleT";
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
