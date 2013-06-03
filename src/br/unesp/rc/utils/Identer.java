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
    private static String sBufferOut = "";
    private static StringTokenizer stk;
            
    private Identer() {
    }
    
    public static StringBuffer run(StringBuffer texto){
        
        blocks = getBlocks(texto);
        
        for (String block : blocks){
            if(!block.equals("")){
                sBufferOut = sBufferOut + formatar(block);
            }
        }       
                
        return new StringBuffer(sBufferOut);
    }
    
     public static String[] getBlocks(StringBuffer in){
        String sBufferString = in.toString();
        
        return sBufferString.split("(?=[@])");        
    }
     
    /*
     * Método que invoca os métodos auxiliares
     */
    public static String formatar(String in){
        String out;
        
        out = substituirAspas(in);
        out = quebrarLinhas(out);
        //out = removerEspacos(out);
        
        return out;
    }
    
    /*
     * Métodos Auxiliares
     */    
    /* 
     * 1. Todas os valores das tags devem ser envolvidas por {}. Substituir 
     * as "" por {} se necessário;
     */
    public static String substituirAspas(String in){
        String out = "";
        String nToken;
        boolean flag = false;
        
        stk = new StringTokenizer(in, "\"", true);        
        
        while(stk.hasMoreTokens()){
            nToken = stk.nextToken();
            if(nToken.equals("\"")){
                if(!flag){
                    out = out + "{";
                    flag = true;
                }else{
                    out = out + "}";
                    flag = false;
                }
            }else{
                out = out + nToken;
            }
        }
               
        return out;
    }
    
    /* 
     * 2. Todos as referências do arquivo deve ter tags internas em linhas 
     * diferentes; 
     * 
     * 3.1. Antes das tags deve existir dois espaços em branco; 
     */
    public static String quebrarLinhas(String in){
        String out;
        int i=0;
        
        // Quebra a primeira linha pois não obedece a regra padrão
        String[] blockParts = in.split("(?<=,)",2);
                
        // Quebra as linhas restantes
        String[] lines = blockParts[1].trim().split("(?<=}),?");
        
        out = padronizarPrimeiraLinha(blockParts[0]);
        for(String line : lines){
            
            if(i!=(lines.length-1)){
                out = out + padronizarLinha(line,false);
                
                if(i==lines.length-2){
                    out = out.substring(0, out.length()-2) + "\n";
                }
                
            }else{
                out = out + padronizarLinha(line,true);
            }                        
            
            i++;
        }
               
        return out;       
    }   
    
    
    /* 
     * 3.2. Até o sinal de (=) deve existir 16 caracteres. Preencher as tags 
     * com espaço em branco
     * 
     * 3.3. Entre o sinal de (=) e a ({) deve existir apenas um espaço em 
     * branco
     * 
     * 3.4. O valor da tag deve estar entre chaves e sem espaços em branco 
     * no início e no fim. Exemplo: {valor dessa tag}
     */
    public static String padronizarLinha(String line, boolean lastLine){
        line = line.trim();
        
        if(!lastLine){
            String[] lineParts = line.split("[={}]");
        
            String chave = String.format("%1$-16s",lineParts[0]);         
            String valor = lineParts[lineParts.length-1].trim();
        
            return "  " + chave + "= {" + valor + "},\n";
        }else{
            return line + "\n\n";
        }
    }
    
    public static String padronizarPrimeiraLinha(String line){
        String out = "";
        boolean upperFlag = false;
        boolean firstNumFlag = false;
        
        char[] letras = line.toCharArray();
        
        for(char l : letras){
            if(l == '{'){
                upperFlag = true;                
            }
            
            if(upperFlag){
                if(!firstNumFlag && Character.isDigit(l)){
                    firstNumFlag = true;
                    out = out + ":" + l;
                }else{
                    out = out + l;
                }                
            }else{
                out = out + Character.toUpperCase(l);
            }
        }
        
        return out + "\n";
    }
       
}
