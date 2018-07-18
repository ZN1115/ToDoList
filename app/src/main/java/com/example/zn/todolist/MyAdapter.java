package com.example.zn.todolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter {
    private List<User> data;
    private LayoutInflater layoutInflater;

    MyAdapter(Context context, List<User> data)
    {
        this.data=data;
        layoutInflater = LayoutInflater.from(context);
    }

    public void action_add_task(String et)
    {
        User user=new User();
        user.itemstring=et;
        data.add(0, user);
        notifyItemInserted(0);


    }
    public void removeItem(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }


    class ItemHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ItemHolder(View View)
        {
            super(View);
            textView = View.findViewById(R.id.textview);
        }

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*簡單說法:將item這個xml檔轉成Java內view這個物件*/
        View view = layoutInflater.inflate(R.layout.item/*這邊是指item的xml檔*/,viewGroup/*你要先幫我挖一塊之後會讓我放*/,false/*是指部要顯示*/);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((ItemHolder)viewHolder)/*這邊把值設定進來*/.textView.setText( data.get(i).itemstring);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }





}
