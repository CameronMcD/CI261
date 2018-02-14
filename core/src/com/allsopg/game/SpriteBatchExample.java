package com.allsopg.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.Color;

/**
 * Created by Cam on 14/02/2018.
 */

public class SpriteBatchExample implements ApplicationListener {

    private static final Color BACKGROUND_COLOR = new Color(.5f,.6f,.7f,1f);
    private static final float WORLD_TO_SCREEN = 1.0f / 100f;
    private static final float SCENE_WIDTH = 12.8f;
    private static final float SCENE_HEIGHT = 7.2f;

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private Texture jacketTexture;






    @Override
    public void create(){
        camera = new OrthographicCamera();
        viewport = new FitViewport(SCENE_WIDTH, SCENE_HEIGHT, camera);
        batch = new SpriteBatch();

        jacketTexture = new Texture("pixelJacket.png");
        jacketTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render(){
        Gdx.gl.glClearColor(BACKGROUND_COLOR.rá, BACKGROUND_COLOR.g, BACKGROUND_COLOR.b, BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        int width = jacketTexture.getWidth();
        int height = jacketTexture.getHeight();
        float originX = width * 0.5f;
        float originY = height * 0.5f;

        batch.begin();

        batch.draw(jacketTexture, -originX, -originY, originX, originY,
                    width, height, WORLD_TO_SCREEN, WORLD_TO_SCREEN,
                    0f, 0, 0, width, height, false, false);

        batch.end();
    }

    @Override
    public void pause(){

    }

    @Override
    public void resume(){

    }

    @Override
    public void dispose(){

        batch.dispose();
        jacketTexture.dispose();
    }
}
