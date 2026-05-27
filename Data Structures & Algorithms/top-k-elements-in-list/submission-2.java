class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> noFreq = new HashMap<>();
        for(int i : nums){
             noFreq.put(i, noFreq.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(noFreq.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());
        int[] result= new int[k];
        for(int i=0;i<k;i++){
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}
