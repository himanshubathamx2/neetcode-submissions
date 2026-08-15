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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (m1, m2)-> m1.end - m2.end);
        int free = 0;
        for(Interval i : intervals){
            if(free <= i.start){
                free = i.end;
            }else
                return false;
        }
        return true;
    }
}
