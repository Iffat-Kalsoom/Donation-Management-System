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
public class Organization {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    int id;
    String name;
    List<Project> projectsList=new ArrayList<>();
    List<User> usersList=new ArrayList<>();
    List<Team> teamsList=new ArrayList<>();
    
    
    Organization(String name_)
    {
        id=ID_GENERATOR.getAndIncrement();
        name=name_;
    }
    
    
    
    void addProject(Project p)
    {
        projectsList.add(p);
    }
   
   
    void addTeamToProject(int proID,int teamId)
    {
        System.out.println("Enter the id of the project in which u want to donate to");
    
        for(Project p:projectsList)
        {
            if(p.id==proID)
            {
                 Team t=getTeam(teamId);
                if(t!=null)
                p.teams.add(t);
            }
                
        }
       
    }
    User getVolunteer()
    {
       
        Scanner input=new Scanner(System.in);
        int inId=input.nextInt();
        
        for(User u:usersList)
        {
            if(u instanceof Volunteer && u.id==inId)
            {
                return u;
            }
        }
      return null; 
    }
     User getVolunteer(int inId)
    {
       
      
        
        for(User u:usersList)
        {
            if(u instanceof Volunteer && u.id==inId)
            {
                return u;
            }
        }
      return null; 
    }
    
    User getAssessor()
    {
      
        Scanner input=new Scanner(System.in);
        int inId=input.nextInt();
        
        for(User u:usersList)
        {
            if(u instanceof Assessor && u.id==inId)
            {
                return u;
            }
        }
      return null; 
    }
    
    Volunteer getLeader()
    {
        Scanner input=new Scanner(System.in);
        int inId=input.nextInt();
        
        for(User u:usersList)
        {
            if(u instanceof Volunteer && u.id==inId)
            {
                return (Volunteer)u;
            }
        }
      return null; 
    }
    
    void addVolunteerInTeam(Team t)
    {
        System.out.println("Enter the id of volunteer you want to add.");
        User u= getVolunteer();
        if(u!=null)
        {
           t.addVolunteer((Volunteer)u);
        }
    }
    
    void addAssessorInTeam(Team t)
    {
        System.out.println("Enter the id of Assessor you want to add.");
        User u= getAssessor();
        if(u!=null)
           t.addAssessor((Assessor)u);
    }
    
    void removeVolunteerFromTeam(Team t)
    {
        System.out.println("Enter the id of volunteer you want to add.");
        User u= getVolunteer();
        if(u!=null)
        {
           t.removeVolunteer((Volunteer)u);
        }
    }
    
    void removeAssessorFromTeam(Team t)
    {
        System.out.println("Enter the id of Assessor you want to add.");
        User u= getAssessor();
        if(u!=null)
           t.removeAssessor((Assessor)u);
    }
    
    void setLeaderOfTeam(Team t)
    {
        System.out.println("Enter the id of Volunteer you want to set as Leader.");
        Volunteer v= getLeader();
        if(v!=null)
            t.setTeamLeader((TeamLead)v);
    }
    
    
    void formTeam()
    {
        System.out.println("Press 1 to add Volunteer and 2 to add Assessor and 3 to set Leader");
        Scanner input=new Scanner(System.in);
        int choice=input.nextInt();
        Team newTeam=new Team();
        switch (choice) {
            case 1:
                {
                    addVolunteerInTeam(newTeam);
                    break;
                }
            case 2:
                {
                    addAssessorInTeam(newTeam);
                    break;
                }
            case 3:
                {
                    
                    setLeaderOfTeam(newTeam);
                    break;
                }
            default:
                break;
        }
        
    
        teamsList.add(newTeam);
    }
    
    Team getTeam(int teamId)
    {
       
        for(Team t:teamsList)
        {
            if(t.id==teamId)
            {
                return t;
            }
        }
        System.out.println("Invalid team id given");
        return null;
    }
    
    
    
    Project getProject()
    {
        System.out.println("Enter the id of the project you want to donate to");
        Scanner s=new Scanner(System.in);
        int c=s.nextInt();
         for(Project t:projectsList)
        {
            if(t.id==c)
            {
                return t;
            }
        }
        System.out.println("Invalid project id given");
        return null;
    }
    
   
    void performActivity(Donation d)
    {
        Project p=getProject();
         if(p!=null)
         {
             p.getDonation(d);
         }
    }
    
    
    Project searchProject(String name)
    {
        for(Project p:projectsList)
        {
            if(p.name.equalsIgnoreCase(name))
            {
                return p;
              
            }
        }
        return null;
    }
    
    Project searchProject(int projMan)
    {
        for(Project p:projectsList)
        {
            if(p.id==projMan)
            {
                return p;
                
            }
        }
       return null;
    }
    
    void addDonor(Donor d)
    {
        usersList.add(d);
    }
    void searchDonor(int donId)
    {
        for(User d:usersList)
        {
            if(d instanceof Donor && d.id==donId)
            {
                d.Display();
                d.DisplayAll();
            }
        }
    }
    
    
    
}


