package com.example.androidproject;

public class Item
{
    String text;
    int image;

    public Item(String text, int image)
    {
        this.text = text;
        this.image = image;

    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
