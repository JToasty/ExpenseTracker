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
        if (v.getId() == income.getId()) {
            expenseTypes.setVisibility(View.GONE);
            incomeTypes.setVisibility(View.VISIBLE);
            currentPage = false;
            return;
        }

        if (v.getId() == expense.getId()) {
            incomeTypes.setVisibility(View.GONE);
            expenseTypes.setVisibility(View.VISIBLE);
            currentPage = true;
            return;
        }


        if (!currentPage) {
            Intent descIntent = new Intent(ExpenseIncomeType.this, ContentDescription.class);
            descIntent.putExtra("page", "Income");
            Bundle bundle = new Bundle();
            switch (v.getId()) {
                case R.id.salaryIncome:
                    descIntent.putExtra("itemName", "Salary");
                    bundle.putInt("itemImage", R.drawable.salaryicon);
                    descIntent.putExtras(bundle);
                    break;

                case R.id.businessIncome:
                    descIntent.putExtra("itemName", "Business");
                    bundle.putInt("itemImage", R.drawable.businessicon);
                    descIntent.putExtras(bundle);
                    break;

                case R.id.giftIncome:
                    descIntent.putExtra("itemName", "Gift");
                    bundle.putInt("itemImage", R.drawable.gifticon);
                    descIntent.putExtras(bundle);
                    break;

                case R.id.loanIncome:
                    descIntent.putExtra("itemName", "Loan");
                    bundle.putInt("itemImage",R.drawable.loanicon);
                    descIntent.putExtras(bundle);
                    break;

                case R.id.taxIncome:
                    descIntent.putExtra("itemName", "Tax Return");
                    bundle.putInt("itemImage",R.drawable.taxreturnicon);
                    descIntent.putExtras(bundle);
                    break;

                case R.id.otherIncome:
                    descIntent.putExtra("itemName", "other");
                    bundle.putInt("itemImage",R.drawable.othericon);
                    descIntent.putExtras(bundle);
                    break;

            }
            ExpenseIncomeType.this.startActivity(descIntent);
        }

        if (currentPage) {
            Intent descIntent2 = new Intent(ExpenseIncomeType.this, ContentDescription.class);
            descIntent2.putExtra("page", "Expense");
            Bundle bundle  = new Bundle();
            switch (v.getId()) {
                case R.id.foodExpense:
                    descIntent2.putExtra("itemName", "Food");
                    bundle.putInt("itemImage",R.drawable.foodicon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.clothingExpense:
                    descIntent2.putExtra("itemName", "Clothing");
                    bundle.putInt("itemImage", R.drawable.clothingicon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.transportExpense:
                    descIntent2.putExtra("itemName", "Transportation");
                    bundle.putInt("itemImage", R.drawable.transporticon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.entertainmentExpense:
                    descIntent2.putExtra("itemName", "Entertainment");
                    bundle.putInt("itemImage", R.drawable.entertainmenticon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.billsExpense:
                    descIntent2.putExtra("itemName", "Bills");
                    bundle.putInt("itemImage", R.drawable.billsicon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.travelExpense:
                    descIntent2.putExtra("itemName", "Travel");
                    bundle.putInt("itemImage", R.drawable.travelicon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.groceryExpense:
                    descIntent2.putExtra("itemName", "Grocery");
                    bundle.putInt("itemImage", R.drawable.groceryicon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.hobbyExpense:
                    descIntent2.putExtra("itemName", "Hobby");
                    bundle.putInt("itemImage", R.drawable.hobbyicon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.workExpense:
                    descIntent2.putExtra("itemName", "Work");
                    bundle.putInt("itemImage", R.drawable.workicon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.giftExpense:
                    descIntent2.putExtra("itemName", "Gift");
                    bundle.putInt("itemImage", R.drawable.gifticon);
                    descIntent2.putExtras(bundle);

                case R.id.maintenanceExpense:
                    descIntent2.putExtra("itemName", "Maintenance");
                    bundle.putInt("itemImage", R.drawable.maintenanceicon);
                    descIntent2.putExtras(bundle);
                    break;

                case R.id.otherExpense:
                    descIntent2.putExtra("itemName", "other");
                    bundle.putInt("itemImage", R.drawable.othericon);
                    descIntent2.putExtras(bundle);
                    break;
            }
            ExpenseIncomeType.this.startActivity(descIntent2);
        }
    }
}