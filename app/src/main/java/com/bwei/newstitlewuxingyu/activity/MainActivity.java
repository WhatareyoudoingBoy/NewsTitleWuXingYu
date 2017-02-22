package com.bwei.newstitlewuxingyu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwei.newstitlewuxingyu.R;
import com.bwei.newstitlewuxingyu.frames.Forever;
import com.bwei.newstitlewuxingyu.frames.Home;
import com.bwei.newstitlewuxingyu.frames.Login;
import com.bwei.newstitlewuxingyu.frames.Video;

public class MainActivity extends AppCompatActivity {
    FrameLayout main_frame;
    RadioGroup main_rg;
    RadioButton main_home;
    RadioButton main_video;
    RadioButton main_forever;
    RadioButton main_login;
    private Home home;
    private Forever forever;
    private Video video;
    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView(); //优化控件
        // 设置为默认页面
       home =  new Home();
//
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, home).commit();
//        getSupportFragmentManager().beginTransaction().show(home).commit();
//        getSupportFragmentManager().beginTransaction().hide(forever).commit();
//        getSupportFragmentManager().beginTransaction().hide(video).commit();
//        getSupportFragmentManager().beginTransaction().hide(login).commit();
        onclickRadioButton(); //RadioButton点击事件
        

       
    }
    
    //控件
    void initView(){
        main_frame = (FrameLayout) findViewById(R.id.main_frame);//FrameLayout 布局
        main_rg = (RadioGroup) findViewById(R.id.main_rg);  //RadioGroup 
        main_home = (RadioButton) findViewById(R.id.main_home);  //首页 
        main_forever = (RadioButton) findViewById(R.id.main_forever); // 收藏
        main_video = (RadioButton) findViewById(R.id.main_video); //视频
        main_login = (RadioButton) findViewById(R.id.main_login); //登录
    }
    // RadioButton 点击事件
    void onclickRadioButton(){
        
        main_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.main_home:
//                        home =  new Home();

                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,home).commit();
//                        getSupportFragmentManager().beginTransaction().show(home);
//                        getSupportFragmentManager().beginTransaction().hide(forever);
//                        getSupportFragmentManager().beginTransaction().hide(video);
//                        getSupportFragmentManager().beginTransaction().hide(login);
                        break;
                    case R.id.main_forever:
                        forever = new Forever();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, forever).commit();
//                        getSupportFragmentManager().beginTransaction().show(forever);
//                        getSupportFragmentManager().beginTransaction().hide(home);
//                        getSupportFragmentManager().beginTransaction().hide(video);
//                        getSupportFragmentManager().beginTransaction().hide(login);
                        break;
                    case R.id.main_video:
                         video = new Video();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,video).commit();
//                        getSupportFragmentManager().beginTransaction().show(video);
//                        getSupportFragmentManager().beginTransaction().hide(home);
//                        getSupportFragmentManager().beginTransaction().hide(forever);
//                        getSupportFragmentManager().beginTransaction().hide(login);
                        break;
                    case R.id.main_login:
                         login = new Login();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,login).commit();
//                        getSupportFragmentManager().beginTransaction().show(login);
//                        getSupportFragmentManager().beginTransaction().hide(home);
//                        getSupportFragmentManager().beginTransaction().hide(forever);
//                        getSupportFragmentManager().beginTransaction().hide(video);
                        break;
                    
                }
            }
        });
        
    }
}
