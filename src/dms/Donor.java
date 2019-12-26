/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

import static dms.FundFactory.getFund;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rubab
 */
public class Donor extends User{
    List<Pledge> pledge=new ArrayList<>();
    List<Donation>receipts=new ArrayList<>();
    List<Project> projList=new ArrayList<>();
    
    Donor(String _name)
    {
       id=ID_GENERATOR.getAndIncrement();
       setName(_name);
    }
    void makePledge(){
        
        System.out.println("Enter the type of fund you want to give");
        Scanner input= new Scanner(System.in);
        String in=input.next();
        Fund f=getFund(in);
        if(f!=null)
        {
            Pledge newPledge=new Pledge();
            newPledge.fund=f;
            newPledge.maker=this;
            
            System.out.println("Enter the type of fund you want to give");
            in=input.next();
            
            newPledge.description=in;
            
            pledge.add(newPledge);
            
        }
    }
    
    void addProject(Project p)
    {
        projList.add(p);
    }
    void makeDonation(Donation d)
    {
        receipts.add(d);
    }
    void trackDonation(int id){
       
        for(Donation d:receipts)
        {
            if(d.id==id)
            {
                d.DisplayBeneficiaries();
                break;
            }
        }  
    }
    
    
    @Override
   void DisplayAll()
   {
       for(Donation d:receipts)
       {
           d.Display();
       }
       
       for(Project p:projList)
       {
           p.Display();
       }
   }
    
    
}
