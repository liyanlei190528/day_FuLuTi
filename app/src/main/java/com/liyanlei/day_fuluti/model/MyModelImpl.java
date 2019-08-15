package com.liyanlei.day_fuluti.model;

import com.liyanlei.day_fuluti.api.MyServer;
import com.liyanlei.day_fuluti.bean.RootBean;
import com.liyanlei.day_fuluti.callback.MyCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModelImpl implements MyModel {
    @Override
    public void getDate(final int page, final MyCallBack callBack) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyServer.url)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<RootBean> date = myServer.getDate(page);
        date.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RootBean>() {
                    @Override
                    public void onSubscribe(final Disposable d) {

                    }

                    @Override
                    public void onNext(final RootBean rootBean) {
                        if (callBack!=null){
                            callBack.onSuccrss(rootBean);
                        }
                    }

                    @Override
                    public void onError(final Throwable e) {
                        if (callBack!=null){
                            callBack.Field(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
