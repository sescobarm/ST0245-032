
/**
 * Solucion de los ejercicios de Recursion 2 de codingbat
 * @author Santiago Escobar , Sebastian Giraldo y Luisa Maria Vasquez
 * @version 03/09/2017
 */
public class Recursion2 {
    
   /**
    * Given an array of ints, is it possible to choose a group of some of the ints,
    * such that the group sums to the given target with this additional constraint: 
    * If a value in the array is chosen to be in the group,the value immediately 
    * following it in the array must not be chosen. (No loops needed.)
    */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        } else {
            return groupNoAdj(start + 1, nums, target) || groupNoAdj(start + 2, nums, target - nums[start]);
        }
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, 
     * such that the group sums to the given target with these additional constraints: 
     * all multiples of 5 in the array must be included in the group.If the value immediately
     * following a multiple of 5 is 1, it must not be chosen. (No loops needed.)
     */
    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        } else {
            if (nums[start] % 5 == 0) {
                if (start + 1 < nums.length && nums[start + 1] == 1) {
                    return groupSum5(start + 2, nums, target - nums[start]);
                } else {
                    return groupSum5(start + 1, nums, target - nums[start]);
                }
            } else {
                return groupSum5(start + 1, nums, target) || groupSum5(start + 1, nums, target - nums[start]);
            }
        }
    }

    /**
     * Given an array of ints, is it possible to divide the ints into two groups, 
     * so that the sums of the two groups are the same. Every int must be in one group or the other. 
     * Write a recursive helper method that takes whatever arguments you like, and make the initial 
     * call to your recursive helper from splitArray(). (No loops needed.)
     */
    public boolean splitArray(int[] nums) {
        return aiuda(0, nums, 0, 0);
    }

    private boolean aiuda(int ini, int a[], int sum1, int sum2) {
        if (ini >= a.length) {
            return sum1 == sum2;
        } else {
            return aiuda(ini + 1, a, sum1 + a[ini], sum2) || aiuda(ini + 1, a, sum1, sum2 + a[ini]);
        }
    }

    /**
     * Given an array of ints, is it possible to divide the ints into two groups, 
     * so that the sum of one group is a multiple of 10, and the sum of the other group is odd.
     * Every int must be in one group or the other. Write a recursive helper method that takes
     * whatever arguments you like, and make the initial call to your recursive helper from splitOdd10(). 
     * (No loops needed.)
     */
    public boolean splitOdd10(int[] nums) {
        return aiuda2(0, nums, 0, 0);
    }

    private boolean aiuda2(int ini, int a[], int sum1, int sum2) {
        if (ini >= a.length) {
            return sum1 % 10 == 0 && sum2 % 2 != 0;
        } else {
            return aiuda(ini + 1, a, sum1 + a[ini], sum2) || aiuda(ini + 1, a, sum1, sum2 + a[ini]);
        }
    }
 
    /**
     * Given an array of ints, is it possible to divide the ints into two groups, 
     * so that the sum of the two groups is the same, with these constraints: all the values that 
     * are multiple of 5 must be in one group, and all the values that are a multiple of 3 
     * (and not a multiple of 5) must be in the other. (No loops needed.)
     */
    public boolean split53(int[] nums) {
        return aiuda3(0, nums, 0, 0);
    }

    private boolean aiuda3(int ini, int a[], int sum1, int sum2) {
        if (ini >= a.length) {
            return sum1 == sum2;
        } else {
            if (a[ini] % 3 == 0) {
                return aiuda(ini + 1, a, sum1 + a[ini], sum2);
            } else if (a[ini] % 5 == 0) {
                return aiuda(ini + 1, a, sum1, sum2 + a[ini]);
            } else {
                return aiuda(ini + 1, a, sum1 + a[ini], sum2) || aiuda(ini + 1, a, sum1, sum2 + a[ini]);
            }
        }
    }

}