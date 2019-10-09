package com.ssq.turntestlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = Constance.MODULE_LIBRARYACTIVITY)
public class LibraryActivity extends AppCompatActivity {

    @Autowired
    String strings;

    @Autowired
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_library);
//        Toast.makeText(LibraryActivity.this, getIntent().getStringExtra("strings"), Toast.LENGTH_SHORT).show();
        Toast.makeText(LibraryActivity.this, "strings==" + strings + "   age==" + age, Toast.LENGTH_SHORT).show();
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent().setClassName(LibraryActivity.this, "com.ssq.arouterdemo.Main2Activity"));
                ARouter.getInstance().build(Constance.APP_ACITIVITY_MAIN2).navigation();
            }
        });
    }
}
