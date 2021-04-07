package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText password;
    EditText phone;
    EditText dob;
    Spinner gender;
    boolean showpass=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void onclick_save(View view) {
        if(checkall()){
        Intent intent = new Intent(this, MainActivity2.class);
        String data="Name: "+firstName.getText().toString()+" "+lastName.getText().toString()+"\n"+
                "Date Of Birth: "+dob.getText().toString()+"\n"+
                 "Gender: "+gender.getSelectedItem().toString()+"\n"+
                 "Password: "+password.getText().toString()+"\n"+
                 "Mobile Number: "+phone.getText().toString();
        intent.putExtra("DATA",data);
        startActivity(intent);}
        else
            return;
    }

    public void onclick_showPass(View view) {
       showpass=!showpass;
       if(showpass)
           password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
       else
           password.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    void initialize(){
        firstName=findViewById(R.id.et_firstName);
        lastName=findViewById(R.id.et_lastName);
        password=findViewById(R.id.et_pass);
        phone=findViewById(R.id.et_phone);
        dob=findViewById(R.id.et_dob);
        gender=findViewById(R.id.spinner);
        spinnerData();

    }
    private void spinnerData(){
        ArrayList<String> data = new ArrayList<>();
        data.add("MALE");
        data.add("FEMALE");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item,data);
        gender.setAdapter(adapter);
    }

    boolean checkall(){
        if(firstName.getText().toString().equals("")){
            Toast.makeText(this,"First name is not entered",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(lastName.getText().toString().equals("")){
            Toast.makeText(this,"Last name is not entered",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(dob.getText().toString().equals("")){
            Toast.makeText(this,"Date of Birth is not entered",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password.getText().toString().equals("")){
            Toast.makeText(this,"Password is not entered",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(phone.getText().toString().equals("")){
            Toast.makeText(this,"Phone number is not entered",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}