package com.mitodevelops.spingame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mitodevelops.spingame.actors.UserActor;

/**
 * Created by seba on 02-10-17.
 */

public class InputActionsProcessor extends InputAdapter {

    private Stage stage;
    private UserActor userActor;

    public InputActionsProcessor(Stage stage, UserActor userActor) {
        this.stage = stage;
        this.userActor = userActor;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        userActor.setPosition(screenX, Gdx.graphics.getHeight() - screenY);
        stage.addActor(userActor);
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
