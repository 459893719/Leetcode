/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
    //注意自定义排序的写法
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        int i=0,j=1;
        while(j<intervals.size()){
            Interval inter1=intervals.get(i);
            Interval inter2=intervals.get(j);
            if(inter2.start<=inter1.end){
                intervals.set(i,new Interval(inter1.start, Math.max(inter1.end, inter2.end)));
                intervals.remove(j);
            }
            else{
                i=j;j++;   
            }
        }
        return intervals;
    }
}