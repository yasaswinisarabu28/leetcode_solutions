class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        
        for (int key : map.keySet()) {
            int freq = map.get(key);
            bucket[freq].add(key);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            for (int num : bucket[i]) {
                result.add(num);
            }
        }
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}