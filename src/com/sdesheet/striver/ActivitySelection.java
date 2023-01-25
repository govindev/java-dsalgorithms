package com.sdesheet.striver;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Meeting meeting = new Meeting(start[i], end[i], i+1);
            meetings.add(meeting);
        }
        Collections.sort(meetings, new MeetingComparator());

        int count = 1;
        Meeting currMeeting = meetings.get(0);
        for (int i = 1; i < n; i++) {
            if(meetings.get(i).start > currMeeting.end) {
                currMeeting = meetings.get(i);
                count++;
            }
        }

        return count;
    }
}
