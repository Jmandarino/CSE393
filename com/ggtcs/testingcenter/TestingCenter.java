/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ggtcs.testingcenter;

import com.ggtcs.Data.Term;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
/**
 *
 * @author Joseph
 */
public class TestingCenter {

    private int numSeats;
    private int numSetAsideSeats;
    private double gapTime;
    private double reminderInterval;
    
    
    private Date startHour;
    private Date endHour;
     
    private ArrayList<Date> closedDates = new ArrayList<Date>();
    

    //for ease of use (# seats) - (set aside seats)
    private int seatsAvailible;
    
    @OneToOne(cascade=CascadeType.ALL, mappedBy="term", fetch=FetchType.LAZY)
    private Term term;

    public TestingCenter(int numSeats, int numSetAsideSeats, double gapTime, 
                        double reminderInterval, int seatsAvailible, Term term,
                        Date startHour, Date endHour, 
                        ArrayList<Date> closedDates) {
        this.numSeats = numSeats;
        this.numSetAsideSeats = numSetAsideSeats;
        this.gapTime = gapTime;
        this.reminderInterval = reminderInterval;
        this.seatsAvailible = seatsAvailible;
        this.term = term;
        this.startHour = startHour;
        this.endHour = endHour;
        this.closedDates = closedDates;
    }

    


    

    public void setTerm(Term term) {
        this.term = term;
    }


    //setters
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public void setNumSetAsideSeats(int numSetAsideSeats) {
        this.numSetAsideSeats = numSetAsideSeats;
    }

    public void setGapTime(double gapTime) {
        this.gapTime = gapTime;
    }

    public void setReminderInterval(double reminderInterval) {
        this.reminderInterval = reminderInterval;
    }

    public void setSeatsAvailible(int seatsAvailible) {
        this.seatsAvailible = seatsAvailible;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public void setEndHour(Date endHour) {
        this.endHour = endHour;
    }

    public void setClosedDates(ArrayList<Date> closedDates) {
        this.closedDates = closedDates;
    }
    
    
    //getters
    
    public int getNumSeats() {
        return numSeats;
    }

    public int getNumSetAsideSeats() {
        return numSetAsideSeats;
    }

    public double getGapTime() {
        return gapTime;
    }

    public double getReminderInterval() {
        return reminderInterval;
    }

    public int getSeatsAvailible() {
        return seatsAvailible;
    }

    public Date getStartHour() {
        return startHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public ArrayList<Date> getClosedDates() {
        return closedDates;
    }
    

    

    
}


