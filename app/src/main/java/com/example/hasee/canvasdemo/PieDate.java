package com.example.hasee.canvasdemo;

public class PieDate{
    private String name;     //名字
    private  float value;    //数值
    private float mpercentage; //百分比

    private int color = 0;   //颜色
    private float angle = 0;  //角度


    public  PieDate(String name,float value){
        this.value = value;
        this.name = name;
    }

    public float getAngle() {
        return angle;
    }

    public float getPercentage() {
        return mpercentage;
    }

    public float getValue() {
        return value;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercentage(float percentage) {
        this.mpercentage = percentage;
    }

    public void setValue(float value) {
        this.value = value;
    }
}