package com.ssq.arouterdemo.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Author : Mr.Shen
 * Date : 2019/10/9 10:57
 * Description :
 */
public class MainApplication extends Application {

    //ARouter 调试开关
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter) {
            //下面两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();//打印日志
            //开启调试模式（如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭，否则有安全风险）
            ARouter.openDebug();
        }
        //官方建议在Application中初始化
        ARouter.init(MainApplication.this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        // 低内存的时候执行
        System.out.println("MainApplication === onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        // 程序在内存清理的时候执行
        super.onTrimMemory(level);
        System.out.println("MainApplication === onTrimMemory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        // 程序终止的时候执行
        System.out.println("MainApplication === onTerminate");
    }
}
