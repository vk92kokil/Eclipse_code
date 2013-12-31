import java.awt.*;
import java.io.File;
import java.util.Random;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.util.Timer;


public class AudioPlay extends JPanel{
	static JFrame f = new JFrame();
	String path = "G:\\Eclipse\\Oracle practice\\src\\M.au";
	public AudioPlay(){
	try {
        AudioInputStream audio = AudioSystem.getAudioInputStream(new File(path));
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();
	}
	catch(Exception uae) {
		   System.out.println(uae);
		}
	}
	
	public static void main(String[] args){
		f.add(new AudioPlay());
		f.setSize(10,10);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	/*import  sun.audio.*;    //import the sun.audio package
	import  java.io.*;
	//** add this into your application code as appropriate
	// Open an input stream  to the audio file.
	InputStream in = new FileInputStream(Filename);
	// Create an AudioStream object from the input stream.
	AudioStream as = new AudioStream(in);         
	// Use the static class member "player" from class AudioPlayer to play
	// clip.
	AudioPlayer.player.start(as);            
	// Similarly, to stop the audio.
	AudioPlayer.player.stop(as);
	 */
}