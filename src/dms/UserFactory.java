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
public class UserFactory {
    
    static User getUser(String user)
    {
        if(user.equalsIgnoreCase("Volunteer"))
        {
            return new Volunteer(null);
        }
        
        else if(user.equalsIgnoreCase("Assessor"))
        {
            return new Assessor(null);
        }
        else if(user.equalsIgnoreCase("Donor"))
        {
            return new Donor(null);
        }
        
       else if(user.equalsIgnoreCase("Beneficiary"))
        {
            return new Beneficiary(null,null,null);
        }
       else{
        System.out.println("Enter valid User");
        return null;
       }
    }
    
}
