/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author rubab
 */
public class User {
    static AtomicInteger ID_GENERATOR = new AtomicInteger(1010);
    int id;
    String name;
    
    void Display(){
       System.out.println("ID is "+id+ "\n Name is: "+name);
    }
    
    void setName(String in)
    {
        name=in;
    }

    void DisplayAll() {
        }
}
