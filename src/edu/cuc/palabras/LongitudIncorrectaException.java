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
public class LongitudIncorrectaException extends Exception {

    /**
     * Creates a new instance of <code>LongitudIncorrectaException</code>
     * without detail message.
     */
    public LongitudIncorrectaException() {
    }

    /**
     * Constructs an instance of <code>LongitudIncorrectaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public LongitudIncorrectaException(String msg) {
        super(msg);
    }
}
