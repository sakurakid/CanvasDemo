package com.example.hasee.canvasdemo;

/**
 * 抽象接口
 */
public interface Builderinterface {
    void setName(String name);

    void setFace(String face);

    void setClothers(String clothers);


    Student build();
}
