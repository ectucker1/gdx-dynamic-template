package com.squirrelbot.template.state

/**
 * Created by Ethan on 4/10/2016.
 */
class StateMachine {

	State currentState = null

	State dispose = null

	public void render(float delta)
	{
		if(dispose != null) {
			dispose.dispose()
			dispose = null
		}
		if(currentState != null)
			currentState.render(delta)
	}

	public void switchState(State newState)
	{
		dispose = currentState
		currentState = newState
		newState.start()
	}

	public void resize(int width, int height)
	{
		currentState.resize(width, height)
	}

}
