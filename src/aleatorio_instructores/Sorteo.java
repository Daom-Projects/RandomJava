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
 * @author DiegoAlonso
 */
public class Sorteo {
    
    private ArrayList<String []> instructores;
    private ArrayList<String []> instructoras;
    private ArrayList<String []> orgList;
    private String rutaArchivo = "instructores.csv";
    
    public Sorteo() {

    }

    public Sorteo(ArrayList<String[]> instructores, ArrayList<String[]> instructoras, ArrayList<String[]> orgList) {
        this.instructores = instructores;
        this.instructoras = instructoras;
        this.orgList = orgList;
    }

    public ArrayList<String[]> getInstructores() {
        return instructores;
    }

    public void setInstructores(ArrayList<String[]> instructores) {
        this.instructores = instructores;
    }

    public ArrayList<String[]> getInstructoras() {
        return instructoras;
    }

    public void setInstructoras(ArrayList<String[]> instructoras) {
        this.instructoras = instructoras;
    }

    public ArrayList<String[]> getOrgList() {
        return orgList;
    }

    public void setOrgList(ArrayList<String[]> orgList) {
        this.orgList = orgList;
    }
    
    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public String toString() {
        return "Sorteo{" + "instructores=" + instructores + ", instructoras=" + instructoras + ", orgList=" + orgList + ", rutaArchivo=" + rutaArchivo + '}';
    }
    
    /* Leer el archivo y cargar los arrays */
    public String getList(){
        instructores = new ArrayList();
        instructoras = new ArrayList();
        orgList = new ArrayList();
        
        FileReader archivo = null;
        try {
          String instructor;
          archivo = new FileReader(rutaArchivo);
          BufferedReader lector = new BufferedReader(archivo);
          while ((instructor = lector.readLine()) != null) {
              String [] ins = instructor.split(";");
              if(ins.length>=2){
                  if(ins[2].equalsIgnoreCase("SI")){
                    if(ins[1].equalsIgnoreCase("M")){
                        instructores.add(ins);
                    }else{
                        instructoras.add(ins);
                    }
                  }
                  orgList.add(ins);
              }            
          }
          return "OK";
        } catch (FileNotFoundException e) {
            return "Error archivo no encontrado: "+e.getMessage();
        } catch (IOException e) {
            return "Error leyendo el archivo: "+e.getMessage();
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
    
    private void saveAssist(String[] in, boolean assist){
        int item = orgList.lastIndexOf(in);
        if(assist)
            in[2] = "SI";
        else
            in[2] = "NO";
        orgList.set(item, in);
    }
    
    private void saveList(){
        String lista = "";
        
        FileWriter salida = null;
        BufferedWriter escritor= null;
        try {
            salida = new FileWriter("C:\\instructores.csv");
            escritor = new BufferedWriter(salida);
            for(String[] ins : orgList){
                escritor.write(ins[0]+";"+ins[1]+";"+ins[2]+";0");
                escritor.newLine();
            }
            
        } catch (IOException e) {
            System.out.println("Error guardando lista: "+e.getMessage());
            
        } finally {
            if (salida != null) {
                try {
                    escritor.close();
                    salida.close();
                } catch (IOException e) {
                    System.out.println("Error cerrando lista: "+e.getMessage());
                }
            }
        }

    }
    
    /**/
    public String [] getRandom(char genero){

        Random rnd = new Random();
        String [] ins = null;
        int aleatorio;
        
        if(genero=='F'){
            if(instructores.size()<=0) //Verificamos instructores disponibles
                return ins;
            
            aleatorio = rnd.nextInt(instructoras.size());
            ins = instructoras.get(aleatorio);
            ins[3] = String.valueOf(aleatorio); //Guardamos posición de lista original
            instructoras.remove(aleatorio);
        }else{
            if(instructoras.size()<=0) //Verificamos instructores disponibles
                return ins;
            
            aleatorio = rnd.nextInt(instructores.size());
            ins = instructores.get(aleatorio);
            ins[3] = String.valueOf(aleatorio); //Guardamos posición de lista original
            instructores.remove(aleatorio);
        }
        return ins;
    }
    
    
}
