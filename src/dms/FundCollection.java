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
public class FundCollection implements Activity{
    
      
     
      @Override
      public void performActivity(Team t,Donation d,Beneficiary b)
      {
          Display();
          t.setCurrentActivity(this);
      }
      
      public void changeActivity(Team t,Donation d,Beneficiary b)     
      {
          FundDisbursement fD= new FundDisbursement();
          t.setCurrentActivity(fD);
          fD.performActivity(t, d, b);
      }
    
      
      public void Display()
      {
          System.out.println("Fund Collection is being performed");
      }
}

