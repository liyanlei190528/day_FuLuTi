package com.liyanlei.day_fuluti.presenter;

import com.liyanlei.day_fuluti.bean.FuLiBean;
import com.liyanlei.day_fuluti.bean.RootBean;
import com.liyanlei.day_fuluti.callback.MyCallBack;
import com.liyanlei.day_fuluti.callback.MyCallBack2;
import com.liyanlei.day_fuluti.model.MyModel;
import com.liyanlei.day_fuluti.model.MyModel2;
import com.liyanlei.day_fuluti.view.MyView;
import com.liyanlei.day_fuluti.view.MyView2;

public class MyPresenterImpl2 implements MyPresenter2, MyCallBack2 {
    private MyModel2 myModel2;
    private MyView2 myView2;

    public MyPresenterImpl2(MyModel2 myModel2, MyView2 myView2) {
        this.myModel2 = myModel2;
        this.myView2 = myView2;
    }

    @Override
    public void getDate(final int page) {
        if (myModel2!=null){
            myModel2.getDate(page,this);
        }
    }

    @Override
    public void onSuccrss(final FuLiBean fuLiBean) {
        if (myView2 !=null){
            myView2.onSuccrss(fuLiBean);
        }
    }

    @Override
    public void Field(final String msg) {
        if (myView2 !=null){
            myView2.Field(msg);
        }
    }
}
