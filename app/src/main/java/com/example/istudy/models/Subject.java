
package com.example.istudy.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("course")
    @Expose
    private Course_ course;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Subject() {
    }

    /**
     * 
     * @param image
     * @param name
     * @param course
     * @param description
     */
    public Subject(String name, Course_ course, String image, String description) {
        super();
        this.name = name;
        this.course = course;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course_ getCourse() {
        return course;
    }

    public void setCourse(Course_ course) {
        this.course = course;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
