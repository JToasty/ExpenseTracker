package expense.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Landing extends AppCompatActivity implements View.OnClickListener {

    Button loginButton;
    EditText userBox;
    EditText passBox;
    TextView errorText;

    static DatabaseHelper dbHelper;
    static String currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        dbHelper = new DatabaseHelper(this);
        loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(this);

        userBox = findViewById(R.id.usernameBox);
        passBox = findViewById(R.id.passwordBox);
        errorText = findViewById(R.id.errorMessage);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == loginButton.getId())
        {
            //Username and password cannot be empty
            if (userBox.getText().toString() != null && passBox.getText().toString() != null && dbHelper.doesUserExist(userBox.getText().toString(), passBox.getText().toString()))
            {
                currentUser = userBox.getText().toString();
                errorText.setVisibility(View.INVISIBLE);
                if(userBox.getText().toString().equals("Admin"))
                {
                    Intent startIntent = new Intent(Landing.this, AdminView.class);
                    Landing.this.startActivity(startIntent);
                }
                else
                    {
                    Intent startIntent = new Intent(Landing.this, Dashboard.class);
                    Landing.this.startActivity(startIntent);
                    }
            }
            else
                errorText.setVisibility(View.VISIBLE);



        }

    }
}
