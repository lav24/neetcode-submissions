class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> noFreq = new HashMap<>();
        for(int i : nums){
             noFreq.put(i, noFreq.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        int[] result= new int[k];
        for(Map.Entry<Integer, Integer> e : noFreq.entrySet()){
            pq.add(e);
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i=0;i<k;i++){
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
