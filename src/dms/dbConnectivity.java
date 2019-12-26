/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iffat Alvi
 */
public class dbConnectivity {
    static Connection con;
    static Statement stmt;
    static{
    String s = "jdbc:sqlserver://localhost\\LAPTOP-M7U26RT6:1433;databaseName=DMS";
        try {
            con=DriverManager.getConnection(s,"iffatalvi","123");
        } catch (SQLException ex) {
            Logger.getLogger(dbConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(dbConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static dbConnectivity db;
    private dbConnectivity() //cons
    {
        try
        {
             String s = "jdbc:sqlserver://localhost\\LAPTOP-M7U26RT6:1433;databaseName=DMS";
             con=DriverManager.getConnection(s,"iffatalvi","123");
            stmt=con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static dbConnectivity getInstance(){
        if(db!=null)
            db=new dbConnectivity();
        return db;
    }
     void displayAllDonor()
    {
        
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Donor");
             while(rs.next())
             {
                 
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
   	Boolean Add_User (User m){
            try{
                String query="insert into User values("+m.id+","+m.name+")";
                stmt.executeUpdate(query);
                return true;
            }
            catch(Exception e){
                 return false;
            }
        }
	Boolean Add_Project (Project m){
            try{
                String query="insert into Project values("+m.id+","+m.name+","+m.dsc+")";
                stmt.executeUpdate(query);
                return true;
            }
            catch(Exception e){
                 return false;
            }
        }        

	Boolean Delete_User (int id){
            try{
                stmt.executeUpdate("delete from User where id="+id);
                return true;
            }
            catch(Exception e){
                 System.out.println("Error: "+e.getMessage());
                 return false;
            }
        }
        Boolean Delete_Project (int id){
            try{
                stmt.executeUpdate("delete from Project where id="+id);
                return true;
            }
            catch(Exception e){
                 System.out.println("Error: "+e.getMessage());
                 return false;
            }
        }
        Boolean Delete_Donation (int id){
            try{
                stmt.executeUpdate("delete from Donation where id="+id);
                return true;
            }
            catch(Exception e){
                 System.out.println("Error: "+e.getMessage());
                 return false;
            }
        }        
	
      List<Donor> getAllDonor(){
        List<Donor> ls=new ArrayList<>();
         try
        {
            ResultSet rs=stmt.executeQuery("select * from User where type='d'");
             while(rs.next())
             {
                Donor d=new Donor(null);
             }
             return ls;
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
      }
      
       public static List<Organization> getAllOrgs(){
        List<Organization> ls=new ArrayList<>();
         try
        {
            ResultSet rs= stmt.executeQuery("select * from Org");
            System.out.println(rs);
            while(rs.next())
             {
                Organization o=new Organization(rs.getString(2));
                ls.add(o);
             }
             return ls;
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
      }
        public static List<User> getAllUser(){
        List<User> ls=new ArrayList<>();
         try
        {
            ResultSet rs= stmt.executeQuery("select * from Org");
            System.out.println(rs);
            while(rs.next())
             {
                User o=new User();
                ls.add(o);
             }
             return ls;
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
      }
       
       
    List<Project> getAllProject(){
        List<Project> ls=new ArrayList<>();
         try
        {
            ResultSet rs=stmt.executeQuery("select * from Project");
             while(rs.next())
             {
                Project p=new Project();
             }
             return ls;
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
      }

    static Boolean  Add_Org(Organization m) {
        try{
                //String query="insert into Org values("+m.id+","+m.name+")";
                //stmt.executeUpdate(query);
                //stmt.execute(query);
                String query = " insert into Org"
                    + " values (?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, m.id);
            preparedStmt.setString(2, m.name);
            preparedStmt.execute();
                return true;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                 return false;
            }
    }
      Boolean removeMember(int mid) {
         try{
              stmt.executeUpdate("delete from Project join Team on Project.teamid=Team.tid where id="+mid);
              return true;
         }
          catch(Exception e){
                 return false;
            }
       
    }
public static void main(String[] args)
{
    dbConnectivity db=new dbConnectivity();
    db.Add_Org(new Organization("Hello"));
        List<Organization> allOrgs = dbConnectivity.getAllOrgs();
        System.out.println(allOrgs);
}
   
}
