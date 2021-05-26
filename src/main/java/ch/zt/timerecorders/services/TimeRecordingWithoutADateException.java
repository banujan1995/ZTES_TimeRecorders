//erstellt durch: Jordi Schmidlin
package ch.zt.timerecorders.services;


//Exception, falls User versucht eine Zeit zuerfassen, ohne vorher ein Datum anzuwählen
public static class TimeRecordingWithoutADateException extends Exception {
    public TimeRecordingWithoutADateException (String info){
        super(info);
        
    }
}

/*

  try {
      in der Datenbank speichern


 } catch (TimeRecordingWithoutADateException e) {
    logger.info("User tried to record workinghours without choosing beforehand a week & validate the input); 
    logger.info(e.toString());
 }
/*

