package expense.tracker;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton addButton;

    private RecyclerView recyclerView;
    private TransactionAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<TransactionData> listData = new ArrayList<TransactionData>();

    TextView incomeView;
    TextView expenseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initData();

        addButton = findViewById(R.id.floatingAdd);
        addButton.setOnClickListener(this);

        incomeView = findViewById(R.id.income);
        expenseView = findViewById(R.id.expenses);
        incomeView.setText(Landing.dbHelper.getIncome() + "");
        expenseView.setText("-" + Landing.dbHelper.getExpense());

        recyclerView = findViewById(R.id.transactionRecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TransactionAdapter(listData);
        recyclerView.setAdapter(adapter);
    }

    private void initData()
    {
        listData.add(new TransactionData(R.drawable.businessicon, "Business", "500 USD", "New client"));
        listData.add(new TransactionData(R.drawable.groceryicon, "Business", "-100 USD", "Weekly groceries"));
        listData.add(new TransactionData(R.drawable.foodicon, "Food", "-7.99 USD", "Taco Bell"));
        listData.add(new TransactionData(R.drawable.gifticon, "Gift", "-30 USD", "Mothers day gift"));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == addButton.getId())
        {
            Intent startIntent = new Intent(Dashboard.this, ExpenseIncomeType.class);
            Dashboard.this.startActivity(startIntent);
        }
    }
}
