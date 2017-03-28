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
public class LongitudSinonimoIncorrectaException extends Exception {

    /**
     * Creates a new instance of
     * <code>LongitudIncorrectaSinonimoException</code> without detail message.
     */
    public LongitudSinonimoIncorrectaException() {
    }

    /**
     * Constructs an instance of
     * <code>LongitudIncorrectaSinonimoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LongitudSinonimoIncorrectaException(String msg) {
        super(msg);
    }
}
