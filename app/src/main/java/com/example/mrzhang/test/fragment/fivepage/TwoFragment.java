package com.example.mrzhang.test.fragment.fivepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mrzhang.test.R;
import com.example.mrzhang.test.activity.SubNavigationTabStrip;
import com.example.mrzhang.test.fragment.BaseFragment;

/**
 *
 */
public class TwoFragment extends BaseFragment{

    private TextView tv;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.two_fragment, container, false);
        tv = inflate.findViewById(R.id.tv);
        tv.setText("贰");
        initView(inflate,null);
        initListener();
        initData();
        return inflate;

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SubNavigationTabStrip.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
