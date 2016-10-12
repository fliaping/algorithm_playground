c class Solution {
    public String countAndSay(int n) {
        if(n==0) return "";
        if(n==1) return "1";
        String s = "1";
        for(int i=2;i<=n;i++){
            StringBuilder newS = new StringBuilder();
            for(int j=0;j<s.length();j++){
                char aChar = s.charAt(j);
                int count = 1;
                while((++j)<s.length() && s.charAt(j) == aChar){
                    count++;
                    //System.out.println("j:"+j);
                }
                j--;
                //System.out.println("count:"+count+"aChar:"+aChar);
                newS.append(count);
                newS.append(aChar);
                
            }
            s = newS.toString();
        }
        return s;
    }
}
