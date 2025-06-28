package update;

import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import render.Renderable;

public interface Updateable {
	public void update() throws IOException,UnsupportedAudioFileException,LineUnavailableException;
	public String getID();
	public Renderable getRenderable();
	
	public default Updateable isColliding(Renderable thisObject,String otherObjectID) {
		ArrayList<Updateable> objects=Updater.getUpdateableObjects();
		for(Updateable object: objects) 
			if(object.getID()==otherObjectID)
				if(thisObject.getX()<object.getRenderable().getX()+object.getRenderable().getWidth() && thisObject.getX()+thisObject.getWidth()>object.getRenderable().getX())
					if(thisObject.getY()<object.getRenderable().getY()+object.getRenderable().getHeight() && thisObject.getY()+thisObject.getHeight()>object.getRenderable().getY())
						return object;
			return null;

	}
}
