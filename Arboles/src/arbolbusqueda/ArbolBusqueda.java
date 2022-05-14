package arbolbusqueda;


/**
 * 
 * @author Jesús Sánchez Allende
 */
public class ArbolBusqueda{
    private NodoBinario raiz;

    public ArbolBusqueda(){
        raiz = null;
    }

    public ArbolBusqueda(NodoBinario nodo){
        this.raiz = nodo;
    }

    public boolean esVacio(){
        return raiz == null;
    }
    
    public NodoBinario raiz() throws Exception{ // si el árbol está vacío
        if (esVacio())
            throw new Exception("raiz: árbol vacío");
        return raiz;
    }
    
    public ArbolBusqueda hijoIzq() throws Exception{ // si el árbol está vacío
        if (esVacio())
            throw new Exception("Error en hijoIzq: árbol vacío");

        return new ArbolBusqueda(raiz.izq);
    }
    
    public ArbolBusqueda hijoDer() throws Exception{ // si el árbol está vacío
        if (esVacio())
            throw new Exception("Error en hijoIzq: árbol vacío");

        return new ArbolBusqueda(raiz.der);
    }
    


    void insertar (int dato) throws Exception{
        raiz = insertar(dato, raiz);
    }
    
    NodoBinario buscar (int dato) throws Exception{
        return buscar(dato, raiz);
    }
    
    NodoBinario buscarMin () throws Exception {
        return buscarMin(raiz);
    }

    NodoBinario buscarMax () throws Exception {
        return buscarMax(raiz);
    }
    
    void eliminar (int dato) throws Exception{
        raiz = eliminar(dato, raiz);
    }
    
    void eliminarMin() throws Exception{
        raiz = eliminarMin(raiz);
    }
    
    NodoBinario buscar (int dato, NodoBinario t) throws Exception{
        while (t != null)
            if (dato < t.dato)
                t = t.izq;
            else if (dato > t.dato)
                t = t.der;
            else
                return t;

        throw new Exception ("Error en buscar: dato no encontrado"); 
    }

    NodoBinario buscarMin (NodoBinario t) throws Exception {
        if (t == null)
            throw new Exception ("Error en buscar: dato no encontrado"); 

        while (t.izq != null)
                t = t.izq;
        return t;
    }

    NodoBinario buscarMax (NodoBinario t) throws Exception {
        if (t == null)
            throw new Exception ("Error en buscar: dato no encontrado"); 

        while (t.der != null)
                t = t.der;
        return t;
    }



    NodoBinario insertar (int dato, NodoBinario t) throws Exception{
        if (t == null)
            t = new NodoBinario(dato, null, null);
        else if (dato < t.dato)
            t.izq = insertar(dato, t.izq);
        else if (dato > t.dato)
            t.der = insertar(dato, t.der);
        else
            throw new Exception("Error en insertar: valor duplicado");

        return t;
    }


    NodoBinario eliminarMin(NodoBinario t) throws Exception{
        if (t == null)
            throw new Exception ("Error en eliminar: dato no encontrado"); 

        if (t.izq != null)
            t.izq = eliminarMin(t.izq);
        else
            t = t.der;

        return t;        
    }

    NodoBinario eliminar (int dato, NodoBinario t) throws Exception{
        if (t == null)
            throw new Exception ("Error en eliminar: dato no encontrado"); 

        else if (dato < t.dato)
            t.izq = eliminar(dato, t.izq);
        else if (dato > t.dato)
            t.der = eliminar(dato, t.der);
        else if (t.izq != null && t.der != null) {
            t.dato = buscarMin(t.der).dato;
            t.der = eliminarMin(t.der);
        } else {
            if (t.izq != null)
                t = t.izq;
            else
                t = t.der;
        }

        return t;
    }
    
    public void eliminarMenoresQue(int n){
        try{
            while(!esVacio() && buscarMin().dato < n)
                eliminarMin();
        }catch(Exception e){}
    }
}
