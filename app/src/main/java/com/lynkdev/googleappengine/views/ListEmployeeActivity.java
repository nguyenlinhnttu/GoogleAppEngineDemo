package com.lynkdev.googleappengine.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lynkdev.googleappengine.R;
import com.lynkdev.googleappengine.presenter.ListEmployeePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListEmployeeActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    ListEmployeePresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_riddle);
        ButterKnife.bind(this);
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mainPresenter = new ListEmployeePresenter(this);

    }
    @OnClick(R.id.btnGetData)
    public void getData() {
        mainPresenter.fetchData(recyclerView);
    }
    @OnClick(R.id.btnCreateRiddle)
    public void show() {
        Intent intent = new Intent(this,CreateEmployeeActivity.class);
        startActivity(intent);
    }
}
