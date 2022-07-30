public class Leetcode5 {
    public String LongestPalindromic(String s){
        int n=s.length();
        int palindromicBeg=0;
        int max=1;
        Boolean[][] dp = new Boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
           // max=1;
        }
        for (int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1]=true;
                palindromicBeg=i;
                max=2;
            }
        }
        for (int cur=3;cur<=n;cur++){
            for (int i=cur;i<n-cur+1;i++){
                int j=i+cur-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    palindromicBeg=i;
                    max=cur;
                }
            }

        }
        return s.substring(palindromicBeg,max+palindromicBeg);
    }

    public static void main(String[] args) {
       // String text="babad";
        Leetcode5 leetcode5 = new Leetcode5();
        System.out.println(leetcode5.LongestPalindromic("babad"));
    }
}
