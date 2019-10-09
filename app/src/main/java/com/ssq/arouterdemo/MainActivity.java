package com.ssq.arouterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ssq.turntestlibrary.Constance;

import javax.security.auth.callback.Callback;

@Route(path = Constance.APP_ACITIVITY_MAIN)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ARouter.getInstance().inject(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClassName(MainActivity.this, "com.ssq.turntestlibrary.LibraryActivity");
//                intent.putExtra("strings", "来自app的跳转");
//                startActivity(intent);
                ARouter.getInstance().build(Constance.MODULE_LIBRARYACTIVITY)
                        .withString("strings", "来自app的跳转")
                        .navigation();

//                ARouter.getInstance()
//                        .build("")
//                        .navigation(MainActivity.this,100);//=startActivityForResult

//                ARouter.getInstance()
//                        .build("")
//                        .navigation(MainActivity.this, new NavCallback() {
//                            @Override
//                            public void onFound(Postcard postcard) {
//                                super.onFound(postcard);
//                                Log.e("zhao", "onArrival: 找到了 ");
//                            }
//
//                            @Override
//                            public void onLost(Postcard postcard) {
//                                super.onLost(postcard);
//                                Log.e("zhao", "onArrival: 找不到了 ");
//                            }
//
//                            @Override
//                            public void onInterrupt(Postcard postcard) {
//                                super.onInterrupt(postcard);
//                                Log.e("zhao", "onArrival: 被拦截了 ");
//                            }
//
//                            @Override
//                            public void onArrival(Postcard postcard) {
//                                Log.e("zhao", "onArrival: 跳转完了 ");
//                            }
//                        });

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ARouter.getInstance().destroy();
    }
}
