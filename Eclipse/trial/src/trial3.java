import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.MidiDevice.Info;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Port;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class trial3 extends JComponent{
	static JFrame frame = new JFrame();
	static Clip cl;
	static String path = "Pehlinazar.au";
	static String [] song = {"Pehli Nazar", "Teri Deewani"};
	static JSlider slider = new JSlider(0,100);static JLabel label = new JLabel("Volume");static JLabel txtlabel = new JLabel("Help");static JPanel panel = new JPanel();
	static JComboBox box = new JComboBox(song);
	static JTextField txt = new JTextField(15);static JButton addbutton = new JButton("Play"); 
	static float v = 0.33F;
	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("v.jpg"));
	public trial3(){
		frame.add(box,BorderLayout.NORTH);box.addItemListener(new SongChooser());
		panel.add(txtlabel);panel.add(txt);panel.add(addbutton);panel.add(label);panel.add(slider);		
		slider.setMajorTickSpacing(20);
		txtlabel.addMouseListener(new MouseListener(){
			String helpmsg = "Add Path like: \n \"C:\\\\Users\\\\Downloads\\\\song1.au\" without quotes\n( remember double \" \\ \" is necessary) \n and give path of the audio file of only .au format ";
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame f2 = new JFrame("Information");
				JTextArea area = new JTextArea();
				f2.setLocation(800, 400);f2.setSize(570, 200);
				area.setFont(new Font("Serif",Font.BOLD,25));area.setText(helpmsg);f2.add(area);
				f2.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				txtlabel.setToolTipText("Click here to know more:");
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		addbutton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				path = txt.getText();
				try{
					cl.stop();
					AudioInputStream audio = AudioSystem.getAudioInputStream(new File(path));	
					cl = AudioSystem.getClip();
					cl.open(audio);
					cl.start();
					cl.loop(Clip.LOOP_CONTINUOUSLY);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}
			}
			
		});
		slider.setPaintLabels(true);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setIconImage(icon);
		Task task = new Task();
		Timer timer = new Timer();
		timer.schedule(task,0,150);
	}
	public class SongChooser implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent event) {
			JComboBox s = (JComboBox) event.getSource();
			String str = (String) s.getSelectedItem();
			setSong(str);
		}
		public void setSong(String song){
			if(song.equalsIgnoreCase("Teri Deewani")){
			path = "teri_deewani.au";}
			else if(song.equalsIgnoreCase("Pehli Nazar")){
				path = "Pehlinazar.au";
			}
			try{
				cl.stop();
				AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(path));	
				cl = AudioSystem.getClip();
				cl.open(audio);
				cl.start();
				cl.loop(Clip.LOOP_CONTINUOUSLY);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex);
			}
		}
	}
	public static void main(String[] args) throws LineUnavailableException{
		final javax.sound.sampled.Port.Info source = Port.Info.SPEAKER;
		
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.metal.MetalLookAndFeel");
		}catch(Exception e3){
			System.out.println("Ero1");
		}
		try{
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(""));
			cl = AudioSystem.getClip();
			cl.open(audio);
			cl.start();
			cl.loop(2);
		}catch(Exception ex){
			cl = AudioSystem.getClip();JOptionPane.showMessageDialog(null,"Please Select the Song from the list");
		}
		
		frame.add(new trial3(),BorderLayout.CENTER);
		
		frame.setSize(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		slider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				v = slider.getValue();
				double d = v/100;
				if (AudioSystem.isLineSupported(source)) 
				{
					try 
					{
						Port outline = (Port) AudioSystem.getLine(source);
						outline.open();                
						FloatControl volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);                
						volumeControl.setValue((float) d); 
					} 
					catch (LineUnavailableException ex) 
					{
						System.err.println("source not supported");
						ex.printStackTrace();
					}
				}
			}
		});
	}

	public class Task extends TimerTask{

		@Override
		public void run() {
			trial4 obj = new trial4();
			frame.add(obj);frame.setVisible(true);
		}
	}
}