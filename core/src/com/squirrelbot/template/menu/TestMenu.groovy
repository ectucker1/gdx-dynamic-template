package com.squirrelbot.template.menu

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox
import com.badlogic.gdx.scenes.scene2d.ui.Slider
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextArea
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import com.badlogic.gdx.scenes.scene2d.ui.Window
import com.badlogic.gdx.scenes.scene2d.ui.List
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.Array

/**
 * Created by Ethan on 4/13/2016.
 */
class TestMenu extends Menu {

	TestMenu(Music music) {
		super(music)
	}

	@Override
	void build() {
		String[] entries = []
		50.times {
			entries += it
		}

		String[] options = []
		5.times {
			options += it
		}

		List list = new List(skin)
		list.setItems(new Array(entries))

		ScrollPane pane = new ScrollPane(list, skin);
		table.add(pane).expandY().fillY().pad(5)

		Table side = new Table()
		table.add(side).expand().fill().row()

		SelectBox box = new SelectBox<String>(skin)
		box.setItems(new Array<String>(options))
		box.setSelectedIndex(0)
		side.add(box).expandX().fillX().align(Align.topLeft).pad(5).row()

		CheckBox check = new CheckBox("Check", skin)
		side.add(check).expandX().align(Align.left).pad(5).row()

		TextField field = new TextField("Simple field", skin)
		side.add(field).expandX().fillX().align(Align.topLeft).pad(5).row()

		ProgressBar progress = new ProgressBar(0, 1, 0.1f, false, skin)
		progress.setValue(0.3f)
		side.add(progress).expandX().fillX().align(Align.topLeft).pad(5).row()

		Slider slider = new Slider(0, 1, 0.1f, false, skin)
		side.add(slider).expandX().fillX().align(Align.topLeft).pad(5).row()

		Button button = new TextButton("Back", skin)
		side.add(button).expand().fillX().align(Align.bottomLeft).pad(5).row()
		button.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.states.switchState(new MainMenu(music))
			}
		});
	}
}
