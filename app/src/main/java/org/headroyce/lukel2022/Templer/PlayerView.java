package org.headroyce.lukel2022.Templer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class PlayerView extends View {
    public int x, y;
    public int velX, velY;

    private int width, height;
    private int color;

    public PlayerView (Context context, AttributeSet attrs) {
        super ( context, attrs);
        width = 50;
        height = 50;
        color = Color.BLACK;

        setMinimumWidth(width);
        setMinimumHeight(height);
    }

    public void onDraw(Canvas c){

            Paint paint = new Paint();
            int radius = (width+1)/2;

            c.drawCircle(x+radius, y+radius, radius, paint);
    }

    public int getPlayerWidth() {
        return width;
    }

    public void setWidth(int width) {
        if ( width >= 0) {
            this.width = width;
        }

    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {


        if (color != 0){
            this.color = color;
        }
    }

    public int getPlayerHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height >= 0){
            this.height = height;
        }
    }

    public void move(){
        this.x += this.velX;
        this.y += this.velY;
    }
}

