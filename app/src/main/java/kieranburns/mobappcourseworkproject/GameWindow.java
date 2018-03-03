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
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;

public class GameWindow extends View {
    //Class variables
    Bitmap background, success_screen, fail_screen, spark, fuse_a, fuse_b, target;
    Rect screenSize, bombSize, targetSize;
    int displayX;
    int bombX, bombY, score, highScore, availableBombs, taps, sparkX, sparkY, fuseX, fuseY, targetX, targetY, successScreenTicks, gameOverTicks;
    Paint letters = new Paint();
    Bombs bomb;
    boolean success, pressDown, swiped, shaken;
    Handler handler;
    Runnable runnable;
    float touchPosX, touchPosY, swipePosX, swipePosY, acceleration, lastAcceleration, shakeIn;
    SensorManager sensorManager;

    public GameWindow(Context context) {
        super(context);

        //Method variable
        int displayY;
        Point size;

        //Set basic values required for the game
        score = 0;
        taps = 0;
        successScreenTicks = 0;
        success = false;
        pressDown = false;
        swiped = false;
        shaken = false;

        //Request an existing high score, if one
        //doesn't exist, 0 will be returned.
        highScore = MainActivity.highScore;

        //Ready the resources to take a phone shaken event, if the user device does not have the
        //hardware to handle a shake event, exclude the shake to defuse bomb from the game.
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager != null) {
            sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
            acceleration = SensorManager.GRAVITY_EARTH;
            lastAcceleration = SensorManager.GRAVITY_EARTH;
            shakeIn = 0.00f;
            availableBombs = 5;
        }
        else {
            availableBombs = 4;
        }

        //Load constant the images used within the game
        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        success_screen = BitmapFactory.decodeResource(getResources(), R.drawable.success);
        fail_screen = BitmapFactory.decodeResource(getResources(), R.drawable.failure);
        spark = BitmapFactory.decodeResource(getResources(), R.drawable.snub);
        fuse_a = BitmapFactory.decodeResource(getResources(), R.drawable.black_fuse_a);
        fuse_b = BitmapFactory.decodeResource(getResources(), R.drawable.black_fuse_b);
        target = BitmapFactory.decodeResource(getResources(), R.drawable.target);

        //Get screen size to scale the game to the phone screen.
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        displayX = size.x;
        displayY = size.y;
        screenSize = new Rect(0, 0, displayX, displayY);

        //Generate the first bomb for the game
        bomb = new Bombs(context, availableBombs);

        //Set the scale of the bomb image to rely on user screen size for
        // use on phones with different sized screens.
        bombX = (displayX / 15);
        bombY = (displayY / 3);
        bombSize = new Rect(bombX, bombY, displayX - bombX, displayY - bombX);

        targetX = (displayX / 2) - (displayX / 8);
        targetY = bombY - (displayX * 2 / 5);
        targetSize = new Rect(targetX, targetY, targetX + (displayX / 4), targetY + (displayX / 4));

        //Set font size from screen scale.
        letters.setColor(Color.BLACK);
        float scaledSizeInPixels = 20 * getResources().getDisplayMetrics().scaledDensity;
        letters.setTextSize(scaledSizeInPixels);

        //Start the game (onDraw)
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    //Used to change to location of the spark placed on the black bombs
    private Rect setSparkLocation() {
        return new Rect(sparkX, sparkY, sparkX + (displayX / 5), sparkY + (displayX / 5));
    }

