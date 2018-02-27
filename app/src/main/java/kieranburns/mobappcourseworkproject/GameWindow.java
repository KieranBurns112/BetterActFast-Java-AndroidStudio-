package kieranburns.mobappcourseworkproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.os.Handler;

public class GameWindow extends View {

    Bitmap background;
    Bitmap success_screen;
    Bitmap fail_screen;

    Rect rect;
    static int displayX, displayY;
    int score = 0;
    Bombs bomb;

    boolean success = false;

    Handler handler;
    Runnable runnable;
    final long update_screen = 750;

    public GameWindow(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        success_screen = BitmapFactory.decodeResource(getResources(),R.drawable.success);
        fail_screen = BitmapFactory.decodeResource(getResources(),R.drawable.failure);
        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        displayX = size.x;
        displayY = size.y;
        rect = new Rect(0,0,displayX,displayY);

        bomb = new Bombs(context, true);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background,null,rect,null);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(72);
        canvas.drawText("Score: " + score, 40, 70, paint);

        canvas.drawBitmap(bomb.getBitmap(),bomb.bombX, bomb.bombY,null);
        bomb.bombFrame++;
        if (/*REAL SUCCESS CONDITION HERE*/ bomb.bombFrame > 4)
        {
            success = true;
        }

        if (success == true) {
            canvas.drawBitmap(success_screen,null,rect,null);
            bomb = new Bombs(getContext(), false);
            score++;
            if (score > 10){
                bomb.bombFrame++;
            }
            if (score > 25){
                bomb.bombFrame++;
            }
            success = false;
        }

        if(bomb.bombFrame > 4) {
           /*FAIL CONDITION TO END GAME*/ bomb.bombFrame = 0;
        }

        handler.postDelayed(runnable,update_screen);
    }


}
