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
public class Project {
    
    
    static AtomicInteger ID_GENERATOR = new AtomicInteger(100);
   
    int id;
    String name;
    String dsc; 
    int budget;
    
    Organization o;
    List<Donor>donorList=new ArrayList<>();
    List<Beneficiary> benList=new ArrayList<>();
    List<Donation> donList=new ArrayList<>();
    List<Team> teams=new ArrayList<>();
    
    ProjectManager projManager=null;
    
    Project(){}
    Project(int id,String name, String dsc, int budget)
    {
        id=ID_GENERATOR.getAndIncrement();
        projManager=(ProjectManager)o.getVolunteer(id);
        
    }
    
    void addTeam(Team t)
    {
        teams.add(t);
    }
    
    void addDonation(Donation d)
    {
        donList.add(d);
        addDonor(d.donor);
    }
    
    void addDonor(Donor d)
    {
        donorList.add(d);
    }
    
    Boolean takeBeneficary(Beneficiary b)
    {
        if(teams.get(0).assess(b)==true)
        {
            b.isEligible=true;
            benList.add(b);
            return true;
        }
        
        return false;
    }
    
    Team getTeam()
    {
        Scanner input=new Scanner(System.in);
        int teamId=input.nextInt();
        
        for(Team t:teams)
        {
            if(t.id==teamId)
            {
                return t;
            }
        }
        System.out.println("Invalid team id given");
        return null;
    }
    
   
    
      void addVolunteerInTeam(Team t)
    {
        System.out.println("Enter the id of volunteer you want to add.");
        User u= t.getVolunteer();
        if(u!=null)
        {
           t.addVolunteer((Volunteer)u);
        }
    }
    
    void addAssessorInTeam(Team t)
    {
        System.out.println("Enter the id of Assessor you want to add.");
        User u= t.getAssessor();
        if(u!=null)
           t.addAssessor((Assessor)u);
    }
    
    void removeVolunteerFromTeam(Team t)
    {
        System.out.println("Enter the id of volunteer you want to remove.");
        User u= t.getVolunteer();
        if(u!=null)
        {
           t.removeVolunteer((Volunteer)u);
        }
    }
    
    void removeAssessorFromTeam(Team t)
    {
        System.out.println("Enter the id of Assessor you want to remove.");
        User u= t.getAssessor();
        if(u!=null)
           t.removeAssessor((Assessor)u);
    }
    
    void setLeaderOfTeam(Team t)
    {
        System.out.println("Enter the id of Volunteer you want to set as Leader.");
        Volunteer v= t.getLeader();
        if(v!=null)
            t.setTeamLeader((TeamLead)v);
    }
    
    
    void updateTeam()
    { 
        Team t=getTeam();
        if(t!=null)
        {
            System.out.println("Press 1 to add a member.Press 2 to remove a member and 3 to change leader.Press 4 to replace a team member");
            Scanner input=new Scanner(System.in);
            int choice=input.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Press 1 to add Volunteer and 2 to add Assessor");
                    choice=input.nextInt();
                 
                    switch (choice) {
                        case 1:
                        {
                            addVolunteerInTeam(t);
                            break;
                        }
                        case 2:
                        {
                            addAssessorInTeam(t);
                            break;
                        }
                        
                        default:
                            System.out.println("Wrong Input");
                            break;
                    }  
                 break;
                    
                    
                case 2:
                    System.out.println("Press 1 to remove Volunteer and 2 to remove Assessor");
                    choice=input.nextInt();
                 
                    switch (choice) {
                        case 1:
                        {
                            removeVolunteerFromTeam(t);
                            break;
                        }
                        case 2:
                        {
                            removeAssessorFromTeam(t);
                            break;
                        }
                        
                        default:
                            System.out.println("Wrong Input");
                            break;
                    }
                    break;
                case 3:
                    setLeaderOfTeam(t);  
                    break;
                    
                 case 4:
                   System.out.println("Press 1 to replace Volunteer and 2 to replace Assessor");
                    choice=input.nextInt();
                 
                    switch (choice) {
                        case 1:
                        {
                            removeVolunteerFromTeam(t);
                            addVolunteerInTeam(t);
                            break;
                        }
                        case 2:
                        {
                            removeAssessorFromTeam(t);
                            addAssessorInTeam(t);
                            break;
                        }
                        
                        default:
                            System.out.println("Wrong Input");
                            break;
                    }
                    break;
                    
                default:
                    System.out.println("Wrong Input");
                    break;
            }
            
        }
    }
    
    
   void getDonation(Donation d)
   {
        Team t=getTeam();
        FundCollection fC=new FundCollection();
        Beneficiary b=getBeneficiary();
        fC.performActivity(t,d,b);
        t.currentActivity.changeActivity(t,d,b);
        t.currentActivity.changeActivity(t,d,b);
   }
    Beneficiary getBeneficiary()
    {
          Random random = new Random();

          int i=random.nextInt(benList.size());
          return benList.get(i);
    }

    void Display() {
        System.out.println("Project id: "+id+"\n Project Name: "+name+"\n Description: "+dsc+"\n Budget: "+budget+"\n Project Manager: "+projManager.id);
         }
    
}
