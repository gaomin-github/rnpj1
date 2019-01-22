package com.rnpj1.testPlugin1;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 1、 原生页面与RN 跳转交互
 * 2、 黑白主题切换
 */

public class TestActivity1 extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createView());
    }
    private View createView() {
        LinearLayout ll= new LinearLayout(this);
        ll.setGravity(Gravity.CENTER);
        ll.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        // 设置文字
        TextView mTextView = new TextView(this);
        mTextView.setText("hello world");
        LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        // 在父类布局中添加它，及布局样式
        ll.addView(mTextView, mLayoutParams);

        return ll;
    }
    @Override
    public void onClick(View v) {

        
    }



}


