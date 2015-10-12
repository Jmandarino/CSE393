/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ggtcs.Handlers;
import com.ggtcs.Data.*;
import java.util.*;


import com.ggtcs.testingcenter.TestingCenter;
/**
 *
 * @author Joseph
 */
public class Scheduler {
    
    //a reference to the testing center
    private TestingCenter testingCenter;
    
    private ArrayList<Term> terms;
    
   
    public boolean checkInStudent(String id, Appointment appt){
     
        if(appt == null || id == null ){
           return false; 
        }
        
        if(appt.getStudent().getIdNumber().equals(id)){
            appt.setIsStudentCheckedIn(true);
            return true;
        }

        return false;
    }
    

    
    
}

