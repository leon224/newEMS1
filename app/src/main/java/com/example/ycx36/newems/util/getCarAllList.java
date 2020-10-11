package com.example.ycx36.newems.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

public class getCarAllList implements interface_getCarAllListData {

    private Context context ;

    public getCarAllList(Context context){
        this.context = context;
    }
    @Override
    public void getCarAllListData_save(int page,int pagesize) {
        requestGetCarAllListBean requestGetCarAllList = new requestGetCarAllListBean();
        requestGetCarAllList.setRequest(new requestGetCarAllListBean.RequestBean());
        requestGetCarAllList.getRequest().setCommon(new requestGetCarAllListBean.RequestBean.CommonBean());
        requestGetCarAllList.getRequest().getCommon().setAction("getCarAllList");      //设置第一参数 "action":"getCarAllList"
        requestGetCarAllList.getRequest().getCommon().setReqtime("20200709232120");    //设置第二参数 "reqtime":"20200709232120"

        requestGetCarAllList.getRequest().setContent(new requestGetCarAllListBean.RequestBean.ContentBean());
        requestGetCarAllList.getRequest().getContent().setId(null);      //设置id
        requestGetCarAllList.getRequest().getContent().setPage(page);   //设置用户名
        requestGetCarAllList.getRequest().getContent().getPagesize(pagesize);  //设置用户密码


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://101.132.137.176:10003/")
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
                .build();
        interface_retrofit rxjavaService = retrofit.create(interface_retrofit.class);
        rxjavaService.getCarAllList(requestGetCarAllList)
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Subscriber<getCarAllListBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("错误          ", e.getMessage());
                    }

