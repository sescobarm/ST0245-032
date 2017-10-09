/**
 * Implementacion propia de la clase Nodo
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez
 */
public class Node {
    /**
     * Dato que contiene el nodo
     */
    protected int data;
    
     /**
     * Nodo siguiente 
     */
    protected Node next;
    public Node(int data)
    {
    	next = null;
    	this.data = data;
    }
	
}