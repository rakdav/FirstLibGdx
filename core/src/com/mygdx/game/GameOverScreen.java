package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FillViewport;

public class GameOverScreen extends BaseScreen{
    private Stage stage;
    private Skin skin;
    private Image gameover;
    private TextButton retry,menu;

    public GameOverScreen(final MainGame game) {
        super(game);
        stage=new Stage(new FillViewport(640,360));
        skin=new Skin(Gdx.files.internal("skin/uiskin.json"));
        gameover=new Image(new Texture(Gdx.files.internal("gameover.png")));
        retry=new TextButton("Retry",skin);
        menu=new TextButton("Menu",skin);
        retry.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.gameScreen);
            }
        });
        menu.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.menuScreen);
            }
        });
        gameover.setPosition(520-gameover.getWidth(),320-gameover.getHeight());
        retry.setSize(200,100);
        retry.setPosition(350,50);
        stage.addActor(retry);
        menu.setSize(200,100);
        menu.setPosition(100,50);
        stage.addActor(menu);
        stage.addActor(gameover);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f,0.5f,0.8f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
