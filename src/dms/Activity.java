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
interface Activity {
    
    void performActivity(Team t,Donation d,Beneficiary b);
    void changeActivity(Team t,Donation d,Beneficiary b);
    void Display();
}
