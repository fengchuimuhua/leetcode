import java.util.*;

/**
 * Created by zhangrunfeng on 1/17/20
 */
public class MeetingRoom {
    static class Interval {
        int start;
        int end;

        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        List<Interval> intervalList = new ArrayList<>();
        for (int ix = 0; ix < intervals.length; ix++) {
            if (intervals[ix] == null || intervals[ix].length != 2) {
                continue;
            }
            intervalList.add(new Interval(intervals[ix][0], intervals[ix][1]));
        }

        intervalList.sort(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });

        boolean[] flags = new boolean[intervalList.size()];
        int count = 0;
        boolean hasNext = true;
        while (hasNext) {
            hasNext = false;
            int lastEnd = Integer.MIN_VALUE;
            for (int ix = 0; ix < intervalList.size(); ix++) {
                if (!flags[ix]) {
                    hasNext = true;
                    if (intervalList.get(ix).start >= lastEnd) {
                        flags[ix] = true;
                        lastEnd = intervalList.get(ix).end;
                    }
                }
            }
            if (hasNext) count++;
        }

        return count;
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }

        List<Interval> intervalList = new ArrayList<>();
        for (int ix = 0; ix < intervals.length; ix++) {
            if (intervals[ix] == null || intervals[ix].length != 2) {
                continue;
            }
            intervalList.add(new Interval(intervals[ix][0], intervals[ix][1]));
        }

        Collections.sort(intervalList, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (int ix = 0; ix < intervalList.size()-1; ix++) {
            if (intervalList.get(ix).end > intervalList.get(ix+1).start) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0][0] = 10;
        intervals[0][1] = 15;
        intervals[1][0] = 0;
        intervals[1][1] = 12;
        intervals[0][0] = 10;
        intervals[0][1] = 15;
        intervals[1][0] = 0;
        intervals[1][1] = 12;

        MeetingRoom mr = new MeetingRoom();
        boolean res = mr.canAttendMeetings(intervals);

        System.out.println(res);
    }
}
