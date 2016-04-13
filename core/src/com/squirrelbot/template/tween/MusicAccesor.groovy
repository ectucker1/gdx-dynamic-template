package com.squirrelbot.template.tween

import com.badlogic.gdx.audio.Music
import dorkbox.tweenengine.TweenAccessor

/**
 * Created by Ethan on 4/11/2016.
 */
class MusicAccesor implements TweenAccessor<Music> {

	public static final int VOLUME = 1

	@Override
	int getValues(Music target, int tweenType, float[] returnValues) {
		switch (tweenType) {
			case VOLUME:
				returnValues[0] = target.volume;
				return 1
			default:
				assert false
				return -1
		}
	}

	@Override
	void setValues(Music target, int tweenType, float[] newValues) {
		switch (tweenType) {
			case VOLUME:
				target.setVolume(newValues[0])
				break
			default:
				assert false
				break
		}
	}

}
