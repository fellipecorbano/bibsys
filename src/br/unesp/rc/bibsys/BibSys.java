/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.bibsys;

import br.unesp.rc.utils.FileManager;
import br.unesp.rc.utils.Identer;
import br.unesp.rc.utils.Splash;
import br.unesp.rc.utils.TrayIco;

/**
 *
 * @author Corbano
 */
public class BibSys {
    //private static StringBuffer identedFile;
    //private static String filelist;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializar SplashScreen
            Splash splashScreen = new Splash();
        
        // Inicializar Tray Icon
        TrayIco tray = new TrayIco();
        tray.run();
        
        
        /* SOMENTE PARA TESTES (REMOVER)
        
        StringBuffer texto = FileManager.leitura("C:\\Users\\Corbano\\Desktop\\exemplo.bib");
        identedFile = Identer.run(texto);
        FileManager.salvar("C:\\Users\\Corbano\\Desktop\\exemplo.bib", identedFile);
        */
    }
}
