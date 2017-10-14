package com.mitodevelops.spingame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * Created by seba on 02-10-17.
 */

public class SpinnerActor extends Actor {

    private ShapeRenderer bar;
    private ShapeRenderer boundsRenderer;
    private int screenWidth, screenHeight;
    private float barWidth;

    private float centerX;
    private float centerY;

    private float radius;

    private float freeSideX;
    private float freeSideY;

    private float angularVelocity; // degrees per second
    private float currentRotation; // degrees in which is currently rotated

    private Polygon bounds;

    public SpinnerActor(ShapeRenderer bar) {
        this.bar = bar;
        this.screenWidth = Gdx.graphics.getWidth();
        this.screenHeight = Gdx.graphics.getHeight();
        this.barWidth = screenWidth / 20.0f;
        this.centerX = screenWidth/2.0f;
        this.centerY = screenHeight/2.0f;
        this.radius = Math.max(screenWidth, screenHeight);
        this.angularVelocity = 140.0f;
        this.currentRotation = 0.0f;
        this.bounds = new Polygon();
        this.boundsRenderer = boundsRenderer;
        setSize(barWidth, radius);
        setPosition(centerX - barWidth/2, centerY);
        setBounds(centerX, centerY, getWidth(), getHeight());

        setTouchable(Touchable.enabled);
//        addListener(new InputListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                System.out.println("DOWN");
//                return true;
//            }
//        });

    }

    @Override
    public void act(float delta) {
//        super.act(delta);
        currentRotation += angularVelocity*delta;
        if(currentRotation > 360f) {
            currentRotation -= 360;
        }
    }

    public Polygon getBounds() {
        this.bounds.setVertices(new float[]{getX(), getY(), getX(), getY() + getHeight(), getX() + getWidth(), getY(), getX() + getWidth(), getY() + getHeight()});
        this.bounds.setOrigin(barWidth/2, 0);
        this.bounds.rotate(-currentRotation);
        return this.bounds;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        freeSideX = (float) (centerX + radius*Math.sin(Math.toRadians(currentRotation)));
        freeSideY = (float) (centerY + radius*Math.cos(Math.toRadians(currentRotation)));

        bar.begin(ShapeRenderer.ShapeType.Filled);
        bar.setColor(Color.WHITE);
        bar.rectLine(new Vector2(centerX, centerY), new Vector2(freeSideX, freeSideY), barWidth);
        setPosition(centerX - barWidth/2, centerY);
        setRotation(-currentRotation);
        setOrigin(barWidth/2, 0);
        bar.end();


    }
}
