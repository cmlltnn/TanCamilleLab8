package com.tan.camille;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText etFname;
    EditText etAge;
    EditText etGender;
    Button btSave;
    Button btSearch;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.display);
        etFname = findViewById(R.id.fname);
        etAge = findViewById(R.id.age);
        etGender = findViewById(R.id.gender);
        btSave = findViewById(R.id.save);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertRecord();
            }
        });
        btSearch = findViewById(R.id.search);


    }

    public void insertRecord(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference root =  database.getReference("Record");
        String fname = etFname.getText().toString().trim();
        String gender = etGender.getText().toString().trim();
        int age = Integer.parseInt(etAge.getText().toString().trim());

        Record srecord = new Record(fname,gender,age);
        String key = root.push().getKey();
        root.child(key).setValue(srecord);
        Toast.makeText(this,"record added to db",Toast.LENGTH_LONG).show();
    }
}
