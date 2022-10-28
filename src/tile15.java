import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class tile15 extends JFrame implements ActionListener {
    JPanel gamePanel = new JPanel();
    JPanel resetPanel = new JPanel();
    JButton nyttspel = new JButton("Start New Game");
    //JButton emptybutton=new JButton("");
    ArrayList<JButton> buttons_list = new ArrayList<>();
    JButton[] buttons = new JButton[16];

    public static JButton placeholder(JButton emptybutton) {
        return emptybutton;
    }

    public tile15() {
        setLayout(new BorderLayout());
        add(gamePanel, "Center");
        add(resetPanel, "North");
        resetPanel.add(nyttspel);
        //gamePanel.add(emptybutton);
        gamePanel.setLayout(new GridLayout(4, 4));
        String nr = "";
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            if (i != buttons.length - 1) {
                buttons[i].setText(Integer.toString(i + 1));
            }
            //buttons[i].addActionListener(this);

            gamePanel.add(buttons[i]);
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        nyttspel.addActionListener(this);
        buttons[15].setText("");
        for (JButton buttons : buttons) {
            buttons.addActionListener(this);
        }
        Collections.addAll(buttons_list, buttons);


    }
    /* public int emptytile_index () {
         int indxnr = 0;
         for (int i = 0; i < buttons_list.size(); i++) {
             buttons_list.get(i).getText();
             if (buttons_list.get(i).getText().trim().equalsIgnoreCase("")) {
                 indxnr = i;
             }

         }
         return indxnr;
     }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        //int indxnr=0;

        if (e.getSource() == nyttspel) {
            Collections.shuffle(/*Arrays.asList(buttons)*/buttons_list);
            for (JButton button : buttons_list/*buttons*/) {
                gamePanel.add(button);
            }
            gamePanel.revalidate();
        } /*else if (e.getSource() != nyttspel ||
                e.getSource() != buttons_list.get(emptytile_index())) {
            for (JButton b : buttons_list
            ) {
                if (){

                }
            }
        }
*/
    }
    /*else if (e.getSource()!=buttons[16]){
        Collections.swap(Arrays.asList(buttons),e.hashCode(),15);
        for (JButton button : buttons) {
            gamePanel.add(button);
        }
        gamePanel.revalidate();
    }*/

    public int emptytile_index () {
        int indxnr = 0;
        for (int i = 0; i < buttons_list.size(); i++) {
            buttons_list.get(i).getText();
            if (buttons_list.get(i).getText().trim().equalsIgnoreCase("")) {
                indxnr = i;
            }

        }
        return indxnr;
    }
}