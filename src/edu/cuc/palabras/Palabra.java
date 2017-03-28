package edu.cuc.palabras;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.DefaultListModel;

/**
 *
 * @author alexisdelahoz
 */
public class Palabra {
    private String palabra;
    private String significado;
    private int maxLongitudSinonimos;
    private ArrayList<Palabra> sinonimos = new ArrayList<>();

    public Palabra(String palabra) throws LongitudIncorrectaException {
        if (palabra.length() < 2) {
            throw new LongitudIncorrectaException("La palabra no tiene suficiente longitud, \n"+
                                                  "solo tiene "+palabra.length());
        }
        this.palabra = palabra;
    }

    public Palabra(String palabra, String significado) throws LongitudIncorrectaException {
        if (palabra.length() < 2) {
            throw new LongitudIncorrectaException("La palabra no tiene suficiente longitud, \n"+
                                                  "solo tiene "+palabra.length());
        }
        this.palabra = palabra;
        this.significado = significado;
    }

    public Palabra(String palabra, int maxLongitudSinonimos) throws LongitudIncorrectaException, LongitudSinonimoIncorrectaException {
        if (palabra.length() < 2) {
            throw new LongitudIncorrectaException("La palabra no tiene suficiente longitud, \n"+
                                                  "solo tiene "+palabra.length());
        }
        this.palabra = palabra;
        if (maxLongitudSinonimos < 0) {
            throw new LongitudSinonimoIncorrectaException("La longitud de los sinonimos es incorrecta, \n"+
                                                          maxLongitudSinonimos);
        }
        this.maxLongitudSinonimos = maxLongitudSinonimos;
    }

    public int getMaxLongitudSinonimos() {
        return maxLongitudSinonimos;
    }

    public void setMaxLongitudSinonimos(int maxLongitudSinonimos) throws LongitudSinonimoIncorrectaException {
        if (maxLongitudSinonimos < 0) {
            throw new LongitudSinonimoIncorrectaException("La longitud de los sinonimos es incorrecta, \n"+
                                                          maxLongitudSinonimos);
        }
        this.maxLongitudSinonimos = maxLongitudSinonimos;
    }
    

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) throws LongitudIncorrectaException {
         if (palabra.length() < 2) {
            throw new LongitudIncorrectaException("La palabra no tiene suficiente longitud, \n"+
                                                  "solo tiene "+palabra.length());
        }
        this.palabra = palabra;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.palabra);
        hash = 29 * hash + Objects.hashCode(this.significado);
        hash = 29 * hash + Objects.hashCode(this.sinonimos);
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
        final Palabra other = (Palabra) obj;
        if (!Objects.equals(this.palabra, other.palabra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Palabra{" + "palabra=" + palabra + ", significado=" + significado + ", sinonimos=" + sinonimos + '}';
    }
    
    //Metodos de gestion de los sinonimos
    public void adicionarSinonimo(Palabra nuevaPalabra) {
        sinonimos.add(nuevaPalabra);
    }
    
    public void adicionarSinRepetidos(Palabra nuevaPalabra) throws PalabraRepetidaException {
        if (!buscarSinonimo(nuevaPalabra)) {
            adicionarSinonimo(nuevaPalabra);
        }
        else {
            throw new PalabraRepetidaException();
        }
    }
    
    public void adicionarConLongitud(Palabra nuevaPalabra) throws LongitudSinonimoIncorrectaException {
        if (maxLongitudSinonimos != 0) {
            int longitud = nuevaPalabra.getPalabra().length();  
            if (longitud> this.maxLongitudSinonimos) {
                throw new LongitudSinonimoIncorrectaException("El sinonimo sobrepasa la maxima longitud permitida: \n"+
                                                              "Max: "+this.maxLongitudSinonimos+ " : "+longitud);
            }
        }
        adicionarSinonimo(nuevaPalabra);
    }
    
    public boolean buscarSinonimo(Palabra nuevaPalabra) {
        return sinonimos.contains(nuevaPalabra);
    }
    
    public boolean eliminarSinonimo(Palabra nuevaPalabra) {
        return sinonimos.remove(nuevaPalabra);
    }
    
    //Metodos de la clase Palabra
    public double promedioLongitud() {
        double suma = 0;
        for (int i = 0; i < sinonimos.size(); i++) {
            Palabra actual = sinonimos.get(i);
            suma += actual.getPalabra().length();
        }
        return suma / sinonimos.size();
    }
    
    public Palabra sinonimoMayorLongitud() {
        Palabra mayor = sinonimos.get(0);
        for (int i = 0; i < sinonimos.size(); i++) {
            Palabra actual = sinonimos.get(i);
            if (actual.getPalabra().length() > mayor.getPalabra().length()) {
                mayor = actual;
            }
        }
        return mayor;
    }
    
    public ArrayList<Palabra> sinonimosInicianLetra(String letraInicial) {
        ArrayList<Palabra> listado = new ArrayList<>();
        for (int i = 0; i < sinonimos.size(); i++) {
            Palabra actual = sinonimos.get(i);
            if (actual.getPalabra().startsWith(letraInicial)) {
                listado.add(actual);
            }
        }
        return listado;
    }
    
    /**
     * Indica el número de sinonimos actuales de la palabra
     * @return la cantidad de sinonimos actuales
     */
    public int cantidadSinonimos() {
        return sinonimos.size();
    }
    
    /**
     * Metodo para mostrar los sinonimos en un modelo de JList
     */
    public DefaultListModel<String> getListSinonimos() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (int i = 0; i < sinonimos.size(); i++) {
            Palabra actual = sinonimos.get(i);
            modelo.addElement(actual.getPalabra());
        }
        return modelo;
    }
    
}
