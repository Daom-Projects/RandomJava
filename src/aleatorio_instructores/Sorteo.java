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

/**
 *
 * @author DiegoAlonso
 */
public class Sorteo {
    
    private ArrayList<StringBuilder []> instructores;
    private ArrayList<StringBuilder []> instructoras;
    private String rutaArchivo = "instructores.csv";
    
    public Sorteo() {
        
    }
    
    public Sorteo(ArrayList<StringBuilder[]> instructores, ArrayList<StringBuilder[]> instructoras) {
        this.instructores = instructores;
        this.instructoras = instructoras;
    }

    public ArrayList<StringBuilder []> getInstructoras() {
        return instructoras;
    }

    public void setInstructoras(ArrayList<StringBuilder []> instructoras) {
        this.instructoras = instructoras;
    }

    public ArrayList<StringBuilder []> getInstructores() {
        return instructores;
    }

    public void setInstructores(ArrayList<StringBuilder []> instructores) {
        this.instructores = instructores;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
    @Override
    public String toString() {
        return "Sorteo{" + "instructores=" + instructores + ", instructoras=" + instructoras + '}';
    }
    
    private void getList(){
        instructores = new ArrayList();
        instructoras = new ArrayList();
        FileReader archivo = null;
        try {
          String instructor;
          archivo = new FileReader(rutaArchivo);
          BufferedReader lector = new BufferedReader(archivo);
          while ((instructor = lector.readLine()) != null) {
              String [] ins = instructor.split(";");
              //if(ins.length>=1)
                  //if(ins[1].equalsIgnoreCase("M"))
                   // instructores.add(ins);
                  //else
                    //instructoras.add(ins);
                      
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
