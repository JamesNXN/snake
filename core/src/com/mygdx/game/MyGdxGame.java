package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;


public class MyGdxGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture img;
	private Pixmap screen;
	private Sound appleEaten;
	private Music mainMusic;
	private final int HEIGHT = 256;
	private final int WIDTH = 256;
	private Board game;

	@Override
	public void create () {
		appleEaten = Gdx.audio.newSound(Gdx.files.internal("snake_get_apple.mp3"));
		mainMusic = Gdx.audio.newMusic(Gdx.files.internal("main.mp3"));

		mainMusic.setLooping(true);
		mainMusic.play();
		mainMusic.setVolume((float) 0.05);

		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,HEIGHT,WIDTH);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		screen = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
		screen.setColor(Color.BLACK);
		screen.fill();

		/// I HAVE NO IDEA WHY THIS WONT WORK!!!
		//for (Cell cell : game.snake.body) {
		//	screen.drawPixel(cell.getX(),cell.getY(),cell.getColor().toIntBits());
		//}
		//screen.drawPixel(game.fruit.getX(),game.fruit.getY(),game.fruit.getColor().toIntBits());

		//for (Cell[] row : game.board){
		//	for (Cell cell : row){
		//		screen.drawPixel(cell.getX(),cell.getY(),cell.getColor().toIntBits());
		//	}
		//}
		//screen.drawPixel(game.fruit.getX(),game.fruit.getY(),game.fruit.getColor().toIntBits());

		img = new Texture(screen);
		screen.dispose();

		batch.begin();
		batch.draw(img,0,0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		mainMusic.dispose();
		appleEaten.dispose();
		batch.dispose();
		img.dispose();
	}
}
