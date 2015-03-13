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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            
            String affiche = convertiChar('a');
            System.out.println(affiche);
            String parite = "";
            if(isPair(affiche)){
                parite = "0";
            }else{
                parite = "1";
            }
            String chaineFinale = parite + affiche;
            System.out.println(chaineFinale);
            String NRZS=calculeNRZS(chaineFinale);
            System.out.println(NRZS);
    }
    
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
    
    public static boolean isPair(String chaine){
        int nb1 = 0;
        
        for(int i = 0; i < chaine.length(); i++){
            if(chaine.charAt(i) == '1'){
                nb1++;
            }
        }
        return (nb1%2 == 0);
    }
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
