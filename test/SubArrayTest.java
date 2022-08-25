
import static org.junit.Assert.*;
import org.junit.Test;



public class SubArrayTest {

       // basic testing. See if the right answer is return in main cases and test cases
        MonotonicSubArray monotonicSubArray = new MonotonicSubArray();
        int[] nums;

        // TYPICAL CASE
        @Test
   public void testSubArrayNonEdgeCase(){
         nums = new int[]{3,4,5,6,1,2,5,6,7,33,100,3};
        assertEquals(7,monotonicSubArray.lengthOfMonotonicSub(nums));
    }

    // CASE WHERE THERE ARE NO MONOTONIC SUBARRAYS, 1 SHOULD BE RETURNED
    @Test
    public void testSubArrayNoMonotonicSubArray(){
         nums = new int[]{10000,9000,8000,7000,4000};
        assertEquals(1,monotonicSubArray.lengthOfMonotonicSub(nums));
    }

    // CASE WHERE THERE IS NULL
    @Test
    public void testForNull(){
         nums= null;
        assertEquals(0,monotonicSubArray.lengthOfMonotonicSub(nums));

    }

    // CASE WHERE THERE IS THE EMPTY ARRAY
    @Test
    public void testForEmpty(){
        nums= new int[]{};
        assertEquals(0,monotonicSubArray.lengthOfMonotonicSub(nums));

    }



}

