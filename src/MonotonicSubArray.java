
import java.util.*;

// This was modeled off of a NC150 problem involving Dynamic 1D Programming
public class MonotonicSubArray
{
    public static int lengthOfMonotonicSub(int[] nums) {
       // ultimate base case
        int answer = 0;
        if (nums == null || nums.length ==0){
            return answer;
        }

        // create name for array, I know. It's the DynamicProgramming array
        int[] dp = new int[nums.length];
        // It is tautology that every number in the array is a subsequence
        Arrays.fill(dp,1);

        // going in a two point fashion, we are testing the requisite evaluation
        // Algorithm is Quadratic, with linear auxillary space (The DP array)
        for(int i= 0; i < nums.length; i++){
            for(int j=0; j<i; j++){
                // the definition of monotonic for a given subproblem
                if(nums[i] > nums[j]){
                    // we just look to see if the newly calculated value is higher
                    // for the succeeding sub problem. "How long of a run are we at this point?"
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // making sure the last value is evaluate (it might be the biggest!)
            answer = Math.max(dp[i], answer);
        }
        // return the answer
        return answer;
    }
}
