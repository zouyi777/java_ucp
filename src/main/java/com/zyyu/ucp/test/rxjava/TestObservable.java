package com.zyyu.ucp.test.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class TestObservable {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> observable = Observable.just("a", "b", "c");

        observable
//                .filter(new Func1<String, Boolean>() {
//                    @Override
//                    public Boolean call(String s) {
//                        return "a".equals(s) || "c".equals(s);
//                    }
//                })
                .map(new Func1<String, Object>() {
                    @Override
                    public Object call(String s) {
                        if("b".equals(s)){
                            return "b_1";
                        }
                        return s;
                    }
                })
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }
                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }
                    @Override
                    public void onNext(Object o) {
                        System.out.println("onNext");
                        System.out.println(o.toString());
                    }
                });
    }
}
