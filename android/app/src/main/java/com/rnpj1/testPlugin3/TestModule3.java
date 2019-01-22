package com.rnpj1.testPlugin3;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * 原生Activity与React交互——模块
 */

public class TestModule3 extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;    //必须定义
    public TestModule3(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext=reactContext;
    }
    // 自定义方法，出发RN定义的console.log()
    public static void sendEvent(String param){
        WritableMap eventValue=new WritableNativeMap();
        // eventValue.putString("type","nativelog");
        eventValue.putString("value",param);
        if(reactContext!=null){
            reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("consoleYS",eventValue);
        }
    }
    @Override
    public String getName(){
        return "TestModule3";
    }
    //注意：记住getName方法中的命名名称，JS中调用需要

    @ReactMethod
    public void startActivityFromJS(String name,String params){
        try{
            Activity currentActivity = getCurrentActivity();
            if(null!=currentActivity){
                Class toActivity = Class.forName(name);
                Intent intent = new Intent(currentActivity,toActivity);
                currentActivity.startActivity(intent);
            }
        }catch(Exception e){
            throw new JSApplicationIllegalArgumentException(
                    "不能打开Activity : "+e.getMessage());
        }
    }

    
//注意：startActivityFromJS方法添加RN注解(@ReactMethod)，否则该方法将不被添加到RN中
}
