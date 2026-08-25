class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=0;
        for(int i=0;i<piles.length;i++){
            maxPile=Math.max(maxPile,piles[i]);
        }
        int l=1;
        int r=maxPile;
        int ans=maxPile;
        while(l<=r){
            long hours=0;
            int mid=(l+r)/2;
            for(int pile:piles){
                hours= hours+(pile+mid-1)/mid;
            }
            if(hours<=h){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}
