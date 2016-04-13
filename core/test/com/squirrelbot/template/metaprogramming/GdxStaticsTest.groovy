package com.squirrelbot.template.metaprogramming

import com.badlogic.gdx.Gdx
import spock.lang.Specification

/**
 * Created by Ethan on 4/12/2016.
 */
class GdxStaticsTest extends Specification {

	def 'test properties not null'()
	{
		when:
		GdxStatics.addToGdx()

		then:
		Gdx.tween != null
		Gdx.states != null
		Gdx.json != null
		Gdx.yaml != null
	}

}
