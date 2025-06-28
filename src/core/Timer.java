package core;

import java.io.IOException;

import render.Renderable;
import update.Updateable;
import update.Updater;

public class Timer implements Updateable {
	int setMillisTime=0;
	int begginningMillisTime;
	
	public Timer(int setMillisTime) {
		this.begginningMillisTime=setMillisTime;
		Updater.addUpdateableObjects(this);
	}

	@Override
	public void update() throws IOException {
		setMillisTime-=FPS.getDeltaTime()*1000;
		
	}
	public boolean isRinging() {
		if(setMillisTime<=0)
			return true;
		return false;
	}
	public void resetTimer() {
		setMillisTime=begginningMillisTime;
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
