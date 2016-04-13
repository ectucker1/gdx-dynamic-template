package com.squirrelbot.template.tween

import com.badlogic.gdx.math.Vector2
import spock.lang.Specification

/**
 * Created by Ethan on 4/12/2016.
 */
class Vector2AccesorTest extends Specification {

	def "returns number of values"()
	{
		setup:
		Vector2Accessor accessor = new Vector2Accessor()

		Vector2 vector = Mock(Vector2)
		float[] returnData = new float[2]

		expect:
		accessor.getValues(vector, type, returnData) == number

		where:
		type               | number
		Vector2Accessor.X  | 1
		Vector2Accessor.X  | 1
		Vector2Accessor.XY | 2
	}

	def "get X values equal"()
	{
		setup:
		Vector2Accessor accessor = new Vector2Accessor()

		Vector2 vector = Mock(Vector2)
		float[] returnData = new float[2]

		when:
		vector.x = x
		accessor.getValues(vector, Vector2Accessor.X, returnData)

		then:
		returnData[0] == x

		where:
		x << [0, 1, -1]
	}

	def "get Y values equal"()
	{
		setup:
		Vector2Accessor accessor = new Vector2Accessor()

		Vector2 vector = Mock(Vector2)
		float[] returnData = new float[2]

		when:
		vector.y = y
		accessor.getValues(vector, Vector2Accessor.Y, returnData)

		then:
		returnData[0] == y

		where:
		y << [0, 1, -1]
	}

	def "get XY values equal"()
	{
		setup:
		Vector2Accessor accessor = new Vector2Accessor()

		Vector2 vector = Mock(Vector2)
		float[] returnData = new float[2]

		when:
		vector.x = x
		vector.y = y
		accessor.getValues(vector, Vector2Accessor.XY, returnData)

		then:
		returnData[0] == x
		returnData[1] == y

		where:
		x << [0, 1, 1, -1, -1]
		y << [0, 1, -1, 1, -1]
	}

	def "set values sets X value"()
	{
		setup:
		Vector2Accessor accessor = new Vector2Accessor()

		Vector2 vector = new Vector2(0, 0)
		float[] newData = new float[2]

		when:
		newData[0] = x
		accessor.setValues(vector, Vector2Accessor.X, newData)

		then:
		vector.x == x

		where:
		x << [0, 1, -1]
	}

	def "set values sets Y value"()
	{
		setup:
		Vector2Accessor accessor = new Vector2Accessor()

		Vector2 vector = new Vector2(0, 0)
		float[] newData = new float[2]

		when:
		newData[0] = y
		accessor.setValues(vector, Vector2Accessor.Y, newData)

		then:
		vector.y == y

		where:
		y << [0, 1, -1]
	}

	def "set values sets XY value"()
	{
		setup:
		Vector2Accessor accessor = new Vector2Accessor()

		Vector2 vector = new Vector2(0, 0)
		float[] newData = new float[2]

		when:
		newData[0] = x
		newData[1] = y
		accessor.setValues(vector, Vector2Accessor.XY, newData)

		then:
		vector.x == x
		vector.y == y

		where:
		x << [0, 1, 1, -1, -1]
		y << [0, 1, -1, 1, -1]
	}
	
}
