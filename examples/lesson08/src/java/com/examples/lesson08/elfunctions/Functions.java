package com.examples.lesson08.elfunctions;

import java.util.Date;
import java.util.GregorianCalendar;

public class Functions {
  
  public static Date now() {
    return new Date();
  }
  
  public static Date date(int day, int month, int year) {
    //months are zero based. you want users to use this function 1 based.
    return new GregorianCalendar(year, month - 1, day).getTime();
  }
}
