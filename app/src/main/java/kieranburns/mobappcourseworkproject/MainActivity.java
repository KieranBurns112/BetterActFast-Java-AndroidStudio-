package kieranburns.mobappcourseworkproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    //Class variable
    public static int highScore = 0;
    public static TextView HighScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load HighScore from file
        SharedPreferences CurrentHighScore = getApplicationContext().getSharedPreferences("HighScore", MODE_PRIVATE);

        /*
        //DELETE TAGS TO USE TEMP TO CLEAR SAVE DATA
        // \TEMP ---
        SharedPreferences.Editor ScoreEditor = CurrentHighScore.edit();
        ScoreEditor.clear();
        ScoreEditor.commit();
        //        ---\
        */

        highScore = CurrentHighScore.getInt("HighScore", 0);
        HighScoreText = (TextView) findViewById(R.id.HighScore);
        HighScoreText.setText("High Score: " + highScore);
    }

    //Launch game (called from activity_main.xml).
    public void Play(View v) {
        Intent playGame = new Intent(this,Play.class);
        startActivity(playGame);
    }

    //Launch help screen (called from activity_main.xml).
    public void Help(View v) {
        Intent openHelp = new Intent(this, HelpButton.class);
        startActivity(openHelp);
    }


}
