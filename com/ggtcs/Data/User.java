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
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ElementCollection;


import com.ggtcs.Data.Course;
import com.ggtcs.Data.Appointment;
import com.ggtcs.Data.Permission;


@Entity
/**
 *
 * @author Joseph
 */
public class User {
    
    @Id
    private String idNumber;
    
    private String firstName;
    private String lastName;
    private String email;
    
    
    //This is confusing, students _take_ courses, instructors _teach_ courses
    //How do we differentiate between the two. Do we need inheritance??
    @ManyToMany(mappedBy="students", fetch=FetchType.LAZY)
    private List<Course> enrolledCourses;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="instructor", fetch=FetchType.LAZY)
    private List<Course> taughtCourses;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="student", fetch=FetchType.LAZY)
    private List<Appointment> appointments;
    
    @ElementCollection
    private List<Permission> permissions;
    
    public User(String firstName, String lastName, String email, String idNumber, List<Permission> permissions) {
        //NEED VALIDATION
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.idNumber = idNumber;
        this.permissions = permissions;
        this.enrolledCourses = new ArrayList<Course>();
        this.taughtCourses = new ArrayList<Course>();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public List<Course> getTaughtCourses() {
        return taughtCourses;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
    
    public void teachCourse(Course course) {
        this.taughtCourses.add(course);
    }
    
    public void enrollCourse(Course course) {
        this.enrolledCourses.add(course);
    }
}
