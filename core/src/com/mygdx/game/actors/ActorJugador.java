package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorJugador extends Actor
{
    private TextureAtlas textureAtlas;
    private Animation animation;
    private float stateTime;
    private boolean alive;
    public ActorJugador(TextureAtlas jugator)
    {
        this.alive=true;
        setSize(280,230);
        textureAtlas=new TextureAtlas(Gdx.files.internal("catatlas.atlas"));
        animation=new Animation(1/7f,textureAtlas.getRegions());
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
        stateTime+=Gdx.graphics.getDeltaTime();
        batch.draw((TextureRegion)animation.getKeyFrame(stateTime,true),10,10);
    }
}
