
/**
 * Clase Dato ,representa los archivos en general que seran ingresados a la estructura de datos, tiene como atributos
 * un nombre y una "llave" segun la cual sera ubicada en el arbol B
 * 
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez 
 */
public abstract class Dato
{
    /**
     * Nombre del dato
     */
    protected String nombre;
    /**
     * LLave segun la cual sera ubicado en el arbol B
     */
    protected int llave;
    /**
     * Constructor de la clase Dato, que recibe el nombre y basado en este genera una "llave" que determinara 
     * su ubicacion en el arbol B
     * @param nombre Nombre del fichero/archivo a crear
     */
    public Dato(String nombre){
        this.nombre=nombre;  
        for(int i =0;i<nombre.length();i++){
            llave+=llave+nombre.charAt(i);
        }
        llave*=nombre.charAt(0);           
    }
    
    /**
     * Metodo que retorna el nombre del dato
     * @return Nombre del dato
     */
    abstract public String getNombre();
    
}
