package com.example.ycx36.newems.util;


import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface interface_retrofit {

    //查历史数据  http://120.79.62.86:10003/getCarAllList
    @POST("/getCarAllList")
    Observable<getCarAllListBean> getCarAllList(
            @Body requestGetCarAllListBean requestGetCarAlListBean
    );

    //查车况  http://120.79.62.86:10003/getCarAll
    @POST("/getCarAll")
    Observable<getCarAllBean> getCarAll(
            @Body requestGetCarAllBean requestGetCarAllBean
    );

    //注册接口。。。 http://120.79.62.86:10003/registerUser
    @POST("/registerUser")
    Observable<regesterUserBean> regesterUser(
            @Body requestRegisterUserBean requestRegisterUserBean
    );
}
