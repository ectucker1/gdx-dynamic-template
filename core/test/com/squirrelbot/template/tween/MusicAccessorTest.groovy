package com.squirrelbot.template.tween

import com.badlogic.gdx.audio.Music
import spock.lang.Specification

/**
 * Created by Ethan on 4/12/2016.
 */
class MusicAccessorTest extends Specification {

	def "returns number of values"()
	{
		setup:
		MusicAccessor accessor = new MusicAccessor()

		Music music = Mock(Music)
		float[] returnData = new float[1]

		expect:
		accessor.getValues(music, MusicAccessor.VOLUME, returnData) == 1
	}

	def "get values gets volume"()
	{
		setup:
		MusicAccessor accessor = new MusicAccessor()

		Music music = Mock(Music)
		float[] returnData = new float[1]

		when:
		music.volume >> volume
		accessor.getValues(music, MusicAccessor.VOLUME, returnData)

		then:
		returnData[0] == volume

		where:
		volume << [0, 0.5f, 1]
	}

	def "set values sets volume"()
	{
		setup:
		MusicAccessor accessor = new MusicAccessor()

		Music music = Stub(Music) {
			setVolume(_) >> { float v ->
				it.volume >> v
			}
		}
		float[] newData = new float[1]

		when:
		newData[0] = volume
		accessor.setValues(music, MusicAccessor.VOLUME, newData)

		then:
		music.volume == volume

		where:
		volume << [0, 0.5f, 1]
	}

}
