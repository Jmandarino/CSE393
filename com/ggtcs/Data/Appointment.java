/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ggtcs.Data;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import com.ggtcs.Data.Exam;
import com.ggtcs.Data.User;
import com.ggtcs.Data.Term;


@Entity
/**
 *
 * @author Joseph
 */
public class Appointment implements Serializable {
    
    /* Appointments are uniquely id'ed by student-exam tuple,
     * (A student takes an exam once and only once) (retakes?? --ask)
     */
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idNumber")
    private User student;
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="examId")
    private Exam exam;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="termId")
    private Term term;
    
    private Date startTime;
    private Date EndTime;
    private int seatNum;
    private boolean isStudentCheckedIn; 


    
    public Appointment(User student, Exam exam, Term term) {
        this.student = student;
        this.exam = exam;
        this.term = term;
        
        
    }
    
    //time slot must start on the hour or half hour
    public boolean validateTimeSlot(){
        if(startTime == null || exam == null){
            return false;
        }
        int minutes = startTime.getMinutes();
        
        if( minutes== 30 || minutes == 0){
            return true;
        }
        
        //need more
        
        
        return false;
        
    }

    public Exam getExam() {
        return exam;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date EndTime) {
        this.EndTime = EndTime;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
    
    

    public User getStudent() {
        return student;
    }

    public Term getTerm() {
        return term;
    }

    public void setIsStudentCheckedIn(boolean isStudentCheckedIn) {
        this.isStudentCheckedIn = isStudentCheckedIn;
    }
    
    
    public int getSeatNum() {
        return seatNum;
    }

    public boolean isIsStudentCheckedIn() {
        return isStudentCheckedIn;
    }
    
    
}

