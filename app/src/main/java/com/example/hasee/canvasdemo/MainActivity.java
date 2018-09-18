package com.example.hasee.canvasdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private myView myView;
    private myView2 myView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PieView view = new PieView(this);
        myView2 = new myView2(this);
        setContentView(R.layout.activity_main);

        ArrayList<PieDate> datas = new ArrayList<>();
        PieDate pieData = new PieDate("sloop", 60);
        PieDate pieData2 = new PieDate("sloop", 30);
        PieDate pieData3 = new PieDate("sloop", 40);
        PieDate pieData4 = new PieDate("sloop", 20);
        PieDate pieData5 = new PieDate("sloop", 20);
        datas.add(pieData);
        datas.add(pieData2);
        datas.add(pieData3);
        datas.add(pieData4);
        datas.add(pieData5);
        view.setData(datas);

        //测试构造者模式

        //先new接口
        Builderinterface builderinterface = new ConcreteBuider();
        //创建构建过程对象
        Director director = new Director(builderinterface);
        //创建学生对象
        Student student = director.createCharacter("笑笑","正太脸","格子衬衣");
        Log.d("233",student.showMsg());



    }
}


