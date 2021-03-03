
package com.example.istudy.models;

//import com.example.istudy.Subject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lesson {

    @SerializedName("lesson_id")
    @Expose
    private String lessonId;
    @SerializedName("course")
    @Expose
    private Course course;
    @SerializedName("created_by")
    @Expose
    private Integer createdBy;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("subject")
    @Expose
    private Subject subject;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("ppt")
    @Expose
    private String ppt;
    @SerializedName("notes")
    @Expose
    private String notes;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Lesson() {
    }

    /**
     * 
     * @param createdAt
     * @param notes
     * @param createdBy
     * @param ppt
     * @param subject
     * @param name
     * @param lessonId
     * @param course
     * @param position
     * @param video
     */
    public Lesson(String lessonId, Course course, Integer createdBy, String createdAt, Subject subject, String name, Integer position, String video, String ppt, String notes) {
        super();
        this.lessonId = lessonId;
        this.course = course;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.subject = subject;
        this.name = name;
        this.position = position;
        this.video = video;
        this.ppt = ppt;
        this.notes = notes;
    }
    /*

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Object getPpt() {
        return ppt;
    }

    public void setPpt(Object ppt) {
        this.ppt = ppt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }*/

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPpt() {
        return ppt;
    }

    public void setPpt(String ppt) {
        this.ppt = ppt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
