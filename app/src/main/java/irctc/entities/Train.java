package irctc.entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Train {
    private String trainId;
    private String trianNo;
    private String trainName;
    private ArrayList<ArrayList<Integer>> seats;
    private HashMap<String, Time> trainTiming;
    private ArrayList<String> stations;

}
