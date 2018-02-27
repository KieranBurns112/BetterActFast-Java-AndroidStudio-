package kieranburns.mobappcourseworkproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;

public class GameView extends View {

    Bitmap background;
    Rect rect;
    int displayX, displayY;

    public GameView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        displayX = size.x;
        displayY = size.y;
        rect = new Rect(0,0,displayX,displayY);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background,null,rect,null);
    }


}
