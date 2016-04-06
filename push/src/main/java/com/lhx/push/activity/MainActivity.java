package com.lhx.push.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lhx.push.R;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * 极光推送
 *
 * 发送通知有Notification提示
 * 发送自定义消息需要程序根据收到的消息进行下一步处理
 *
 */
public class MainActivity extends Activity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        // 设置别名
        JPushInterface.setAlias(this, "test123456", new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                Log.i(TAG, "set alias result is" + i);
            }
        });
        // 设置Tag可以分组
        Set<String> sets = new HashSet<String>();
        sets.add("sports");
        sets.add("game");
        JPushInterface.setTags(this, sets, new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                Log.i(TAG, "set tag result is" + i);
            }
        });
    }
}
