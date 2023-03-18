package Main;

import View.Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static int posX=0,posY=0;
    public static void main(String[] args) {
        JFrame Tampilan = new JFrame("Sofwtare Client Sederhana");
        Gui Konten = new Gui();
        Tampilan.setContentPane(Konten.get_content());
        Tampilan.setSize(420,220);
        Tampilan.setLocationRelativeTo(null);
        Tampilan.setUndecorated(true);
        Tampilan.setVisible(true);

        Tampilan.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GRAY));

        Konten.get_content().addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                posX=e.getX();
                posY=e.getY();
            }
        });

        Konten.get_content().addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent evt)
            {
                Tampilan.setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
            }
        });

        Konten.get_minimze_btn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tampilan.setExtendedState(Tampilan.getExtendedState() | Tampilan.ICONIFIED);
            }
        });

    }
}