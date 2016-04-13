package com.squirrelbot.template.menu

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener

/**
 * Created by Ethan on 4/10/2016.
 */
class MainMenu extends Menu {

	MainMenu(Music music) {
		super(music)
	}

	@Override
	void build() {
		TextButton play = new TextButton("Play", skin);
		play.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				println "Switch to game here"
			}
		});
		table.add(play).fillX().row()

		TextButton how = new TextButton("How to Play", skin);
		how.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.states.switchState(new HowMenu(music))
			}
		});
		table.add(how).fillX().row()
	}

}
