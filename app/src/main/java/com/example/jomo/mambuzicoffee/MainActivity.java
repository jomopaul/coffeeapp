package com.example.jomo.mambuzicoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView quantity;
    Button numOfCups;
    TextView price;
    int cups=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity=(TextView)findViewById(R.id.quantity_text_view);
        numOfCups=(Button)findViewById(R.id.number_of_cups);
        price=(TextView)findViewById(R.id.price);
    }

    public void addCups(View view)
    {
     cups=cups +1;
     String strCups=String.valueOf(cups);
     quantity.setText(strCups+"cups odered");
     setPrice(view);
    }
    public void setPrice(View view)
    {
        int priceInt=40*cups;
        String strPrice=String.valueOf(priceInt);
        price.setText("The cost is sh." +strPrice);
    }
    public void removeCups(View view)
    {
        if (cups>=1){
        cups=cups-1;
        String strCups=String.valueOf(cups);
        quantity.setText("remaining cups"+strCups);
        setPrice(view);
    }
    else {
            Toast.makeText(this,
                    "you must oder atleast 1 cup", Toast.LENGTH_SHORT).show();

        }
    }
    public void feedback(View view)
    {
        CheckBox WhippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream=WhippedCreamCheckBox.isChecked();
        Log.v("MainActivity","Has Whipped Cream: " +hasWhippedCream);
Toast.makeText(this,"thank you customer",Toast.LENGTH_SHORT) .show();
        openMessage(view);

    }
    public void openMessage(View view)
    {
        Intent intent=new Intent(  this,Message.class);
        startActivity(intent);
    }
    public void onCheckBoxClicked(View view)
    {
        boolean checked =((CheckBox)view).isChecked();
        switch (view.getId())
        {
            case R.id.whipped_cream_checkbox:
                if (checked)
                        break;
            case R.id.chocolate_checkbox:
                if (checked)
                    break;
        }
    }
}

