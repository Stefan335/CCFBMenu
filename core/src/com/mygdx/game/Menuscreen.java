package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.awt.Label;

public class Menuscreen extends ApplicationAdapter {
	private static final float BUTTON_WIDTH = 300f;
	private static final float BUTTON_HEIGHT = 60f;
	SpriteBatch batch;
	Texture tBack, tButton;
	TextureRegion region;
	Stage stage;
	TextureAtlas taButton;
	BitmapFont font;
	TextButton tbStart, tbExit;
	TextButton.TextButtonStyle tbsNewGame, textButtonStyle;
	Table table;
	Skin skNewGame;
	Label laTitle;
	int nSHeight, nSWidth, nChoi=0;
	
	@Override
	public void create () {
		stage= new Stage();

		Gdx.input.setInputProcessor(stage);

		taButton = new TextureAtlas("MenuButton.pack");
		skNewGame = new Skin(taButton);

		font = new BitmapFont();
		//font.setFontScale(nSWidth * 3 / 1794, nSHeight * 3 / 1080);
		tBack = new Texture(Gdx.files.internal("Picnic.jpg"));
		region = new TextureRegion(tBack, 20, 20, 50, 50);
		tButton = new Texture(Gdx.files.internal("expences-button-png-hi.png"));
		textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.up = skNewGame.newDrawable("MenuButtonUp");
		textButtonStyle.down = skNewGame.newDrawable("MenuButtonDown");
		textButtonStyle.checked = skNewGame.newDrawable("MenuButtonUp");
		textButtonStyle.over = skNewGame.newDrawable("MenuButtonUp");
		textButtonStyle.font = font;

		LabelStyle headingstyle = new LabelStyle(font, Color.WHITE);
		headingstyle.font = font;

		//laTitle = new Label("Ants", headingstyle);

		tbStart = new TextButton("Start", textButtonStyle);
		tbStart.pad(20f);
		tbStart.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		tbStart.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				nChoi = 1;
				System.out.println(nChoi);
			}
		});

		tbExit = new TextButton("Exit", textButtonStyle);
		tbExit.pad(20f);
		tbExit.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		tbExit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		table = new Table();
		table.setFillParent(true);
		table.add(tbStart);
		table.row();
		table.add(tbExit);
		table.setDebug(true);
		stage.addActor(table);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/*batch.begin();
		//batch.draw(region, 10, 10);
		System.out.print("hi");
		batch.end();*/
		stage.act();
		stage.draw();
	}
}
