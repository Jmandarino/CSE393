/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ggtcs.Data;

import java.util.List;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import com.ggtcs.Data.Term;
import com.ggtcs.Data.Appointment;

@Entity
/**
 *
 * @author Joseph
 */
public class Exam {
    //maybe we can combine the start date and start time
    // is there a unifying Date class or does Date class hold all the answers
    //(you ain't got the answers sway!)
    
    @Id
    private String examId;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="exam", fetch=FetchType.LAZY)
    private List<Appointment> appointments;
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="termId")
    private Term term;
    
    /* Exams start and end at arbitrary times throughout the day */
    private Date startDate;         //Date is actually a date-time pair
    private Date endDate;
    //Ask professor about valid durations (ie: in hours or minutes?)
    private double examDuration;
    //maybe enum instead of string
    private ExamStatus examStatus;
    //maybe should be something different 
    //enum? lol
    private ExamType examType;

    public Exam() {
        
    }
    public Exam(String examId, Date start, Date end, double duration,
                ExamStatus status, ExamType examType){
        this.examId = examId;
        this.startDate = start;
        this.endDate = end;
        this.examDuration = duration;
        this.examStatus = status;
        this.examType = examType;
    }
    
    
    

    
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public void setExamDuration(double examDuration) {
        this.examDuration = examDuration;
    }
    
    public void setExamStatus(ExamStatus examStatus) {
        this.examStatus = examStatus;
    }
    
    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    //getters
    
    
    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }


    public double getExamDuration() {
        return examDuration;
    }

    public ExamStatus getExamStatus() {
        return examStatus;
    }

    public ExamType getExamType() {
        return examType;
    }

    
    
}
