

/**
 * Solucion a los ejericios de Recursion 1 de codingbat 
 * @author Santiago Escobar , Sebastian Giraldo y Luisa Maria Vasquez
 *  @version 03/09/2017
 */
public class Recursion1 {
    
   /**
    * 
    * We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, 
    * the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) 
    * the total number of blocks in such a triangle with the given number of rows
    */
    public int triangle(int rows) {
        if (rows == 0) {
            return 0;
        } else {
            return rows + triangle(rows - 1);
        }
    }

    /**
     * Given a string, compute recursively a new string where all the 'x' chars have been removed.
     */
    public String noX(String str) {
        if (str.length() == 0) {
            return "";
        } else {
            if (str.charAt(0) == 'x') {
                return noX(str.substring(1));
            } else {
                return str.charAt(0) + "" + noX(str.substring(1));
            }
        }

    }
    
    
    /**
     * Given base and n that are both 1 or more, compute recursively (no loops) 
     * the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
     */
    public int powerN(int base, int n) {
        if (n == 0) {
            return 1;
        } else {
            return base * powerN(base, n - 1);
        }
    }
    
    /**
     * Given a string, compute recursively (no loops) a new string where 
     * all appearances of "pi" have been replaced by "3.14".
     */
    public String changePi(String str) {
        if (str.length() == 0) {
            return "";
        } else if (str.length() == 1) {
            return str.charAt(0) + "";
        } else {
            if ((str.charAt(0) + "" + str.charAt(1)).equals("pi")) {
                return "3.14" + changePi(str.substring(2));
            } else {
                return str.charAt(0) + changePi(str.substring(1));
            }
        }
    }
     
    
    /**
     * Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
     */
    public int countHi(String str) {
        if (str.length() == 1 || str.length() == 0) {
            return 0;
        } else {
            if ((str.charAt(0) + "" + str.charAt(1)).equals("hi")) {
                return 1 + countHi(str.substring(1));
            } else {
                return 0 + countHi(str.substring(1));
            }
        }
    }

}

