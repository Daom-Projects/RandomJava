/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio_instructores;

/**
 *
 * @author Carlos
 */
public class Aleatorio_Instructores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sorteo sr = new Sorteo();
        sr.getList();
        
        System.out.println("---- Hombres -----");
        System.out.println(sr.getStrInstructores());
        System.out.println("\n");
        
        System.out.println("---- Mujeres -----");
        System.out.println(sr.getStrInstructoras());
        System.out.println("\n");
        
        System.out.println("Total: "+sr.getOrgList().size());
        
        System.out.println("");
        System.out.println("");
        System.out.println("----Pareja----");
        String [] ins1 = sr.getRandom('F');
        String [] ins2 = sr.getRandom('M');
        
        System.out.println(ins1[0]+" :::: "+ins2[0]);
        sr.saveAssist(ins1, false);
        sr.saveAssist(ins2, false);
        
        sr.saveList();
    }
    
}