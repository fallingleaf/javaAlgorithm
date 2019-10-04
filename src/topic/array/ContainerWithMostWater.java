package array;


// https://leetcode.com/submissions/detail/153079184/
// Give array of height find container with most water
// check left and right height, water = (right - left) * min(left_height, right_height)
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
    	if (height == null || height.length < 2) {
    		return 0;
    	}

    	int max = 0;
    	int left = 0;
    	int right = height.length - 1;

    	while (left < right) {
    		max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
    		if (height[left] < height[right])
    			left++;
    		else
    			right--;
    	}

    	return max;
    }
}
