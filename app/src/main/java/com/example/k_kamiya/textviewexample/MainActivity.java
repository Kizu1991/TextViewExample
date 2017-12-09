package com.example.k_kamiya.textviewexample;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;

import com.example.k_kamiya.textviewexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 動的テキスト設定！
        mBinding.text1.setText("動的HelloWorld！！");
        // strings.xmlのリソースも指定できる！
        mBinding.text2.setText(R.string.app_name);

        //HTML指定
        String html = "普通のテキスト<B>太字</B><BIG>大きく</BIG><font color=\"red\">赤</font>";
        mBinding.text3.setText(Html.fromHtml(html));

        // テキストサイズ指定
        mBinding.text4.setTextSize(20);

        // 太字
        mBinding.text5.setTypeface(Typeface.DEFAULT_BOLD);

        // 独自フォント設定
        Typeface typeface = Typeface.createFromAsset(getAssets(), "APJapanesefont.ttf");
        mBinding.text6.setTypeface(typeface);

        // ARGBで指定
        mBinding.text7.setTextColor(0xffff0000);
        // colors.xmlリソースから色設定 少し長くなる癖がある！
        mBinding.text8.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        // Colorクラスを使った設定方法
        mBinding.text9.setTextColor(Color.parseColor("#00ff00"));

        // AppendでTextViewの文字を連結する事ができる
        for (int i = 0; i < 3; i++) {
            mBinding.text10.append("Appendで追加！");
            mBinding.text10.append(String.valueOf(i));
            mBinding.text10.append("\n");
        }


    }
}
