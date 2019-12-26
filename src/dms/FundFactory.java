/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

import java.util.Scanner;

/**
 *
 * @author rubab
 */
public class FundFactory {
    
    static Fund getFund(String type)
    {
        Scanner s=new Scanner(System.in);
        
        if(type.equalsIgnoreCase("Food"))
        {
            System.out.println("enter quantity");
            int c=s.nextInt();
            return new Food(c);
        }
        
        else if(type.equalsIgnoreCase("Clothes"))
        {
            System.out.println("enter quantity");
            int c=s.nextInt();
            return new Clothes(c);
        }
        
        else if(type.equalsIgnoreCase("Cash"))
        {
            System.out.println("enter amount");
            int c=s.nextInt();
            return new Cash(c);
        }
        
        return null;
    }
    
}
