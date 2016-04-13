package com.squirrelbot.template.metaprogramming

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector2
import com.squirrelbot.template.components.PositionComponent
import com.squirrelbot.template.state.State
import dorkbox.tweenengine.Tween
import spock.lang.Specification

/**
 * Created by Ethan on 4/12/2016.
 */
class TweenMethodsTest extends Specification {

	def "test methods added"()
	{
		setup:
		Tween tween = GroovyMock(Tween)

		when:
		TweenMethods.addToTween()

		then:
		Tween.metaClass.respondsTo(tween, "switchState", State)
	}

	def "test accessors registered"()
	{
		when:
		TweenMethods.addToTween()

		then:
		Tween.getRegisteredAccessor(Music.class) != null
		Tween.getRegisteredAccessor(Vector2.class) != null
		Tween.getRegisteredAccessor(PositionComponent.class) != null
		Tween.getRegisteredAccessor(Color.class) != null
	}

}
