

import java.util.Arrays;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * Solucion al ejercicio 1.1 del laboratorio 2 de Estructuras de datos y algoritmos 1
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez ( Codigo base: Mauricio Toro)  
 * @version 12/09/2017
 */
public class Laboratory2
{      
     
      /**
     * M�todo que suma todos los elementos de un arreglo recursivamente
     * @param A El par�metro A es el arreglo cuyos elementos ser�n sumados 
     * @param n El par�metro n es el �ndice del elemento que ser� sumado  
     * @return La suma total de los elementos del arreglo
     */
    public static int ArraySum(int[] A, int n){          
        int sum;

        if(A.length==0){
            return sum=0;
        }
        if (n == 0){
            sum = A[0];
        }else{ 
            sum = A[n] + ArraySum(A,n-1);
        }
      
        return sum;
    }
    
    
    /**
     * M�todo que busca el elemento m�s grande del arreglo recursivamente
     * @param A El par�metro A es el arreglo en el cual se buscar� el elemento mayor 
     * @param n El par�metro n es el �ndice del elemento que se est� analizando  
     * @return El elemento m�s grande del arreglo
     */
    public static int ArrayMax(int[] A, int n){
        int max;
        if(A.length==0){
            return max=0;
        }
        if (n == 0){
            max = A[0];
        }else{
            max = Math.max(A[n],ArrayMax(A, n-1));
        }
        return max;
    }
    
    /**
     * M�todo que ordena los elementos de un arreglo de menor a mayor cambiando posiciones en el mismo arreglo
     * @param A El par�metro A es el arreglo cuyos elementos ser�n ordenados   
     */
     public static void InsertionSort(int[] A){
       int temp,j;
       for (int i = 0; i < A.length; i++){
         j = i;
         while (j > 0 && A[j-1] > A[j]){
               temp = A[j];
               A[j] = A[j-1];
               A[j-1] = temp;
               j = j-1;
         }           
       }
       System.out.println(Arrays.toString(A));
    }
    
    
  
    /**
     * M�todo que ordena los elementos de un arreglo de menor a mayor dividi�ndolo en mitades recursivamente
     * @param A El par�metro A es el arreglo cuyos elementos ser�n ordenados   
     * @param izq El par�metro izq es la posicion m�s a la izquierda del subconjunto con el que te trabaja
     * @param der El par�metro der es la posicion m�s a la derecha del subconjunto con el que te trabaja
     */
    public static void mergesort(int A[],int izq, int der){
       if (izq<der){
            int m=(izq+der)/2;
            mergesort(A,izq, m);
            mergesort(A,m+1, der);
            merge(A,izq, m, der);
       }
    }
    
    
     /**
     * M�todo que ordena y junta los subconjuntos tomados en el m�todo mergesort
     * @param A El par�metro A es el arreglo cuyos elementos ser�n ordenados   
     * @param izq El par�metro izq es la posicion m�s a la izquierda del subconjunto con el que te trabaja
     * @param m El par�metro m es la posicion del medio  del subconjunto con el que te trabaja
     * @param der El par�metro der es la posicion m�s a la derecha del subconjunto con el que te trabaja
     */
    public static void merge(int A[], int izq, int m, int der) {
        int i, j, k;
        int[] B = new int[A.length]; //array auxiliar
        for (i = izq; i <= der; i++){ //copia ambas mitades en el array auxiliar 
            B[i] = A[i];
        }
        
        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der){ //copia el siguiente elemento más grande
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m){ //copia los elementos que quedan de la primera mitad (si los hay)  
            A[k++] = B[i++]; 
        }
    }
      
    
    /**
     * M�todo que genera un arreglo aleatorio de tama�o n 
     * @param n El par�metro n es el tama�o del cual se quiere generar el arreglo 
     * @return Un arreglo con valores aleatorios de tama�o n  
     */
    public static int[] generarArregloDeTamanoN(int n){
        int max = 5000;
        int[] array = new int[n];
        Random generator = new Random();
        for (int i =0; i<n; i++){
            array[i] = generator.nextInt(max);
        }
        return array;
    }
    
     /**
     * M�todo que toma el tiempo para ArraySum
     * @param n El par�metro n es el tama�o del cual se quiere generar un arreglo aleatorio y encontrar la suma de sus elementos  
     * @return El tiempo que toma hallar la suma de los elementos del arreglo 
     */
    public static long tomarTiempoSum(int n){
        int[]a = generarArregloDeTamanoN(n);
        long startTime = System.currentTimeMillis();
        int b= ArraySum(a, a.length-1);
        long estimatedTime = System.currentTimeMillis()-startTime;
        System.out.println("ArraySum: "+b+" Tiempo: "+estimatedTime);
        return estimatedTime;
    }
    
   /**
     * M�todo que toma el tiempo para ArrayMax
     * @param n El par�metro n es el tama�o del cual se quiere generar un arreglo aleatorio y encontrar el elemento mayor  
     * @return El tiempo que toma hallar el elemento mayor del arreglo
     */
    public static long tomarTiempoMax(int n){
        int[]a = generarArregloDeTamanoN(n);
        long startTime = System.currentTimeMillis();
        int b=ArrayMax(a, a.length-1);
        long estimatedTime = System.currentTimeMillis()-startTime;
        System.out.println("ArrayMax: "+b+" Tiempo: "+estimatedTime);
       return estimatedTime;
    }
    
     /**
     * M�todo que toma el tiempo para Insertion Sort
     * @param n El par�metro n es el tama�o del cual se quiere generar un arreglo aleatorio y ordenar sus elementos de menor a mayor 
     * @return El tiempo que toma ordenar el arreglo con este m�todo
     */
    public static long tomarTiempoInsort(int n){
        int[]a = generarArregloDeTamanoN(n);
        long startTime = System.currentTimeMillis();
        InsertionSort(a);
        long estimatedTime = System.currentTimeMillis()-startTime;
        System.out.println("Insertion Sort tiempo: "+estimatedTime);
       return estimatedTime;
    }
    
     /**
     * M�todo que toma el tiempo para MergeSort
     * @param n El par�metro n es el tama�o del cual se quiere generar un arreglo aleatorio y ordenar sus elementos de menor a mayor
     * @return El tiempo que toma ordenar el arreglo generado
     */
     public static long tomarTiempoMerge(int n){
        int[]a = generarArregloDeTamanoN(n);
        long startTime = System.currentTimeMillis();
        mergesort(a,0,a.length-1);
        long estimatedTime = System.currentTimeMillis()-startTime;
        System.out.println("MergeSort tiempo: "+estimatedTime);
        return estimatedTime;
    }
    
    
    /**
     * M�todo que prueba los m�todos que toman el tiempo de ejecuci�n
     */
    public static void main(String[] args){
        int tama = 1000000;
       //tomarTiempoSum(tama);
        //tomarTiempoMax(tama);
        //tomarTiempoMerge(tama);
        tomarTiempoInsort(tama);
       
 
    } 
}

