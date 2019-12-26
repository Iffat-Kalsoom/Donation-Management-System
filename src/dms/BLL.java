/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iffat Alvi
 */
public class BLL {
    List<Organization> lsOrg=new ArrayList<>();
    List<User> lsUser=new ArrayList<>();
    List<Fund> lsFund=new ArrayList<>();
    List<Donation> lsDon=new ArrayList<>();
    List<Project> lsProj=new ArrayList<>();
    List<Activity> lsAct=new ArrayList<>();
    List<Pledge> lsPledge=new ArrayList<>();
    
    dbConnectivity db=dbConnectivity.getInstance();
    
     BLL(){
           lsOrg=db.getAllOrgs();
           lsUser=db.getAllUser();
       // lsProj=db.getAllProject();
    }
  
        List<Organization> getOrgList(){return lsOrg;}
        
        Boolean Add_User (User m){
            try{
                lsUser.add(m);
                return db.Add_User(m);
            }
            catch(Exception e){
                 return false;
            }
        }
	Boolean Add_Project (Project m){
            try{
               lsProj.add(m);
                return db.Add_Project(m);
            }
            catch(Exception e){
                 return false;
            }
        }        
        Boolean Add_Org (Organization m){
            try{
               lsOrg.add(m);
               for(Organization o: this.lsOrg)
               {
                   System.out.println(o.name);
               }
               boolean b=db.Add_Org(m);
                return b;
            }
            catch(Exception e){
                 return false;
            }
        }    
	Boolean Delete_User (int id){
            try{
                lsUser.remove(id);
                for(User u:lsUser)
                    if(u.id==id)
                        return db.Delete_User(id);
                return false;

            }
            catch(Exception e){
                 return false;
            }
        }
        Boolean Delete_Project (int id){
            try{
                lsProj.remove(id);
                for(Project p:lsProj)
                    if(p.id==id)
                        return db.Delete_Project(id);    
                return false;
            }
            catch(Exception e){
                 return false;
            }
        }
        Boolean Delete_Donation (int id){
            try{
                lsDon.remove(id);
                for(Donation d:lsDon)
                    if(d.id==id)
                        return db.Delete_Donation(id);
                return false;

            }
            catch(Exception e){
                 return false;
            }
        }        

   
    Boolean removeMember(int tid, int mid, int pid) {
        for(Project p:lsProj){
            if(p.id==pid){
                for(Team t:p.teams){
                    if(t.id==tid){
                        t.volList.remove(mid);
                         return db.removeMember(mid);
                    }
                }
            }
        }
        return false;
    }

    
	
    
}
