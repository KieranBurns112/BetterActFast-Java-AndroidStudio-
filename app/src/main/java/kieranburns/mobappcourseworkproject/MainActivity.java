package kieranburns.mobappcourseworkproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {
    //Class variables
    public static int highScore = 0;
    public TextView HighScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Fullscreen mode.
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Load High Score from file if it exists.
        SharedPreferences CurrentHighScore = getApplicationContext().getSharedPreferences("HighScore", MODE_PRIVATE);
        highScore = CurrentHighScore.getInt("HighScore", 0);
        HighScoreText = findViewById(R.id.HighScore);
        UpdateHighScore();
    }

    //Update 'High Score' text when Play has finished.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        UpdateHighScore();
    }

    private void UpdateHighScore() {
        String highScoreTextContent = "High Score: " + highScore;
        HighScoreText.setText(highScoreTextContent);
    }

    //Launch game (called from activity_main.xml).
    public void Play(View v) {
        Intent playGame = new Intent(this, Play.class);
        startActivityForResult(playGame, 1);
    }

    //Launch help screen (called from activity_main.xml).
    public void Help(View v) {
        Intent openHelp = new Intent(this, HelpButton.class);
        startActivity(openHelp);
    }


}
