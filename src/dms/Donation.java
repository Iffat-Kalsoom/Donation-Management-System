/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author rubab
 */
public class Donation {
    
    static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    int id;
    Fund fund;
    Donor donor;
    List<Beneficiary> benList=new ArrayList<>();
    
    Donation()
    {
        id=id=ID_GENERATOR.getAndIncrement();
    }
    
    void receiveFunds(Fund f,Donor d)
    {
        fund=f;
        donor=d;  
    }
    
    
    void addBeneficary(Beneficiary b)
    {
        benList.add(b);
        
    }
    
    void DisplayBeneficiaries()
    {
        if(benList!=null)
        for(Beneficiary b:benList)
        {
            b.Display();
        }
        
        else
        {
            System.out.println("Funds have not been disbursed yet");
        }
    }

    void Display() {
        fund.Display();
        
        System.out.println("Press 1 to see beneficiary list also");
        Scanner s=new Scanner(System.in);
        
        
      }
    
}
