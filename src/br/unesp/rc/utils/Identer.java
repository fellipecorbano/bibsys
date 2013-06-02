/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.utils;

import java.util.StringTokenizer;

/**
 *
 * @author Corbano
 */
public class Identer {
    private static String[] blocks;
    private static String r;
    private static String sBufferOut = "";
    
    private Identer() {
    }
 
    public static StringBuffer run(StringBuffer texto){
        
        blocks = getBlocks(texto);
                
        for (String block : blocks){
            if(!block.equals("")){
                sBufferOut = sBufferOut.concat(formatar(block));                
            }
        }
                
        return new StringBuffer(sBufferOut);
    }
    /*
     * Método que invoca os métodos auxiliares
     */
    public static String formatar(String in){
        String out;
        
        out = removerEspacos(in);
        
        return out;
    }
    
    /*
     * Métodos Auxiliares
     */
    public static String[] getBlocks(StringBuffer in){
        String sBufferString = in.toString();
        
        return sBufferString.split("(?=[@])");        
    }
    
    /* 1. Todos as referências do arquivo deve ter tags internas em linhas 
     * diferentes; 
     */
    
    /* 2. Todas os valores das tags devem ser envolvidas por {}. Subistituir 
     * as "" por {} se necessário;
     */
    
    /* 3.1. Antes das tags deve existir dois espaços em branco; */
    public static String removerEspacos(String in){
        return in.replace(",\n", ",\n  ");        
    }
    
    /* 3.2. Até o sinal de (=) deve existir 16 caracteres. Preencher as tags 
     * com espaço em branco
     */
    
    /* 3.3. Entre o sinal de (=) e a ({) deve existir apenas um espaço em 
     * branco
     */
    
    /* 3.4. O valor da tag deve estar entre chaves e sem espaços em branco 
     * no início e no fim. Exemplo: {valor dessa tag}
     */
}
