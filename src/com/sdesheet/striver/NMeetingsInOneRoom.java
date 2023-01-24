package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Meeting {
    int start;
    int end;
    int pos;

    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting m1, Meeting m2) {
        if (m1.end < m2.end) return -1;
        else if (m1.end > m2.end) return 1;
        else if (m1.pos < m2.pos) return -1;
        return 1;
    }
}

public class NMeetingsInOneRoom
{


    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(start[i], end[i], i+1));
        }

        MeetingComparator comparator = new MeetingComparator();
        Collections.sort(meetings, comparator);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(meetings.get(0).pos);
        int prevMeetingEndTime = meetings.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meetings.get(i).start > prevMeetingEndTime) {
                prevMeetingEndTime = meetings.get(i).end;
                res.add(meetings.get(i).pos);
            }
        }

        return res.size();
    }


}
