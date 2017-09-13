
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Taller8 {

    public static void main(String[] args) {
//       Stack <Integer> pila=new Stack();
//       pila.push(1);
//       pila.push(2);
//       pila.push(3);
//       pila=invertir(pila);
//      
//       Queue <String> cola=new LinkedList<String>();
//       cola.add("Juancho");
//       cola.add("Marío");
//       cola.add("Pedrito");
//       
//       atender(cola);

//        proceso("3 10 5 + *");
      
        
        procesoRecursivo("3 10 5 + *",0);
    }

    public static Stack invertir(Stack s) {
        Stack<Integer> a = new Stack();
        while (!s.isEmpty()) {
            System.out.println();
            a.push((int) s.pop());
        }
        return a;
    }

    public static void atender(Queue q) {
        while (!q.isEmpty()) {
            System.out.println("Atendiendo a: " + q.remove());
        }
    }

    public static void proceso(String s) {
        Stack<Integer> stack = new Stack();
        String a[] = s.split(" ");
        for (int i = 0; i < a.length; i++) {
            if (!(a[i].equals("+") || a[i].equals("*") || a[i].equals("/") || a[i].equals("-"))) {
                stack.push(Integer.parseInt(a[i]));
            } else {
                int aux = stack.pop();
                int aux2 = stack.pop();
                switch (a[i]) {
                    case "+":
                        stack.push(aux + aux2);
                        break;
                    case "-":
                        stack.push(aux - aux2);
                        break;
                    case "*":
                        stack.push(aux * aux2);
                        break;
                    case "/":
                        stack.push(aux / aux2);
                        break;

                }
            }
        }
        System.out.println(stack.pop());
    }
    
    public static void procesoRecursivo(String a, int i){
        if(i!=a.length()){
            
            if (a.charAt(i)=='+'||a.charAt(i)=='*') {
                 int aux1=(int)(a.charAt(i-2));
                  int aux2= (int)(a.charAt(i-1));
int acu;
                switch (a.charAt(i)) {
                   
                    case '+':
                        acu=aux1+aux2;
                        a= a.substring(0,i-2)+acu+a.substring(i+1);
                        procesoRecursivo(a,i+1);
                        break;
                    case '*':
                        acu=aux1*aux2;
                        a= a.substring(0,i-2)+acu+a.substring(i+1);
                        procesoRecursivo(a,i+1);
                        break;
                   

                }
                
            }else{
                procesoRecursivo(a,i+1);
            }
        }else{
            System.out.println(a);
        }
//        return Integer.parseInt(a[i]);
    }
}
