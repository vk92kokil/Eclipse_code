import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class CinnaChat extends JFrame
{
  JLabel lblServerIP = new JLabel("Server IP:");
  JTextField serverIP = new JTextField(15);
  JLabel lblPort = new JLabel("Port Num:");
  JTextField port = new JTextField(15);
  JLabel lblName = new JLabel("NickName:");
  JTextField name = new JTextField(15);
  JRadioButton serverBTN = new JRadioButton("Server (Host)");
  JRadioButton clientBTN = new JRadioButton("Client (Guest)");
  JButton connect = new JButton("Connect");
  JButton disconnect = new JButton("Disconnect");
  JTextArea messages = new JTextArea("",10,21);
  JTextField mssg = new JTextField(15);
  JButton send = new JButton("Send");
  JLabel lbl = new JLabel("Chat");
  Font btn = new Font("times new roman",Font.BOLD,20);
  Font lblFont = new Font("times new roman",Font.BOLD+Font.HANGING_BASELINE,45);
  Socket socket = null;
  Socket socket2 = null;
  ServerSocket serverSocket = null;
  PrintWriter out = null;
  BufferedReader in = null;
  PrintWriter out2 = null;
  BufferedReader in2 = null;
  boolean server = true;
  Color purple = new Color(108,111,206);
  Color yellow = new Color(173,115,5);
  Color blue = new Color(15,11,102);
  public CinnaChat()
  {
    super("CinnaChat");
    setSize(505,250);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    Container contentArea = getContentPane();
    GridLayout flowManager = new GridLayout(1,2);
    contentArea.setLayout(flowManager);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    setCursor(cursor);
    JPanel pnl = new JPanel();
    pnl.add(lbl);
    lbl.setFont(lblFont);
    lbl.setForeground(Color.darkGray);
    pnl.add(lblServerIP);
    lblServerIP.setForeground(purple);
    pnl.add(serverIP);
    pnl.add(lblPort);
    lblPort.setForeground(purple);
    pnl.add(port);
    pnl.add(lblName);
    lblName.setForeground(purple);
    pnl.add(name);
    ButtonGroup type = new ButtonGroup();
    type.add(serverBTN);
    serverBTN.setForeground(yellow);
    serverBTN.addActionListener(
        new ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          {
            server = true;
          }
        }
    );
    type.add(clientBTN);
    clientBTN.setForeground(yellow);
    clientBTN.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            server = false;
          }
        }
    );
    pnl.add(serverBTN);
    pnl.add(clientBTN);
    pnl.add(connect);
    connect.addActionListener(
        new ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          {
            connect();
          }
        }
    );
    connect.setFont(btn);
    connect.setForeground(blue);
    pnl.add(disconnect);
    disconnect.setEnabled(false);
    disconnect.addActionListener(
        new ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          {
            disconnect();
          }
        }
    );
    disconnect.setFont(btn);
    disconnect.setForeground(blue);
    contentArea.add(pnl);
    JPanel pnl2 = new JPanel();
    pnl2.add(new JScrollPane(messages,
                             JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                             JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
    messages.setEditable(false);
    messages.setCursor(new Cursor(Cursor.TEXT_CURSOR));
    pnl2.add(mssg);
    pnl2.add(send);
    send.setEnabled(false);
    send.addActionListener(
        new ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          {
            send();
          }
        }
    );
    contentArea.add(pnl2);
    contentArea.setBackground(Color.white);
    setContentPane(contentArea);
  }
  public void connect()
  {
    serverBTN.setEnabled(false);
    clientBTN.setEnabled(false);
    disconnect.setEnabled(true);
    connect.setEnabled(false);
    send.setEnabled(true);
    try
    {
      if(!server)
      {
        try
        {
          socket = new Socket(serverIP.getText(),
                              Integer.parseInt(port.getText()));
          out = new PrintWriter(socket.getOutputStream(), true);
          in = new BufferedReader(new InputStreamReader(
              socket.getInputStream()));
          messages.append(in.readLine());
        }
        catch (Exception hostEx)
        {
          JOptionPane.showMessageDialog(null,"Error with port number or IP "+
                                        "Address.","Error",
                                        JOptionPane.ERROR_MESSAGE);
        }
      }
      else
      {
        try
        {
          serverSocket = new ServerSocket(Integer.parseInt(port.getText()));
        }
        catch (Exception portInUseEx)
        {
          JOptionPane.showMessageDialog(null,"Port in use.  Select a different "+
                                        "port.","Port in Use",
                                        JOptionPane.ERROR_MESSAGE);
        }
        PrintWriter out2 = new PrintWriter(
                      socket2.getOutputStream(), true);
        BufferedReader in2 = new BufferedReader(
                        new InputStreamReader(
                            socket2.getInputStream()));
        messages.append(in2.readLine());
      }
    }
    catch (Exception exception)
    {
    }
  }
  public void disconnect()
  {
    serverBTN.setEnabled(true);
    clientBTN.setEnabled(true);
    disconnect.setEnabled(false);
    connect.setEnabled(true);
    send.setEnabled(false);
    try
    {
      if(!server)
      {
        out.close();
        in.close();
        socket.close();
      }
      else
      {
        out2.close();
        in2.close();
        socket2.close();
        serverSocket.close();
      }
    }
    catch(Exception closeEx)
    {
    }
  }
  public void send()
  {
    try
    {
      if(!server)
      {
        messages.append(name.getText() + ":  " + mssg.getText() + "\n");
        out.println(name.getText() + ":  " + mssg.getText());
      }
      else
      {
        messages.append(name.getText() + ":  " + mssg.getText() + "\n");
        out2.println(name.getText() + ":  " + mssg.getText());
      }
    }
    catch(Exception e3)
    {
    }
  }
  public static void main (String [] args)
  {
    new CinnaChat();
  }
}