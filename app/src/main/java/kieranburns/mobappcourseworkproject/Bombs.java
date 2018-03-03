package kieranburns.mobappcourseworkproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.Random;

public class Bombs {
    //Class variables
    Bitmap currentBomb[] = new Bitmap[33];
    int bombFrame, currentBombNo;

    //When called, randomly select a bomb from the list of 5.
    public Bombs(Context context) {
        //Select random bomb
        Random rand = new Random();
        int chooseBomb =  rand.nextInt(4);

        //Call exclusive values of selected bomb
        if (chooseBomb == 0) {
            BlackBomb(context);
            currentBombNo = 0;
        }
        else if (chooseBomb == 1) {
            BlackBomb(context);
            currentBombNo = 1;
        }
        else if (chooseBomb == 2) {
            RedBomb(context);
            currentBombNo = 2;
        }
        else if (chooseBomb == 3) {
            BlueBomb(context);
            currentBombNo = 3;
        }
        else if (chooseBomb == 4) {
            YellowBomb(context);
            currentBombNo = 4;
        }

        //Set current bomb image to the first frame.
        bombFrame = 0;
    }

    //Returns image links to each frame of this bomb
    //if its called.
    private void BlackBomb (Context context){
        for (int bombNo = 0; bombNo < 33; bombNo ++) {
            if (bombNo >= 0 && bombNo < 8){
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_4);
            }
            else if (bombNo >= 8 && bombNo < 16) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_3);
            }
            else if (bombNo >= 16 && bombNo < 24) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_2);
            }
            else if (bombNo >= 24 && bombNo < 32) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_1);
            }
            else {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb);
            }
        }
    }

    //Returns image links to each frame of this bomb
    //if its called.
    private void RedBomb (Context context){
        for (int bombNo = 0; bombNo < 33; bombNo ++) {
            if (bombNo >= 0 && bombNo < 8){
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
            }
            else if (bombNo >= 8 && bombNo < 16) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
            }
            else if (bombNo >= 16 && bombNo < 24) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
            }
            else if (bombNo >= 24 && bombNo < 32) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
            }
            else {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb);
            }
        }
    }

    //Returns image links to each frame of this bomb
    //if its called.
    private void BlueBomb (Context context){
        for (int bombNo = 0; bombNo < 33; bombNo ++) {
            if (bombNo >= 0 && bombNo < 8){
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
            }
            else if (bombNo >= 8 && bombNo < 16) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
            }
            else if (bombNo >= 16 && bombNo < 24) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
            }
            else if (bombNo >= 24 && bombNo < 32) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
            }
            else {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb);
            }
        }
    }

    //Returns image links to each frame of this bomb
    //if its called.
    private void YellowBomb (Context context){
        for (int bombNo = 0; bombNo < 33; bombNo ++) {
            if (bombNo >= 0 && bombNo < 8){
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
            }
            else if (bombNo >= 8 && bombNo < 16) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
            }
            else if (bombNo >= 16 && bombNo < 24) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
            }
            else if (bombNo >= 24 && bombNo < 32) {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
            }
            else {
                currentBomb[bombNo] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb);
            }
        }
    }

    //Returns a link to the current frame of current bomb when called.
    public Bitmap getBitmap(){
        return currentBomb[bombFrame];
    }
}
