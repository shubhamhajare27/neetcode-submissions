class Solution {

    private int key=1;
    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
       for(int i=0;i<strs.size();i++){
        sb.append(strs.get(i).length());
        sb.append("#");
        sb.append(strs.get(i));
       }
       return sb.toString();
    }

    public List<String> decode(String str) {
       
        List<String> mainStr = new ArrayList<String>();

        for(int i=0;i<str.length();){
            int start=i;
            while(str.charAt(i)!='#'){
                i++;
            }
            int len = Integer.parseInt(str.substring(start,i));
            int j=len+i+1;
            String subStr=str.substring(i+1,j);
            mainStr.add(subStr);
            i=j;
        }
        return mainStr;
    }
}   

