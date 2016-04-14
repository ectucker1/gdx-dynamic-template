package com.squirrelbot.template.state

import com.badlogic.gdx.utils.Disposable
import groovy.transform.CompileStatic

/**
 * Created by Ethan on 4/10/2016.
 */
@CompileStatic
interface State extends Disposable {

	void render(float delta)

	void resize(int width, int height)

	void start()

}