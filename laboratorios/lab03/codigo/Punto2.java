
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Punto2 {
    public static List InicioFin(String s) {
        LinkedList<Character> a = new LinkedList<>();
        int p = 0;
        boolean lugar = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                lugar=true;
                p=0;
            }else if(s.charAt(i) == ']'){
                lugar=false;
            }else if(lugar){
                a.add(p, s.charAt(i));
                p++;
            }else{
                a.add( s.charAt(i));
            }
        }
        return a;
    }
    
    public static void imprimir(List a){
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i));
        }
    }
    
    public static void main(String[] args) {
       
        //InicioFin
        Scanner sc=new Scanner(System.in);
        imprimir(InicioFin(sc.nextLine()));
    }
}
