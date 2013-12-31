
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
*/

public class ChatSound {

	public static final String SUBMIT_SOUND = "sounds/submit.wav";
	
	public static void play(String soundPath){
		
		
		//** add this into your application code as appropriate
		// Open an input stream  to the audio file.
		InputStream in;
		try {
			in = new FileInputStream(soundPath);
			// Create an AudioStream object from the input stream.
		/*	AudioStream as = new AudioStream(in);  
			// Use the static class member "player" from class AudioPlayer to play
			// clip.
			AudioPlayer.player.start(as);            
			*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		       
		
	}

}
