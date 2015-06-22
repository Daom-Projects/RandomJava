/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio_instructores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
    private static ArrayList<String []> orgList;

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
        String [] ins1 = getRandom('F');
        String [] ins2 = getRandom('M');
        
        System.out.println(ins1[0]+" :::: "+ins2[0]);
        saveAssist(ins1, true);
        saveAssist(ins2, false);
        
        saveList();
    }
    
    public static String [] getRandom(char genero){
        Random rnd = new Random();
        String [] ins;
        int aleatorio;
        
        if(genero=='F'){
            aleatorio = rnd.nextInt(instructoras.size());
            ins = instructoras.get(aleatorio);
            ins[3] = String.valueOf(aleatorio); //Guardamos posición de lista original
            instructoras.remove(aleatorio);
        }else{
            aleatorio = rnd.nextInt(instructores.size());
            ins = instructores.get(aleatorio);
            ins[3] = String.valueOf(aleatorio); //Guardamos posición de lista original
            instructores.remove(aleatorio);
        }
        return ins;
    }
    
    
    private static void saveAssist(String[] in, boolean assist){
        int item = orgList.lastIndexOf(in);
        if(assist)
            in[2] = "SI";
        else
            in[2] = "NO";
        
        orgList.set(item, in);
    }
    
    private static void saveList(){
        String lista = "";
        
        
        
        FileWriter salida = null;
        try {
            salida = new FileWriter("C:\\instructores.csv");
            BufferedWriter escritor = new BufferedWriter(salida);
            for(String[] ins : orgList){
                escritor.write(lista.concat(ins[0]+";"+ins[1]+";"+ins[2]+";0"));
                escritor.newLine();
            }
            //escritor.write(lista);
            
        } catch (IOException e) {
            
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    
                }
            }
        }

    }
    
    
    private static void getList(){
        instructores = new ArrayList();
        instructoras = new ArrayList();
        orgList = new ArrayList();
        
        FileReader archivo = null;
        try {
          String instructor;
          archivo = new FileReader("C:\\instructores.csv");
          BufferedReader lector = new BufferedReader(archivo);
          while ((instructor = lector.readLine()) != null) {
              String [] ins = instructor.split(";");
              
              if(ins.length>=2){
                  if(ins[2].equalsIgnoreCase("SI"))
                    if(ins[1].equalsIgnoreCase("M"))
                        instructores.add(ins);
                    else
                        instructoras.add(ins);
                  
                  orgList.add(ins);
              }
              
              
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
