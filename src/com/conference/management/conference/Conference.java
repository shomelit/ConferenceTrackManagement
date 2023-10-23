package com.conference.management.conference;
import com.conference.management.symilarity.Similarity;
import com.conference.management.talks.Talks;

import static com.conference.management.configuration.Configuration.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Conference {
    List<Talks> listTalks;

    public Conference(List<Talks> list){
        listTalks = list;
    }

    public List<Talks> getListTalks(){
        return listTalks;
    }
    public int totalMinutes(){
        int total =0;
        for (Talks talks1 : listTalks) {
            total += talks1.getMinutes();
        }
        return total;
    }
    public int totalTalks(){
        return listTalks.size();
    }

    public int totalTracks(){
        int totalSession = MORNING_SESSION + AFTERNOON_SESSION;
        double numTrack =  (double) totalMinutes() / totalSession;
        double fraction = numTrack % 1;
        double integer = numTrack - fraction;
        int minutes = totalMinutes() - (int)integer * totalSession;
        return minutes >0 ? (int) integer +1 : (int)integer ;
    }

    public void createConference(){
        int i;
        int index = 0;
        String sessionNewTitle;
        Collections.sort(getListTalks(), new Similarity());

        if(!listTalks.isEmpty()) {
            System.out.println("Test Output");
            System.out.println(" ");
        }
        for (int j = 0; j< totalTracks(); j++) {

            System.out.println("Track " + (j + 1));
            int morningSession = MORNING_SESSION;
            int afternoonSession = AFTERNOON_SESSION;
            SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
            Calendar calendar = new GregorianCalendar();
            calendar.set(Calendar.HOUR,HOUR_INITIAL_MORNING);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.AM_PM,Calendar.AM);

            for (i = index; i < totalTalks(); i++) {
                if (morningSession >= listTalks.get(i).getMinutes()) {
                    morningSession = morningSession - listTalks.get(i).getMinutes();
                    sessionNewTitle = format.format(calendar.getTime()) + " " + listTalks.get(i).getTitle() + " " + listTalks.get(i).getMinutes() + "min";
                    listTalks.get(i).setTitle(sessionNewTitle);
                    calendar.add(Calendar.MINUTE, listTalks.get(i).getMinutes());
                    System.out.println(listTalks.get(i).getTitle());
                }
                if (morningSession < listTalks.get(i).getMinutes()) {
                    break;
                }
                if(morningSession>0){
                    continue;
                }
                if (morningSession <= 0) {
                    break;
                }
            }

            System.out.println("12:00 PM Lunch");
            calendar.add(Calendar.MINUTE, 60);
            i++;

            for (; i < totalTalks(); i++) {
                if (afternoonSession >= listTalks.get(i).getMinutes()) {
                    afternoonSession = afternoonSession - listTalks.get(i).getMinutes();
                    sessionNewTitle = format.format(calendar.getTime()) + " " + listTalks.get(i).getTitle() + " " + listTalks.get(i).getMinutes() + "min";
                    listTalks.get(i).setTitle(sessionNewTitle);
                    calendar.add(Calendar.MINUTE, listTalks.get(i).getMinutes());
                    System.out.println(listTalks.get(i).getTitle());
                }
                if (afternoonSession < listTalks.get(i).getMinutes()) {
                    break;
                }
                if(afternoonSession>0) {
                    continue;
                }
                if (afternoonSession <= 0) {
                    break;
                }
            }

            i++;
            index = i;
            System.out.println(format.format(calendar.getTime()) + " Networking Event");
            System.out.println(" ");
        }
    }


}
