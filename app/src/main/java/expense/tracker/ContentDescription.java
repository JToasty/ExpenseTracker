package expense.tracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentDescription extends AppCompatActivity implements View.OnClickListener{

    TextView item;
    ImageView itemIcon;
    Button save;
    String amount = "";
    String desc = "";
    String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_description);

        item = findViewById(R.id.descItem);
        itemIcon = findViewById(R.id.descIcon);
        save = findViewById(R.id.save);

        item.setText(ExpenseIncomeType.newItem);

        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == save.getId())
        {

        }
    }
}
