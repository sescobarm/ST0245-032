
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solucion al punto 1.3 del laboratorio 4 
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez
 */
public class Punto1_3 {
 
    /**
     * Metodo que prueba el metodo "simular banco"
     */
    public static void main(String[] args) {
        Queue<String> f1 = new LinkedList<>();
        f1.offer("f1-1");
        Queue<String> f2 = new LinkedList<>();
        f2.offer("f2-1");
        f2.offer("f2-2");
        Queue<String> f3 = new LinkedList<>();
        f3.offer("f3-1");
        f3.offer("f3-2");
        f3.offer("f3-3");
        Queue<String> f4 = new LinkedList<>();
        f4.offer("f4-1");
        f4.offer("f4-2");
        f4.offer("f4-3");
        f4.offer("f4-4");

        simularBanco(f1, f2, f3, f4);
    }
    
    /**
     * Metodo que simula como son atendidos los clientes en un banco por los cajeros  
     * @param fila1 Cola que representa la fila 1 
     * @param fila2 Cola que representa la fila 2 
     * @param fila3 Cola que representa la fila 3 
     * @param fila4 Cola que representa la fila 4 
     */
    public static void simularBanco(Queue fila1, Queue fila2, Queue fila3, Queue fila4) {
       
        ArrayList<Queue> filas=new ArrayList<>();
        filas.add(fila1);
        filas.add(fila2);
        filas.add(fila3);
        filas.add(fila4);
        int f=0;
        int c=1;
        while(!(filas.get(0).isEmpty()&&filas.get(1).isEmpty()&&filas.get(2).isEmpty()&&filas.get(3).isEmpty())){
            if(!filas.get(f).isEmpty()){
                System.out.println("Cajero "+c+" atentiendo a "+filas.get(f).poll());
                if(c==1)c=2;
                else if(c==2) c=1;
            }
            if(f==0)f=1;
            else if(f==1)f=2;
            else if(f==2)f=3;
            else if(f==3)f=0;
            
        }
    }
}
