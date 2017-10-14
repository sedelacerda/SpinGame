package com.mitodevelops.spingame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mitodevelops.spingame.actors.SpinnerActor;
import com.mitodevelops.spingame.actors.PlayerActor;

/**
 * Created by seba on 02-10-17.
 */

public class InputActionsProcessor extends InputAdapter {

    private Stage stage;
    private PlayerActor userActor;
    private SpinnerActor spinnerActor;

    public InputActionsProcessor(Stage stage, PlayerActor userActor, SpinnerActor spinnerActor) {
        this.stage = stage;
        this.userActor = userActor;
        this.spinnerActor = spinnerActor;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        userActor.setPosition(screenX, Gdx.graphics.getHeight() - screenY);
        stage.addActor(userActor);
        System.out.println("User: x=" + userActor.getBounds() + "\nSpinner: x=" + spinnerActor.getBounds());
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        userActor.setPosition(screenX, Gdx.graphics.getHeight() - screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        userActor.remove();
        return true;
    }
}
