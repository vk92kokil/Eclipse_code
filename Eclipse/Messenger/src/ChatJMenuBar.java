
/**
 * File: TextPadJMenuBar
 * TextPadJMenuBar is a JMenuBar for the frame of the main program
 * @author Anthony Turner
 *
 */

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ChatJMenuBar extends JMenuBar implements FileMenuConstants {

	//Constant fields
	private static final long serialVersionUID = 1L;

	//Instance fields
	private ChatClient chatFrame;

	/**
	 * Constructs a one parameterized new TextPadJMenuBar
	 * @param handler A file handler for file menu action events
	 */
	public ChatJMenuBar(ChatClient fileHandler){
		chatFrame = fileHandler;

		setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );	
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createToolMenu();
		createAboutMenu();
		createClock();
	}


	/*
	 * Creates a JMenu item with the given item text and a tool tip as it's arguments
	 */
	private JMenuItem createMenuItem(String itemLabel, String toolTip){

		JMenuItem menuItem = new JMenuItem(itemLabel);
		menuItem.setToolTipText(toolTip);
		menuItem.addActionListener( chatFrame.getClientHandler() );
		return menuItem;
	}

	/*
	 * Creates all file menu components
	 */
	private void createFileMenu() {
		JMenu file = new JMenu(MN_FILE);
		file.add(  createMenuItem(MI_NEW,  ""));
		file.add(  createMenuItem(MI_OPEN, ""));
		file.add(  createMenuItem(MI_SAVE, ""));
		file.add(  createMenuItem(MI_EXIT, ""));
		add(file);
	}

	/*
	 * Creates all edit menu components
	 */
	private void createEditMenu() {
		JMenu edit = new JMenu(MN_EDIT);
		edit.add( createMenuItem(MI_UNDO, "undo the last action."));
		edit.add( createMenuItem(MI_REDO, "redo the previous action."));
		edit.add( createMenuItem(MI_CUT, "Cut the selected text."));
		edit.add( createMenuItem(MI_COPY, "copy the selected text."));
		edit.add( createMenuItem(MI_PASTE, "paste the copied text."));
		add(edit);
	}

	/*
	 * Creates all format menu components
	 */
	private void createFormatMenu() {
		JMenu format = new JMenu(MN_FORMAT);
		JCheckBox wordCB = new JCheckBox(MI_WORD_WRAP);
		wordCB.addItemListener( chatFrame );

		format.add(wordCB);
		
		JMenuItem themes = new JMenuItem(MI_THEMES);
		themes.setActionCommand(MI_THEMES);
		themes.addActionListener( chatFrame.getClientHandler()  );
		format.add(themes);
		add(format);
		
		
	}

	/*
	 * Creates all tool menu components
	 */
	private void createToolMenu() {
		JMenu tools = new JMenu(MN_TOOLS);
		tools.add( createMenuItem(MI_FIND, ""));
		add(tools);
		
	}
	/*
	 * Creates all about menu components
	 */
	private void createAboutMenu() {
		JMenu about = new JMenu(MN_ABOUT);
		about.add(  createMenuItem(MI_HELP, ""));
		add(about);
	}

	/*
	 * Creates the clock and adds it to the JMenuBar
	 */
	private void createClock() {
		add( Box.createHorizontalGlue() ); //Adds space before the clock
		add( new Clock() ); //Add the clock
	}
}

