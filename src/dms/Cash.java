/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

/**
 *
 * @author rubab
 */
public class Cash extends Fund {
    int amount;
    
    
   Cash(int c)
   {
       amount=c;
   }

    @Override
    void Display() {
        System.out.println("Cash amount is: "+amount);
    
     }
}
