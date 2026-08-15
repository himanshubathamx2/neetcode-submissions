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
        List<int[]> meetings = new ArrayList<>();
        for(Interval inter : intervals){
            meetings.add(new int[]{inter.start, inter.end});
        }
        Collections.sort(meetings, (a, b)->a[1] - b[1]);
        int free = 0;
        int c = 0;
        for(int[] meet : meetings){
            if(meet[0] > free){
                c++;
                free = meet[1];
            }
        }
        return c;
    }
}
