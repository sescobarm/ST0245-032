
 

import java.util.Scanner;
import java.util.Stack;


public class Bloques {

  static Stack arreglo[]=new Stack[25]; 
  
 
    public static void moveAontoB( int a , int b){
        int lugarA=0;
      for (int i = 0; i < 25; i++) {
          if(arreglo[i].search(a)!= -1){
            lugarA= i;
            break;
          }
      } 
      int lugarB=0;
      for (int i = 0; i < 25; i++) {
          if (arreglo[i].search(b) != -1) {
            lugarB= i;
            break;
          }
      }
      while((int)(arreglo[lugarA].lastElement())!=a){
          arreglo[(int)arreglo[lugarA].lastElement()].add(arreglo[lugarA].pop());
      }
      while((int)(arreglo[lugarB].lastElement())!=b){
          arreglo[(int)arreglo[lugarB].lastElement()].add(arreglo[lugarB].pop());
      }
       arreglo[lugarB].add(arreglo[lugarA].pop());
    }
    
    
     public static void moveAoverB( int a , int b ){
        int lugarA=0;
      for (int i = 0; i < 25; i++) {
          if(arreglo[i].search(a)!= -1){
            lugarA= i;
            break;
          }
      } 
      int lugarB=0;
      for (int i = 0; i < 25; i++) {
          if (arreglo[i].search(b) != -1) {
            lugarB= i;
            break;
          }
      }
      while((int)(arreglo[lugarA].lastElement())!=a){
          arreglo[(int)arreglo[lugarA].lastElement()].add(arreglo[lugarA].pop());
      }
       arreglo[lugarB].add(arreglo[lugarA].pop());
    }
  
      public static void pileAontoB( int a , int b ){
        int lugarA=0;
        Stack<Integer> aux=new Stack();
      for (int i = 0; i < 25; i++) {
          if(arreglo[i].search(a)!= -1){
            lugarA= i;
            break;
          }
      } 
      int lugarB=0;
      for (int i = 0; i < 25; i++) {
          if (arreglo[i].search(b) != -1) {
            lugarB= i;
            break;
          }
      }
     
      while((int)(arreglo[lugarB].lastElement())!=b){
          arreglo[(int)arreglo[lugarB].lastElement()].add(arreglo[lugarB].pop());
      }
      while((int)(arreglo[lugarA].lastElement())!=a){
       aux.add((int)arreglo[lugarA].pop());
      }
     aux.add((int)arreglo[lugarA].pop());
     while(!aux.empty()){
       arreglo[lugarB].add((int)aux.pop());
      }
    }
     
      public static void pileAoverB( int a , int b ){
        int lugarA=0;
        Stack<Integer> aux=new Stack();
      for (int i = 0; i < 25; i++) {
          if(arreglo[i].search(a)!= -1){
            lugarA= i;
            break;
          }
      } 
      int lugarB=0;
      for (int i = 0; i < 25; i++) {
          if (arreglo[i].search(b) != -1) {
            lugarB= i;
            break;
          }
      }
      while((int)(arreglo[lugarA].lastElement())!=a){
       aux.add((int)arreglo[lugarA].pop());
      }
     aux.add((int)arreglo[lugarA].pop());
     
     while(!aux.empty()){
       arreglo[lugarB].add((int)aux.pop());
      }
    }
     
     public static void imprimirBloques(){
         for (int i = 0; i < arreglo.length ; i++) {
               System.out.println(i+": "+stackImp(i));
                if (arreglo[i+1]==null) {
                    break;
                }
         }
     }
  
     public static String stackImp(int a){
         String m="";
         Stack<Integer> aux=new Stack();
         while(!arreglo[a].empty()){
            aux.add((int)arreglo[a].pop());
         }
         while(!aux.isEmpty()){
           m=m+aux.pop();
         }
         return m;
     }
    
     
     
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int numeroS= sc.nextInt();
        for (int i = 0; i < numeroS; i++) {
            Stack<Integer> p=new Stack();
            p.add(i);
            arreglo[i]=p;
        }
        Scanner p = new Scanner(System.in);
       String fin= p.nextLine();
       
        while(!"quit".equals(fin)){
           String[] finp=fin.split(" ");
           int a=Integer.parseInt(finp[1]);
           int b=Integer.parseInt(finp[3]);
            if ("move".equals(finp[0])&&"onto".equals(finp[2])) {
                moveAontoB(a,b);
            }else if ("move".equals(finp[0])&&"over".equals(finp[2])) {
                moveAoverB(a,b);
            }else if ("pile".equals(finp[0])&&"over".equals(finp[2])) {
                pileAoverB(a,b);
            }else if ("pile".equals(finp[0])&&"onto".equals(finp[2])) {
                pileAontoB(a,b);
            }
            fin= p.nextLine();
        }
        imprimirBloques();
    }
    
}
