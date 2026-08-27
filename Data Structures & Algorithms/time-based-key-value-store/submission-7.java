class TimeMap {

    Map<String,ArrayList<ValTimeStamp>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<String,ArrayList<ValTimeStamp>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<ValTimeStamp>());
        }

        timeMap.get(key).add(
            new ValTimeStamp(value, timestamp)
        );
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)){
            return "";
        }
        ArrayList<ValTimeStamp> myArrList = timeMap.get(key);
        int l=0;
        int r=myArrList.size()-1;
        int m = 0;
        while(l<=r){
            m =(l+r)/2;
            if (myArrList.get(m).timestamp <= timestamp) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r == -1 ? "" : myArrList.get(r).value;

    }
}
class ValTimeStamp{
    String value;
    int timestamp;

    ValTimeStamp(String value,int timestamp){
        this.value=value;
        this.timestamp=timestamp;
    }
}
