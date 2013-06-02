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
    private static StringBuffer identedFile;
    private static String filelist;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Descomentar para funciona splash screen e icon tray
        //Splash teste = new Splash();
        
        //TrayIco teste2 = new TrayIco();
        //teste2.run();
        
        
        // SOMENTE PARA TESTES
        StringBuffer texto = FileManager.leitura("C:\\Users\\Corbano\\Desktop\\exemplo.bib");

        identedFile = Identer.run(texto);
            
        FileManager.salvar("C:\\Users\\Corbano\\Desktop\\exemplo.bib", identedFile);
    }
}
