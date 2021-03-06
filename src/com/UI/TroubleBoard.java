package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TroubleBoard {

    PopOMatic popOMatic = new PopOMatic();

    MyDrawPanel drawPanel = new MyDrawPanel();
    int position=0;
    private JPanel  buttonPanel;
    private JButton button;
    private JButton piece1;
    private JButton piece2;
    private JButton piece3;
    private JButton piece4;
    private JLabel ch;
    private JButton resetButton;
    private JFrame frame;
    private boolean redIsHome=false;
    private boolean blueIsHome=false;
    private boolean yellowIsHome=false;
    private boolean greenIsHome=false;
    public static void main(String[] args) throws IOException {
        //initiate board
        Board board = new Board();


        // initiate player rotation


        //begin plyer turns
//        while (!board.AnyWinners())
//        {
//            for (int i = 0; i <board.players.length ; i++) {
//                int roll = 0;
//                do {
//                    roll = board.die.Roll();
//                    //Turn stuff here
//
//
//
//
//                }while(roll == 6);
//
//            }
//        }

        //display winner message


        
        //integrate with board

        new TroubleBoard().createBoard();
    }

    public void createBoard() throws IOException {
        System.out.println("Trouble Board:create Board");
        frame = new JFrame(); // ***create frame
        button = new JButton("MOVE--> "+drawPanel.chanceToPlay); // ***create button
        piece1= new JButton("1");
        piece2= new JButton("2");
        piece3= new JButton("3");
        piece4= new JButton("4");
        buttonPanel=new JPanel();
        buttonPanel.setSize(30,650);
        buttonPanel.setLocation(650,0);
        buttonPanel.add(BorderLayout.CENTER,piece1);
        buttonPanel.add(piece2);
        buttonPanel.add(piece3);
        buttonPanel.add(piece4);
//        buttonPanel.add(BorderLayout.CENTER,ch);
        
        resetButton = new JButton("Reset"); //***create button
        //
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel); //***set up drawPanel location on frame
        frame.getContentPane().add(BorderLayout.NORTH,button); 
        frame.getContentPane().add(BorderLayout.EAST,buttonPanel); // ***set up button location on frame
        //frame.getContentPane().add(BorderLayout.EAST,piece2);
        //frame.getContentPane().add(BorderLayout.EAST,piece3);
        //frame.getContentPane().add(BorderLayout.EAST,piece4);
        frame.getContentPane().add(BorderLayout.SOUTH,resetButton);
        // ***frame configs
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false); 
        frame.setLocation(50,50);
        //frame.setLocationRelativeTo(null);
        // ***button configs
        frame.pack();
        // button.setLocation(50, 50);
        ButtonListener bb=new ButtonListener();
        button.addActionListener(new ButtonListener());
        piece1.addActionListener(bb); // ***make button respond to clicks
        piece2.addActionListener(bb);
        piece3.addActionListener(bb);
        piece4.addActionListener(bb);


       resetButton.addActionListener(new ResetButtonListener());

    }
      
       public void buttonControl(boolean a)
       {
        piece1.setEnabled(a);
        piece2.setEnabled(a);
        piece3.setEnabled(a);
        piece4.setEnabled(a);
       }  

      public void  isWinner()
      {
      if(redIsHome==false && drawPanel.redI[0]==-10 && drawPanel.redI[1]==-10 && drawPanel.redI[2]==-10 && drawPanel.redI[3]==-10)
      { 
      position++;
      JOptionPane.showMessageDialog(null, "RED stands : "+position+" in the game!");
      redIsHome=true;
      }
     
      if(blueIsHome==false && drawPanel.blueI[0]==-10 && drawPanel.blueI[1]==-10 && drawPanel.blueI[2]==-10 && drawPanel.blueI[3]==-10)
      {
      position++;
      JOptionPane.showMessageDialog(null, "BLUE stands : "+position+" in the game!"); 
      blueIsHome=true;
      }
  
      if(yellowIsHome==false && drawPanel.yellowI[0]==-10 && drawPanel.yellowI[1]==-10 && drawPanel.yellowI[2]==-10 && drawPanel.yellowI[3]==-10)
      {
      position++;
      JOptionPane.showMessageDialog(null, "YELLOW stands : "+position+" in the game!"); 
      yellowIsHome=true;
      }
      
      if(greenIsHome==false && drawPanel.greenI[0]==-10 && drawPanel.greenI[1]==-10 && drawPanel.greenI[2]==-10 && drawPanel.greenI[3]==-10)
      {
      position++;
      JOptionPane.showMessageDialog(null, "Green stands : "+position+" in the game!");
      greenIsHome=true;
      }
      }





    class ButtonListener implements ActionListener { //*** inner class for clicks
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("dice rolling");
            if(e.getSource()==button)
            {
            drawPanel.diceNumber = popOMatic.Roll();
            button.setEnabled(false);
            buttonControl(true);
            }
            else
            {
            if(e.getSource()==piece1)
            { 
            drawPanel.move(drawPanel.diceNumber,0); 
            button.setEnabled(true);
            buttonControl(false);
            button.setText("MOVE--> "+drawPanel.chanceToPlay);
            }
            if(e.getSource()==piece2)
            {
            drawPanel.move(drawPanel.diceNumber,1);
            button.setEnabled(true);
            buttonControl(false);

            button.setText("MOVE--> "+drawPanel.chanceToPlay);
            }
            if(e.getSource()==piece3)
            {
            drawPanel.move(drawPanel.diceNumber,2);
            button.setEnabled(true);
            buttonControl(false);
            button.setText("MOVE--> "+drawPanel.chanceToPlay);
            }
            if(e.getSource()==piece4)
            {
            drawPanel.move(drawPanel.diceNumber,3);
            button.setEnabled(true);
            buttonControl(false);
            button.setText("MOVE--> "+drawPanel.chanceToPlay);
            }
            isWinner();
            }
            frame.repaint();
        }
    }// close ButtonListener

    class ResetButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          frame.dispose();
          Board  board=new Board();
       try
       {       
     new TroubleBoard().createBoard();
         }catch(IOException ee){ System.out.println(ee.getMessage()); }  
          drawPanel.restart();
            frame.repaint();
        }
    }
}//close TroubleBoard
