package kieranburns.mobappcourseworkproject;

import android.annotation.SuppressLint;
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

public class GameWindow extends View{
    //Class variables
    Bitmap background, success_screen, fail_screen,spark,target;
    Rect screenSize;
    static int displayX, displayY;
    int score, highScore, taps, sparkPosX, sparkPosY, targetX, targetY, successScreenTicks, gameOverTicks;
    Paint letters = new Paint();
    Bombs bomb;
    boolean success, pressDown, swiped;
    Handler handler;
    Runnable runnable;
    final long update_screen = 100;
    float touchPosX, touchPosY, swipePosX, swipePosY;

    public GameWindow(Context context) {
        super(context);

        //Set basic values required for the game
        score = 0;
        taps = 0;
        successScreenTicks = 0;
        success = false;
        pressDown = false;
        swiped = false;
        gameOverTicks = 0;

        //Request an existing high score, if one
        //doesn't exist, 0 will be returned.
        highScore = MainActivity.highScore;

        //Load constant the images used within the game
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        success_screen = BitmapFactory.decodeResource(getResources(),R.drawable.success);
        fail_screen = BitmapFactory.decodeResource(getResources(),R.drawable.failure);
        spark = BitmapFactory.decodeResource(getResources(),R.drawable.snub);
        target = BitmapFactory.decodeResource(getResources(),R.drawable.target);

        //Get screen size to scale the game to the phone screen.
        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        displayX = size.x;
        displayY = size.y;
        screenSize = new Rect(0,0,displayX,displayY);

        //Generate the first bomb for the game
        bomb = new Bombs(context);

        //Start the game (onDraw)
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

        //Draw background on screen.
        canvas.drawBitmap(background, null, screenSize, null);

        //Draw current user score on screen.
        letters.setColor(Color.BLACK);
        letters.setTextSize(72);
        canvas.drawText("Score: " + score, 40, 70, letters);
        canvas.drawText("High Score: " + highScore, 40, 140, letters);

        //Draw current bomb on screen.
        canvas.drawBitmap(bomb.getBitmap(), bomb.bombX, bomb.bombY, null);

        if (gameOverTicks == 0){
            //If bomb is not defused, advance to the next frame of the
            //bomb countdown.
            if (!success) {
                bomb.bombFrame++;
            }

            //If the current bomb is 'BlackBombA'
            //run the code to generate the wick for the
            //bomb and await a click on the wick as
            //the success condition.
            if (bomb.currentBombNo == 0) {
                sparkPosX = (bomb.bombX + bomb.getBitmap().getWidth() - (spark.getWidth() + (spark.getWidth()/2)));
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

            //If the current bomb is 'BlackBombB'
            //run the code to generate the wick for the
            //bomb and await a click on the wick as
            //the success condition.
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

            //If the current bomb is 'RedBomb' await 5
            // clicks on the bomb as the success condition.
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

            //If the current bomb is 'BlueBomb' await a flick
            //from the middle of the screen towards the top as
            //the success condition.
            else if (bomb.currentBombNo == 3) {
                targetX = ((displayX / 2) - (target.getWidth() / 2));
                targetY = (bomb.bombY - (target.getHeight()/2));
                canvas.drawBitmap(target, targetX, targetY, null);

                if (pressDown && swiped) {
                    if (touchPosX >= bomb.bombX && touchPosX <= (bomb.bombX + bomb.getBitmap().getWidth())) {
                        if (touchPosY >= (bomb.bombY + (target.getHeight() / 2)) && touchPosY <= (bomb.bombY + bomb.getBitmap().getHeight())) {
                            if (swipePosX >= targetX && swipePosX <= (targetX + target.getWidth())) {
                                if (swipePosY >= targetY && swipePosY <= (targetY + target.getHeight())) {
                                    pressDown = false;
                                    swiped = false;
                                    success = true;
                                }
                                else {
                                    swiped = false;
                                    pressDown = false;
                                }
                            }
                            else {
                                swiped = false;
                                pressDown = false;
                            }
                        }
                        else {
                            swiped = false;
                            pressDown = false;
                        }
                    }
                    else {
                        swiped = false;
                        pressDown = false;
                    }
                }
            }

            else if (bomb.currentBombNo == 4) {
                if (/*REAL SUCCESS CONDITION HERE*/ bomb.bombFrame > 4) {
                    success = true;
                }
            }
        }

        //If a success condition is met,
        //display success screen for 1 'tick' (100ms).
        if (success) {
            canvas.drawBitmap(success_screen,null, screenSize,null);
            successScreenTicks++;
        }

        //Make success screen display for 8 'ticks' (800ms)
        //then generate next bomb. Remove 1 second
        //on new bomb timer after 10 points are scored and
        //remove 2 seconds after 25.
        if (successScreenTicks == 8) {
            bomb = new Bombs(getContext());
            score++;
            if (score > 10){
                bomb.bombFrame+=8;
            }
            if (score > 25) {
                bomb.bombFrame += 8;
            }
            success = false;
            touchPosX = 0;
            touchPosY = 0;
            swipePosX = 0;
            swipePosY = 0;
            successScreenTicks = 0;
        }

        //If success condition is not met when the timer hits 0
        //trigger game over.
        if(bomb.bombFrame > 30 && !success) {
            canvas.drawBitmap(fail_screen,null, screenSize,null);
            gameOverTicks++;
        }

        //Make game over screen display for
        //25 'ticks' (2.5 seconds) then close
        //GameWindow and terminate the play class.
        if (gameOverTicks == 20) {
            if (score > highScore) {
                MainActivity.highScore = score;
            }
            ((Play) getContext()).finish();
        }

        //Progress 'ticks' by 1 (100ms)
        handler.postDelayed(runnable,update_screen);
    }

    //Await user tapping the screen and take the coordinates
    //of the area that was tapped.
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN && !pressDown) {
            swipePosX = 0;
            swipePosY = 0;
            touchPosX = event.getX();
            touchPosY = event.getY();
            pressDown = true;
        }
        //If the current bomb is blue, accept a swipe instead of a tap
        if (action == MotionEvent.ACTION_UP && bomb.currentBombNo == 3 && !swiped) {
            swipePosX = event.getX();
            swipePosY = event.getY();
            swiped = true;
        }
        return true;
    }
}
