/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.utils;

import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Corbano
 */
public class Splash extends Frame implements ActionListener {
    static void renderSplashFrame(Graphics2D g, int frame) {
        final String[] comps = {"foo", "bar", "baz"};
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(120,140,100,250);
        g.setPaintMode();
        g.setColor(Color.WHITE);
        g.drawString("Loading "+comps[(frame/5)%3]+"...", 120, 300);
    }
    public Splash() {
        final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }
        for(int i=0; i<100; i++) {
            renderSplashFrame(g, i);
            splash.update();
            try {
                Thread.sleep(90);
            }
            catch(InterruptedException e) {
            }
        }
        splash.close();  
        
        
        
        /***************************************/
        /* Primeira janela */
         //super("SplashScreen demo");
        /*
        setTitle("SplashScreen demo");
        setSize(300, 200);
        setLayout(new BorderLayout());
        Menu m1 = new Menu("File");
        MenuItem mi1 = new MenuItem("Exit");
        m1.add(mi1);
        mi1.addActionListener(this);
        this.addWindowListener(closeWindow);

        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        mb.add(m1);
        setVisible(true);
        toFront();
        * */
        /***************************************/
    }
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
    
    private static WindowListener closeWindow = new WindowAdapter(){
        public void windowClosing(WindowEvent e){
            e.getWindow().dispose();
        }
    };
}