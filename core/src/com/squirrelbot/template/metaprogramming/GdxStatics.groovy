package com.squirrelbot.template.metaprogramming

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Json
import com.squirrelbot.template.state.StateMachine
import dorkbox.tweenengine.TweenManager
import org.yaml.snakeyaml.Yaml

/**
 * Created by Ethan on 4/10/2016.
 */
class GdxStatics {

	static TweenManager tween
	static StateMachine states

	static Json json
	static Yaml yaml

	public static void addToGdx()
	{
		tween = new TweenManager()
		states = new StateMachine()

		json = new Json()
		yaml = new Yaml()

		Gdx.metaClass.static.getTween = {->
			return tween}
		Gdx.metaClass.static.getStates = {->
			return states}

		Gdx.metaClass.static.getJson = {->
			return json}
		Gdx.metaClass.static.getYaml = {->
			return yaml}
	}

}
