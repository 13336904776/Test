package com.example.mrzhang.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrzhang.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class OneOneAdapter extends RecyclerView.Adapter<OneOneAdapter.MyViewHolder>{
    List mData;
    Context mContext;
    ClikeListion clikeListion;

    public ClikeListion getClikeListion() {
        return clikeListion;
    }

    public void setClikeListion(ClikeListion clikeListion) {
        this.clikeListion = clikeListion;
    }

    public OneOneAdapter(Context mContext, List<String> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.one_one_item_layout, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(mData.get(i)+"");
        viewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clikeListion != null){
                    clikeListion.onClikeListion(view,i);
                }
            }
        });
        viewHolder.tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(clikeListion != null){
                    clikeListion.onLongClikeListion(view,i);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    public void addData(String text,int postion){
        mData.add(postion,text);
        notifyItemInserted(postion);
    }

    public void removeData(int position){
        mData.remove(position);
        notifyItemRemoved(position);
    }

    public interface ClikeListion{
        void onClikeListion(View view,int position);
        void onLongClikeListion(View view,int position);
    }

}
