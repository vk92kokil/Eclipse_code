import java.applet.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;

public class practice extends Applet implements ActionListener{

  public void init(){
  String link_Text = "google";
  Button b = new Button(link_Text);
  b.addActionListener(this);
  add(b);
  }

  public void actionPerformed(ActionEvent ae){
  //get the button label
  Button source = (Button)ae.getSource();

  String link = "http://www.google.com";
  try
  {
  AppletContext a = getAppletContext();
  URL u = new URL(link);
//  a.showDocument(u,"_blank");
//  _blank to open page in new window  
  a.showDocument(u,"_self");
  }
  catch (MalformedURLException e){
  System.out.println(e.getMessage());
  }
  }
}