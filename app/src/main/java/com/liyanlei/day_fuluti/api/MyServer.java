package com.liyanlei.day_fuluti.api;

import com.liyanlei.day_fuluti.bean.FuLiBean;
import com.liyanlei.day_fuluti.bean.RootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyServer {

    public String url = "https://www.wanandroid.com/";



    @GET("project/list/{page}/json?cid=294")
    Observable<RootBean> getDate(@Path("page") int page);

    public String url2 = "http://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/{page}")
    Observable<FuLiBean> fuLiDate(@Path("page") int page);
}
