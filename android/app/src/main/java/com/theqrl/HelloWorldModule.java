package com.theqrl;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class HelloWorldModule extends ReactContextBaseJavaModule {

    static {
        // load the C-library
        System.loadLibrary("hello_world_jni");
    }

    public HelloWorldModule(ReactApplicationContext reactContext) {
        super(reactContext); //required by React Native
    }

    @Override
    public String getName() {
        return "HelloWorld"; //HelloWorld is how this module will be referred to from React Native
    }

    // This is to return data from Java to Javascript
//    @ReactMethod
//    public void helloWorld(Callback errorCallback, Callback successCallback) { //this method will be called from JS by React Native
//        try {
//            String hello = helloWorldJNI();
//            successCallback.invoke(hello);
//            //promise.resolve(hello);
//        } catch (Exception e) {
//            errorCallback.invoke(e.getMessage());
//            //promise.reject("ERR", e);
//        }
//        //promise.resolve("Hello World!");
//    }

    @ReactMethod
    public void helloWorld(Promise promise) {
        try {
            System.out.println("HAHAAAAA");

            String hello = helloWorldJNI();
            promise.resolve(hello);
        } catch (Exception e) {
            promise.reject("ERR", e);
        }
    }
    public native String helloWorldJNI();

//    public void helloWorld(Promise promise) { //this method will be called from JS by React Native
//        promise.resolve("Hello World!");
//    }


}
