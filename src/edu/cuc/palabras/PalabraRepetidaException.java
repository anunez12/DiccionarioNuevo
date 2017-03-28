/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.palabras;

/**
 *
 * @author alexisdelahoz
 */
public class PalabraRepetidaException extends Exception {

    /**
     * Creates a new instance of <code>PalabraRepetidaException</code> without
     * detail message.
     */
    public PalabraRepetidaException() {
    }

    /**
     * Constructs an instance of <code>PalabraRepetidaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PalabraRepetidaException(String msg) {
        super(msg);
    }
}
