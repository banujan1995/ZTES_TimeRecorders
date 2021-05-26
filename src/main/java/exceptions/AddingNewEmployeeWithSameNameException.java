package ch.zt.timerecorders.exceptions;


public static class AddingNewEmployeeWithSameNameException extends Exception {
    public AddingNewEmployeeWithSameNameException (String info){
        super(info);
        
    }
}