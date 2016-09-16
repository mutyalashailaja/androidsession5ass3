package com.example.admin.contextmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.admin.contextmenu.Adapter.StudentAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mListview;
    ArrayList<Student> mArraylist;
    StudentAdapter mStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListview=(ListView)findViewById(R.id.listView);
        mArraylist=new ArrayList<>();
        mArraylist.add(new Student(" shailaja","8121928339"));
        mArraylist.add(new Student(" santosh","9121928339"));
        mArraylist.add(new Student(" sairam","6121928339"));
        mArraylist.add(new Student(" shailu","8521928339"));
        mStudentAdapter=new StudentAdapter(this,mArraylist);
        mListview.setAdapter(mStudentAdapter);

        registerForContextMenu(mListview);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select The Option");
        menu.add(1,100,1,"CALL");
        menu.add(1,101,2,"SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == 100) {
            Intent i = new Intent(Intent.ACTION_CALL,Uri.parse("call"));
            startActivity(i);
        }
        if (id == 101) {

            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:"));

            startActivity(sendIntent);
        }
        return true;
    }}
