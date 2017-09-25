
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Sebastián Giraldo Gómez- Luisa María Vásquez Gómez - Santiago Escobar Mejía
 */
public class Punto1 {
/**
 * Este método recibe un Stack con las neveras disponibles, y un Queue con las solicitudes,
 * el método asigna a cada solicitud la cantidad de neveras que necesita, con su respectiva
 * marca y código, si no hay existencias no asigna más neveras.
 * En cada línea se imprime solicitante, cantidad y las neveras con su código.
 * @param neveras Neveras disponibles
 * @param solicitudes Solicitudes
 */
    public static void ejercicio4(Stack<String[]> neveras, Queue<String[]> solicitudes) {

        while (!solicitudes.isEmpty()) {
            String s[] = solicitudes.poll();
            int c = Integer.parseInt(s[1]);
            System.out.print("(" + s[0] + ", [");
            for (int i = 0; i < c && !neveras.isEmpty(); i++) {
                String a[] = neveras.pop();
                System.out.print("(" + a[0] + ", " + a[1] + "), ");
            }
            System.out.println("])");

        }

    }
/**
 * Este método recibe una lista de enteros, y con un ciclo guarda la 
 * multiplicación de sus elementos en una variable y posteriormente
 * la retorna
 * @param list Lista de enteros a multiplicar
 * @return multipliación de elementos
 */
    public static int multiply(List<Integer> list) {
        int mult = 1;
        for (int i = 0; i < list.size(); i++) {
            mult *= list.get(i);
        }
        return mult;
    }
/**
 * El método recibe una lista de enteros, y con un ciclo evalúa
 * si el entero a agregar existe, en caso de que exista no se agrega
 * y por el contrario si no existe se agrega al final.
 * @param l Lista de enteros a la cual sera agregado data
 * @param data Entero a agregar
 */
    public static void smartInsert(List<Integer> l, int data) {
        boolean c = true;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == data) {
                c = false;
                break;
            }
        }
        if (c) {
            l.add(data);
        }
    }
/**
 * Este método recibe una lista de enteros, con un ciclo evalúa posición
 * por posición la diferencia entre la suma de los elementos de la izquierda
 * y de la derecha, en cada recorrido escoge guarda la menor diferencia y la 
 * posición donde se dió el pivote óptimo, y en cada recorrido evalúa y escoge
 * el mejor pivote.
 * @param list Lista a ser evaluada
 * @return La posición del pivote óptimo
 */
    public static int pivote(List<Integer> list) {
        int pos = -1;
        int dif = 999999999;
        for (int i = 0; i < list.size(); i++) {    //n
            int c1 = 0;
            int c2 = 0;
            for (int j = 0; j < i; j++) {   //n^2
                c1 += list.get(j);
            }
            for (int j = i + 1; j < list.size(); j++) {//n^2
                c2 += list.get(j);
            }
            int dif2 = Math.abs(c1 - c2);
            if (dif2 < dif) {
                dif = dif2;
                pos = i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[]{1, 3, 5, 7}));

        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[]{2, 4, 6, 8}));

        // Multiply
        System.out.println(multiply(linked));
        System.out.println(multiply(array));

        //SmartInsert
        smartInsert(linked, 2);
        smartInsert(array, 2);

        //pivote
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(new Integer[]{10, 2, 4, 8}));
        System.out.println(pivote(a));

        //Ejercicio4
        String[] neveras = {"1", "haceb", "2", "lg", "3", "ibm", "4", "haceb", "5", "lg", "6",
            "ibm", "7", "haceb", "8", "lg", "9", "ibm", "8", "lg", "9", "ibm"};
        Stack<String[]> n = new Stack();
        for (int i = 0; i < neveras.length; i += 2) {
            String[] c = {neveras[i], neveras[i + 1]};
            n.push(c);
        }
        String[] soli = {"eafit", "10", "la14", "2", "olimpica", "4", "éxito", "1"};
        Queue<String[]> nn = new LinkedList();
        for (int i = soli.length - 1; i >= 0; i -= 2) {
            String[] c = {soli[i - 1], soli[i]};
            nn.add(c);
        }
        ejercicio4(n, nn);
    }
}
