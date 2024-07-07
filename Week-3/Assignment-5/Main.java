import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(nums, target);

        if (result.length == 2) {
            System.out.printf("[%d, %d]%n", result[0], result[1]);
        } else {
            System.out.println("No valid pair found.");
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
    	// Create a HashMap to store the numbers and indices.
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if the complement is already in the HashMap.
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            // Add the number and its index to the HashMap if it's not in the HashMap.
            numMap.put(nums[i], i);
        }
        return new int[0]; // No solution found
    }
}