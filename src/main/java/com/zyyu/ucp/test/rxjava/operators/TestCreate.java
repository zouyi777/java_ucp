package com.zyyu.ucp.test.rxjava.operators;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observables.SyncOnSubscribe;

public class TestCreate {

    public static void main(String[] args) {

        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {

            }
        }).subscribe(new Observer() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted...");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError..."+throwable.toString());
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext..."+o.toString());
            }
        });
    }
}
