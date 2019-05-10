package expense.tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ExpenseIncomeType extends AppCompatActivity implements View.OnClickListener{

    Button income;
    Button expense;
    LinearLayout expenseTypes;
    LinearLayout incomeTypes;

    LinearLayout salaryIncome;
    LinearLayout businessIncome;
    LinearLayout giftIncome;
    LinearLayout loanIncome;
    LinearLayout taxReturnIncome;
    LinearLayout otherIncome;

    LinearLayout foodExpense;
    LinearLayout clothingExpense;
    LinearLayout transportExpense;
    LinearLayout billExpense;
    LinearLayout entertainExpense;
    LinearLayout travelExpense;
    LinearLayout groceryExpense;
    LinearLayout hobbyExpense;
    LinearLayout workExpense;
    LinearLayout giftExpense;
    LinearLayout maintenanceExpense;
    LinearLayout otherExpense;
    boolean currentPage;
    static String newItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_income_type);

        currentPage = false; //false = income, true = expense
        newItem = "";
        income = findViewById(R.id.incomeButton);
        income.setOnClickListener(this);
        expense = findViewById(R.id.expenseButton);
        expense.setOnClickListener(this);

        expenseTypes = findViewById(R.id.expensePage);
        incomeTypes = findViewById(R.id.incomePage);

        salaryIncome = findViewById(R.id.salaryIncome);
        salaryIncome.setOnClickListener(this);
        businessIncome = findViewById(R.id.businessIncome);
        businessIncome.setOnClickListener(this);
        giftIncome = findViewById(R.id.giftIncome);
        giftIncome.setOnClickListener(this);
        loanIncome = findViewById(R.id.loanIncome);
        loanIncome.setOnClickListener(this);
        taxReturnIncome = findViewById(R.id.taxIncome);
        taxReturnIncome.setOnClickListener(this);
        otherIncome = findViewById(R.id.otherIncome);
        otherIncome.setOnClickListener(this);

        foodExpense = findViewById(R.id.foodExpense);
        foodExpense.setOnClickListener(this);
        clothingExpense = findViewById(R.id.clothingExpense);
        clothingExpense.setOnClickListener(this);
        transportExpense = findViewById(R.id.transportExpense);
        transportExpense.setOnClickListener(this);
        billExpense = findViewById(R.id. billsExpense);
        billExpense.setOnClickListener(this);
        entertainExpense = findViewById(R.id.entertainmentExpense);
        entertainExpense.setOnClickListener(this);
        travelExpense = findViewById(R.id.travelExpense);
        travelExpense.setOnClickListener(this);
        groceryExpense = findViewById(R.id.groceryExpense);
        groceryExpense.setOnClickListener(this);
        hobbyExpense = findViewById(R.id.hobbyExpense);
        hobbyExpense.setOnClickListener(this);
        workExpense = findViewById(R.id.workExpense);
        workExpense.setOnClickListener(this);
        giftExpense = findViewById(R.id.giftExpense);
        giftExpense.setOnClickListener(this);
        maintenanceExpense = findViewById(R.id.maintenanceExpense);
        maintenanceExpense.setOnClickListener(this);
        otherExpense = findViewById(R.id.otherExpense);
        otherExpense.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == income.getId())
        {
            expenseTypes.setVisibility(View.GONE);
            incomeTypes.setVisibility(View.VISIBLE);
            currentPage = false;

        }

        if(v.getId() == expense.getId())
        {
            incomeTypes.setVisibility(View.GONE);
            expenseTypes.setVisibility(View.VISIBLE);
            currentPage = true;
        }

        if(!currentPage)

            switch (v.getId())
            {
                case R.id.salaryIncome:
                    newItem = "salary";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.businessIncome:
                    newItem = "business";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.giftIncome:
                    newItem = "gift";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.loanIncome:
                    newItem = "loan";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.taxIncome:
                    newItem = "tax returns";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.otherIncome:
                    newItem = "other";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

            }

        if (currentPage)
            switch (v.getId())
            {
                case R.id.foodExpense:
                    newItem = "food";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.clothingExpense:
                    newItem = "clothing";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.transportExpense:
                    newItem = "transport";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.entertainmentExpense:
                    newItem = "entertainment";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.billsExpense:
                    newItem = "bill";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.travelExpense:
                    newItem = "travel";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.groceryExpense:
                    newItem = "grocery";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.hobbyExpense:
                    newItem = "hobby";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.workExpense:
                    newItem = "work";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.giftExpense:
                    newItem = "gift";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.maintenanceExpense:
                    newItem = "maintenance";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;

                case R.id.otherExpense:
                    newItem = "other";
                    ExpenseIncomeType.this.startActivity(new Intent(ExpenseIncomeType.this, ContentDescription.class));
                    break;
            }
    }
}