package arbolgeneral;

/**
 * 
 * @author Jesús Sánchez Allende
 */
public class NodoGeneral{
    public int dato;        // dato que se guarda en el nodo
    public NodoGeneral primerHijo; // referencia al primer hijo
    public NodoGeneral hermano;    // referencia al hermano de la derecha
    public NodoGeneral padre;      // referencia al padre

    // constructor
    public NodoGeneral(int info){
        dato = info;
        primerHijo = null;
        hermano = null;
        padre = null;
    }
}
