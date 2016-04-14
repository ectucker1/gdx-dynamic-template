package com.squirrelbot.template.menu

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.squirrelbot.template.state.State
import groovy.transform.CompileStatic

/**
 * Created by Ethan on 4/10/2016.
 */
abstract class Menu implements State {

	int oldWidth, oldHeight

	Stage stage
	Table table

	Skin skin

	Music music

	Color background = Color.WHITE

	public Menu(Music music)
	{
		stage = new Stage()
		stage.setViewport(new ScreenViewport())

		FreeTypeFontGenerator.FreeTypeFontParameter fontParam = new FreeTypeFontGenerator.FreeTypeFontParameter()
		fontParam.size = 32
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("data/ui/common/default.otf"));
		BitmapFont font = generator.generateFont(fontParam);
		generator.dispose()

		skin = new Skin()
		skin.addRegions(new TextureAtlas(Gdx.files.internal("data/ui/themes/ui-blue.atlas")))
		skin.add("default-font", font)
		skin.load(Gdx.files.internal("data/ui/common/uiskin.json"))

		table = new Table()
		table.setFillParent(true)
		stage.addActor(table)

		build()

		oldWidth = Gdx.graphics.width
		oldHeight = Gdx.graphics.height

		stage.getViewport().update(oldWidth, oldHeight, true)
		table.invalidate()

		this.music = music
	}

	abstract void build()

	void disposeMusic()
	{
		music.stop()
		music.dispose()
	}

	@Override
	void render(float delta) {
		Gdx.gl.glClearColor(background.r, background.g, background.b, background.a)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act()
		stage.draw()
	}

	@Override
	void resize(int width, int height) {
		if(width != oldWidth || height != oldHeight)
		{
			Gdx.states.switchState(this.class.newInstance(music))
		}
	}

	@Override
	void start() {
		Gdx.input.setInputProcessor(stage)
		music.play()
	}

	@Override
	void dispose() {
		stage.dispose()
		skin.dispose()
	}
}
