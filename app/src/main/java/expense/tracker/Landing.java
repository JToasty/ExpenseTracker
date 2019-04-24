package expense.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Landing extends AppCompatActivity implements View.OnClickListener {

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == loginButton.getId())
        {
            Intent startIntent = new Intent(Landing.this, Dashboard.class);
            Landing.this.startActivity(startIntent);
        }

    }
}
