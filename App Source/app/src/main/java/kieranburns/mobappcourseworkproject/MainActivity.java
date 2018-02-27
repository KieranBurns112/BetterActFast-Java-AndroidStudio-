package kieranburns.mobappcourseworkproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Play(View v) {
        Intent playGame = new Intent(this,Play.class);
        startActivity(playGame);
        finish();
    }

    public void Help(View v) {
        Intent openHelp = new Intent(this, HelpButton.class);
        startActivity(openHelp);
    }


}
