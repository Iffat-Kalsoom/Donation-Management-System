/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author rubab
 */
public class Team {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    int id;
    Activity currentActivity;
    
    TeamLead leader;
    List<Volunteer> volList=new ArrayList<>();
    List<Assessor> assessorList=new ArrayList<>();
    
    Team()
    {
        id=ID_GENERATOR.getAndIncrement();
        currentActivity=null;
    }
    
       User getVolunteer()
    {
       
        Scanner input=new Scanner(System.in);
        int inId=input.nextInt();
        
        for(User v:volList)
        {
            if(v.id==inId)
            {
                return v;
            }
        }
      return null; 
    }
    
    User getAssessor()
    {
      
        Scanner input=new Scanner(System.in);
        int inId=input.nextInt();
        
         for(Assessor v:assessorList)
        {
            if(v.id==inId)
            {
                return v;
            }
        }
      return null; 
      
    }
    
    Volunteer getLeader()
    {
        Scanner input=new Scanner(System.in);
        int inId=input.nextInt();
        
        for(User u:volList)
        {
            if(u instanceof Volunteer && u.id==inId)
            {
                return (Volunteer)u;
            }
        }
      return null; 
    }
    
    void setCurrentActivity(Activity act)
    {
        currentActivity=act;
        
    }
    
    
    void addVolunteer(Volunteer v)
    {
        volList.add(v);
    }
    
    void addAssessor(Assessor a)
    {
        assessorList.add(a);
    }
    
    void removeVolunteer(Volunteer v)
    {
        volList.remove(v);
    }
    
    void removeAssessor(Assessor a)
    {
        assessorList.remove(a);
    }
    
    void setTeamLeader(TeamLead tL)
    {
        //adding prev leader to volList
        if(leader!=null)
        {
            volList.add(leader);
        }
        
        //removing new leader from vol List
        if(volList.contains(tL))
        {
            volList.remove(tL);
        }
        
         leader=tL;
         
         System.out.print("Volunteer with id "+tL.id+ " set as team leader");
    }

    Boolean assess(Beneficiary applicant)
    {
    Random num=new Random();
    int i= num.nextInt(assessorList.size());
    return assessorList.get(i).assess(applicant);
    }

   

  
}
