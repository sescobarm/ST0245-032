
/**
 * Solución a los ejercicios en línea del laboratorio 2 de Estructuras de datos y algoritmos 1
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez ( Codigo base: Mauricio Toro)  
 * @version 12/09/2017
 */
public class EjerciciosLinea
{
    
    // Array2 
    
  /**
   * Return the number of even ints in the given array. 
   * Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
   */  
    public int countEvens(int[] nums) {
      int cont=0;
      for(int i=0;i<nums.length;i++){
        if(nums[i]%2==0){
        cont++;
       }    
     }
    return cont;
  }
  
  
  /**
   * Given an array length 1 or more of ints, return the difference 
   * between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) 
   * and Math.max(v1, v2) methods return the smaller or larger of two values.
   */
    public int bigDiff(int[] nums) {
    int min=9999;
    int max=0;
     for(int i=0;i<nums.length;i++){
      max=Math.max(max,nums[i]);
      min=Math.min(min,nums[i]);
     }
    return max-min;  
  }
  
  /**
   * Return the sum of the numbers in the array, returning 0 for an empty array. 
   * Except the number 13 is very unlucky, so it does not count and numbers that come
   * immediately after a 13 also do not count.
   */
   public int sum13(int[] nums) {
    int sum=0;
    for(int i=0;i<nums.length;i++){
      if(nums[i]!=13){
          sum+= nums[i];
        }else{
            i++;
        }
    }
    return sum;
  }

  /**
   * Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
   */
    public boolean has22(int[] nums) {
    for(int i=0;i<nums.length-1;i++){
      if(nums[i]==2&&nums[i+1]==2){
        return true;
      }
    }
    return false;
  }
  
  
  /**
   * Given a number n, create and return a new int array of length n,
   * containing the numbers 0, 1, 2, ... n-1. The given n may be 0, 
   * in which case just return a length 0 array. You do not need a separate 
   * if-statement for the length-0 case; the for-loop should naturally execute 
   * 0 times in that case,so it just works. The syntax to make a new int array 
   * is: new int[desired_length] 
   */
    public int[] fizzArray(int n) {
     int a[]=new int[n];
     for(int i=0;i<n;i++){
       a[i]=i;
    }
    return a;
  }
  
  //Array3
  
  /**
   * Consider the leftmost and righmost appearances of some value in an array.
   * We'll say that the "span" is the number of elements between the two inclusive. 
   * A single value has a span of 1. Returns the largest span found in the given array.
   * (Efficiency is not a priority.)
   */
   public int maxSpan(int[] nums) {
     if (nums.length > 0) {
        int maxSpan = 1;
        for (int i = 0; i < nums.length; i++)
            for (int j = nums.length - 1; j > i; j--)
                if (nums[j] == nums[i]) {
                    int count = (j - i) + 1;
                    if (count > maxSpan){
                        maxSpan = count;
                    }
                    break;
                }
        return maxSpan;
     } else {
        return 0;
     }
  }
  
  
  /**
   * Return an array that contains exactly the same numbers as the given array, 
   * but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's,
   * but every other number may move. The array contains the same number of 3's and 4's,
   * every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
   */
  public int[] fix34(int[] nums) {
   int pos4=0;
   for(int i=0;i<nums.length-1;i++){
       if(nums[i]==3){
         for(int j=pos4;j<nums.length;j++){
           if(nums[j]==4){
             pos4=j;
             nums[j]= nums[i+1];
             nums[i+1]=4;
             break;
           }
        }
      }
   }
   return nums;
 }
 
 
 /**
  * Given a non-empty array, return true if there is a place to split the array so that the
  * sum of the numbers on one side is equal to the sum of the numbers on the other side.
  */
   public boolean canBalance(int[] nums) {
     for (int i = 0; i < nums.length; i++) { 
        int sumatoria = 0;
        for (int j = 0; j < i; j++) {
          sumatoria += nums[j];
        }
        for (int e = i; e < nums.length; e++){
          sumatoria -= nums[e];
        } 
        if (sumatoria == 0) {
        return true;
        }
     }
     return false;
  }
  
  
  /**
   * Given n>=0, create an array length n*n with the following pattern, shown here for n=3 :
   * {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
   */
  public int[] squareUp(int n) {
    int a[]=new int[n*n];
     int pos=a.length-1-n;
     int cont=n;
     for(int i=a.length-1;i>=0;i-=n){
       int ii=i;
      for(int j=1;j<=cont;j++){
        a[ii]=j;
        ii--;
      }
      cont--;
    }
    return a;
 }
 
 /**
 * Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value.
 * Return the number of clumps in the given array.
 */ 
   public int countClumps(int[] nums) {
    int rep=-1;
    int cont=0;
    for(int i=0; i<nums.length-1;i++){
      if(nums[i]==nums[i+1]&&nums[i]!=rep){
        rep=nums[i];
        cont++;
       }else if(nums[i]!=rep){
         rep=0;
      }
    }
    return cont;
  }





  
  




}
