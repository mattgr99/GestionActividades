/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDeMultas;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class Multas {
    private int numero;
    private int capacidad;
    private String conductor;
    private List<Multado> pasajeros;

    public Multas() {
        pasajeros = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    

    public List<Multado> getPasajero() {
        return pasajeros;
    }
    
    //Calcula el porcentaje de uso de asientos en la unidad de trasporte
    public float CalcularPorcentajeDeUso(){
        int n = pasajeros.size();
        float r = ((float)n/(float)capacidad)*100;
        return r;
    }
    
    public boolean Archivar(){
            try {
                String n = "Bus_".concat(Integer.toString(numero)).concat(".txt");
                try(FileWriter a = new FileWriter(n)){
                    a.write(this.Mostrar());
                }
                return true;
            } catch (Exception e) {
                return false;
            }
         }
    public String Mostrar(){
        return ("\t\t*****Transporte del Bus KemBus*****\r\n"+
                "\tNúmero de la unidad: "+ numero +"\r\n"+
                "\t\tNombre del conductor: " + conductor+ "\r\n" +
                "\t\tCapacidad del bus : " + capacidad + "\r\n"+
                "\tDatos de los pasajeros: \r\n"+
                "Pasajero del asiento: ");
        
    }
    
    
}
