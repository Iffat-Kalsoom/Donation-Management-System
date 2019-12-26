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
public class FundDisbursement implements Activity {
    
@Override

      public void performActivity(Team t,Donation d,Beneficiary b)
      {
         if(calFunds(b,d)==true)
         {
           disburseToBeneficiary(d,b);
           t.setCurrentActivity(this);
           Display();
         }
          
         else
         {
             System.out.println("Error. Not enough funds");
         }
      }
       
      
      
      
     Boolean calFunds(Beneficiary b,Donation d)
     {
          if(d.fund!=null)
          {
              return true;
          }
          
          return false;
     }
    void disburseToBeneficiary(Donation d, Beneficiary b){
        d.benList.add(b);
        
    }
    public void changeActivity(Team t,Donation d,Beneficiary b)
    {
        System.out.println("Process has been completed.");
        t.currentActivity=null;
        
    }
    
    public void Display()
    {
        System.out.println("Fund Disbursement is being performed");
    }
}
