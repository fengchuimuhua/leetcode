import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangrunfeng on 2019-04-25
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int idx = 0; idx < nums.length; idx++) {
            if (!numMap.containsKey(nums[idx])) {
                numMap.put(nums[idx], idx);
            }
        }

        int[] res = new int[2];
        for (int idx = 0; idx < nums.length; idx++) {
            if (numMap.containsKey(target - nums[idx])
                    && (numMap.get(target - nums[idx]) != idx)) {
                res[0] = idx;
                res[1] = numMap.get(target - nums[idx]);
            }
        }

        return res;
    }
}