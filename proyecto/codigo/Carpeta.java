import java.util.*;
/**
 * Clase que representa los ficheros que seran ingresados a la estructura , hereda de "Dato"
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez 
 */
public class Carpeta extends Dato
{
   /**
    * Tamaño de la carpeta
    */
   protected int tamaño;
   
   /**
    * Lista enlazada que contiene los archivos de cada carpeta
    */
  protected LinkedList <Dato> lista= new LinkedList();
  
   /**
    * Constructor de la clase Carpeta , recibe el nombre de esta y su tamaño
    * @param nom Nombre del fichero
    * @param tamaño Tamaño del fichero
    */
   public Carpeta(String nom,int tamaño){
     super(nom);
     this.tamaño=tamaño;
    }
    
     /**
     * Metodo que retorna el nombre del dato
     * @return Nombre de la carpeta
     */
    public String getNombre(){
      return nombre;
    } 
    
     /**
     * Metodo que retorna el tamaño de la carpeta
     * @return Tamaño de la carpeta
     */
    public int getTamaño(){
        return tamaño;
    }
    

    /**
     * Metodo que agrega un archivo o fichero a la carpeta 
     * @param a Archivo a ser Agregado
     */
    public void addArchivo(Dato a ){
       lista.add(a);
    }
    
    /**
     * Metodo que elimina un archivo o fichero de la carpeta 
     * @param a Archivo a ser eliminado
     */
     public void removeArchivo(Dato a ){
       lista.remove(a);
    }
}
