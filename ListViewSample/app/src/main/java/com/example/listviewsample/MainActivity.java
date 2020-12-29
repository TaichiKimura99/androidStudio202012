package com.example.listviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //データを作成（DBから取得した想定）
        List<String> menuList = new ArrayList<>();
        menuList.add("唐揚げ定食");
        menuList.add("ハンバーグ定食");
        menuList.add("生姜焼き定食");
        menuList.add("ステーキ定食");

        ListView lvMenu = findViewById(R.id.lvMenu);
        lvMenu.setOnItemClickListener(new ListItemClickListener());

        //第１引数：アクティビティ
        //第２引数：リストビューのアイテム一つのID、リストビューの中一つ一つにIDは設定していないが、javaが勝手にIDを設定する
        //第３引数：リストビューに反映したいリスト
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,menuList);
        lvMenu.setAdapter(adapter);
    }

    //リスナーを作る
    private class ListItemClickListener implements AdapterView.OnItemClickListener{

        /**
         *
         * @param parent リストビュー（イベントがあった要素の親）
         * @param view イベントがあった要素
         * @param position イベントがあった行番号
         * @param id データベース関連のID
         */
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            // 選択された定食名を取得
            //必ずしもStringが入っている訳ではない。
            String item = (String)parent.getItemAtPosition(position);
            //String item = view.getText().toString()でも可

            String show = "あなたが選んだ定食：" + item;

            //トーストの表示
            // 第１引数：トーストを表示したいアクティビティ
            // 第２引数：トーストに表示するメッセージ
            // 第３引数：トーストの長さ（大きさ）
            Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();

        }
    }
}