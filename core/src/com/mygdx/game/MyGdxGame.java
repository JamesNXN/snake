package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;


public class MyGdxGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture img;
	private Sound appleEaten;
	private Music mainMusic;

	@Override
	public void create () {
		appleEaten = Gdx.audio.newSound(Gdx.files.internal("snake_get_apple.mp3"));
		mainMusic = Gdx.audio.newMusic(Gdx.files.internal("main.mp3"));

		mainMusic.setLooping(true);
		mainMusic.play();

		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,256,256);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
