package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_ist);

        //リストを作り、データ追加する
        List<String> itemList = new ArrayList<>();
        itemList.add("Java book");
        itemList.add("Ruby book");
        itemList.add("PHP book");
        ListView lvItem = findViewById(R.id.lvItem);

        lvItem.setOnItemClickListener(new ListItemClickListener());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ItemListActivity.this,android.R.layout.simple_list_item_1,itemList);
        lvItem.setAdapter(adapter);

    }
    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        /**
         *
         * @param parent リストビュー
         * @param view　イベントがあった要素
         * @param position　イベントがあった行番号
         * @param id
         */
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //選択された本の名前を取得
            String item = (String)parent.getItemAtPosition(position);

            String show = "選択された商品" + item;

            Toast.makeText(ItemListActivity.this,show,Toast.LENGTH_LONG).show();

        }
    }
}