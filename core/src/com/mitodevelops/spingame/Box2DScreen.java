package com.mitodevelops.spingame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by seba on 14-10-17.
 */

public class Box2DScreen extends BaseScreen {

    private World world;
    private Box2DDebugRenderer renderer;
    private OrthographicCamera camera;

    private Body playerBody, spinnerBody;
    private Fixture playerFixture, spinnerFixture;

    public Box2DScreen(MainGame game) {
        super(game);
    }

    @Override
    public void show() {
        world = new World(new Vector2(0, -10), true);
        renderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(28.125f, 50);

        playerBody = world.createBody(createPlayerBodyDef());
        spinnerBody = world.createBody(createSpinnerBodyDef());

        createPlayerFixture(playerBody);
        createSpinnerFixture(spinnerBody);

        spinnerBody.setAngularVelocity(2);
    }

    private BodyDef createPlayerBodyDef() {
        BodyDef def = new BodyDef();
        def.position.set(0, 10);
        def.type = BodyDef.BodyType.StaticBody;
        return def;
    }

    private Fixture createPlayerFixture(Body playerBody) {
        CircleShape shape = new CircleShape();
        shape.setRadius(1*Gdx.graphics.getHeight()/Gdx.graphics.getWidth());
        playerFixture = playerBody.createFixture(shape, 1);
        shape.dispose();
        return playerFixture;
    }

    private BodyDef createSpinnerBodyDef() {
        BodyDef def = new BodyDef();
        def.position.set(0, 0);
        def.type = BodyDef.BodyType.KinematicBody;
        return def;
    }

    private Fixture createSpinnerFixture(Body spinnerBody) {
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(0.5f, 20, new Vector2(0, -20), 0);
        spinnerFixture = spinnerBody.createFixture(shape, 1);
        shape.dispose();
        return spinnerFixture;
    }

    @Override
    public void dispose() {
        playerBody.destroyFixture(playerFixture);
        world.destroyBody(playerBody);

        spinnerBody.destroyFixture(spinnerFixture);
        world.destroyBody(spinnerBody);

        world.dispose();
        renderer.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(delta, 6, 2);

        camera.update();
        renderer.render(world, camera.combined);
    }
}
