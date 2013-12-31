/**
 * File: Clock.java
 * This class represents a clock with an hour, time, and seconds
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Clock extends JLabel implements ActionListener{
	
	//Constant fields
	private static final long serialVersionUID = 1L;
	private static final String PADDING = "  ";
	public static final int MILLISECONDS_PER_SECONDS = 999;//Number of milliseconds per seconds
	//Instance fields
	
	/**
	 * Constructs a zero parameter Clock
	 */
	public Clock(){
		setLabelProperties();	
		new Timer(MILLISECONDS_PER_SECONDS, this).start();
	}

	/*
	 * Updates the clocks time
	 */
	private void updateTime() {
		setText( getTime() ) ;
	}
	
	/*
	 * Set the properties for the label
	 */
	private void setLabelProperties() {
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	
	}
	
	/**
	 * @return Returns the current system time
	 */
	public String getTime(){
		Calendar cl = Calendar.getInstance();
		String hours = 	formatTime(cl.get(Calendar.HOUR), "Hour"); 
		String minutes = formatTime (cl.get(Calendar.MINUTE),"Minutes");
		String seconds = formatTime (cl.get(Calendar.SECOND), "Seconds");
		return PADDING + hours + ":" + minutes + ":" + seconds + PADDING;
	}
	
	/*
	 * Formats the current system time
	 */
	private String formatTime(int time, String hour) {

		switch( time ){
		
			case 0:	if( hour.equals("Hour") ){
					return "12";
					}else{
						return "00";
					}
				
			case 1: return "01";
			
			case 2: return "02";
				
			case 3: return "03";
			
			case 4: return "04";
				
			case 5: return "05";
			
			case 6: return "06";
				
			case 7: return "07";
			
			case 8: return "08";
				
			case 9: return "09";
				
			default : return String.valueOf(time);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateTime();
	}
}