package objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import core.FPS;
import core.Window;
import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;

public class Enemy implements Updateable,Renderable{
	
	private double width;
	private double height;
	private double x;
	private double y;
	
	private final int layer=2;
	private static BufferedImage enemy;
	private double speed=150;
	Random rand=new Random();
	public Enemy() throws IOException {
		int dimensions=rand.nextInt(75+1);
		if(dimensions<35)
			dimensions=35;
		
		width=dimensions;
		height=dimensions;
		int posX=rand.nextInt((int)Window.getWinWidth()-(int)getWidth()+1);
		this.x=posX;
		this.y=-getHeight();
		
		enemy=ImageIO.read(new File("res/EnemySpaceship.png"));
		Renderer.addRenderableObjects(this);
		Updater.addUpdateableObjects(this);
	}
	
	@Override
	public void update() throws IOException {
		y+=speed *FPS.getDeltaTime();
		if(y>=Window.getWinHeight()) {
			Updater.removeUpdateableObjects(this);
			Renderer.removeRenderableObjects(this);
		}
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
		return enemy;
	}

	@Override
	public String getID() {
		return "enemy";
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
