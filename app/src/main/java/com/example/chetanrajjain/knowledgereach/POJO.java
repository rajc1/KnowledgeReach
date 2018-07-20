package com.example.chetanrajjain.knowledgereach;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class POJO{
    @SerializedName("searchTerms")
    private  String searchTerm;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public ArrayList<Proposals> getProposals() {
        return proposals;
    }

    public void setProposals(ArrayList<Proposals> proposals) {
        this.proposals = proposals;

    }

    @SerializedName("proposals")
    private ArrayList<Proposals> proposals = new ArrayList<>();

        }