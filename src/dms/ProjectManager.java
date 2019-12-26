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
public class ProjectManager extends Volunteer{
    
    Project pro;

    public ProjectManager(String _name) {
        super(_name);
    }
    
  
    void setProject(Project p)
    {
        pro=p;
        
    }
    
    void manage()
    {
    }
    
    void assess(Beneficiary b)
    {
       if(pro.takeBeneficary(b))
       {
           System.out.print("You are successfully a part of this project now");
          
       }
    }
    
 
    
}
