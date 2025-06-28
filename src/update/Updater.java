package update;

import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Updater {
	private static ArrayList<Updateable> updateableObjects =new ArrayList<Updateable>();
	private static ArrayList<Updateable> addupdateableObjects= new ArrayList<Updateable>();
	private static ArrayList<Updateable> removeupdateableObjects= new ArrayList<Updateable>();
	
	public static void update() throws IOException ,UnsupportedAudioFileException,LineUnavailableException{
		for(Updateable object: updateableObjects)
			object.update();
		updateableObjects.removeAll(removeupdateableObjects);
		updateableObjects.addAll(addupdateableObjects);
		
		addupdateableObjects.clear();
		removeupdateableObjects.clear();
		}
	
	public static void addUpdateableObjects(Updateable object) {
		addupdateableObjects.add(object);
	}
	
	public static void removeUpdateableObjects(Updateable object) {
		removeupdateableObjects.add(object);
	}
	public static ArrayList<Updateable> getUpdateableObjects(){
		return updateableObjects;
	}
	
}
