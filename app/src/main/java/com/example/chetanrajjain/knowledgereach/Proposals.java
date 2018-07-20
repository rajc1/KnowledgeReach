
package com.example.chetanrajjain.knowledgereach;

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
    @SerializedName("state")
    private String state;



        }