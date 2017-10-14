package com.mitodevelops.spingame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by seba on 11-10-17.
 */

public class UserActor extends Actor {

    private float radius;
    private ShapeRenderer touchArea;
    private Polygon bounds;

    public UserActor(ShapeRenderer touchArea) {
        this.touchArea = touchArea;
        this.radius = 25;
        this.bounds = new Polygon();
        setSize(2*radius, 2*radius);
        setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
    }

    @Override
    public void setPosition(float x, float y) {
        //System.out.println("SET POSITION");
        super.setPosition(x - radius, y - radius);
    }

    public Polygon getBounds() {
        this.bounds.setVertices(new float[]{getX(), getY(), getX(), getY() + getHeight(), getX() + getWidth(), getY(), getX() + getWidth(), getY() + getHeight()});
        return this.bounds;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        touchArea.begin(ShapeRenderer.ShapeType.Line);
        touchArea.setColor(Color.WHITE);
        touchArea.circle(getX() + radius, getY() + radius, radius);
        touchArea.end();
    }
}
