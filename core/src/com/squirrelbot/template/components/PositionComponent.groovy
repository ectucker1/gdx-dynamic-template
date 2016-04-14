package com.squirrelbot.template.components

import com.badlogic.ashley.core.Component
import groovy.transform.CompileStatic

/**
 * Created by Ethan on 2/19/2016.
 */
@CompileStatic
class PositionComponent implements Component {

	float x
	float y

	public PositionComponent(float x, float y)
	{
		this.x = x
		this.y = y
	}

}
