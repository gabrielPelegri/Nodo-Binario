package arbolbusqueda;

import arbolbinario.*;

/**
 * 
 * @author Jesús Sánchez Allende
 */
public class NodoBinario{
    public int dato;        // dato que se guarda en el nodo
    public NodoBinario izq; // referencia al nodo izquierdo
    public NodoBinario der; // referencia al nodo derecho
    
    // constructor
    public NodoBinario(int info){
        // Tambien se puede llamar como
        // this(info, null, null);
        dato = info;
        izq = null;
        der = null;
    }
    
    public NodoBinario(int info, NodoBinario hijoIzq, NodoBinario hijoDer){
        dato = info;
        izq = hijoIzq;
        der = hijoDer;
    }
}
