package com.mitodevelops.spingame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mitodevelops.spingame.actors.SpinnerActor;
import com.mitodevelops.spingame.actors.UserActor;

/**
 * Created by seba on 02-10-17.
 */

public class MainGameScreen extends BaseScreen {

    private Stage stage;
    private SpinnerActor spinnerActor;
    private UserActor userActor;
    private ShapeRenderer bar;
    private ShapeRenderer touchArea;
    private float[] backgroundColor = {0.0f, 0.88f, 0.88f, 0.88f};
    private InputActionsProcessor inputProcessor;

    public MainGameScreen(MainGame game) {
        super(game);
        this.bar = new ShapeRenderer();
        this.touchArea = new ShapeRenderer();
    }

    @Override
    public void show() {
        stage = new Stage();
        stage.setDebugAll(true);

        spinnerActor = new SpinnerActor(bar);
        stage.addActor(spinnerActor);

        userActor = new UserActor(touchArea);
        //stage.addActor(userActor);
        inputProcessor = new InputActionsProcessor(stage, userActor);

        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(backgroundColor[0], backgroundColor[1], backgroundColor[2], backgroundColor[3]);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();

        //System.out.println(Intersector.userActor.getBounds().getVertices());
        stage.draw();
    }

    @Override
    public void dispose() {
        bar.dispose();
        touchArea.dispose();
    }
}
