package com.squirrelbot.template.tween

import com.badlogic.gdx.math.Vector2
import dorkbox.tweenengine.TweenAccessor

/**
 * Created by Ethan on 4/11/2016.
 */
class Vector2Accesor implements TweenAccessor<Vector2> {

	public static final int X = 1
	public static final int Y = 2
	public static final int XY = 3

	@Override
	int getValues(Vector2 target, int tweenType, float[] returnValues) {
		switch (tweenType) {
			case X:
				returnValues[0] = target.x
				return 1
			case Y:
				returnValues[0] = target.y
				return 1
			case XY:
				returnValues[0] = target.x
				returnValues[1] = target.y
				return 2
			default:
				assert false
				return -1
		}
	}

	@Override
	void setValues(Vector2 target, int tweenType, float[] newValues) {
		switch (tweenType) {
			case X:
				target.x = newValues[0]
				break
			case Y:
				target.y = newValues[0]
				break
			case XY:
				target.x = newValues[0]
				target.y = newValues[1]
				break
			default:
				assert false
				break
		}
	}
}