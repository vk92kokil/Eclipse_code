
/* We will open Web pages with this applet. 
The user will be able to type in an address and the applet 
will try to open it. If the adress is malformed we will try to fix 
it or show an error. 
This example will show you also about String methods, which you can use 
to check user text input.
*/

import java.awt.*; 
import java.net.*; 
import java.awt.event.*; 

import javax.swing.JApplet;
 

public class openweblink extends JApplet implements ActionListener  
{ 
     TextField urlField; 
     Button goButton; 
 // This varable will determine if the URL should be loaded 
 // or if an error message should appear. 
     boolean UrlOnError; 
 // The URL that we want to display 
     URL userUrl;

     public void init()  
     { 
          setLayout(new FlowLayout()); 
          urlField = new TextField("RealApplets"); 
          goButton = new Button("Go!"); 
          urlField.addActionListener(this); 
          goButton.addActionListener(this); 
          add(urlField); 
          add(goButton); 
     }

     public void paint(Graphics g) 
     { 
          // Will display when correct URL are entered and when the applet starts. 
          // !UrlOnError means "do if UrlOnError is false"; 
          if (!UrlOnError)  
               g.drawString("Type your URL and click go!",20,80);

          // A help message to display when a bad URL has been typed. 
          // In this case an URL without a ".com" domain. 
          else  
          { 
               g.drawString("Malformed URL: "+userUrl,20,80); 
               g.drawString("This Applet only allows .com domains",20,100);  
          } 
     }

     public void actionPerformed(ActionEvent act)  
     { 
          // Start with good hope... 
           UrlOnError = false; 
          // Save the data of the textfield. 
          String temp = urlField.getText();

          // If the URL is longer than 6 characters.  
          if (temp.length() > 6)  
          { 
               // Then check if it starts with "http://" 
               if (!temp.substring(0,7).toUpperCase().equals("HTTP://")) 
                // if not then append it to it. 
                temp = "Http://" + temp; 
          } 
          // if it's not longer than 6 chars then it will surely miss 
          // the "http://" part. So we'll fix that. 
          else temp = "Http://" + temp; 

          // Now that the Http:// is there we'll check if it's a .com URL 
          // If the index of ".com" is -1 that means it isn't there. 
          //if (temp.indexOf(".com") == -1) 
           // So we'll show an error message later 
            //   UrlOnError = true;

          // Now it's time to transform the String to a real URL 
          try  
          {  
           // This will do that. 
               userUrl = new URL(temp); 
          } 
          // You MUST try-catch this method. 
          // If it is still wrong then we'll show an error message too. 
          catch (Exception e)  
          { 
               UrlOnError = true; 
          }  
          // Show the user what you have done with his typed in URL 
          urlField.setText(userUrl.toString());

          // And finally load a new browser window and show the page. 
          // If it was right of course. 
           if (!UrlOnError)  
           // This will do so. Note that the "_blank" part can be  
           // replaced with "_self" or "_parent" like in HTML. 
           // even frame targets are possible. 
           getAppletContext().showDocument(userUrl,"_blank"); 
          // Now show the error message or nothing if it was right. 
          repaint(); 
     }

}