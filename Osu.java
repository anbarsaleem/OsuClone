import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
// import java.awt.Image;
// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Font;
// import java.awt.FontMetrics;
import java.util.Timer;
import java.util.Random;

public class Osu extends JFrame implements MouseListener, ActionListener {

    private static final long serialVersionUID = 1L;
    private static final int BOARD_WIDTH = 300;
    private static final int BOARD_LENGTH = 300;
    
    private static final int TIMER_DELAY = 3000;
    
    Timer timer;

    ImageIcon star;
    JLabel target;
    int target_xCoord, target_yCoord;
    boolean hit;

    int score;
    int lives = 3; 

    Random coord = new Random();
    private Graphics g;
    
    public Osu(String osu){

        super(osu);
        
        timer = new Timer();

        star = new ImageIcon("star.png");
        target = new JLabel(star);

        addMouseListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.RED);
        setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        locateObject();

    }
    
    @Override
    public void mouseClicked(MouseEvent e){

        if(e.getX() == target_xCoord && e.getY() == target_yCoord) {

            hit = true;
            score += 10;

        }

        else {

            hit = false;
            lives--;
            if(lives == 0) {

                gameOver(g);

            }

        }

    }

    public void locateObject() {

        int xCoord = coord.nextInt(BOARD_WIDTH);
        target_xCoord = xCoord;

        final int yCoord = coord.nextInt(BOARD_LENGTH);
        target_yCoord = yCoord;

        target.setLocation(target_xCoord, target_yCoord);

    }

    public void gameOver(Graphics g) {

        String endMessage = "GAME OVER! SCORE: " + score;
        Font f = new Font("Times New Roman", Font.BOLD, 18);
        FontMetrics fm = getFontMetrics(f);

        g.setColor(Color.WHITE);
        g.setFont(f);
        g.drawString(endMessage, BOARD_WIDTH - fm.stringWidth(endMessage) / 2, BOARD_LENGTH / 2);

    }

    public static void main(String[] args){

        Osu osu = new Osu("Be sure to react on time! 3 lives only");
        osu.setSize(BOARD_WIDTH, BOARD_LENGTH);
        osu.setVisible(true);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}