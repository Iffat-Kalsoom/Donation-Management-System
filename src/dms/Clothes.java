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
public class Clothes extends Fund{
    int quantity;
    
    
   Clothes(int c)
   {
       quantity=c;
   }

    @Override
    void Display() {
        System.out.println("Clothes quantity is: "+quantity);
    
    }
    
}
