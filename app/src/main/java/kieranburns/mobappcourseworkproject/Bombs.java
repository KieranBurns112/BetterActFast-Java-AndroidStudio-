package kieranburns.mobappcourseworkproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.Random;

public class Bombs {
    //Class variables
    Bitmap currentBomb[] = new Bitmap[33];
    int bombX, bombY, bombFrame, currentBombNo;

    //When called, randomly select a bomb from the list of 5.
    public Bombs(Context context) {
        //Select random bomb
        Random rand = new Random();
        int chooseBomb = rand.nextInt(1); //SET TO 5 AT END OF CREATION

        //Call exclusive values of selected bomb
        if (chooseBomb == 0) {
            BlackBombA(context);
            currentBombNo = 0;
        }
        else if (chooseBomb == 1) {
            BlackBombB(context);
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

        //Set shared values of all bombs
        bombX = (GameWindow.displayX /2) - (currentBomb[0].getWidth() /2) + 50;
        bombY = (GameWindow.displayY /2) - (currentBomb[0].getHeight() /3);
        bombFrame = 0;
    }

    //Returns image links to each frame of this bomb
    //if its called.
    private void BlackBombA (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_4);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_4);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_4);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_4);
        currentBomb[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_4);
        currentBomb[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_4);
        currentBomb[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_4);
        currentBomb[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_3);
        currentBomb[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_3);
        currentBomb[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_3);
        currentBomb[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_3);
        currentBomb[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_3);
        currentBomb[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_3);
        currentBomb[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_3);
        currentBomb[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_3);
        currentBomb[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_2);
        currentBomb[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_2);
        currentBomb[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_2);
        currentBomb[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_2);
        currentBomb[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_2);
        currentBomb[21] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_2);
        currentBomb[22] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_2);
        currentBomb[23] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_2);
        currentBomb[24] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_1);
        currentBomb[25] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_1);
        currentBomb[26] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_1);
        currentBomb[27] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_1);
        currentBomb[28] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_1);
        currentBomb[29] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_1);
        currentBomb[30] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_1);
        currentBomb[31] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_1);
        currentBomb[32] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a);
    }

    //Returns image links to each frame of this bomb
    //if its called.
    private void BlackBombB (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_4);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_4);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_4);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_4);
        currentBomb[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_4);
        currentBomb[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_4);
        currentBomb[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_4);
        currentBomb[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_3);
        currentBomb[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_3);
        currentBomb[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_3);
        currentBomb[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_3);
        currentBomb[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_3);
        currentBomb[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_3);
        currentBomb[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_3);
        currentBomb[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_3);
        currentBomb[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_2);
        currentBomb[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_2);
        currentBomb[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_2);
        currentBomb[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_2);
        currentBomb[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_2);
        currentBomb[21] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_2);
        currentBomb[22] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_2);
        currentBomb[23] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_2);
        currentBomb[24] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_1);
        currentBomb[25] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_1);
        currentBomb[26] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_1);
        currentBomb[27] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_1);
        currentBomb[28] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_1);
        currentBomb[29] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_1);
        currentBomb[30] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_1);
        currentBomb[31] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_1);
        currentBomb[32] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b);
    }

    //Returns image links to each frame of this bomb
    //if its called.
    private void RedBomb (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
        currentBomb[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
        currentBomb[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
        currentBomb[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
        currentBomb[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
        currentBomb[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
        currentBomb[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
        currentBomb[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
        currentBomb[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
        currentBomb[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
        currentBomb[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
        currentBomb[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
        currentBomb[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
        currentBomb[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
        currentBomb[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
        currentBomb[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
        currentBomb[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
        currentBomb[21] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
        currentBomb[22] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
        currentBomb[23] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
        currentBomb[24] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
        currentBomb[25] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
        currentBomb[26] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
        currentBomb[27] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
        currentBomb[28] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
        currentBomb[29] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
        currentBomb[30] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
        currentBomb[31] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
        currentBomb[32] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb);
    }

    //Returns image links to each frame of this bomb
    //if its called.
    private void BlueBomb (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
        currentBomb[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
        currentBomb[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
        currentBomb[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
        currentBomb[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
        currentBomb[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
        currentBomb[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
        currentBomb[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
        currentBomb[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
        currentBomb[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
        currentBomb[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
        currentBomb[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
        currentBomb[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
        currentBomb[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
        currentBomb[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
        currentBomb[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
        currentBomb[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
        currentBomb[21] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
        currentBomb[22] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
        currentBomb[23] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
        currentBomb[24] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
        currentBomb[25] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
        currentBomb[26] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
        currentBomb[27] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
        currentBomb[28] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
        currentBomb[29] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
        currentBomb[30] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
        currentBomb[31] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
        currentBomb[32] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb);
    }

    //Returns image links to each frame of this bomb
    //if its called.
    private void YellowBomb (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
        currentBomb[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
        currentBomb[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
        currentBomb[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
        currentBomb[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
        currentBomb[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
        currentBomb[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
        currentBomb[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
        currentBomb[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
        currentBomb[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
        currentBomb[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
        currentBomb[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
        currentBomb[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
        currentBomb[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
        currentBomb[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
        currentBomb[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
        currentBomb[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
        currentBomb[21] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
        currentBomb[22] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
        currentBomb[23] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
        currentBomb[24] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
        currentBomb[25] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
        currentBomb[26] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
        currentBomb[27] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
        currentBomb[28] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
        currentBomb[29] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
        currentBomb[30] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
        currentBomb[31] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
        currentBomb[32] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb);
    }

    //Returns a link to the current frame of current bomb when called.
    public Bitmap getBitmap(){
        return currentBomb[bombFrame];
    }
}
