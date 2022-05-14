package arbolbinario;

/**
 * 
 * @author Jesús Sánchez Allende
 * @param <E> La clase de objetos que se guardan en el árbol
 */
public class NodoBinario<E>{
    E dato;        // dato que se guarda en el nodo
    NodoBinario<E> izq; // referencia al nodo izquierdo
    NodoBinario<E> der; // referencia al nodo derecho
    
    // constructor
    public NodoBinario(E info){
        // Tambien se puede llamar como
        // this(info, null, null);
        dato = info;
        izq = null;
        der = null;
    }
    
    public NodoBinario(E info, NodoBinario<E> hijoIzq, NodoBinario<E> hijoDer){
        dato = info;
        izq = hijoIzq;
        der = hijoDer;
    }
}
