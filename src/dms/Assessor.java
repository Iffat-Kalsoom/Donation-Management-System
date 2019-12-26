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
public class Assessor extends User{
     List<String> qs=new ArrayList<>();
     Assessor(String _name)
     {
         id=ID_GENERATOR.getAndIncrement();
         setName(_name);
         qs.add("Are you retired?");
         qs.add("Is your motnhly income less than 10,000?");
         qs.add("Do your children need funds for education?");
     }
     
     Boolean assess(Beneficiary applicant)
     {
         System.out.println("Press 1 for yes and 2 for no");
         Scanner s=new Scanner(System.in);
         int response;
         
         for(String q:qs)
         {
            System.out.println(q);
            response= s.nextInt();

            if(response==2)
            {
                return false;
            }


         }
         return true;
     }
     
}
