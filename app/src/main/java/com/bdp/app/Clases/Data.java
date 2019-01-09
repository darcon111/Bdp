package com.bdp.app.Clases;

public class Data {

    private String text;
    private String cost;
    private String money;
    private Boolean black;

    public Data(String text, String cost, String money, Boolean black) {
        this.text = text;
        this.cost = cost;
        this.money = money;
        this.black = black;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Boolean getBlack() {
        return black;
    }

    public void setBlack(Boolean black) {
        this.black = black;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
