package com.mitodevelops.spingame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
	SpriteBatch batch;
	Texture img;
	private int width, height;
	private InputActionsProcessor inputProcessor;

	
	@Override
	public void create () {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		System.out.println("Width = " + width + ", Height = " + height);

		setScreen(new MainGameScreen(this));

//		inputProcessor = new InputActionsProcessor();
//		Gdx.input.setInputProcessor(inputProcessor);

	}

//	@Override
//	public void render () {
//		Gdx.gl.glClearColor(1, 1, 1, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
////		batch.begin();
////		batch.draw(img, 0, 0);
////		batch.end();
//	}
//
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
