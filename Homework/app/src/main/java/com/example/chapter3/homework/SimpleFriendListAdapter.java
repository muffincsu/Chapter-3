package com.example.chapter3.homework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SimpleFriendListAdapter extends BaseAdapter
{
    private List<String> friends;

    private Context context;

    public SimpleFriendListAdapter(Context context, List<String> friends)
    {
        this.context = context;
        this.friends = friends;
    }

    @Override
    public int getCount()
    {
        return friends.size();
    }

    @Override
    public String getItem(int position)
    {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        TextView textView;

        if (convertView == null)
        {
            textView = new TextView(context);
            textView.setPadding(60, 60, 60, 60); // 设置内边距
        }
        else
        {
            textView = (TextView) convertView;
        }

        String friend = getItem(position);
        textView.setText(friend);
        return textView;
    }

}
