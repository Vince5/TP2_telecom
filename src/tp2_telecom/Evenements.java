/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_telecom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;


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
    
    private void afficherChaine(final String chaine, double vitesse, final InterfacePrincipale fenetre){
        
        int delay = (int) (vitesse*1000); //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            int nbFait=0;
            public void actionPerformed(ActionEvent evt) {
                if (nbFait==7){
                    ((Timer)evt.getSource()).stop();
                }
                fenetre.addChar(chaine.charAt(nbFait));
                String soundJouer;
                if (chaine.charAt(nbFait)=='0'){
                    soundJouer=System.getProperty("user.dir")+"/src/son1.wav";
                }else{
                    soundJouer=System.getProperty("user.dir")+"/src/son2.wav";
                }
                
                try{
                        File f=new File(soundJouer);
                        AudioInputStream audioInputStream =
                                AudioSystem.getAudioInputStream(
                                        f);
                        System.out.println("Test");
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        
                        clip.start();
                 }
                 catch(Exception ex)
                 {
                     System.out.println(ex);
                 }
                nbFait++;
            }
        };
        new Timer(delay, taskPerformer).start();
    }
}
