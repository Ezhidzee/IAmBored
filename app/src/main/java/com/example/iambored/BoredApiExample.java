package com.example.iambored;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BoredApiExample {

    @SerializedName("activity")
    @Expose
    public String activity;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("participants")
    @Expose
    public Double participants;
    @SerializedName("price")
    @Expose
    public Double price;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("key")
    @Expose
    public String key;
    @SerializedName("accessibility")
    @Expose
    public Double accessibility;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getParticipants() {
        return participants;
    }

    public void setParticipants(Double participants) {
        this.participants = participants;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Double accessibility) {
        this.accessibility = accessibility;
    }

}
