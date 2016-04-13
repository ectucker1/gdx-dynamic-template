package com.squirrelbot.template

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.squirrelbot.template.menu.MainMenu
import com.squirrelbot.template.metaprogramming.GdxStatics

public class AppStart extends ApplicationAdapter {

	@Override
	public void create () {
		addMetaprogramming()

		Gdx.states.switchState(new MainMenu(Gdx.audio.newMusic(Gdx.files.internal("data/music/menu.ogg"))))
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Gdx.tween.update(Gdx.graphics.getDeltaTime())
		Gdx.states.render(Gdx.graphics.getDeltaTime())
	}

	@Override
	public void resize(int width, int height)
	{
		Gdx.states.resize(width, height)
	}

	public static void addMetaprogramming()
	{
		GdxStatics.addToGdx()
	}

}
