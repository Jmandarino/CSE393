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
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ggtcs.Data.Exam;
import com.ggtcs.Data.Appointment;
import com.ggtcs.Data.Course;
import com.ggtcs.testingcenter.TestingCenter;

@Entity
/**
 *
 * @author Joseph
 */
public class Term {
    
    @Id
    private String termId;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="term", fetch=FetchType.LAZY)
    private List<Exam> exams;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="term", fetch=FetchType.LAZY)
    private List<Appointment> appointments;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="term", fetch=FetchType.LAZY)
    private List<Course> courses;
    
    private Date startDate;
    private Date endDate;
    
    @OneToOne(cascade=CascadeType.ALL, mappedBy="term", fetch=FetchType.LAZY)
    private TestingCenter testingCenter;
    
    
    
    public Term(String termId, Date startDate, Date endDate, 
                List<Appointment> appointments) {
        this.termId = termId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.appointments = appointments;
    }
    /**
     * Adds exam to current term
     * @param exam
     * @return 
     */
    public boolean addExamToTerm(Exam exam){
        if(exam == null){
            return false;
        }
      //possible need to validate date of exam with this
    
        exams.add(exam);
        return true;
        
    }
      /**
       * Adds course to given term
       * @param course
       * @return 
       */
    public boolean addCourseToTerm(Course course){
        if(course == null){
            return false;
        }
        //possible need to validate date of exam with this
    
        courses.add(course);
        return true;
        
    }
      
    public boolean addAppointmentToTerm(Appointment appointment){
        if(appointment == null){
            return false;
        }
      //possible need to validate date of exam with this

        appointments.add(appointment);
        return true;

    }

    public void setTestingCenter(TestingCenter testingCenter) {
        this.testingCenter = testingCenter;
    }

    public TestingCenter getTestingCenter() {
        return testingCenter;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    
    
    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
    
    
    
}
