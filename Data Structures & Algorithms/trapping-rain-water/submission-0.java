class Solution {
    public int trap(int[] height) {
        int sum =0;
        for(int i=0;i<height.length;i++){
            int heightToLeft = 0;
            for(int j=0;j<i;j++){
                heightToLeft = Math.max(heightToLeft, height[j]);
            }
            int heightToRight = 0;
            for(int j=i+1;j< height.length;j++){
                 heightToRight = Math.max(heightToRight, height[j]);
            }
            System.out.println(i + " - " + heightToLeft + " - " + heightToRight + "-- "+ (Math.min(heightToLeft , heightToRight) - height[i]));
            int s1 = (Math.min(heightToLeft , heightToRight) - height[i]);
            if(s1 > 0){
              sum += Math.min(heightToLeft , heightToRight) - height[i];
            }
        }
        return sum;
    }
}
