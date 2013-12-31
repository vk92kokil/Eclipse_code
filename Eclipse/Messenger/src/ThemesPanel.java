/**
 * File: ThemesPanel.java
 * ThemesPanel manages themes in the Chat client
 * It changes the look and feel of the client specified by a list of themes
 * @author Anthony Turner
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ThemesPanel extends JPanel implements ActionListener{

	//Constant fields
	private static final long serialVersionUID = 1L;
	//Instance fields
	private ChatClient frame;

	/**
	 * Constructs a new ThemesPanel
	 * @param frame The chat clients frame
	 */
	public ThemesPanel(ChatClient frame){
		this.frame = frame;
		final JComboBox cb = new JComboBox( ThemeList.values() );
		cb.addActionListener( this );
		add(cb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		ThemeList themeName = (ThemeList)cb.getSelectedItem();
		//Update the main gui frame for chatClient and the themes combo box
		ChatClientUIManager.updateLook(themeName, frame);
		//update(themeName);
	}
}
