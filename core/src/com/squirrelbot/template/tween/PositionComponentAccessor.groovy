package com.squirrelbot.template.tween

import com.squirrelbot.template.components.PositionComponent
import dorkbox.tweenengine.TweenAccessor

/**
 * Created by Ethan on 4/12/2016.
 */
class PositionComponentAccessor implements TweenAccessor<PositionComponent> {

	public static final int X = 1
	public static final int Y = 2
	public static final int XY = 3

	@Override
	int getValues(PositionComponent target, int tweenType, float[] returnValues) {
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
	void setValues(PositionComponent target, int tweenType, float[] newValues) {
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
