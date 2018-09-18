package com.example.hasee.canvasdemo;

/**
 * 接口实现类
 */
public class ConcreteBuider implements Builderinterface {
   private Student mstudent = new Student();
    @Override
    public void setName(String name) {
        mstudent.setName(name);
    }

    @Override
    public void setFace(String face) {
        mstudent.setFace(face);

    }

    @Override
    public void setClothers(String clothers) {
        mstudent.setClothers(clothers);

    }

    @Override
    public Student build() {
        return mstudent;
    }
}
