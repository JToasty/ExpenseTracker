package expense.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class ContentDescription extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView item;
    ImageView itemIcon;
    Button save;
    Spinner currency;
    TextView typeView;
    TextView descCurrency;
    EditText amountContent;
    EditText descContent;

    String[] currencies;
    ArrayAdapter<String> adapter;

    String amount;
    String desc;
    String type;
    String currencyString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_description);

        currencies  = new String[]{"USD", "EUR", "JPY", "GBP", "CHF", " CAD", "AUD", "ZAR"};
        adapter  = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencies);

        item = findViewById(R.id.descItem);
        itemIcon = findViewById(R.id.descIcon);
        save = findViewById(R.id.save);
        currency = findViewById(R.id.currencyButton);
        descCurrency = findViewById(R.id.currencyText);
        typeView = findViewById(R.id.typeDesc);
        amountContent = findViewById(R.id.amountContent);
        descContent = findViewById(R.id.descContent);


        currency.setAdapter(adapter); //display currency types

        Intent intent = getIntent(); //getting info from Expense/Income Activity
        Bundle bundle = getIntent().getExtras(); //Getting image id from Expense/Income Activity

        typeView.setText(intent.getStringExtra("page"));
        item.setText(intent.getStringExtra("itemName"));
        itemIcon.setImageResource(bundle.getInt("image"));

        currency.setOnItemSelectedListener(this);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == save.getId())
        {
            save();
            if(typeView.getText().equals("Expense"))
                Landing.dbHelper.addExpense(Landing.currentUser, type, amount, currencyString, desc);

            if(typeView.getText().equals("Income"))
                Landing.dbHelper.addIncome(Landing.currentUser, type, amount, currencyString, desc);

        }

    }

    private void save()
    {
        type = item.getText().toString();
        currencyString = descCurrency.getText().toString();
        amount = amountContent.getText().toString();
        desc = descContent.getText().toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String str = currency.getSelectedItem().toString();
        descCurrency.setText(str);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //do nothing
    }
}
