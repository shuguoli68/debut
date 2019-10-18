package com.example.debut.entity;

public class Joke {

    private int id;
    private String jokeId;
    private String jokeStr;
    private Long upTime;
    private String jokeUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJokeId() {
        return jokeId;
    }

    public void setJokeId(String jokeId) {
        this.jokeId = jokeId;
    }

    public String getJokeStr() {
        return jokeStr;
    }

    public void setJokeStr(String jokeStr) {
        this.jokeStr = jokeStr;
    }

    public Long getUpTime() {
        return upTime;
    }

    public void setUpTime(Long upTime) {
        this.upTime = upTime;
    }

    public String getJokeUrl() {
        return jokeUrl;
    }

    public void setJokeUrl(String jokeUrl) {
        this.jokeUrl = jokeUrl;
    }
}
