package com.example.a16047.listview_chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16047 on 2018/3/8.
 */

public class ChatItemListViewAdapter extends BaseAdapter {
    private List<ChatItemListViewBean> mData;
    private LayoutInflater mInflater;
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public ChatItemListViewAdapter(Context context,List<ChatItemListViewBean> mData){
        this.mData=mData;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        ChatItemListViewBean bean=mData.get(position);
        return bean.getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            if(getItemViewType(i)==0) {
                holder = new ViewHolder();
                view = mInflater.inflate(R.layout.chat_item_itemin, null);
                holder.icon = (ImageView) view.findViewById(R.id.icon_in);
                holder.text = (TextView) view.findViewById(R.id.text_in);
            }else {
                holder = new ViewHolder();
                view = mInflater.inflate(R.layout.chat_item_itemout, null);
                holder.icon = (ImageView) view.findViewById(R.id.icon_out);
                holder.text = (TextView) view.findViewById(R.id.text_out);
            }
            view.setTag(holder);
        }else {
            holder=(ViewHolder) view.getTag();
        }
        holder.icon.setImageBitmap(mData.get(i).getIcon());
        holder.text.setText(mData.get(i).getText());
        return view;
    }

    public final class ViewHolder{
        public ImageView icon;
        public TextView text;
    }
}
