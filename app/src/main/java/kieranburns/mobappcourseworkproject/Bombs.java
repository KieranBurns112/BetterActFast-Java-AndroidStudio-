package kieranburns.mobappcourseworkproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.Random;

public class Bombs {
    Bitmap currentBomb[] = new Bitmap[5];
    int bombX, bombY, bombFrame, currentBombNo;

    public Bombs(Context context, boolean first) {
        if (first == true){
            BlackBombA(context);
        }
        else{
            Random rand = new Random();
            int chooseBomb = rand.nextInt(5);

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
                currentBombNo = 4;;
            }
        }

        bombX = (GameWindow.displayX /2) - (currentBomb[0].getWidth() /2) + 50;
        bombY = (GameWindow.displayY /2) - (currentBomb[0].getHeight() /2);
        bombFrame = 0;
    }

    private void BlackBombA (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_3);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_2);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a_1);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_a);
    }

    private void BlackBombB (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_3);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_2);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b_1);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.black_bomb_b);
    }

    private void RedBomb (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_3);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_2);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb_1);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.red_bomb);
    }

    private void YellowBomb (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_3);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_2);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb_1);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.yellow_bomb);
    }

    private void BlueBomb (Context context){
        currentBomb[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_4);
        currentBomb[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_3);
        currentBomb[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_2);
        currentBomb[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb_1);
        currentBomb[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.blue_bomb);
    }

    public Bitmap getBitmap(){
        return currentBomb[bombFrame];
    }
}
