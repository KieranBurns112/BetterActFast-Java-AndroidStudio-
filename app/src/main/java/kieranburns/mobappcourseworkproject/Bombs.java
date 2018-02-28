package kieranburns.mobappcourseworkproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.Random;

public class Bombs {
    Bitmap currentBomb[] = new Bitmap[33];
    int bombX, bombY, bombFrame, currentBombNo;

    public Bombs(Context context) {
        Random rand = new Random();
        int chooseBomb =  2; //rand.nextInt(5);
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
            YellowBomb(context);
            currentBombNo = 3;
        }
        else if (chooseBomb == 4) {
            BlueBomb(context);
            currentBombNo = 4;
        }

        bombX = (GameWindow.displayX /2) - (currentBomb[0].getWidth() /2) + 50;
        bombY = (GameWindow.displayY /2) - (currentBomb[0].getHeight() /2);
        bombFrame = 0;
    }

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

    public Bitmap getBitmap(){
        return currentBomb[bombFrame];
    }
}
