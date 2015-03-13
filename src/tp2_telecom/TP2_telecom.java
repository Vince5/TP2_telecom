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
            char lettreSelect='B';
            int value = (int)lettreSelect;
            String affiche="";
            while(value!=0){
                int v=value%2;
                value=value/2;
                affiche=""+v+affiche;
            }
            System.out.println(affiche);
    }
    
}
