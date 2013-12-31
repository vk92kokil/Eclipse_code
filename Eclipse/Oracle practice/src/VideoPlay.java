import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import javax.management.*;
import javax.sound.midi.*;
import javax.swing.JPanel;
   
   	public class VideoPlay extends JPanel
   	{
      	 public VideoPlay( URL mediaURL )
      	 {
         	 setLayout( new BorderLayout() ); // use a BorderLayout
   
         	 // Use lightweight components for Swing compatibility
   	 Manager.setHint( Manager.LIGHTWEIGHT_RENDERER, true );
         
         	 try
         	 {
            	 // create a player to play the media specified in the URL
            	 Player mediaPlayer = Manager.createRealizedPlayer( mediaURL );
   
            	 // get the components for the video and the playback controls
            	 Component video = mediaPlayer.getVisualComponent();
            	 Component controls = mediaPlayer.getControlPanelComponent();
            
            	 if ( video != null )
               	 add( video, BorderLayout.CENTER ); // add video component
   
            	 if ( controls != null )
               	 add( controls, BorderLayout.SOUTH ); // add controls
   
            	 mediaPlayer.start(); // start playing the media clip
         	 } // end try
         	 catch ( NoPlayerException noPlayerException )
         	 {
            	 System.err.println( "No media player found" );
         	 } // end catch
         	 catch ( CannotRealizeException cannotRealizeException )
   	 {
            	 System.err.println( "Could not realize media player" );
         	 } // end catch
         	 catch ( IOException iOException )
	   {
            	 System.err.println( "Error reading from the source" );
         	 } // end catch
	      } // end MediaPanel constructor
      	 /*private void displayVideo (int i) {
  Player player = null;
  try {
     URL mediaURL = new URL("File://C:/Users/Jess/workspace/Play/src/movies/1.avi");
     player = Manager.createRealizedPlayer( mediaURL );
     if (player.getVisualComponent() != null){
        add("Center", player.getVisualComponent());
     }
     if (player.getControlPanelComponent() != null){
        add("South", player.getControlPanelComponent());
     }
  }
  catch (Exception b) {
     System.err.println( "Got exception " + b );
  }
  player.start();*/
      	 public static void main(String[] args){
      		 new VideoPlay();
      	 }
  	} // end class MediaPanel