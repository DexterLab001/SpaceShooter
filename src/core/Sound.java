package core;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	public static void playsound(String filePath) throws UnsupportedAudioFileException,IOException, LineUnavailableException{
	AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File(filePath));
	Clip clip=AudioSystem.getClip();
	clip.open(audioInputStream);
	clip.setMicrosecondPosition(0);
	clip.start();
}
}
