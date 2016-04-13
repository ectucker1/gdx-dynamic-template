package com.squirrelbot.template.tween

import com.badlogic.gdx.graphics.Color
import dorkbox.tweenengine.TweenAccessor

/**
 * Created by Ethan on 4/13/2016.
 */
class ColorAccessor implements TweenAccessor<Color> {

	public static final int R= 1
	public static final int G = 2
	public static final int B = 3
	public static final int RGB = 4

	@Override
	int getValues(Color target, int tweenType, float[] returnValues) {
		switch (tweenType) {
			case R:
				returnValues[0] = target.r
				return 1
			case G:
				returnValues[0] = target.g
				return 1
			case B:
				returnValues[0] = target.b
				return 1
			case RGB:
				returnValues[0] = target.r
				returnValues[1] = target.g
				returnValues[2] = target.b
				return 3
			default:
				assert false
				return -1
		}
	}

	@Override
	void setValues(Color target, int tweenType, float[] newValues) {
		switch (tweenType) {
			case R:
				target.r = newValues[0]
				break
			case G:
				target.g = newValues[0]
				break
			case B:
				target.b = newValues[0]
				break
			case RGB:
				target.r = newValues[0]
				target.g = newValues[1]
				target.b = newValues[2]
				break
			default:
				assert false
				break
		}
	}

}
