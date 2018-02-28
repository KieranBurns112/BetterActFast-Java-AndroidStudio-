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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class GameWindow extends View {

    Bitmap background, success_screen, fail_screen,spark;
    Rect rect;
    static int displayX, displayY;
    int score = 0,taps = 0, sparkPosX, sparkPosY, highScore = 0;
    Bombs bomb;
    boolean success = false, pressDown = false;
    Handler handler;
    Runnable runnable;
    final long update_screen = 1000;
    float touchPosX, touchPosY;



    public GameWindow(Context context) {
        super(context);

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("highscore.txt");
            highScore = Integer.parseInt(inputStream.toString());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

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
        canvas.drawBitmap(background,null,rect,null);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(72);
        canvas.drawText("Score: " + score, 40, 70, paint);
        canvas.drawText("HighScore: " + highScore, 40, 140, paint);

        canvas.drawBitmap(bomb.getBitmap(),bomb.bombX, bomb.bombY,null);
        bomb.bombFrame++;

        if (bomb.currentBombNo == 0) {
            sparkPosX = (bomb.bombX*4)+75;
            sparkPosY = bomb.bombY;
            canvas.drawBitmap(spark, sparkPosX, sparkPosY,null);

            if (pressDown) {
                pressDown = false;
                if (touchPosX >= sparkPosX && touchPosX <= (sparkPosX + spark.getWidth())){
                    if (touchPosY >= sparkPosY && touchPosY <= (sparkPosY + spark.getHeight())){
                        success = true;
                    }
                }
            }
        }
        else if (bomb.currentBombNo == 1) {
            sparkPosX = bomb.bombX+50;
            sparkPosY = bomb.bombY-20;
            canvas.drawBitmap(spark, sparkPosX, sparkPosY,null);

            if (pressDown) {
                if (touchPosX >= sparkPosX && touchPosX <= (sparkPosX + spark.getWidth())){
                    if (touchPosY >= sparkPosY && touchPosY <= (sparkPosY + spark.getHeight())){
                        success = true;
                    }
                }
            }
        }
        else if (bomb.currentBombNo == 2) {
            if (/*REAL SUCCESS CONDITION HERE*/ bomb.bombFrame > 4) {
                success = true;
                //Taps for counting red pressed (make sure to reset)
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

        if(bomb.bombFrame > 4) {
            if (!success) {
                canvas.drawBitmap(fail_screen,null,rect,null);
                newHighScore(); //add if condition
                ((Play) getContext()).finish();
            }
            else {
                bomb.bombFrame = 0;
            }
        }

        handler.postDelayed(runnable,update_screen);
    }

    private void newHighScore() {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("highscore.txt");
            outputStream.write(score);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
