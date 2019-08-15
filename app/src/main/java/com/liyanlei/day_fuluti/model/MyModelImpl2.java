package com.liyanlei.day_fuluti.model;

import com.liyanlei.day_fuluti.api.MyServer;
import com.liyanlei.day_fuluti.bean.FuLiBean;

import com.liyanlei.day_fuluti.callback.MyCallBack2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModelImpl2 implements MyModel2 {
    @Override
    public void getDate(final int page, final MyCallBack2 callBack2) {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.url2)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<FuLiBean> resultsBeanObservable = myServer.fuLiDate(page);
        resultsBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuLiBean>() {
                    @Override
                    public void onSubscribe(final Disposable d) {

                    }

                    @Override
                    public void onNext(final FuLiBean resultsBean) {
                            if (callBack2 !=null){
                                callBack2.onSuccrss(resultsBean);
                            }
                    }

                    @Override
                    public void onError(final Throwable e) {
                        if (callBack2 !=null){
                            callBack2.Field(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
