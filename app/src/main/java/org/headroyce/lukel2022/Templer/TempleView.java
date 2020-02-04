package org.headroyce.lukel2022.Templer;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;


public class TempleView extends View {

    private PlayerView player;
    private boolean firstDraw;

    private Handler animTimer;
    private boolean animRunning;

    public TempleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        animTimer = new Handler();
        player = new PlayerView(context, attrs);



    }

    public void onPause(){

        animRunning = false;
    }

    public void onResume(){

        animRunning = true;

        player.velX = 5;
        player.velY= 5;

        animTimer.post(new TemplerAnim());

    }



    public void onDraw(Canvas c) {

        if (firstDraw == false) {
            player.x = getWidth() / 2 - player.getPlayerWidth() / 2;
            player.y = getHeight() / 2 - player.getPlayerHeight() / 2;
            firstDraw = true;
        }

        player.draw(c);
    }

    private class TemplerAnim implements Runnable {
        public void run() {
            if (getWidth() == 0 || getHeight() == 0) {
                if (animRunning) {
                    animTimer.postDelayed(this, 17);
                }
                return;
            }
            //Game Loop

           // Move Objects

           player.move();

           // Check Collisions and React to Collisions

            if (player.x+player.getPlayerWidth() > getWidth()){

                player.x = getWidth() - player.getPlayerWidth();
                player.velX *= -1;


            }


            // Draw Objects
            invalidate();

           if (animRunning) {
               animTimer.postDelayed(this, 17);
           }


        }
    }
}