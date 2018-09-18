package com.example.hasee.canvasdemo;

/**
 * 构建者模式的产品类
 */
public class Student {
    private String name;

    private String face;

    private String clothers;

    public void setName(String name) {
        this.name = name;
    }

    public void setClothers(String clothers) {
        this.clothers = clothers;
    }

    public void setFace(String face) {
        this.face = face;
    }

    String showMsg(){
        return "这里有个叫" + name + "的小学生" + "长的一张" + face + "穿着一身" + clothers + "哈哈哈哈";
    }
}
