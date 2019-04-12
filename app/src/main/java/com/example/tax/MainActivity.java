package com.example.tax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_salary ;
    Button btn_tax;
    int store;
TextView result;
GetSet getSet = new GetSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_salary = findViewById(R.id.et_salary);
        btn_tax = findViewById(R.id.btn_tax);
        result = findViewById(R.id.tv_tax);
        btn_tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            getSet.setSalary(et_salary.getText().toString());
//                result.setText(getSet.getSalary());
                int calculate;
                calculate = Integer.parseInt(getSet.getSalary());
                int a=calculate;
                store= (a * 12);
                switch (v.getId()){
                    case R.id.btn_tax:
                        if (store>=1 && store<= 200000){
                            int tax  = (store/100);
                            result.setText(" Youre Tax amount is : Rs."+tax);
                            Toast.makeText(MainActivity.this, "calculation done", Toast.LENGTH_SHORT).show();

                    }
                    if (store >= 200000 && store <= 350000)
                    {
                        int tax = (int) (2000 + (store - 200000)* 0.15);
                        result.setText("Youre tax amount is : Rs"+tax );
                        Toast.makeText(MainActivity.this, "calculaion done", Toast.LENGTH_SHORT).show();
                    }
                    if (store >= 350000){
                        int tax = (int) (2000 + 22500 + ((store - 350000)*0.25));
                        result.setText("Youre tax amount is : Rs"+tax );
                        Toast.makeText(MainActivity.this, "calculaion done", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }
}
