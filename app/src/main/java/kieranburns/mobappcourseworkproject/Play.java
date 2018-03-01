package kieranburns.mobappcourseworkproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

//When Called, launch GameWindow until GameWindow
//calls finish.
public class Play extends Activity {
    //Class variable
    GameWindow gameWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gameWindow = new GameWindow(this);
        setContentView(gameWindow);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        //Write current High Score to file to ensure persistence.
        SharedPreferences pref = getApplicationContext().getSharedPreferences("HighScore", MODE_PRIVATE);
        SharedPreferences.Editor ScoreEditor = pref.edit();
        ScoreEditor.putInt("HighScore", MainActivity.highScore);
        ScoreEditor.commit();

        MainActivity.HighScoreText.setText("High Score: " + MainActivity.highScore);
    }
}
