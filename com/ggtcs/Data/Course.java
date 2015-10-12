/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ggtcs.Data;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import com.ggtcs.Data.User;
import com.ggtcs.Data.Term;

@Entity
/**
 *
 * @author Joseph
 */
public class Course {
    
    @Id
    private String courseId;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idNumber")
    private User instructor;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="CourseStudent")
    private List<User> students;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="termId")
    private Term term;
    

    
    public Course(String courseId, User instructor, Term term) {
        this.courseId = courseId;
        this.instructor = instructor;
        this.term = term;
        this.students = new ArrayList<User>();
    }
    
    
    
    
    
    public boolean addStudent(User student) {
        if(student != null){
            return false;
        }
        
        students.add(student);
        return true;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public void setTerm(Term term) {
        this.term = term;
    }
    
    
    
    
    
}