    //Used to change to location of the fuse placed on the black bombs
    private Rect setFuseLocation() {
        return new Rect(fuseX, fuseY, fuseX + (displayX / 5), fuseY + (displayX / 10));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Method variables
        Rect sparkSize;
        Rect fuseSize;

        //Draw background on screen.
        canvas.drawBitmap(background, null, screenSize, null);

        //Draw current user score on screen.
        canvas.drawText("Score: " + score, 0, letters.getTextSize(), letters);
        canvas.drawText("High Score: " + highScore, 0, letters.getTextSize() * 2, letters);

        //Draw current bomb on screen.
        canvas.drawBitmap(bomb.getBitmap(), null, bombSize, null);
        if (gameOverTicks == 0) {
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
                fuseX = displayX / 2;
                fuseY = bombY - (displayX / 10);
                fuseSize = setFuseLocation();
                canvas.drawBitmap(fuse_a, null, fuseSize, null);

                sparkX = displayX - bombX - (displayX / 3);
                sparkY = bombY - (displayX / 5);
                sparkSize = setSparkLocation();
                canvas.drawBitmap(spark, null, sparkSize, null);

                if (pressDown) {
                    if (touchPosX >= sparkX && touchPosX <= sparkSize.right) {
                        if (touchPosY >= sparkY && touchPosY <= sparkSize.bottom) {
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
                fuseX = (displayX / 2) - (displayX / 5);
                fuseY = bombY - (displayX / 10);
                fuseSize = setFuseLocation();
                canvas.drawBitmap(fuse_b, null, fuseSize, null);

                sparkX = displayX / 6;
                sparkY = bombY - (displayX / 5);
                sparkSize = setSparkLocation();
                canvas.drawBitmap(spark, null, sparkSize, null);


                if (pressDown) {
                    if (touchPosX >= sparkX && touchPosX <= sparkSize.right) {
                        if (touchPosY >= sparkY && touchPosY <= sparkSize.bottom) {
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
                    if (touchPosX >= bombX && touchPosX <= (bombX + bomb.getBitmap().getWidth())) {
                        if (touchPosY >= bombY && touchPosY <= (bombY + bomb.getBitmap().getHeight())) {
                            taps++;
                        }
                    }
                    pressDown = false;
                }
                if (taps >= 5) {
                    taps = 0;
                    success = true;
                }
            }

            //If the current bomb is 'BlueBomb' await a flick
            //from the middle of the screen towards the top as
            //the success condition.
            else if (bomb.currentBombNo == 3) {
                canvas.drawBitmap(target, null, targetSize, null);

                if (pressDown && swiped) {
                    if (touchPosX >= bombX && touchPosX <= (bombX + bomb.getBitmap().getWidth())) {
                        if (touchPosY >= bombY && touchPosY <= (bombY + bomb.getBitmap().getHeight())) {
                            if (swipePosX >= targetX && swipePosX <= targetSize.right) {
                                if (swipePosY >= targetY && swipePosY <= targetSize.bottom) {
                                    pressDown = false;
                                    swiped = false;
                                    success = true;
                                } else {
                                    swiped = false;
                                    pressDown = false;
                                }
                            } else {
                                swiped = false;
                                pressDown = false;
                            }
                        } else {
                            swiped = false;
                            pressDown = false;
                        }
                    } else {
                        swiped = false;
                        pressDown = false;
                    }
                }
            } else if (bomb.currentBombNo == 4) {
                if (shaken) {
                    shaken = false;
                    success = true;
                }
            }
        }

        //If a success condition is met,
        //display success screen for 1 'tick' (100ms).
        if (success) {
            canvas.drawBitmap(success_screen, null, screenSize, null);
            successScreenTicks++;
        }

        //Make success screen display for 8 'ticks' (800ms)
        //then generate next bomb. Remove 1 second
        //on new bomb timer after 10 points are scored and
        //remove 2 seconds after 25.
        if (successScreenTicks == 8) {
            bomb = new Bombs(this.getContext(), availableBombs);
            score++;
            if (score > 10) {
                bomb.bombFrame += 8;
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
        if (bomb.bombFrame > 30 && !success) {
            canvas.drawBitmap(fail_screen, null, screenSize, null);
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
        handler.postDelayed(runnable, 100);
    }

    //Await user tapping the screen and take the coordinates
    //of the area that was tapped.
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        //Look for a tap event.
        if (action == MotionEvent.ACTION_DOWN && !pressDown) {
            swipePosX = 0;
            swipePosY = 0;
            touchPosX = event.getX();
            touchPosY = event.getY();
            pressDown = true;
        }
        //If the current bomb is blue, accept a swipe instead of a tap by looking
        //for the location the finger left the screen as well as was placed on
        //it.
        if (action == MotionEvent.ACTION_UP && bomb.currentBombNo == 3 && !swiped) {
            swipePosX = event.getX();
            swipePosY = event.getY();
            swiped = true;
        }
        return true;
    }

    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            //Only do something with a new shake event if the current bomb is
            //yellow and is looking for an event.
            if (!shaken && bomb.currentBombNo == 4) {
                //Take in the movement directions of the shake event.
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];

                lastAcceleration = acceleration;

                //Calculate acceleration of the shake and use it to work out the distance
                //of the shake event.
                acceleration = (float) Math.sqrt((double) ((x * x) + (y * y) + (z * z)));
                float distance = acceleration - lastAcceleration;
                shakeIn = shakeIn * 0.9f + distance;

                //Work out if the input shake is of a sufficient speed and distance to
                //defuse the bomb (the number after the > effects how much speed and distance
                //combined is required).
                if (shakeIn > 8) {
                    shaken = true;
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {}
    };
}