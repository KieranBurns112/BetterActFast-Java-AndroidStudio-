package kieranburns.mobappcourseworkproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_button);

    }

    public void Back(View v) {
        Intent returnHome = new Intent(this, MainActivity.class);
        startActivity(returnHome);
    }
}