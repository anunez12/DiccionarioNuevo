/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.fraccionarios;

/**
 *
 * @author alexisdelahoz
 */
public class DenominadorCeroException extends Exception {

    /**
     * Creates a new instance of <code>DenominadorCeroException</code> without
     * detail message.
     */
    public DenominadorCeroException() {
    }

    /**
     * Constructs an instance of <code>DenominadorCeroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DenominadorCeroException(String msg) {
        super(msg);
    }
}
