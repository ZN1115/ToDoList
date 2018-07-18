package com.example.zn.todolist;

import android.app.Instrumentation;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.InstrumentationInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.zn.todolist.R.layout.note;

public class MainActivity extends AppCompatActivity {
    MyAdapter myAdapter;
    RecyclerView recyclerView;
    Toolbar toolbar;
    EditText editText1;

    private UserDao userDao;
    private AppDatabase AppDatabase;

    public void createDB() {//取得AppDatabase後還在再透過AppDatabase內的public abstract UserDao userDao();去取得Dao內的各種方法
        userDao=AppDatabase.getINSTANCE(this.getApplicationContext()).userDao();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createDB();

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //ArrayList<String>list=new ArrayList<>();

        List<User> userlist=userDao.getAll();


        myAdapter = new MyAdapter(this,userlist);
        recyclerView.setAdapter(myAdapter);





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_add_task: //   Adapter增加

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View v = inflater.inflate(R.layout.note, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Add New Task")
                        .setView(v)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText editText = (EditText) (v.findViewById(R.id.dialogitem));
                                String et;
                                et=editText.getText().toString();
                                myAdapter.action_add_task(et);
                                User user=new User();
                                user.itemstring=et;
                                userDao.insert(user);
                            }
                        })
                        .show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
