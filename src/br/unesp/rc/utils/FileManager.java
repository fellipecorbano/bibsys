package br.unesp.rc.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aluno
 */
public class FileManager {

    private FileManager() {
    }

    public static boolean salvar(String path, StringBuffer buf) {
        boolean b = false;
        try {
            //File file = new File(path);
            // PARA TESTES
            File file = new File(path.replace(".bib", "") + "_output.bib");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(buf.toString());
            bw.close();
            b = true;
        } catch (IOException ex) {
            System.out.println("Mensagem: \n" + ex.getMessage());
        }

        return b;
    }

    public static StringBuffer leitura(String path) {
        StringBuffer texto = new StringBuffer();
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(path));
            while ((sCurrentLine = br.readLine()) != null) {
                texto.append(sCurrentLine);
                texto.append("\n");
            }
        } catch (IOException ex) {
            System.out.println("Mensagem: \n" + ex.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println("Mensagem: \n" + ex.getMessage());
            }
        }
        return texto;
    }
}