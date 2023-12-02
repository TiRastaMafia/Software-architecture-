package com.example.homework7.domain;



public class Message {

    private static int count = 1000;
    private int Id;


    private String text;


    private String tag;

    {
        Id = ++count;
    }

    public Message() {
    }

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public Integer getId() {
        return Id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setId(Integer id) {
        Id = id;
    }


}
