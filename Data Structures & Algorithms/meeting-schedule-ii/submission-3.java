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
        for(int i=0;i<n;i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        int max = 0;
        int c = 0;
        while(i<n && j<n){
            if(start[i] < end[j]){
                c++;
                max = Math.max(max, c);
                i++;
            }else if(start[i] >= end[j]){
                c--;
                j++;
            }
        }
        return max;
    }
}
