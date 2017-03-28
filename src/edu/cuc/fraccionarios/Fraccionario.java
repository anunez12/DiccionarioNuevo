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
public class Fraccionario {
    private int numerador;
    private int denominador;

    public Fraccionario(int numerador, int denominador) throws DenominadorCeroException {
        this.numerador = numerador;
        if (denominador == 0) {
            throw new DenominadorCeroException();
        }
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) throws DenominadorCeroException {
         if (denominador == 0) {
            throw new DenominadorCeroException();
        }
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return "Fraccionario{" + "numerador=" + numerador + ", denominador=" + denominador + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.numerador;
        hash = 97 * hash + this.denominador;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraccionario other = (Fraccionario) obj;
        if (this.numerador != other.numerador) {
            return false;
        }
        if (this.denominador != other.denominador) {
            return false;
        }
        return true;
    }
    
    
}
