
/**
 * Arbol B adaptado a la estructura de datos necesaria para el Proyecto de Estructuras de
 * datos y algoritmos
 * 
 * Codigo base de arbol B : http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
 * 
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez 
 * 
 */
public class BTree
{
    /**
     * Nodo principal del arbol
     */
    public static Node raiz;
    
    /**
     * Constructor por omision
     */
    public BTree(){
     raiz=null;
    }
    
    /**
    * Metodo que insertara un Dato a la estructura de datos comparando su "llave" con las ya existentes 
    * @param c Dato a ser agregado
    */
    public void insertar(Dato c){
        if(!yaEsta(c)){
           Node nuevo = new Node(c);
           if(raiz==null){
			raiz = nuevo;
			return;
		  }
		
		Node temp=raiz;
		Node padre=null;
		
		
		while(true){
		    padre = temp;
		      if(c.hashCode() < temp.hashCode()){
		          temp = temp.left;
		          if(temp==null){
		              padre.left= nuevo;
		              return;
		          }
		      }else{
		          temp= temp.right;
		          if(temp==null){
		              padre.right=nuevo;
		              return;
		          }
		      }
		  }
		
     
      }else{
        System.out.print(" El elemento ya se encuentra en la estructura de datos");
        }
   }
    
   
     
    /**
    * Metodo que imprime los elementos del arbol in-orden (primero por izquierda, luego el centro y 
    * luego la derecha)
    * @param c Nodo raiz
    */
    public void display(Node raiz){
        
		if(raiz!=null){
			display(raiz.left);
			System.out.print(" " + raiz.dato.getNombre());
			display(raiz.right);
		}
	}
    
      
    /**
    * Metodo que determina si el dato ya esta en la estructura de datos 
    * @param c Dato a buscar
    * @return Si el dato ya esta o no en la estructura
    */
	public boolean yaEsta(Dato id){
	    Node temp = raiz;
		while(temp!=null){
			if(temp.dato.llave==id.llave){
				return true;
			}else if(temp.dato.llave>id.llave){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
		}
		return false;
	   }
	   
	   
	     
    /**
    * Metodo que buscar basado en el nombre del dato el objeto que se encuentra en la estructura 
    * @param nombre Nombre del dato a buscar
    * @return Objeto de tipo "Dato" buscado o null si no se encuentra 
    */
	   public Dato search(String nombre){
       int llavep=0;
          for(int i =0;i<nombre.length();i++){
            llavep+=llavep+nombre.charAt(i);
        }
        llavep*=nombre.charAt(0);
       
		Node temp = raiz;
		while(temp!=null){
			if(temp.dato.llave == llavep){
				return temp.dato;
			}else if(temp.dato.llave > llavep){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
		}
		return null;
	}
	
	  
    /**
    * Metodo que elimina un Dato de la estructura de datos
    * @param id Dato a ser eliminado
    * @return Si la eliminacion sucedio con exito o no 
    */
	public boolean delete(Dato id){
		Node padre = raiz;
		Node temp = raiz;
		boolean estaIzquierda = false;
		
		//Encontrar el dato
		while(temp.dato.llave!=id.llave){
			padre = temp;
			if(temp.dato.llave>id.llave){
				estaIzquierda = true;
				temp = temp.left;
			}else{
				estaIzquierda = false;
				temp = temp.right;
			}
			if(temp ==null){
				return false;
			}
		}

		
		
		//Caso 1 : El nodo a eliminar no tiene hijos
		if(temp.left==null && temp.right==null){
			if(temp==raiz){
				raiz = null;
			}
			if(estaIzquierda ==true){
				padre.left = null;
			}else{
				padre.right = null;
			}
		}
		//Caso 2 : Solo tiene un hijo
	   else if(temp.right==null){
			if(temp==raiz){
				raiz = temp.left;
			}else if(estaIzquierda){
				padre.left = temp.left;
			}else{
				padre.right = temp.left;
			}
		}
		else if(temp.left==null){
			if(temp==raiz){
				raiz = temp.right;
			}else if(estaIzquierda){
				padre.left = temp.right;
			}else{
				padre.right = temp.right;
			}	
		}
		//Cso 3 : Tiene 2 hijos
		else if(temp.left!=null && temp.right!=null){

			Node siguiente	 = getsiguiente(temp);
			if(temp==raiz){
				raiz = siguiente;
			}else if(estaIzquierda){
				padre.left = siguiente;
			}else{
				padre.right = siguiente;
			}			
			siguiente.left = temp.left;
		}		
		return true;		
	}
	
	  
    /**
    * Metodo auxiliar de eliminacion que retorna el sucesor del nodo a eliminar
    * @param deleleNode Dato a ser eliminado
    * @return Nodo que reemplazara al eliminado
    */
	public Node getsiguiente(Node deleleNode){
		Node siguiente =null;
		Node siguientepadre =null;
		Node temp = deleleNode.right;
		while(temp!=null){
			siguientepadre = siguiente;
			siguiente = temp;
			temp = temp.left;
		}

		if(siguiente!=deleleNode.right){
			siguientepadre.left = siguiente.right;
			siguiente.right = deleleNode.right;
		}
		return siguiente;
	}
	
	/**
	 * Metodo principal
	 */
	public static void main(){
	    BTree b =new BTree();
	    Carpeta a = new Carpeta("1",123);
	    Carpeta be = new Carpeta("2",456);
	    Carpeta c = new Carpeta("3",789);
	    Archivo d = new Archivo("Este.txt");
	    Archivo e = new Archivo("Esta.doc");
	    b.insertar(a);
	    b.insertar(be);
	    b.insertar(c);
	    a.addArchivo(d);
	    c.addArchivo(e);
	    b.display(raiz);
	    b.delete(be);
	    System.out.println();
	    b.display(raiz);
        Carpeta t= (Carpeta) b.search("3");
         Carpeta s = new Carpeta("4",7769);
        b.insertar(s);
        System.out.println();
        b.display(raiz);
        
	    
	    
	   }
    
}
