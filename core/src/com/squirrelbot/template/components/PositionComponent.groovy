package com.squirrelbot.template.components

import com.badlogic.ashley.core.Component

/**
 * Created by Ethan on 2/19/2016.
 */
class PositionComponent implements Component {

	float x
	float y

	public PositionComponent(float x, float y)
	{
		this.x = x
		this.y = y
	}

}
