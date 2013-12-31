import java.awt.Component;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class ChatClientUIManager {

	public static void updateLook(ThemeList themeName, Component frame) {
		try {
			UIManager.setLookAndFeel( themeName.getThemeUrl() );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI( frame );
							
	}
	
}
