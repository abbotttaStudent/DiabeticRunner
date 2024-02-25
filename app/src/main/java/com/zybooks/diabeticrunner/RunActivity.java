package com.zybooks.diabeticrunner;

import java.util.Date;

public class RunActivity {
    public String Description;
    public String AveragePace;
    public Date RunDate;
    public String TimeElapsed;
    public double Distance;
    public String StarBg;
    public String EndBg;

    public RunActivity(String description, String averagePace, Date runDate, String timeElapsed, double distance, String startBg, String endBg){
        Description = description;
        AveragePace = averagePace;
        RunDate = runDate;
        TimeElapsed = timeElapsed;
        Distance = distance;
        StarBg = startBg;
        EndBg = endBg;
    }
}
