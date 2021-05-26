package ch.zt.timerecorders.exceptions;


public static class TimeRecordingWithoutADateException extends Exception {
    public TimeRecordingWithoutADateException (String info){
        super(info);
        
    }
}