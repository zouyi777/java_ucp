package com.zyyu.ucp.test.kotlin;

public class TestInterFace {


    private void funS(){
        setInter(new MyLister() {
            @Override
            public void fun1() {

            }

            @Override
            public void fun2() {

            }
        });
    }


    private void setInter(MyLister myLister){

    }

    interface MyLister{

        void fun1();

        void fun2();
    }
}
