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
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;

public class GameWindow extends View {

    Bitmap background, success_screen, fail_screen,spark;
    Rect rect;
    static int displayX, displayY;
    int score,taps, sparkPosX, sparkPosY;
    Bombs bomb;
    boolean success = false, pressDown = false;
    Handler handler;
    Runnable runnable;
    final long update_screen = 100;
    float touchPosX, touchPosY;



    public GameWindow(Context context) {
        super(context);

        score = 0;
        taps = 0;

        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        success_screen = BitmapFactory.decodeResource(getResources(),R.drawable.success);
        fail_screen = BitmapFactory.decodeResource(getResources(),R.drawable.failure);
        spark = BitmapFactory.decodeResource(getResources(),R.drawable.snub);

        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        displayX = size.x;
        displayY = size.y;
        rect = new Rect(0,0,displayX,displayY);

        bomb = new Bombs(context);

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
        canvas.drawBitmap(background, null, rect, null);

        Paint letters = new Paint();
        letters.setColor(Color.BLACK);
        letters.setTextSize(72);
        canvas.drawText("Score: " + score, 40, 70, letters);

        canvas.drawBitmap(bomb.getBitmap(), bomb.bombX, bomb.bombY, null);
        bomb.bombFrame++;

        if (bomb.currentBombNo == 0) {
            sparkPosX = (bomb.bombX * 4) + 75;
            sparkPosY = bomb.bombY;
            canvas.drawBitmap(spark, sparkPosX, sparkPosY, null);

            if (pressDown) {
                if (touchPosX >= sparkPosX && touchPosX <= (sparkPosX + spark.getWidth())) {
                    if (touchPosY >= sparkPosY && touchPosY <= (sparkPosY + spark.getHeight())) {
                        success = true;
                    }
                }
                pressDown = false;
            }
        }

        else if (bomb.currentBombNo == 1) {
            sparkPosX = bomb.bombX + 50;
            sparkPosY = bomb.bombY - 20;
            canvas.drawBitmap(spark, sparkPosX, sparkPosY, null);

            if (pressDown) {
                if (touchPosX >= sparkPosX && touchPosX <= (sparkPosX + spark.getWidth())) {
                    if (touchPosY >= sparkPosY && touchPosY <= (sparkPosY + spark.getHeight())) {
                        success = true;
                    }
                }
                pressDown = false;
            }
        }

        else if (bomb.currentBombNo == 2) {
            if (pressDown) {
                if (touchPosX >= bomb.bombX && touchPosX <= (bomb.bombX + bomb.getBitmap().getWidth())) {
                    if (touchPosY >= bomb.bombY && touchPosY <= (bomb.bombY + bomb.getBitmap().getHeight())) {
                        taps++;
                    }
                }
                pressDown = false;
            }
            if (taps >= 5) {
                success = true;
                taps = 0;
            }
        }


        else if (bomb.currentBombNo == 3) {
            if (/*REAL SUCCESS CONDITION HERE*/ bomb.bombFrame > 4) {
                success = true;
            }
        }

        else if (bomb.currentBombNo == 4) {
            if (/*REAL SUCCESS CONDITION HERE*/ bomb.bombFrame > 4) {
                success = true;
            }
        }


        if (success) {
            canvas.drawBitmap(success_screen,null,rect,null);
            bomb = new Bombs(getContext());
            score++;
            if (score > 10){
                bomb.bombFrame++;
            }
            if (score > 25){
                bomb.bombFrame++;
            }
            success = false;
        }

        if(bomb.bombFrame > 31) {
            /*game over and high score screen*/
            ((Play) getContext()).finish();
        }

        handler.postDelayed(runnable,update_screen);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN && !pressDown) {
            touchPosX = event.getX();
            touchPosY = event.getY();
            pressDown = true;
        }
        return true;
    }
}
