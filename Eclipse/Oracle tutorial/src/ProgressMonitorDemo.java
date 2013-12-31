import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

import java.beans.*;
import java.util.Random;
 
public class ProgressMonitorDemo extends JPanel
                                 implements ActionListener,
                                            PropertyChangeListener {
 
    private ProgressMonitor progressMonitor;
    private JButton startButton;
    private JButton taskOutput,hidden = new JButton();
    private Task task;
    Icon icon = new ImageIcon(getClass().getResource("dukeWaveRed.gif"));
    class Task extends SwingWorker<Void, Void> {
        @Override
        public Void doInBackground() {
            Random random = new Random();
            int progress = 0;
            setProgress(0);
            try {
                Thread.sleep(1000);
                while (progress < 100 && !isCancelled()) {
                    //Sleep for up to one second.
                    Thread.sleep(random.nextInt(1000));
                    //Make random progress.
                    progress += random.nextInt(10);
                    setProgress(Math.min(progress, 100));
                }
            } catch (InterruptedException ignore) {}
            return null;
        }
 
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            startButton.setEnabled(true);
            progressMonitor.setProgress(0);
            progressMonitor.close();hidden.setIcon(icon);hidden.setBackground(Color.MAGENTA);hidden.setFocusable(false);hidden.setBorderPainted(false);
            taskOutput.setEnabled(true); taskOutput.setBackground(Color.MAGENTA);taskOutput.setText("");taskOutput.add(hidden);
//            taskOutput.addMouseMotionListener(new Listener());
            hidden.addMouseMotionListener(new Listener());
            JColorChooser j = new JColorChooser();
//            taskOutput.add(j);
        }
    }
    public class Listener extends JComponent implements MouseMotionListener{
		@Override
		public void mouseDragged(MouseEvent e1) {
			hidden.setLocation(-icon.getIconWidth()/2 + e1.getX(), -icon.getIconHeight()/2 + e1.getY());	
		}

		@Override
		public void mouseMoved(MouseEvent e2) {
			
		}
    	
    }
    public ProgressMonitorDemo() {
        super(new BorderLayout());
 
        //Create the demo's UI.
        startButton = new JButton("Start");
        startButton.setActionCommand("start");
        startButton.addActionListener(this);
        
//        taskOutput = new JTextArea(5, 20);
        taskOutput = new JButton();
        taskOutput.setMargin(new Insets(5,5,5,5));
        taskOutput.setEnabled(false);
 
        add(startButton, BorderLayout.PAGE_START);
        add(new JScrollPane(taskOutput), BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
 
 
    /**
     * Invoked when the user presses the start button.
     */
    public void actionPerformed(ActionEvent evt) {
        progressMonitor = new ProgressMonitor(ProgressMonitorDemo.this,
                                  "Running a Long Task",
                                  "", 0, 100);
        progressMonitor.setProgress(0);
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
        startButton.setEnabled(false);
    }
 
    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName() ) {
            int progress = (Integer) evt.getNewValue();
            progressMonitor.setProgress(progress);
            String message =
                String.format("Completed %d%%.\n", progress);
            progressMonitor.setNote(message);
//            taskOutput.append(message);
            taskOutput.setText(message);
            if (progressMonitor.isCanceled() || task.isDone()) {
                Toolkit.getDefaultToolkit().beep();
                if (progressMonitor.isCanceled()) {
                    task.cancel(true);
//                    taskOutput.append("Task canceled.\n");
                    taskOutput.setText("Task canceled.\n");
                } else {
//                    taskOutput.append("Task completed.\n");
                    taskOutput.setText("Task completed.\n");
                }
                startButton.setEnabled(true);
            }
        }
 
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ProgressMonitorDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new ProgressMonitorDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
                createAndShowGUI();
            }
        });
    }
}
