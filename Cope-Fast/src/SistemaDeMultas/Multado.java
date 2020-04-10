/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDeMultas;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kevin
 */
public class Multado {
    private String nombre;
    private String ruta;
    private int aniesto;
    private float costo;

    public Multado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getAniesto() {
        return aniesto;
    }

    public void setAniesto(int aniesto) {
        this.aniesto = aniesto;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
      public String MostrarPasajeros(){
        return ("\tDatos del pasajero: \r\n"+
                "\t\tNombre del pasajero: " + nombre + "\r\n" +
                "\t\tAsiento: : " + aniesto +"\r\n"+
                "\t\tRuta: " + ruta + "\r\n"+
                "\tCosto del pasaje: \r\n"+costo);
    
}
      public boolean archivar(String filename, String contenido){
        
        try {            
            String n = filename.concat(".txt");
            FileWriter a = new FileWriter(n, true);
            a.write(contenido);
            a.close();
            System.out.println("guardado " + contenido + " en " + n);
            return true;
        } catch (IOException e) {            
            return false;
        }       
    }
}
    
      
