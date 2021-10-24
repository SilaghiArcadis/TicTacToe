import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50)); //dark grey
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(50,50,50));
            buttons[i].addActionListener(this);
        }


        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O turn");
                        check();
                    }
                }else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,250));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    /**
     * firstTurn method picks a random player at each round. X or O
     * it also sleeps for 2 seconds in order to show the title " Tic Tac Toe "
     */
    public void firstTurn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1_turn = true;
            textfield.setText("X turn");
        }
        else{
            player1_turn = false;
            textfield.setText("O turn");
        }

    }

    public void check(){

        //check X win conditions
        /**
         * XXX
         * 111
         * 111
         */
        if(
                (buttons[0].getText()=="X")&&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")
                    ){
            xWins(0,1,2);
        }
        /**
         * 111
         * XXX
         * 111
         */
        else if(
                (buttons[3].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")
                    ){
            xWins(3,4,5);
        }
        /**
         * 111
         * 111
         * XXX
         */
        else if(
                (buttons[6].getText()=="X")&&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")
                   ){
            xWins(6,7,8);
        }
        /**
         * X11
         * X11
         * X11
         */
        else if(
                (buttons[0].getText()=="X")&&
                (buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")
                   ){
            xWins(0,3,6);
        }
        /**
         * 1X1
         * 1X1
         * 1X1
         */
        else if(
                (buttons[1].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")
                   ){
            xWins(1,4,7);
        }
        /**
         * 11X
         * 11X
         * 11X
         */
        else if(
                (buttons[2].getText()=="X")&&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")
                   ){
            xWins(2,5,8);
        }
        /**
         * X11
         * 1X1
         * 11X
         */
        else if(
                (buttons[0].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")
                   ){
            xWins(0,4,8);
        }
        /**
         * 11X
         * 1X1
         * X11
         */
        else if(
                (buttons[2].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")
                   ){
            xWins(2,4,6);
        }
        //check O win conditions
        /**
         * OOO
         * 111
         * 111
         */
        else if(
                (buttons[0].getText()=="O")&&
                (buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")
        ){
            oWins(0,1,2);
        }
        /**
         * 111
         * OOO
         * 111
         */
        else if(
                (buttons[3].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")
        ){
            oWins(3,4,5);
        }
        /**
         * 111
         * 111
         * OOO
         */
        else if(
                (buttons[6].getText()=="O")&&
                (buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")
        ){
            oWins(6,7,8);
        }
        /**
         * O11
         * O11
         * O11
         */
        else if(
                (buttons[0].getText()=="O")&&
                (buttons[3].getText()=="O")&&
                (buttons[6].getText()=="O")
        ){
            oWins(0,3,6);
        }
        /**
         * 1O1
         * 1O1
         * 1O1
         */
        else if(
                (buttons[1].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[7].getText()=="O")
        ){
            oWins(1,4,7);
        }
        /**
         * 11O
         * 11O
         * 11O
         */
        else if(
                (buttons[2].getText()=="O")&&
                (buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")
        ){
            oWins(2,5,8);
        }
        /**
         * O11
         * 1O1
         * 11O
         */
        else if(
                (buttons[0].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")
        ){
            oWins(0,4,8);
        }
        /**
         * 11O
         * 1O1
         * O11
         */
        else if(
                (buttons[2].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")
        ){
            oWins(2,4,6);
        }
        else{
            int checkTie = 0;
            for(JButton i : buttons){
                if(i.getText()=="O"|| i.getText()=="X"){
                    checkTie++;
                }
            }
            if(checkTie==9){
                tiedGame();
            }
        }

    }

    public void xWins(int a,int b,int c){

        buttons[a].setBackground(new Color(1,70,32));
        buttons[b].setBackground(new Color(1,70,32));
        buttons[c].setBackground(new Color(1,70,32));

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }

    public void oWins(int a,int b,int c){

        buttons[a].setBackground(new Color(1,70,32));
        buttons[b].setBackground(new Color(1,70,32));
        buttons[c].setBackground(new Color(1,70,32));

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");



    }

    public void tiedGame(){

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("DRAW");
    }

    public void reset(){

        try {
            Thread.sleep(3000);
            for(int i=0; i<9; i++) {
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                buttons[i].setBackground(new Color(38,38,38));
            }
            firstTurn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
