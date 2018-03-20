package com.nikhil.frontgammon;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by niniagar on 2/18/2018.
 */

public class Explosion {
    private int x;
    private int y;
    private int width;
    private int height;
    private Bitmap spritesheet;
    private int row;
    private Animation animation = new Animation();

    public Explosion(Bitmap res, int x, int y, int w, int h, int numFrames) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;

        Bitmap[] image = new Bitmap[numFrames];

        spritesheet = res;

        for(int i = 0; i < image.length; i++) {
            if(i%5 == 0 && i > 0)
                row++;
            image[i] = Bitmap.createBitmap(spritesheet, (i%5)*width, row*height, width, height);
        }
        animation.setFrames(image);
        animation.setDelay(10);
    }

    public void draw(Canvas canvas) {
        if(!animation.playedOnce()) {
            canvas.drawBitmap(animation.getImage(), x, y, null);
        }
    }

    public void update() {
        if(!animation.playedOnce()) {
            animation.update();
        }
    }

    public int getHeight() {
        return this.height;
    }
}
