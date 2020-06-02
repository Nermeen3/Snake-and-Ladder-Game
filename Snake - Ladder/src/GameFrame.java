
/**
 *
 * @author nina
 */
//package mp3_player;
import sun.audio.*;
import java.io.*;
import java.util.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.*;
public class GameFrame extends javax.swing.JFrame {
    private String name1,name2;
    private int player1_dice,player2_dice; //these are for players dice's variable
    private int first_player_dice,second_player_dice;   //these are for knowing who will start so each is used one time
    private int turn;
    //private boolean first=true;
    private int dice_turn=1,dice2_turn=0;
    private boolean New_Game=false;
    private final int rows=6;
    private final int columns=6;
    private int Player1_Location=1;
    private int Player2_Location=1;
    private int x1;
    private int x2;
    private int snake_positions[][];
    private int ladder_positions[][];
    private final int snakes_number=5;
    private final int ladders_number=5;
    private int on_off,second;
    boolean s=true;
    //private AudioPlayer fall_sound_player = AudioPlayer.player;
    //private AudioStream fall_sound;
    //private AudioData MD;
    //private ContinuousAudioDataStream loop;

    /**
     * Creates new form GameFrame
     */
    public String getname1(){return name1;}//??
    public String getname2(){return name2;}//??

    public GameFrame() {
        super("Snakes and Ladders");
        initComponents();
        setSize(1250,800);
        setSnakes();
        setLadders();
    } 

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setBounds(new java.awt.Rectangle(200, 10, 50, 50));
        setMinimumSize(new java.awt.Dimension(1500, 1000));
        setSize(new java.awt.Dimension(1500, 1500));
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Capture.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 40, 742, 740);

        jButton1.setBackground(new java.awt.Color(102, 102, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton1.setText("START GAME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1000, 150, 240, 120);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice.PNG"))); // NOI18N
        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1060, 370, 140, 150);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel2.setText("player's turn,");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(890, 300, 460, 70);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(1070, 590, 120, 60);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel3.setText("Dice Result :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(890, 520, 140, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penguin.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1070, 80, 30, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monkey.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1160, 80, 30, 30);

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/music2.PNG"))); // NOI18N
        jButton3.setText("Music");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1290, 20, 100, 90);

        jMenu1.setText("File");

        jMenuItem1.setText("New /game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar2.add(jMenu1);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Random rand = new Random();
        int d;
        s=true;
      if(New_Game==true)
      {
        if(evt.getSource()==jButton2)
        {
            if(dice_turn >= 3) //this is where characters should move ,,should use random genertator here and store player1_dice and player2_dice
            {
                if(turn%2 == 0) //if turn is even then its player's 1 turn if odd then player's 2 turn and gotta set label and make random
                {   //HERE ONLY USE PLAYER1_DICE AND PLAYER2_DICE FOR MOVING CHAR IN LABELS AND FOR CURRENT POSITION DONT USE FIRST_PLAYER_DICE AND SECOND_PLAYER_DICE          
                    d = rand.nextInt(6)+1;
                    jTextField1.setText(Integer.toString(d));
                    jLabel2.setText( name1 + ", its your turn,, ROLL THE DICE"); 
                    player1_dice=Integer.parseInt(jTextField1.getText());
                    Player1_Location+=player1_dice;
                    //if player 2 dice roll is higher than the board finish line at the end
                    if (Player1_Location>36)
                    {
                        Player1_Location-=player1_dice;
                        JOptionPane.showMessageDialog(null, "Out of Bounds!, Try again next turn");
                        jTextField1.setText(" ");
                    }
                    //if player 1 lands on a snake
                    for(int i=0;i<snakes_number;i++)
                    {
                        if(Player1_Location == snake_positions[i][0])
                        {
                            Player1_Location = snake_positions[i][1];
                            try{
                            JFXPanel j = new JFXPanel();
                            String uri;
                             uri = new File("fall.mp3").toURI().toString();
                             new MediaPlayer(new Media(uri)).play();
                            }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
                            
                            JOptionPane.showMessageDialog(null, "R.I.P");
                        }
                    }
                    //if player 1 lands on a ladder
                    for(int j=0;j<ladders_number;j++)
                    {
                        if(Player1_Location == ladder_positions[j][0])
                        {
                            Player1_Location = ladder_positions[j][1];
                            try{
                            JFXPanel jw = new JFXPanel();
                            String uri;
                            uri = new File("climbing.mp3").toURI().toString();
                            new MediaPlayer(new Media(uri)).play();    
                            }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
                            JOptionPane.showMessageDialog(null, "Oh Yeah! Mwahahahaha!");
                        }
                    }
                    
                    //defining x coordinates for player 1
                    if (Player1_Location==1 || Player1_Location==12 || Player1_Location==13 || Player1_Location==24 || Player1_Location==25 || Player1_Location==36)
                        x1=55;
                    else if(Player1_Location==2 || Player1_Location==11 || Player1_Location==14 || Player1_Location==23 || Player1_Location==26 || Player1_Location==35)
                        x1=180;
                    else if(Player1_Location==3 || Player1_Location==10 || Player1_Location==15 || Player1_Location==22 || Player1_Location==27 || Player1_Location==34)
                        x1=305;
                    else if (Player1_Location==4 || Player1_Location==9 || Player1_Location==16 || Player1_Location==21 || Player1_Location==28 || Player1_Location==33)
                        x1=430;
                    else if (Player1_Location==5 || Player1_Location==8 || Player1_Location==17 || Player1_Location==20 || Player1_Location==29 || Player1_Location==32)
                        x1=555;
                    else if (Player1_Location==6 || Player1_Location==7 || Player1_Location==18 || Player1_Location==19 || Player1_Location==30 || Player1_Location==31)
                        x1=680;
                    
                    //setting positions for player 1
                    for(int r=0;r<rows;r++)
                    {
                        for(int c=0;c<columns;c++)
                        {
                          if(Player1_Location%6!=0)
                          {
                            switch(Player1_Location/6)
                            {
                                case 0:
                                    jLabel4.setLocation(x1,625);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 1:
                                    jLabel4.setLocation(x1,500);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 2:
                                    jLabel4.setLocation(x1,375);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 3:
                                    jLabel4.setLocation(x1,250);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 4:
                                    jLabel4.setLocation(x1,125);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 5:
                                    jLabel4.setLocation(x1,0);
                                    jLabel1.add(jLabel4);
                                    break;
                            }
                          }
                          else
                          {
                              switch(Player1_Location/6)
                            {
                                case 1:
                                    jLabel4.setLocation(x1,625);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 2:
                                    jLabel4.setLocation(x1,500);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 3:
                                    jLabel4.setLocation(x1,375);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 4:
                                    jLabel4.setLocation(x1,250);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 5:
                                    jLabel4.setLocation(x1,125);
                                    jLabel1.add(jLabel4);
                                    break;
                                case 6:
                                    jLabel4.setLocation(x1,0);
                                    jLabel1.add(jLabel4);
                                    break;
                            }
                          }
                        }
                    }
                    //if player 1 wins the game
                    if (Player1_Location == 36)
                    {
                        Player1_Location=1;
                        Player2_Location=1;
                        
                        try{
                        JFXPanel j = new JFXPanel();
                        String uri;
                        uri = new File("ending.mp3").toURI().toString();
                        new MediaPlayer(new Media(uri)).play();
                        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
                        
                        try{
                        JFXPanel j = new JFXPanel();
                        String uri;
                        uri = new File("won.mp3").toURI().toString();
                        new MediaPlayer(new Media(uri)).play();
                        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
                        
                        JOptionPane.showMessageDialog(null, "Congratulations " +name1+ "!! You Won the Game");
                        jButton1.setEnabled(true);
                        jButton2.setEnabled(false);
                    }
                    turn++;
                }
                else if(turn%2 == 1) //here is player's 2 turn
                {
                    d = rand.nextInt(6)+1;
                    jTextField1.setText(Integer.toString(d));
                    jLabel2.setText( name2 + ", its your turn,, ROLL THE DICE");
                    player2_dice=Integer.parseInt(jTextField1.getText());
                    Player2_Location+=player2_dice;
                    //if player 2 dice roll is higher than the board finish line at the end
                    if (Player2_Location>36)
                    {
                        Player2_Location-=player2_dice;
                        JOptionPane.showMessageDialog(null, "Out of Bounds!, Try again next turn");
                        jTextField1.setText(" ");
                    }
                    //if player 2 lands on a snake
                    for(int i=0;i<snakes_number;i++)
                    {
                        if(Player2_Location == snake_positions[i][0])
                        {
                            Player2_Location = snake_positions[i][1];
                            try{
                            JFXPanel j = new JFXPanel();
                            String uri;
                             uri = new File("fall.mp3").toURI().toString();
                             new MediaPlayer(new Media(uri)).play();
                            }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
                            
                            JOptionPane.showMessageDialog(null, "R.I.P");
                        }
                    }
                    //if player 2 lands on a ladder
                    for(int j=0;j<ladders_number;j++)
                    {
                        if(Player2_Location == ladder_positions[j][0])
                        {
                            Player2_Location = ladder_positions[j][1];
                            try{
                            JFXPanel jw = new JFXPanel();
                            String uri;
                            uri = new File("climbing.mp3").toURI().toString();
                            new MediaPlayer(new Media(uri)).play();
                            }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
                            JOptionPane.showMessageDialog(null, "Oh Yeah! Mwahahahaha!");
                        }
                    }
                    //defining x coordinates for player 2
                    if (Player2_Location==1 || Player2_Location==12 || Player2_Location==13 || Player2_Location==24 || Player2_Location==25 || Player2_Location==36)
                        x2=55;
                    else if (Player2_Location==2 || Player2_Location==11 || Player2_Location==14 || Player2_Location==23 || Player2_Location==26 || Player2_Location==35)
                        x2=180;
                    else if (Player2_Location==3 || Player2_Location==10 || Player2_Location==15 || Player2_Location==22 || Player2_Location==27 || Player2_Location==34)
                        x2=305;
                    else if (Player2_Location==4 || Player2_Location==9 || Player2_Location==16 || Player2_Location==21 || Player2_Location==28 || Player2_Location==33)
                        x2=430;
                    else if (Player2_Location==5 || Player2_Location==8 || Player2_Location==17 || Player2_Location==20 || Player2_Location==29 || Player2_Location==32)
                        x2=555;
                    else if (Player2_Location==6 || Player2_Location==7 || Player2_Location==18 || Player2_Location==19 || Player2_Location==30 || Player2_Location==31)
                        x2=680;
                    
                    //setting positions for player 2
                    for(int r=0;r<rows;r++)
                    {
                        for(int c=0;c<columns;c++)
                        {
                          if (Player2_Location%6!=0)
                          {
                            switch(Player2_Location/6)
                            {
                                case 0:
                                    jLabel5.setLocation(x2,675);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 1:
                                    jLabel5.setLocation(x2,550);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 2:
                                    jLabel5.setLocation(x2,425);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 3:
                                    jLabel5.setLocation(x2,300);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 4:
                                    jLabel5.setLocation(x2,175);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 5:
                                    jLabel5.setLocation(x2,50);
                                    jLabel1.add(jLabel5);
                                    break;
                            }
                          }
                          else
                          {
                              switch(Player2_Location/6)
                            {
                                case 1:
                                    jLabel5.setLocation(x2,675);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 2:
                                    jLabel5.setLocation(x2,550);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 3:
                                    jLabel5.setLocation(x2,425);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 4:
                                    jLabel5.setLocation(x2,300);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 5:
                                    jLabel5.setLocation(x2,175);
                                    jLabel1.add(jLabel5);
                                    break;
                                case 6:
                                    jLabel5.setLocation(x2,50);
                                    jLabel1.add(jLabel5);
                                    break;
                            }
                          }
                        }
                    }
                    //if player 2 wins the game
                    if (Player2_Location == 36)
                    {
                        Player1_Location=1;
                        Player2_Location=1;
                        
                        try{
                        JFXPanel j = new JFXPanel();
                        String uri;
                        uri = new File("ending.mp3").toURI().toString();
                        new MediaPlayer(new Media(uri)).play();
                        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
                        
                        try{
                        JFXPanel j = new JFXPanel();
                        String uri;
                        uri = new File("won.mp3").toURI().toString();
                        new MediaPlayer(new Media(uri)).play();
                        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
                        
                        JOptionPane.showMessageDialog(null, "Congratulations " +name2+ "!! You Won the Game");
                        jButton1.setEnabled(true);
                        jButton2.setEnabled(false);
                    }
                    turn++;
                }
            }
            
            if(dice_turn == 2)
            {
                d = rand.nextInt(6)+1;
                jTextField1.setText(Integer.toString(d));
                second_player_dice = Integer.parseInt(jTextField1.getText());
                if(first_player_dice > second_player_dice)
                {   turn = 0; //even for player 1 and everytime there's turn make turn+1
                    JOptionPane.showMessageDialog(null, name1+ " IS THE BOSS HERE ,, LET'S START THE GAME, follow the label on top of the dice");
                    jLabel2.setText( name1 + ", its your turn,, ROLL THE DICE");
                    turn++;
                    dice_turn++;
                    jTextField1.setText(" ");
                }
                if(second_player_dice > first_player_dice)
                {   turn = 1; //odd for player 2
                    JOptionPane.showMessageDialog(null, name2+ " IS THE BOSS HERE ,, LET'S START THE GAME, follow the label on top of the dice");
                    jLabel2.setText( name2 + ", its your turn,, ROLL THE DICE");
                    turn++;
                    dice_turn++;
                    
                }
                if(first_player_dice == second_player_dice)
                {
                    jTextField1.setText(" ");
                    JOptionPane.showMessageDialog(null,"eghh,, guys you're equal but cheer up we'll find our BOSS, let's try this again :/");
                    dice_turn=1;
                    dice2_turn++;
                    JOptionPane.showMessageDialog(null,"ok " + name1 + ", roll the dice again!!");
                    s=false;
                }
                //
                //dice_turn++;

            }
            if(dice_turn == 1)
            {   if(s==true)
            {if(dice2_turn ==1)
                {
                    //jTextField1.setText(" ");
                    d = rand.nextInt(6)+1;
                    jTextField1.setText(Integer.toString(d));
                    first_player_dice = Integer.parseInt(jTextField1.getText());
                    JOptionPane.showMessageDialog(null,"and now " + name2 + ", roll the dice,,again ;/");
                    dice_turn++;
                    
                    
                }
                if(dice2_turn <1)
                {
                    d = rand.nextInt(6)+1;
                    jTextField1.setText(Integer.toString(d));
                    first_player_dice = Integer.parseInt(jTextField1.getText());
                    JOptionPane.showMessageDialog(null,"and now " + name2 + ", roll the dice");
                    dice_turn++;
                }
            }
            }
        
        }
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if(evt.getSource()==jButton1)
         {
             boolean same_name=true;
            JOptionPane.showMessageDialog(null, "Welcome To The Snake and Ladder Game :D ");
			name1=JOptionPane.showInputDialog("Player 1 enter your name");
			name2=JOptionPane.showInputDialog("Player 2 enter your name");
                    while(same_name==true)
                    {
                        if (name1.equalsIgnoreCase(name2))
                        {
                            name2=JOptionPane.showInputDialog("That name is taken plz enter another name");
                        }
                        if(!name1.equalsIgnoreCase(name2))
                            same_name=false;
                    }
            JOptionPane.showMessageDialog(null,"Alright guys .. now we wanna know who's the BOSS that's gonn start first,, Do as follow:");
            New_Game=true;
            JOptionPane.showMessageDialog(null,"OK " + name1 + ", roll the dice");
            jButton1.setEnabled(false);
            
            //base location for the players
            jLabel4.setLocation(55, 625);
            jLabel5.setLocation(55, 675);
            jLabel1.add(jLabel4);
            jLabel1.add(jLabel5);
            
            jButton2.setEnabled(true);
            

		//jButton2.setEnable(false);
       				

         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int music = 0;
        //ContinuousAudioDataStream loop = new ContinuousAudioDataStream;
        
      /*if(on_off == 1)
        {
            second = Integer.parseInt(JOptionPane.showInputDialog("hello there,, do you wanna stop the music or try another one?,, type 1 to stop or 2 to try another one"));
            if(second == 1)
            {
                on_off = 0;
                second = 1;
            }
            if(second == 2)
            {
                on_off = 0;
                second = 2;
            }
        }
        */
        
            JOptionPane.showMessageDialog(null,"hmmm.. you wanna hear some background music hah?!.. ok then :PPP");
            music = Integer.parseInt(JOptionPane.showInputDialog("what would you like to hear : some funny music OR JAZZ OR some happy kids music"));
            //JOptionPane.showMessageDialog(null,"good choice! also remeber ,, u can stop music by clicking the same button again");
            
        if(music == 1)
        {   
        try{
           JFXPanel j = new JFXPanel();
           String uri;
           uri = new File("Funny.mp3").toURI().toString();
          // if(second == 1)
               // new MediaPlayer(new Media(uri)).stop();
            //if(second == 2 || second == 0)
                new MediaPlayer(new Media(uri)).play();
           on_off=1;
           
           }catch(Exception e){JOptionPane.showMessageDialog(null,e);}}
        //
        if(music == 2)
        {try{
            JFXPanel j = new JFXPanel();
            String uri;
            uri = new File("Jazz.mp3").toURI().toString();
           // if(second == 1)
             //   new MediaPlayer(new Media(uri)).stop();
            //else if(second == 2 || second == 0)
                new MediaPlayer(new Media(uri)).play();
           on_off=1;
          }catch(Exception e){JOptionPane.showMessageDialog(null,e);}}
        
        //
        if(music == 3)
        {try{
           JFXPanel j = new JFXPanel();
           String uri;
           uri = new File("kids.mp3").toURI().toString();

            //if(second == 1)
              //  new MediaPlayer(new Media(uri)).stop();
            //else if(second == 2 || second == 0)   
               new MediaPlayer(new Media(uri)).play();
           on_off=1;
       }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        GameFrame obj = new GameFrame();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
        
    }
    
    public void setSnakes()//[beginning of the snake][ending of the snake]
    {
        snake_positions=new int[snakes_number][2];
        
        snake_positions[0][0]=17;
        snake_positions[0][1]=4;
        snake_positions[1][0]=20;
        snake_positions[1][1]=6;
        snake_positions[2][0]=24;
        snake_positions[2][1]=16;
        snake_positions[3][0]=32;
        snake_positions[3][1]=30;
        snake_positions[4][0]=34;
        snake_positions[4][1]=12;
    }
    
    public void setLadders()//[beginning of the ladder][ending of the ladder]
    {
        ladder_positions=new int[ladders_number][2];
        
        ladder_positions[0][0]=2;
        ladder_positions[0][1]=15;
        ladder_positions[1][0]=5;
        ladder_positions[1][1]=7;
        ladder_positions[2][0]=9;
        ladder_positions[2][1]=27;
        ladder_positions[3][0]=18;
        ladder_positions[3][1]=29;
        ladder_positions[4][0]=25;
        ladder_positions[4][1]=35;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
