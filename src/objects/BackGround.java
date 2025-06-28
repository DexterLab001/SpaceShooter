package objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.FPS;
import core.Window;
import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;

public class BackGround implements Renderable, Updateable {
	
	private static double width = Window.getWinWidth();
	private static double height = Window.getWinHeight() *2;
	private static double x;
	private double y;
	
	private final int layer=0;
	
	private static BufferedImage backGround;
	private double speed =300;
	public BackGround(double y)throws IOException{
		this.y=y;
		
		backGround=ImageIO.read(new File("res/Background.png"));
		Renderer.addRenderableObjects(this);
		Updater.addUpdateableObjects(this);
	}
	@Override
	public void update() throws IOException {
		y += speed * FPS.getDeltaTime();
		
		if(y >=0)
			y= -Window.getWinHeight();	
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
		return backGround;
	}
	@Override
	public String getID() {
		return null;
	}
	@Override
	public Renderable getRenderable() {
		return null;
	}
	@Override
	public boolean drawCollisionBox() {
		
		return false;
	}

}
