import java.lang.IndexOutOfBoundsException;

/**
 * Implementacion propia de listas enlazadas
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez
 */
public class LinkedListLab4 
{
    
    /**
     * Nodo raiz del arbol
     */private Node first;
    
    /**
	 * Tamaño de la lista
	 */private int size;
    
    public LinkedListLab4()
    {
    	size = 0;
    	first = null;	
    }

	/**
	 * Retorna el nodo de la posicion especificada en la lista.
	 * @param index Indice del nodo a retornar.
	 * @return El nodo de la posicion especificada en la lista.
	 * @throws IndexOutOfBoundsException
	 */
	private Node getNode(int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index < size) {
			Node temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Retorna el elemento del indice especificado.
	 * @param index Indice del elemento a retornar.
	 * @return El elemento de la posicion especificada en la lista.
	 */
	public int get(int index) {
		Node temp = null;
		try {
			temp = getNode(index);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return temp.data;
	}

    /**
	 * Retorna el tamaño de la lista enlazada, no necesita recorrerla ya que al crear
	 * y remover nodos se modifica el tamaño.
	 * @return Tamaño de la lista.
	 */
    public int size()
    {
       return size;
    }
    
    /**
	 * Inserta un elemento en una posicion especifica de la lista.
	 * @param index Indice en el que se quiere insertar el elemento.
	 * @param data Dato a ser insertado en la lista.
	 */
    public void insert(int data, int index)
    {
       if(index==0){
           Node nuevo = new Node(data);
          if (first != null) {
             nuevo.next=first;
            first = nuevo;
            size++;
         } else {
            first = nuevo;
            size++;
         }
        }
         else  {
            
            if(index > size){
                System.out.println("No se puede insertar en esta posicion ya que excede el tamaño de la lista");
            }else{
            Node current= first;
            for(int i =0;i < size;++i){
                if(i==index-1){
                    Node nuevo=new Node (data);
                    if(current.next==null){
                        current.next=nuevo;
                        size++;
                        
                    }else{
                        nuevo.next=current.next;
                       current.next=nuevo;
                        size++;
                       
                    }
                     break;
                }else{
                    current=current.next;
                }
            }
         }
          
        }
    }
    
    
    /**
	 * Elimina un elemento en una posicion especifica de la lista.
	 * @param index Indice cuyo elemento sera eliminado.
	 */
    public void remove(int index)
    {
       if(index==0){
           if(first ==null){
               System.out.println("No hay elementos en la lista para eliminar");
            }else{
            first=first.next;
            size--;
          }
           
        }else{ 

              Node current= first;
              for(int i =0;i < size;++i){
                if(i==index-1){
                    if(current.next !=null){
                        current.next=current.next.next;
                        size--;
                    }
                    break;
                }else{
                    current=current.next;
                }
              }
   
        }
    }
    
    /**
	 * Retorna si un elemento esta o no en la lista enlazada. 
	 * @param data Dato a ser buscado en la lista.
	 * @return Si el elemento esta o no en la lista.
	 */
    public boolean contains(int data)
    {
        if(first != null){
    	  Node current= first;
          for(int i =0;i < size;++i){
                if(current.data==data){
                    return true;
                }else{
                 current=current.next;
                }
           }
        }
        return false;
    }

}
