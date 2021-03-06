package com.pacman.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private PacmanGame pacmanGame;
	private World world;
	private SpriteBatch batch;
	private Texture pacmanImg;
	private MazeRenderer mazeRenderer;
	
	public static final int BLOCK_SIZE = 40;
	
    public WorldRenderer(PacmanGame pacmanGame, World world) {
        this.pacmanGame = pacmanGame;
        batch = pacmanGame.batch;
        this.world = world;
        pacmanImg = new Texture("pacman.png");
        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
    }
    
    public void render(float delta) {
    	mazeRenderer.render();
    	Vector2 pos = world.getPacman().getPosition();
        batch.begin();
        batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, 
                PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
        batch.end();
    }
}
