/**
 * Betty Vuong 
 * ICS4U
 * 23/06/22
 * An object class that acts like a stopwatch. The object can time, calculate time elapsed in nanoseconds, seconds, minutes, and hours.
 */

import java.math.BigInteger;
public class StopWatch {
	//final is used as these variables are fixed and don't need to be modified
    private final long nanoSecondsPerSec;
    
    //for stopwatch to run, time, and function
    private long startTime;
    private long stopTime;
    private long elapsedTime;
    private double minsInHrs;
    private double secsInMins;
    private double hours;
    private double mins;
    private double secs;
    private boolean stopWatchRunning;
    
    //constructor
    public StopWatch() {
    	nanoSecondsPerSec = 1000000000;
    	startTime = 0;
    	stopTime = 0;
    	elapsedTime = 0;
    	minsInHrs = 0;
    	secsInMins = 0;
    	hours = 0;
    	mins = 0;
    	secs = 0;
    	stopWatchRunning = false; //indicates if stopwatch is running or not
    			
    }
    
    // starts stopwatch
    public void startWatch() {
    	startTime = System.nanoTime(); 
    	stopWatchRunning = true; //indicates that the stopwatch is running
    }
    
    // stops stopwatch
    public void stopWatch() {
    	this.stopTime = System.nanoTime();
    	this.stopWatchRunning = false; //indicates that the stopwatch is not running
    }
    
    // calculate the current or final elapsed time in nanoseconds and calculates and returns the time in seconds
    // post: long variable value of elapsed seconds is returned, long was chosen for its accuracy compared other data types
    public long getElapsedSecs() {
    	if(stopWatchRunning) { //calculates elapsed time if stopwatch is still running
    		elapsedTime = System.nanoTime()-startTime;
    	} else { //calculates final elapsed time
    		elapsedTime = stopTime-startTime; 
    	}
    	
    	//converts from elapsed time from nanoseconds to seconds
    	elapsedTime = elapsedTime/nanoSecondsPerSec;
    	
    	return elapsedTime;
    }
    
    // calculates only the hours in the elapsed time
    // post: returns int variable value with the number of hours 
    public int getHours() {
    	double hoursWhole = 0;
    	
    	hoursWhole = (double)elapsedTime/3600; //converts from seconds to hours with accuracy
    	minsInHrs = hoursWhole%1; // finds the amount of minutes in hours unit
    	hours = hoursWhole-minsInHrs; // calculates for hours only
    	minsInHrs = hoursWhole-hours; // finds the amount of minutes in hours unit bc modulo cuts off a lot of decimals
    	
    	return (int)hours;
    	
    }
    
    // Overloaded for main purposes. Calculates only the hours in the elapsed time
    // pre: long 'elapsedTimeArrList', value comes from main arraylist for the scoreboard time records
    // post: returns int variable value with the number of hours
    public int getHours(long elapsedTimeArrList) {
    	double hoursWhole = 0;
    	
    	hoursWhole = (double)elapsedTimeArrList/3600; //converts from seconds to hours with accuracy
    	minsInHrs = hoursWhole%1; // finds the amount of minutes in hours unit
    	hours = hoursWhole-minsInHrs; // calculates for hours only
    	minsInHrs = hoursWhole-hours; // finds the amount of minutes in hours unit bc modulo cuts off a lot of decimals
    	
    	return (int)hours;
    	
    }
    
    // calculates only the minutes in the elapsed time
    // post: returns int variable value with the number of minutes 
    public int getMins() {
    	getHours();
    	
    	mins = minsInHrs*60; //converts from hours to minutes with accuracy
    	secsInMins = mins%1; // finds the amount of seconds in minutes unit
    	mins = mins-secsInMins; // calculates for minutes only
    	
    	return (int)mins;
    	
    }
    
    // Overloaded for main purposes. Calculates only the minutes in the elapsed time
    // pre: long 'elapsedTimeArrList', value comes from main arraylist for the scoreboard time records
    // post: returns int variable value with the number of minutes
    public int getMins(long elapsedTimeArrList) {
    	getHours(elapsedTimeArrList);
    	
    	mins = minsInHrs*60; //converts from hours to minutes with accuracy
    	secsInMins = mins%1; // finds the amount of seconds in minutes unit
    	mins = mins-secsInMins; // calculates for minutes only
    	
    	return (int)mins;
    	
    }
    
    // calculates only the seconds in the elapsed time
    // post: returns int variable value with the number of seconds 
    public int getSeconds() {
    	getHours();
    	getMins(); 
    	
    	secs = secsInMins*60; // converts from minutes to seconds with accuracy
    	secs = secs-secs%1; // calculates for seconds only
    	
    	return (int)secs;
    }  
    
    // Overloaded for main purposes. Calculates only the seconds in the elapsed time
    // pre: long 'elapsedTimeArrList', value comes from main arraylist for the scoreboard time records
    // post: returns int variable value with the number of seconds
    public int getSeconds(long elapsedTimeArrList) {
    	getHours(elapsedTimeArrList);
    	getMins(elapsedTimeArrList); 
    	
    	secs = secsInMins*60; // converts from minutes to seconds with accuracy
    	secs = secs-secs%1; // calculates for seconds only
    	
    	return (int)secs;
    }  
    
    // method override (toString) that displays the timer time
    // post: returns string value with timer info 
    public String toString() {
    	String info = getHours() + "H " + getMins() + "M " + getSeconds() + "S";
    	
    	return info;
    }
   
    // method overload (toString) that displays the timer time
    // post: returns string value with timer info 
    public String toString(long elapsedTimeArrList) {
    	String info = getHours(elapsedTimeArrList) + "H " + getMins(elapsedTimeArrList) + "M " + getSeconds(elapsedTimeArrList) + "S";
    	
    	return info;
    }
    
}
