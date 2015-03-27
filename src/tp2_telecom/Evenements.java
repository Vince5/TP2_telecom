/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_telecom;

import static java.lang.Thread.sleep;

/**
 *
 * @author Vincent
 */
public class Evenements {
    
    
    public Evenements(char c, String parite, String signal, double vitesse, InterfacePrincipale fenetre){
        
        //Transformer le char en chaine
        
        String bit = "";
        String chaine = "";
        chaine = TP2_telecom.convertiChar(c);
        
        
        if(parite.equals("pair")){
            
            //Trouver le bit de parite
            if(TP2_telecom.isPair(chaine)){
                bit = "0";
            }else{
                bit = "1";
            }
            
        }else if(parite.equals("impair")){
            
            //Trouver le bit
            if(TP2_telecom.isPair(chaine)){
                bit = "1";
            }else{
                bit = "0";
            }
            
        }else{
            
            bit = "0";
        }
        
        //Former la chaine finale avec le bit et la chaine
        String chaineL = bit + chaine;
        
        if(signal.equals("S")){
            
            //Remplacer la chaine finale avec la chaine en S
            String chaineS = TP2_telecom.calculeNRZS(chaineL);
            
            afficherChaine(chaineS, vitesse, fenetre);
        }else{
            
            afficherChaine(chaineL, vitesse, fenetre);
        }
        
    }
    
    private void afficherChaine(String chaine, double vitesse, InterfacePrincipale fenetre){
        
        try{
            for(int i=0; i<chaine.length(); i++){
                fenetre.addChar(chaine.charAt(i));
                System.out.println("hey ");
                sleep((long)vitesse*1000);
            }
        }catch(Exception e){
            
        }
       
        
        
    }
}
