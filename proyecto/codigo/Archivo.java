
/**
 * Clase Archivo que representa los objetos que no son ficheros a ser agregados en el arbol B
 * 
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez 
 */
public class Archivo extends Dato
{
    /**
     * Constructor que recibe un nombre y lo asigna al archivo
     * @param s Nombre del archivo
     */
    public Archivo(String s){
     super(s);   
    }
    
    
    /**
     * Metodo que retorna el nombre del archivo
     * @return Nombre del archivo
     */
    public String getNombre(){
        return nombre;
    }
}