                    @Override
                    public void onNext(getCarAllListBean data) {
                        if (data.getResponse().getContent() != null) {
                            //存储信息
                            saveUserData("UID", "uid", data.getResponse().getContent().getUid()); //设备车VIN码（唯一号）
                            saveUserData("UPDATETIME", "updatetime", data.getResponse().getContent().getUpdatetime()); //更新时间
                            saveUserData("TOTALCURRENT", "totalcurrent", data.getResponse().getContent().getTotalcurrent()); //电流状态 1：正常 0：不正常
                            saveUserData("TOTALVOLTAGE", "totalvoltage", data.getResponse().getContent().getTotalvoltage()); //电压状态 1：正常 0：不正常
                            saveUserData("VEHICLESTATUS", "vehiclestatus", data.getResponse().getContent().getVehiclestatus()); //车辆状态
                            saveUserData("CHARGINGSTATE", "chargingstate", data.getResponse().getContent().getChargingstate()); //充电状态
                            saveUserData("MODEL", "model", data.getResponse().getContent().getModel()); //运行模式
                            saveUserData("SPEED", "speed", data.getResponse().getContent().getSpeed()); //车速
                            saveUserData("MILEAGE", "mileage", data.getResponse().getContent().getMileage()); //累计里程
                            saveUserData("VOLTAGE", "voltage", data.getResponse().getContent().getVoltage()); //总电压
                            saveUserData("CURRENT", "current", data.getResponse().getContent().getCurrent()); //总电流
                            saveUserData("AFTERCURRENT", "aftercurrent", data.getResponse().getContent().getAftercurrent()); //剩余电流
                            saveUserData("QID", "qid", data.getResponse().getContent().getQid()); //驱动电机序号
                            saveUserData("TEMPERATURE", "temperature", data.getResponse().getContent().getTemperature()); //驱动电机控制器温度
                            saveUserData("MOTORSPEED", "motorspeed", data.getResponse().getContent().getMotorspeed());  //驱动电机转速
                            saveUserData("MOTOTTORQUE", "motortorque", data.getResponse().getContent().getMotortorque());  //驱动电机转矩
                            saveUserData("MOTORTEM", "motortem", data.getResponse().getContent().getMotortem()); //驱动电机温度
                            saveUserData("MOTORVM", "motorvm", data.getResponse().getContent().getMotorvm()); //电机控制器输入电压
                            saveUserData("MOTORAM", "motoram", data.getResponse().getContent().getMotoram()); //电机控制器直流母线电流
                            saveUserData("LONGITUDE", "longitude", data.getResponse().getContent().getLongitude()); //经度
                            saveUserData("LATITUDE", "latitude", data.getResponse().getContent().getLatitude()); //纬度
                            saveUserData("UNITVM", "Unitvm", data.getResponse().getContent().getUnitvm()); //最高单体电压
                            saveUserData("UNITID", "Unitid", data.getResponse().getContent().getUnitid()); //最低单体电压序号
                            saveUserData("UNITVMLOW", "Unitvmlow", data.getResponse().getContent().getUnitvmlow()); //最低单体电压
                            saveUserData("UNITTEMID", "Unittemid", data.getResponse().getContent().getUnittemid()); //最高单体温度探针序号
                            saveUserData("UNITTEM", "Unittem", data.getResponse().getContent().getUnittem()); //最高电池单体温度
                            saveUserData("UNITIDLOW", "Unitidlow", data.getResponse().getContent().getUnitidlow()); //最低单体温度探针序号
                            saveUserData("UNITTEMLOW", "Unittemlow", data.getResponse().getContent().getUnittemlow()); //最低电池单体温度
                        } else {
                            //存储信息
                            saveUserData("UID", "uid", ""); //设备车VIN码（唯一号）
                            saveUserData("UPDATETIME", "updatetime", ""); //更新时间
                            saveUserData("TOTALCURRENT", "totalcurrent", ""); //电流状态 1：正常 0：不正常
                            saveUserData("TOTALVOLTAGE", "totalvoltage", ""); //电压状态 1：正常 0：不正常
                            saveUserData("VEHICLESTATUS", "vehiclestatus", ""); //车辆状态
                            saveUserData("CHARGINGSTATE", "chargingstate", ""); //充电状态
                            saveUserData("MODEL", "model", ""); //运行模式
                            saveUserData("SPEED", "speed", ""); //车速
                            saveUserData("MILEAGE", "mileage", ""); //累计里程
                            saveUserData("VOLTAGE", "voltage", ""); //总电压
                            saveUserData("CURRENT", "current", ""); //总电流
                            saveUserData("AFTERCURRENT", "aftercurrent", ""); //剩余电流
                            saveUserData("QID", "qid",""); //驱动电机序号
                            saveUserData("TEMPERATURE", "temperature", ""); //驱动电机控制器温度
                            saveUserData("MOTORSPEED", "motorspeed", "");  //驱动电机转速
                            saveUserData("MOTOTTORQUE", "motortorque", "");  //驱动电机转矩
                            saveUserData("MOTORTEM", "motortem", ""); //驱动电机温度
                            saveUserData("MOTORVM", "motorvm", ""); //电机控制器输入电压
                            saveUserData("MOTORAM", "motoram", ""); //电机控制器直流母线电流
                            saveUserData("LONGITUDE", "longitude", ""); //经度
                            saveUserData("LATITUDE", "latitude", ""); //纬度
                            saveUserData("UNITVM", "Unitvm", ""); //最高单体电压
                            saveUserData("UNITID", "Unitid", ""); //最低单体电压序号
                            saveUserData("UNITVMLOW", "Unitvmlow", ""); //最低单体电压
                            saveUserData("UNITTEMID", "Unittemid", ""); //最高单体温度探针序号
                            saveUserData("UNITTEM", "Unittem", ""); //最高电池单体温度
                            saveUserData("UNITIDLOW", "Unitidlow", ""); //最低单体温度探针序号
                            saveUserData("UNITTEMLOW", "Unittemlow", ""); //最低电池单体温度
                        }
                    }
                });
    }

    @Override
    public void getCarAllListData_read() {

    }

    public void saveUserData(String NAME,String name,String data){
        SharedPreferences.Editor editor = context.getSharedPreferences(NAME,MODE_PRIVATE).edit();
        editor.putString(name,data);
        editor.apply();
    }
}
