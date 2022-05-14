/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

/**
 *
 * @author Jesús Sánchez Allende
 */
public class PruebaArbolBinario {
    public static void main(String[] args) {
        
        ArbolBinario<String> arbolA = new ArbolBinario(new NodoBinario<String>("A"));
        ArbolBinario<String> arbolB = new ArbolBinario(new NodoBinario<String>("B"));
        ArbolBinario<String> arbolC = new ArbolBinario(new NodoBinario<String>("C"));
        ArbolBinario<String> arbolD = new ArbolBinario(new NodoBinario<String>("D"));
        ArbolBinario<String> arbolE = new ArbolBinario(new NodoBinario<String>("E"));
        ArbolBinario<String> arbolF = new ArbolBinario(new NodoBinario<String>("F"));
        ArbolBinario<String> arbolG = new ArbolBinario(new NodoBinario<String>("G"));
        
        try {
            arbolA.ponHijoIzq(arbolB);
            arbolA.ponHijoDer(arbolC);
            arbolB.ponHijoIzq(arbolD);

            arbolC.ponHijoIzq(arbolE);
            arbolC.ponHijoDer(arbolF);

            arbolF.ponHijoDer(arbolG);
            
            
            preorden(arbolA.raiz);
            System.out.println();
            
            inorden(arbolA.raiz);
            System.out.println();
            
            postorden(arbolA.raiz);
            System.out.println();
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
    }

    public static void preorden(NodoBinario nodo){
        if(nodo != null){
            System.out.print(nodo.dato);
            preorden(nodo.izq);
            preorden(nodo.der);
        }
    }
    
    public static void inorden(NodoBinario nodo){
        if(nodo != null){
            inorden(nodo.izq);
            System.out.print(nodo.dato);
            inorden(nodo.der);
        }
    }
    
    public static void postorden(NodoBinario nodo){
        if(nodo != null){
            postorden(nodo.izq);
            postorden(nodo.der);
            System.out.print(nodo.dato);
        }
    }
    
}
