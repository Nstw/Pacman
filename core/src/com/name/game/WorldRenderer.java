package com.name.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private PacmanGame pacmanGame;
	private SpriteBatch batch;
	private World world;
	private Texture pacmanImg;
	private MazeRenderer mazeRenderer;
	public static final int BLOCK_SIZE = 40;

	public WorldRenderer(PacmanGame pacmanGame, World world) {
		this.pacmanGame = pacmanGame;
		batch = pacmanGame.batch;
		
		this.world = world;
		
		mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
		pacmanImg = new Texture("pacman.png");
	}
	
	public void render(float delta) {
		mazeRenderer.render();
		Pacman pacman = world.getPacman();
		
		SpriteBatch batch = pacmanGame.batch;
		Vector2 pos = world.getPacman().getPosition();
		batch.begin();
		//Vector2 pos = pacman.getPosition();
		//batch.draw(pacmanImg, pos.x, pos.y);
		batch.draw(pacmanImg, pos.x-BLOCK_SIZE/2, PacmanGame.HEIGHT-pos.y-BLOCK_SIZE/2);
		batch.end();
	}
}
