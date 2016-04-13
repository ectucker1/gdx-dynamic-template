package com.squirrelbot.template.metaprogramming

import com.badlogic.gdx.Gdx
import dorkbox.tweenengine.Tween
import spock.lang.Specification

/**
 * Created by Ethan on 4/12/2016.
 */
class TweenMethodsTest extends Specification {

	def "test mthods added"()
	{
		setup:
		Tween tween = Mock(Tween)

		when:
		TweenMethods.addToTween()

		then:
		tween.metaClass.respondsTo(tween, "switchState", String)
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
