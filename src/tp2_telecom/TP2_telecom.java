/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_telecom;

/**
 *
 * @author Vincent
 */
public class TP2_telecom {

    /*
    * Converti un caractère en chaine de 0 et 1
    * @param c est le caractère a transformer
    * @return affiche est un String de 7 caractères
    */
    public static String convertiChar(char c){
        
        int value = (int)c;
        String affiche="";
        while(value!=0){
            int v=value%2;
            value=value/2;
            affiche=""+v+affiche;
        }
        
        return affiche;
    }
    
    /*
    * Détermine si la chaine de 7 bits a un nombre pair de 1
    * @param chaine est la chaine
    * @return boolean
    */
    public static boolean isPair(String chaine){
        int nb1 = 0;
        
        for(int i = 0; i < chaine.length(); i++){
            if(chaine.charAt(i) == '1'){
                nb1++;
            }
        }
        return (nb1%2 == 0);
    }
    
    /*
    * La fonction retourne la chaine si elle est en format NRZS à partir du
    * code en format NRZL.
    * @param recoit le codeNRZL
    * @return le codeNRZS
    */
    public static String calculeNRZS(String codeNRZL){
        String codeNRZS = "";
        int valNext = 1;
        for(int i = 0; i < codeNRZL.length(); i++){
            if (codeNRZL.charAt(i)=='0'){
                if(valNext==1){
                    valNext=0;
                }else{
                    valNext=1;
                }
            }
            codeNRZS= codeNRZS+valNext;
        }
        return codeNRZS;
    }  
}
