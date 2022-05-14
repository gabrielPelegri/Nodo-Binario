package arbolgeneral;

/**
 * 
 * @author Jesús Sánchez Allende
 */
public class ArbolGeneral {

    private NodoGeneral raiz;

    public ArbolGeneral() {
        raiz = null;
    }

    public ArbolGeneral(NodoGeneral nodo) {
        this.raiz = nodo;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public void vaciar() {
        raiz = null;
    }

    public NodoGeneral raiz() throws Exception { // si el árbol está vacío
        if (esVacio()) {
            throw new Exception("Error en raiz: árbol vacío");
        }
        return raiz;
    }

    public ArbolGeneral primerHijo() throws Exception { // si el árbol está vacío
        if (esVacio()) {
            throw new Exception("Error en hijoIzq: árbol vacío");
        }

        return new ArbolGeneral(raiz.primerHijo);
    }

    public ArbolGeneral hermano() throws Exception { // si el árbol está vacío
        if (esVacio()) {
            throw new Exception("Error en hijoIzq: árbol vacío");
        }

        return new ArbolGeneral(raiz.hermano);
    }

    public ArbolGeneral padre() throws Exception { //argumento ilegal
        if (raiz == null) {
            throw new Exception("Error en padre: subárbol vacío");
        }

        return new ArbolGeneral(raiz.padre);
    }

    public void añadirHijo(NodoGeneral hijo) throws Exception { // si el árbol está vacío o argumento ilegal
        if (hijo == null) {
            throw new Exception("Error en añadirHijo: hijo es un árbol vacío");
        }
        if (esVacio()) {
            throw new Exception("Error en añadirHijo: árbol vacío");
        }

        if (raiz.primerHijo == null) {
            raiz.primerHijo = hijo;
            hijo.padre = raiz;
        } else {
            NodoGeneral aux = raiz.primerHijo;
            while (aux.hermano != null) {
                aux = aux.hermano;
            }

            aux.hermano = hijo;
            hijo.padre = raiz;
        }
    }

    public void eliminar(ArbolGeneral subarbol) throws Exception {
        if (subarbol == null) {
            throw new Exception("Error en borra: subárbol vacío");
        }

        if (subarbol.raiz == raiz) {
            raiz = null;
        } else {
            ArbolGeneral p = subarbol.padre();
            if (p.esVacio()) {
                throw new Exception("Error en borra: no existe el subárbol a eliminar");
            } else if (p.raiz.primerHijo == subarbol.raiz) {
                p.raiz.primerHijo = p.raiz.primerHijo.hermano;
            } else {
                NodoGeneral aux = p.raiz.primerHijo;
                while (aux.hermano != subarbol.raiz) {
                    aux = aux.hermano;
                }

                aux.hermano = aux.hermano.hermano;
            }
        }
    }

    public void pintaArbol(int esp) {
        if (!esVacio()) {
            try {
                for (int i = 0; i < esp; i++) {
                    System.out.print("  ");
                }
                System.out.print("|-");
                System.out.println(raiz.dato + " ");

                for (ArbolGeneral aux = primerHijo(); !aux.esVacio(); aux = aux.hermano()) {
                    aux.pintaArbol(esp + 1);
                }
            } catch (Exception e) {
            }
        }
    }
    
    
    
    /*ejercicios*/
    public int sumaNodos() {
        if (esVacio()) {
            return 0;
        } else {
            try {
                return primerHijo().sumaNodos() + hermano().sumaNodos() + raiz().dato;
            } catch (Exception e) {
                return -1111;
            }
        }
    }

    public int altura() {
        if (esVacio()) {
            return 0;
        } else {
            int max = 0;
            try {
                ArbolGeneral h = primerHijo();
                while (!h.esVacio()) {
                    int alt = h.altura();
                    if (alt > max) {
                        max = alt;
                    }
                    h = h.hermano();
                }
                return max + 1;
            } catch (Exception e) {
                return -1111;
            }
        }
    }

    public static void escribePrimogénitos(ArbolGeneral a) {
        if (!a.esVacio()) {
            try {
                ArbolGeneral aux = a.primerHijo();
                if (!aux.esVacio()) {
                    System.out.println(aux.raiz().dato);
                }
                while (!aux.esVacio()) {
                    escribePrimogénitos(aux);
                    aux = aux.hermano();
                }
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }

    public static int cuentaPositivos(ArbolGeneral a) {
        if (a.esVacio()) {
            return 0;
        } else {
            try {
                if (a.raiz().dato > 0) {
                    return cuentaPositivos(a.primerHijo()) + cuentaPositivos(a.hermano()) + 1;
                } else {
                    return cuentaPositivos(a.primerHijo()) + cuentaPositivos(a.hermano());
                }
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public static int cuantasHojas(ArbolGeneral a) {
        if (a.esVacio()) {
            return 0;
        } else {
            try {
                if (a.primerHijo().esVacio()) {
                    return 1 + cuantasHojas(a.hermano());
                } else {
                    return cuantasHojas(a.primerHijo()) + cuantasHojas(a.hermano());
                }
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public static int grado(ArbolGeneral a) {
        if (a.esVacio()) {
            return 0;
        } else {
            try {
                ArbolGeneral aux = a.primerHijo();
                int cont = 0;
                int grado;
                while (!aux.esVacio()) {
                    aux = aux.hermano();
                    cont++;
                }
                grado = cont;
                aux = a.primerHijo();
                while (!aux.esVacio()) {
                    int x = grado(aux);
                    if (x > grado) {
                        grado = x;
                    }
                    aux = aux.hermano();
                }
                return grado;
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        NodoGeneral n = new NodoGeneral(1);
        ArbolGeneral a = new ArbolGeneral(n);
        n = new NodoGeneral(2);
        ArbolGeneral b = new ArbolGeneral(n);
        n = new NodoGeneral(3);
        ArbolGeneral c = new ArbolGeneral(n);
        n = new NodoGeneral(-4);
        ArbolGeneral d = new ArbolGeneral(n);
        ArbolGeneral e = new ArbolGeneral(new NodoGeneral(2));
        ArbolGeneral f = new ArbolGeneral(new NodoGeneral(43));
        ArbolGeneral g = new ArbolGeneral(new NodoGeneral(1));
        ArbolGeneral h = new ArbolGeneral(new NodoGeneral(-3));
        ArbolGeneral i = new ArbolGeneral(new NodoGeneral(54));
        try {
            c.añadirHijo(new NodoGeneral(-8));
            a.añadirHijo(c.raiz());
            a.añadirHijo(b.raiz());
            b.añadirHijo(d.raiz());
            c.añadirHijo(new NodoGeneral(5));
            e.añadirHijo(a.raiz());
            b.añadirHijo(f.raiz());
            b.añadirHijo(g.raiz());
            b.añadirHijo(h.raiz());
            b.añadirHijo(i.raiz());
//	    	a.primerHijo().hermano()
            System.out.println("arbol");
            e.pintaArbol(0);
            System.out.println("suma: " + a.sumaNodos());
//	    	System.out.println("eliminar");
//	    	a.eliminar(a.primerHijo().hermano());
            System.out.println("suma: " + e.sumaNodos());
            e.pintaArbol(0);
            System.out.println("altura " + a.altura());
//	    	escribePrimog�nitos(a);
            System.out.println(cuentaPositivos(e));
            System.out.println(cuantasHojas(e));
            System.out.println(grado(e));

        } catch (Exception exc) {
        }

    }
}
