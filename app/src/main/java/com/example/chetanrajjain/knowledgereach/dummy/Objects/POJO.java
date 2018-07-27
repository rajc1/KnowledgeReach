package com.example.chetanrajjain.knowledgereach.dummy.Objects;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class POJO implements Parcelable
{
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}