/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.pruebas;

import edu.cuc.fraccionarios.DenominadorCeroException;
import edu.cuc.fraccionarios.Fraccionario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexisdelahoz
 */
public class PruebaFraccionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Fraccionario frac1 = new Fraccionario(10, 20);
            frac1.setDenominador(0);
            //Fraccionario frac2 = new Fraccionario(10, 0);
            
        } catch (DenominadorCeroException ex) {
            Logger.getLogger(PruebaFraccionario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("El denominador está en cero!");
        }
    }
    
}
