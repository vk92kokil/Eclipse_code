import java.awt.Color;

import java.io.IOException;
 
import java.util.logging.Level;

import java.util.logging.Logger;

import javax.swing.JApplet;

import javax.swing.JFrame;

 

public class go extends javax.swing.JApplet {

     

    static serverConnection connection = null;

    static String clientversion = "0.0.5";

    private static JApplet app = null;

 

    private static void startLogin() {

        loginPanel.setVisible(true);

    }

 


    public void init() {

        try {

            java.awt.EventQueue.invokeAndWait(new Runnable() {

                public void run() {

                    initComponents();

                }

            });

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")


    private void initComponents() {

 

        connectLabel = new javax.swing.JLabel();

        loginPanel = new javax.swing.JPanel();

        jTextField1 = new javax.swing.JTextField();

        jTextField2 = new javax.swing.JTextField();

        jLabel1 = new javax.swing.JLabel();

        jLabel2 = new javax.swing.JLabel();

        loginButton = new javax.swing.JButton();

        logLabel = new javax.swing.JLabel();

 

        connectLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        connectLabel.setText("Connecting to Server.");

 

        jTextField1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                woops(evt);

            }

        });

 

        jLabel1.setText("Username:");

 

        jLabel2.setText("Password:");

 

        loginButton.setText("Login");

        loginButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
         loginButtonActionPerformed(evt);

            }

        });

 

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);

        loginPanel.setLayout(loginPanelLayout);

        loginPanelLayout.setHorizontalGroup(

            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(loginPanelLayout.createSequentialGroup()

                .addContainerGap()

                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)

                    .addGroup(loginPanelLayout.createSequentialGroup()
                    .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                            .addComponent(jLabel1)

                            .addComponent(jLabel2))

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                   .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)

                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)

                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))))

                .addContainerGap())

        );

        loginPanelLayout.setVerticalGroup(

            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(loginPanelLayout.createSequentialGroup()

                .addContainerGap()

                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addComponent(jLabel1))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addComponent(jLabel2))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                .addComponent(loginButton)

                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

        );

 

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(

            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                        .addContainerGap()

                        .addComponent(logLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE))

                    .addGroup(layout.createSequentialGroup()

                        .addGap(259, 259, 259)

                        .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                    .addGroup(layout.createSequentialGroup()

                        .addContainerGap()

                        .addComponent(connectLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)))

                .addContainerGap())

        );

        layout.setVerticalGroup(

            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()

                .addContainerGap()

                .addComponent(connectLabel)

                .addGap(184, 184, 184)

                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)

                .addComponent(logLabel)

                .addContainerGap())

        );

    }// </editor-fold>                       

    private void woops(java.awt.event.ActionEvent evt) {                      

    }                     

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           


    }                                          

 

  /*  public static void main(String[] args){

 

        app = new go();

        app.init();

        app.start();

        app.setVisible(true);

        loginPanel.setVisible(false);

        System.out.println("started.");

 

        if(args[0] == null ? "yes" == null : args[0].equals("yes")){

            JFrame frame = new JFrame();

            frame.add(app);

            frame.pack();

            frame.setVisible(true);

 

        }

 

        setLogLabel("Connecting to server...");

 

        (connection = new serverConnection()).start();

        setLogLabel("Connecting to server at "+connection.host+":"+connection.port+"......");

        int con = 0;

 

        while(true){

            if(connection.connectionStatus==1){

                con=1;

                break;

            } else if(connection.connectionStatus==2){

                con=2;

                break;

            }

        }

 

        if(con==2){

            connectLabel.setText("Error connecting to server!");

            connectLabel.setForeground(Color.red);

            setLogLabel("Could not connect to server.");

        } else if(con==1){

            app.remove(connectLabel);

            setLogLabel("Connected now waiting for version check request..");

            app.repaint();

 

        try {

            String in = connection.is.readLine();

            if(in.equals("send_version")){

                setLogLabel("Been asked to check Client version by server");

 

                connection.os.println(clientversion);


                in = connection.is.readLine();

                if(in.equals("good_version")){

                    setLogLabel("Correct client version. Now you can login.");

                    startLogin();

                } else {

                    setLogLabel("This is not the latest version of the client. Please try restarting your browser.");

                }

            } else {

                setLogLabel("Confused.. Was expecting a version check from server.");

            }

        } catch (IOException ex) {

            System.err.println(ex);

        }

        }

    }*/

 

    public static void setLogLabel(String log){

        logLabel.setText(log);

        app.repaint();

    }

    private static javax.swing.JLabel connectLabel;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JTextField jTextField1;

    private javax.swing.JTextField jTextField2;

    private static javax.swing.JLabel logLabel;

    private javax.swing.JButton loginButton;

    private static javax.swing.JPanel loginPanel;

    // End of variables declaration                  

 

}
