 /**
  * Clase Nodo , de la cual esta compuesta el arbol B creado
  * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez 
  */class Node
 {    
     /**
      * Nodos derecho e izquierdo del actual
      */
     Node left, right;
     
     /**
      * Dato asociado al Nodo
      */
     Dato dato;
 
     /**
      * Constructor por omision
      */
     public Node()
     {
         left = null;
         right = null;
         dato = null;
     }
     
     /**
      * Constructor que recibe un objeto de tipo "Dato"
      * @param n Dato que sera asignado al dato 
      */
     public Node(Dato n)
     {
         left = null;
         right = null;
         dato = n;
     }  
     
  
 }