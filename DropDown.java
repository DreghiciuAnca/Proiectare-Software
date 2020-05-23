import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DropDown extends JFrame {
    public JFrame window = new JFrame();
    Timer tm1, tm2,tm3;
    Integer pl1=60,pl2=60,pl3=60;


    public DropDown()
    {
        init();
    }
    public void init()
    {
        window.setSize(600,600);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.setLayout(new FlowLayout());


        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");
        JButton button3 = new JButton("Button3");
        JButton newButton1 = new JButton("New button");
        JButton button = new JButton("button");
        button1.setBackground(Color.YELLOW);
        button2.setBackground(Color.YELLOW);
        button3.setBackground(Color.YELLOW);
        JButton newButton2 = new JButton("New button");


        tm1 = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(pl1 > 300)
                {
                    tm1.stop();
                }
                else{
                    panel.setSize(panel.getWidth(), pl1);
                    pl1 += 10;
                }
            }
        });

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                newButton1.setVisible(true);
                newButton2.setVisible(true);
                panel1.add(newButton1);
                panel1.add(newButton2);
                tm1.start();
                tm2 = new Timer(10, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if(pl2 > 300)
                        {
                            tm2.stop();
                        }
                        else{
                            panel.setSize(panel.getWidth(), pl2);
                            pl2 += 10;
                        }
                    }
                });

                newButton1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);

                        button.setVisible(true);
                        panel1.add(button);
                        tm2.start();
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        button.setVisible(false);
                        tm2.stop();
                    }
                });
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                //newButton1.setVisible(false);
                newButton2.setVisible(false);
                tm1.stop();
            }
        });



        panel1.add(button1);
        //panel1.add(newButton1);
        panel2.add(button2);
        panel3.add(button3);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        window.add(panel);

        window.setVisible(true);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
