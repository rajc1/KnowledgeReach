package com.example.chetanrajjain.knowledgereach.dummy.Objects;

import com.google.gson.annotations.SerializedName;

public class GradeLevel {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String level;
}
