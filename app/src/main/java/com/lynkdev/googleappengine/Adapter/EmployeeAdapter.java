package com.lynkdev.googleappengine.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lynkdev.googleappengine.Model.Employee;
import com.lynkdev.googleappengine.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LynkMieu on 11/30/2016.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    ArrayList<Employee> listEmployee;
    Context context;

    public EmployeeAdapter(Context context, ArrayList<Employee> listEmployee) {
        this.context = context;
        this.listEmployee = listEmployee;
    }

    @Override
    public EmployeeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeHolder holder, int position) {
        Employee employee = listEmployee.get(position);
        holder.tv_employeecode.setText(String.valueOf(employee.getEmployeeCode()));
        holder.tv_fullName.setText(employee.getFullName());
    }

    @Override
    public int getItemCount() {
        return listEmployee.size();
    }

    class EmployeeHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_employeecode)
        TextView tv_employeecode;
        @BindView(R.id.txt_fullname)
        TextView tv_fullName;
        public EmployeeHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

