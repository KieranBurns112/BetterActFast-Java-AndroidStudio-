package kieranburns.mobappcourseworkproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import static android.support.v4.content.ContextCompat.startActivity;

public class Play extends Activity {

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
    protected void onStop() {
        super.onStop();
    }

}
