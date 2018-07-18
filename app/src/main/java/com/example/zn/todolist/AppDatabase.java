package com.example.zn.todolist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.graphics.Color;

@Database(entities = User.class,version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase INSTANCE;
    private static final Object sLock=new Object();
    public abstract UserDao userDao();

    public static AppDatabase getINSTANCE(Context context)
    {
        if(INSTANCE == null){
            INSTANCE=Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"user.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
