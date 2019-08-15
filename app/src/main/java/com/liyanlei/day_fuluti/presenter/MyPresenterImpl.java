package com.liyanlei.day_fuluti.presenter;

import com.liyanlei.day_fuluti.bean.RootBean;
import com.liyanlei.day_fuluti.callback.MyCallBack;
import com.liyanlei.day_fuluti.model.MyModel;
import com.liyanlei.day_fuluti.view.MyView;

public class MyPresenterImpl implements MyPresenter, MyCallBack {
    private MyModel myModel;
    private MyView myView;

    public MyPresenterImpl( MyModel myModel,  MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void getDate(final int page) {
        if (myModel!=null){
            myModel.getDate(page,this);
        }
    }

    @Override
    public void onSuccrss(final RootBean rootBean) {
        if (myView !=null){
            myView.onSuccrss(rootBean);
        }
    }

    @Override
    public void Field(final String msg) {
        if (myView !=null){
            myView.Field(msg);
        }
    }
}
