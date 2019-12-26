/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rubab
 */
public class  Volunteer extends User{
    boolean available; 
    Date workingDate;
   
    Volunteer(String _name)
    {
        id=ID_GENERATOR.getAndIncrement();
        setName(_name);
        available=true;
        workingDate=new Date();
    }
  
    void scheduleWorkTime()
    {
        SimpleDateFormat ft =  new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

       System.out.println("Current Date: " + ft.format(workingDate));
       
    }
    
    Boolean isAvailable(Time t)
    {
        if(workingDate.getTime()==t.getTime())
        {
            available=false;
        }
        return available;
    }
    
}