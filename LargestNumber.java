class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(compare(nums[i],nums[j])){
                    nums[i]=nums[i]^nums[j];
                    nums[j]=nums[i]^nums[j];
                    nums[i]=nums[i]^nums[j];
                }
            }
        }
        if(nums[n-1]==0) return "0";
        StringBuilder sb= new StringBuilder();
        for(int i=n-1;i>=0;i--) sb.append(nums[i]);
        return sb.toString();
    }

    boolean compare(int a, int b){
        String A=""+a+b, B=""+b+a;
        return A.compareTo(B)>0;
    } 
}