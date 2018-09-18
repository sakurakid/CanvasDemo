package com.example.hasee.canvasdemo;

/**
 * 构造过程类
 */
public class Director {
    private Builderinterface mbuilderinterface = null;

    Director(Builderinterface builderinterface){
        this.mbuilderinterface = builderinterface;
    }

    Student createCharacter(String name, String face, String clothers){
        this.mbuilderinterface.setName(name);
        this.mbuilderinterface.setFace(face);
        this.mbuilderinterface.setClothers(clothers);

        return mbuilderinterface.build();
    }
}
