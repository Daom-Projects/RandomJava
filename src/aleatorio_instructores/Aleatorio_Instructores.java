/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio_instructores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Carlos
 */
public class Aleatorio_Instructores {
    
    private static ArrayList<String []> instructores;
    private static ArrayList<String []> instructoras;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getList();
        int a =0;
        System.out.println("Hombres:");
        for(String[] instructor : instructores){
            System.out.println(instructor[0]+"--"+instructor[1]);
            a++;
        }
        
        System.out.println("Mujeres:");
        for(String[] instructor : instructoras){
            System.out.println(instructor[0]+"--"+instructor[1]);
            a++;
        }
        System.out.println("Total: "+a);
        
        System.out.println("");
        System.out.println("");
        System.out.println("----Pareja----");
        System.out.println(Aleatorio('F')[0]+" :::: "+Aleatorio('M')[0]);
    }
    
    public static String [] Aleatorio(char genero){
        Random rnd = new Random();
        String [] ins;
        if(genero=='F'){
            ins = instructoras.get(rnd.nextInt(instructoras.size()));
        }else{
            ins = instructores.get(rnd.nextInt(instructores.size()));
        }
        return ins;
    }
    
    public static void getList(){
        instructores = new ArrayList();
        instructoras = new ArrayList();
        FileReader archivo = null;
        try {
          String instructor;
          archivo = new FileReader("instructores.csv");
          BufferedReader lector = new BufferedReader(archivo);
          while ((instructor = lector.readLine()) != null) {
              String [] ins = instructor.split(";");
              if(ins.length>=1)
                  if(ins[1].equalsIgnoreCase("M"))
                    instructores.add(ins);
                  else
                    instructoras.add(ins);
                      
          }
          
          
        } catch (FileNotFoundException e) {
            System.out.println("Error archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo");
        } finally {
          if (archivo != null) {
            try {
              archivo.close();
            } catch (IOException e) {
                System.out.println("Error cerrando el archivo");
            }
          }
        }
        
        
        
    }
    
}
