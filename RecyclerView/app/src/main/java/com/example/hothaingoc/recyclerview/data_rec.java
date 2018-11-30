package com.example.hothaingoc.recyclerview;

public class data_rec {

    private  int img;
    private  String text;
    private  String symbol;


    public data_rec(int img, String text, String symbol) {
        this.img = img;
        this.text = text;
        this.symbol = symbol;
    }

    public data_rec() {

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
