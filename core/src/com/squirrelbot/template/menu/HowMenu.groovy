package com.squirrelbot.template.menu

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Align

/**
 * Created by Ethan on 4/10/2016.
 */
class HowMenu extends Menu {

	static String instructions = "Instructions"

	HowMenu(Music music) {
		super(music)
	}

	@Override
	void build() {
		Label text = new Label(instructions, skin)
		text.setAlignment(Align.topLeft)
		table.add(text).fill().expand().row()

		TextButton back = new TextButton("Back", skin);
		back.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.states.switchState(new MainMenu(music))
			}
		});
		table.add(back).fillX().row()
	}

}
