package objects;

import java.io.IOException;

import core.Timer;
import render.Renderable;
import update.Updateable;
import update.Updater;

public class EnemySpawner implements Updateable{
	Timer timer=new Timer(500);
	public EnemySpawner() {
				Updater.addUpdateableObjects(this);
				
	}
	@Override
	public void update() throws IOException {
	if(timer.isRinging()) {
		new Enemy();
		timer.resetTimer();
	}
		
	}
	@Override
	public String getID() {
		return null;
	}
	@Override
	public Renderable getRenderable() {
		return null;
	}

}
