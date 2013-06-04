/*
 * BibSys File Identer v1.0
 * Sistema para formatação/identação de arquivos BibTEX
 * 
 * @author
 * Fellipe C. Corbano (fellipecorbano@gmail.com)
 * Daniel F. Lucasv (danielfelipelucas@gmail.com)
 * 
 */
package br.unesp.rc.bibsys;

import br.unesp.rc.utils.FileManager;
import br.unesp.rc.utils.Identer;
import br.unesp.rc.utils.Splash;
import br.unesp.rc.utils.TrayIco;

public class BibSys {

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
