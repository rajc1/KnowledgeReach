
package com.example.chetanrajjain.knowledgereach.dummy.Objects;

import com.google.gson.annotations.SerializedName;

public class Proposals{
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCostToComplete() {
        return costToComplete;
    }

    public void setCostToComplete(String costToComplete) {
        this.costToComplete = costToComplete;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @SerializedName("imageURL")
    private String imageURL;
    @SerializedName("title")
    private String title;
    @SerializedName("costToComplete")
    private String costToComplete;
    @SerializedName("stateFullName")
    private String state;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getNoofStudent() {
        return noofStudent;
    }

    public void setNoofStudent(String noofStudent) {
        this.noofStudent = noofStudent;
    }

    @SerializedName("teacherName")
    private String teacherName;
    @SerializedName("numStudents")
    private String noofStudent;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @SerializedName("totalPrice")
    private String total;

    public String getPaymentLink() {
        return paymentLink;
    }

    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }

    @SerializedName("fundURL")
    private String paymentLink;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("shortDescription")
    private  String description;


    public GradeLevel getLevel() {
        return level;
    }

    public void setLevel(GradeLevel level) {
        this.level = level;
    }

    @SerializedName("gradeLevel")
    private GradeLevel level;



        }