package com.example.mrzhang.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrzhang.test.R;
import com.example.mrzhang.test.bean.MyDataBean;

import java.util.List;

/**
 *
 */
public class OneOne1Adapter extends RecyclerView.Adapter<OneOne1Adapter.MyViewHolder>{
    MyDataBean myDataBean;
    Context mContext;
    ClikeListion clikeListion;

    public ClikeListion getClikeListion() {
        return clikeListion;
    }

    public void setClikeListion(ClikeListion clikeListion) {
        this.clikeListion = clikeListion;
    }

    public OneOne1Adapter(Context mContext, MyDataBean myDataBean) {
        this.myDataBean = myDataBean;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.one_one1_item_layout, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(myDataBean.getData().get(i).getTitle());
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

        viewHolder.rv.setLayoutManager(new LinearLayoutManager(mContext));
        List<String> subdata = myDataBean.getData().get(i).getSubdata();
        OneOne11Adapter oneOne11Adapter = new OneOne11Adapter(mContext,subdata);
        viewHolder.rv.setAdapter(oneOne11Adapter);
    }

    @Override
    public int getItemCount() {
        return myDataBean.getData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        RecyclerView rv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            rv = itemView.findViewById(R.id.rv);
        }
    }



    public interface ClikeListion{
        void onClikeListion(View view, int position);
        void onLongClikeListion(View view, int position);
    }

}
