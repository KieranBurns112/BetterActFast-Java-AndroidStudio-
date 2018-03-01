package kieranburns.mobappcourseworkproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_button);
    }

    //Close this activity (called from activity_help_button.xml).
    public void Back(View v) {
        finish();
    }
}
