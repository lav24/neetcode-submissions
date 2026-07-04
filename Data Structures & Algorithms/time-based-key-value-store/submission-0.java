class TimeMap {

    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key ,k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
       List<Pair<Integer, String>> values =  map.getOrDefault(key, new ArrayList<>());
       int left = 0; int right = values.size() -1;
       String result = "";
       while(left <= right){
           int mid = (left + right) /2 ;
           if(values.get(mid).getKey() <= timestamp){
               result = values.get(mid).getVal();
               left = mid +1;
           }else{
               right = mid - 1;
           }
       }
       return result;
    }

    private static class Pair<K,V>{
        private final K key;
        private final V val;
        
        public Pair(K key, V val){
            this.key = key;
            this.val = val;
        }

        public K getKey(){
            return this.key;
        }

        public V getVal(){
            return this.val;
        }
    }
}
