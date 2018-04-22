package com.example.welcome.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import java.math.BigDecimal;
public class MainActivity extends AppCompatActivity {




    public String from;
    public String to;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText input = (EditText)findViewById(R.id.input);
                EditText output = (EditText)findViewById(R.id.output);
                Double amount = Double.parseDouble(input.getText().toString());
                if(from == "USD") {

                }
                else if( from == "EUR") {
                    amount = amount*1.23;
                }
                else if (from== "VND"){
                    amount = amount*0.000044;
                }
                else if (from == "CNY"){
                    amount = amount*0.16;
                }
                else if(from == "JPY"){
                    amount = amount*0.0093;
                }


                if(to == "USD") {

                }
                else if( to == "EUR") {
                    amount = amount/1.23;
                }
                else if (to == "VND"){
                    amount = amount/0.000044;
                }
                else if (to == "CNY"){
                    amount = amount/0.16;
                }
                else if(to == "JPY"){
                    amount = amount/0.0093;
                }


                output.setText(amount.toString());
            }
        });
    }
    protected void onResume(){
        super.onResume();
        setUpSpinnerData();

    }
    public void setUpSpinnerData(){
        Spinner from=(Spinner)findViewById(R.id.from);
        Spinner to=(Spinner)findViewById(R.id.to);

        String[] currencyList={"USD", "EUR", "VND", "JPY", "CNY"};
        ArrayAdapter<String> aFrom=new ArrayAdapter<String>(this,R.layout.spinner_list,currencyList);
        from.setAdapter(aFrom);
        from.setOnItemSelectedListener(new ItemSelectedFrom());
        ArrayAdapter<String> aTo=new ArrayAdapter<String>(this,R.layout.spinner_list,currencyList);
        to.setAdapter(aTo);
        to.setOnItemSelectedListener(new ItemSelectedTo());

    }

    public class ItemSelectedFrom implements OnItemSelectedListener{
        public void onNothingSelected(AdapterView<?> av){

        }
        public void onItemSelected(AdapterView<?> av, View view, int position, long id){
            TextView v=(TextView)view;
            from=v.getText().toString();

        }
    }

    public class ItemSelectedTo implements OnItemSelectedListener{
        public void onNothingSelected(AdapterView<?> av){

        }
        public void onItemSelected(AdapterView<?> av, View view, int position, long id){
            TextView v=(TextView)view;
            to=v.getText().toString();

        }
    }

}
