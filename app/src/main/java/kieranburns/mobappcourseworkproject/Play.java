package kieranburns.mobappcourseworkproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class Play extends Activity {

    GameWindow gameWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameWindow = new GameWindow(this);
        setContentView(gameWindow);
    }
}
