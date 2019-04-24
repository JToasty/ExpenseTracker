package expense.tracker;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        addButton = findViewById(R.id.floatingAdd);
        addButton.setOnClickListener(this);
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
