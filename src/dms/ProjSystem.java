/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author rubab
 */
public class ProjSystem {
    
    private static ProjSystem sys;
    List<Organization> orgList;
    
    
    private ProjSystem()
    {
        sys=null;
        orgList= new ArrayList<>();
    }
    
    public static ProjSystem getSystemInstance()
    {
        if(sys==null)
        {
            sys=new ProjSystem();
        }
        
        return sys;
    }
    
    void makeOrganization()
    {
        System.out.println("Give the name for new Organization");
        Scanner input=new Scanner(System.in);
        String inpName=input.next();
        
        Organization o= new Organization(inpName);
        orgList.add(o);
    }
    
   
    
   void giveDonation(Donor d,Donation don)
   {
        d.makeDonation(don);
   }
}
