package arbolbinario;

/**
 * 
 * @author Jesús Sánchez Allende
 * @param <E> La clase de objetos que se guardan en el árbol
 */
public class ArbolBinario<E>{
    NodoBinario<E> raiz;

    public ArbolBinario(){
        raiz = null;
    }

    public ArbolBinario(NodoBinario<E> nodo){
        this.raiz = nodo;
    }

    public boolean esVacio(){
        return raiz == null;
    }
    
    public void vaciar(){
        raiz = null;
    }
    
    public NodoBinario<E> raiz() throws Exception{ // si el arbol está vacio
        if (esVacio())
            throw new Exception("raiz: árbol vacío");
        return raiz;
    }
    
    public ArbolBinario<E> hijoIzq() throws Exception{ // si el arbol está vacio
        if (esVacio())
            throw new Exception("Error en hijoIzq: árbol vacío");

        return new ArbolBinario(raiz.izq);
    }
    
    public ArbolBinario<E> hijoDer() throws Exception{ // si el arbol está vacio
        if (esVacio())
            throw new Exception("Error en hijoIzq: árbol vacío");

        return new ArbolBinario(raiz.der);
    }
    

    public void ponHijoIzq(ArbolBinario<E> hijo) throws Exception{ // si el arbol está vacio o argumento ilegal
        if (hijo == null)
            throw new Exception("Error en ponHijoIzq: hijo es un árbol vacío");
        if (esVacio())
            throw new Exception("Error en ponHijoIzq: árbol vacío");

        raiz.izq = hijo.raiz;
    }
    
    public void ponHijoDer(ArbolBinario<E> hijo) throws Exception{ // si el árbol está vacio o argumento ilegal
        if (hijo == null)
            throw new Exception("Error en ponHijoDer: hijo es un árbol vacío");
        if (esVacio())
            throw new Exception("Error en ponHijoDer: árbol vacío");

        raiz.der = hijo.raiz;
    }
    
    public void eliminar(ArbolBinario<E> subarbol) throws Exception{
        if (subarbol == null)
            throw new Exception("Error en eliminar: subárbol vacío");

        if (subarbol.raiz == raiz)
            raiz = null;
        else {
            ArbolBinario<E> p = padre(subarbol);
            if (p.esVacio())
                throw new Exception("Error en eliminar: no existe el subárbol a eliminar");
            else
                if (p.raiz.izq == subarbol.raiz)
                    p.raiz.izq = null;
                else
                    p.raiz.der = null;
        }
    }

    public ArbolBinario<E> padre(ArbolBinario<E> subarbol) throws Exception{ //argumento ilegal
        if (subarbol == null)
            throw new Exception("Error en padre: subárbol vacío");

        if (esVacio() || subarbol.esVacio() || subarbol.raiz == raiz)
            return new ArbolBinario<E>();
        else
            if (raiz.izq == subarbol.raiz || raiz.der == subarbol.raiz)
                return this;
            else{
                ArbolBinario<E> p = (new ArbolBinario<E>(raiz.izq)).padre(subarbol);
                if (p.esVacio())
                    return (new ArbolBinario<E>(raiz.der)).padre(subarbol);
                else
                    return p;
            }
    }

}
