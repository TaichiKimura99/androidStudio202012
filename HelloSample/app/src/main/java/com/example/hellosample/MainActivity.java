package com.example.hellosample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloListener listener = new HelloListener();

        //リスナをボタンに設定
        Button btClick = findViewById(R.id.btClick);
        btClick.setOnClickListener(new HelloListener());

        //リスナをクリアボタンに設定

        //リスナをクリアボタンに設定
        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }

    //リスナーのみ　実行はoncreateから
    private class HelloListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            EditText input = findViewById(R.id.etName);
            TextView output = findViewById(R.id.tvOutput);
            int id = v.getId();

            switch(id){
                case R.id.btClick:
                    //入力内容の取得
                    //1.EditTextを取得する

                    //2.EditTextから入力内容を抽出する
                    String inputStr = input.getText().toString();

                    //入力内容の出力
                    //1.TextViewを取得
                    //2.TextViewに入力内容を出力
                    output.setText(inputStr + "さん、こんにちは！");
                    break;
                case R.id.btClear:
                    //入力内容を空にする
                    input.setText("");
                    //出力内容を空に
                    output.setText("");
                    break;
            }

        }
    }
}