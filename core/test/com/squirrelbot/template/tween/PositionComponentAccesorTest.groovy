package com.squirrelbot.template.tween

import com.squirrelbot.template.components.PositionComponent
import spock.lang.Specification

/**
 * Created by Ethan on 4/12/2016.
 */
class PositionComponentAccesorTest extends Specification {

	def "returns number of values"()
	{
		setup:
		PositionComponentAccesor accessor = new PositionComponentAccesor()

		PositionComponent component = Mock(PositionComponent)
		float[] returnData = new float[2]

		expect:
		accessor.getValues(component, type, returnData) == number

		where:
		type | number
		PositionComponentAccesor.X | 1
		PositionComponentAccesor.X | 1
		PositionComponentAccesor.XY | 2
	}

	def "get X values equal"()
	{
		setup:
		PositionComponentAccesor accessor = new PositionComponentAccesor()

		PositionComponent component = Mock(PositionComponent)
		float[] returnData = new float[2]

		when:
		component.x >> x
		accessor.getValues(component, PositionComponentAccesor.X, returnData)

		then:
		returnData[0] == x

		where:
		x << [0, 1, -1]
	}

	def "get Y values equal"()
	{
		setup:
		PositionComponentAccesor accessor = new PositionComponentAccesor()

		PositionComponent component = Mock(PositionComponent)
		float[] returnData = new float[2]

		when:
		component.y >> y
		accessor.getValues(component, PositionComponentAccesor.Y, returnData)

		then:
		returnData[0] == y

		where:
		y << [0, 1, -1]
	}

	def "get XY values equal"()
	{
		setup:
		PositionComponentAccesor accessor = new PositionComponentAccesor()

		PositionComponent component = Mock(PositionComponent)
		float[] returnData = new float[2]

		when:
		component.x >> x
		component.y >> y
		accessor.getValues(component, PositionComponentAccesor.XY, returnData)

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
		PositionComponentAccesor accessor = new PositionComponentAccesor()

		PositionComponent component = new PositionComponent(0, 0)
		float[] newData = new float[2]

		when:
		newData[0] = x
		accessor.setValues(component, PositionComponentAccesor.X, newData)

		then:
		component.x == x

		where:
		x << [0, 1, -1]
	}

	def "set values sets Y value"()
	{
		setup:
		PositionComponentAccesor accessor = new PositionComponentAccesor()

		PositionComponent component = new PositionComponent(0, 0)
		float[] newData = new float[2]

		when:
		newData[0] = y
		accessor.setValues(component, PositionComponentAccesor.Y, newData)

		then:
		component.y == y

		where:
		y << [0, 1, -1]
	}

	def "set values sets XY value"()
	{
		setup:
		PositionComponentAccesor accessor = new PositionComponentAccesor()

		PositionComponent component = new PositionComponent(0, 0)
		float[] newData = new float[2]

		when:
		newData[0] = x
		newData[1] = y
		accessor.setValues(component, PositionComponentAccesor.XY, newData)

		then:
		component.x == x
		component.y == y

		where:
		x << [0, 1, 1, -1, -1]
		y << [0, 1, -1, 1, -1]
	}

}
