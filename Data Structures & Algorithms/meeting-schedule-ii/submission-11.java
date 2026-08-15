/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        int i=0;
        for(Interval inter : intervals){
            start[i] = inter.start;
            end[i] = inter.end;
            i++;
        }   
        Arrays.sort(start);
        Arrays.sort(end);
        int c = 0;
        int max = 0;
        i=0;
        int j=0;
        while(i < n && j < n){
            if(start[i] < end[j]){
                c++;
                max = Math.max(max, c);
                i++;
            }else{
                j++;
                c--;
            }
        }
        return max;
    }
}
