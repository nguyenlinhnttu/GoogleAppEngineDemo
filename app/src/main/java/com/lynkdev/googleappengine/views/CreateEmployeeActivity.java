package com.lynkdev.googleappengine.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.lynkdev.googleappengine.Model.Employee;
import com.lynkdev.googleappengine.R;
import com.lynkdev.googleappengine.presenter.CreateEmployeePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateEmployeeActivity extends AppCompatActivity {

    CreateEmployeePresenter presenter;
    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_fullname)
    EditText edtFullname;
    @BindView(R.id.edt_employcode)
    EditText edtEmploycode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_riddle);
        ButterKnife.bind(this);
        presenter = new CreateEmployeePresenter(this);

    }

    @OnClick(R.id.btn_create)
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setFullName(edtFullname.getText().toString());
        employee.setEmployeeCode(edtEmploycode.getText().toString());
        employee.setPhoneNumber(Integer.parseInt(edtPhone.getText().toString()));
        presenter.createEmployeeData(employee);
    }

}
