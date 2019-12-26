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
public class Beneficiary extends User
{
    List<Donation> donList=new ArrayList<>();
   
    String number;
    String address;
    boolean isEligible;
    
    Beneficiary(String _name,String num,String addr)
    {
        id=ID_GENERATOR.getAndIncrement();
        setName(_name);
        number=num;
        address=addr;
        isEligible=false;
    }
    
    
    void receiveDonation(Donation d)
    {
        if(isEligible==true)
        donList.add(d);
    }
}
