package com.squirrelbot.template.tween

import com.badlogic.gdx.graphics.Color
import spock.lang.Specification

/**
 * Created by Ethan on 4/12/2016.
 */
class ColorAccessorTest extends Specification {

	def "test returns number of values"()
	{
		setup:
		ColorAccessor accessor = new ColorAccessor()

		Color color = Mock(Color)
		float[] returnData = new float[2]

		expect:
		accessor.getValues(color, type, returnData) == number

		where:
		type | number
		ColorAccessor.R | 1
		ColorAccessor.G | 1
    ColorAccessor.B | 1
		ColorAccessor.RGB | 3
	}

	def "test get R values equal"()
	{
		setup:
		ColorAccessor accessor = new ColorAccessor()

		Color color = Mock(Color)
		float[] returnData = new float[3]

		when:
		color.r = r
		accessor.getValues(color, ColorAccessor.R, returnData)

		then:
		returnData[0] == r

		where:
		r << [0, 0.5f, 1]
	}

  def "test get G values equal"()
	{
		setup:
		ColorAccessor accessor = new ColorAccessor()

		Color color = Mock(Color)
		float[] returnData = new float[3]

		when:
		color.g = g
		accessor.getValues(color, ColorAccessor.G, returnData)

		then:
		returnData[0] == g

		where:
		g << [0, 0.5f, 1]
	}

  def "test get B values equal"()
  {
    setup:
    ColorAccessor accessor = new ColorAccessor()

    Color color = Mock(Color)
    float[] returnData = new float[3]

    when:
    color.b = b
    accessor.getValues(color, ColorAccessor.B, returnData)

    then:
    returnData[0] == b

    where:
    b << [0, 0.5f, 1]
  }

	def "test get RGB values equal"()
	{
		setup:
		ColorAccessor accessor = new ColorAccessor()

		Color color = Mock(Color)
		float[] returnData = new float[3]

		when:
		color.r = r
		color.g = g
    color.b = b
		accessor.getValues(color, ColorAccessor.RGB, returnData)

		then:
		returnData[0] == r
		returnData[1] == g
    returnData[2] == b

		where:
		r << [0, 0.5f, 1]
    g << [1, 0, 0.5f]
		b << [0.5f, 1, 0]
	}

	def "test set values sets R value"()
	{
		setup:
		ColorAccessor accessor = new ColorAccessor()

		Color color = Stub(Color) {
			setR(_) >> { float r ->
				it.r >> r
			}
		}
		float[] newData = new float[3]

		when:
		newData[0] = r
		accessor.setValues(color, ColorAccessor.R, newData)

		then:
		color.r == r

		where:
		r << [0, 0.5f, 1]
	}

  def "test set values sets G value"()
  {
    setup:
    ColorAccessor accessor = new ColorAccessor()

    Color color = Stub(Color) {
      setG(_) >> { float g ->
        it.g >> g
      }
    }
    float[] newData = new float[3]

    when:
    newData[0] = g
    accessor.setValues(color, ColorAccessor.G, newData)

    then:
    color.g == g

    where:
    g << [0, 0.5f, 1]
  }

  def "test set values sets B value"()
  {
    setup:
    ColorAccessor accessor = new ColorAccessor()

    Color color = Stub(Color) {
      setB(_) >> { float b ->
        it.b >> b
      }
    }
    float[] newData = new float[3]

    when:
    newData[0] = b
    accessor.setValues(color, ColorAccessor.B, newData)

    then:
    color.b == b

    where:
    b << [0, 0.5f, 1]
  }

	def "test set values sets RGB value"()
	{
		setup:
		ColorAccessor accessor = new ColorAccessor()

		Color color = Stub(Color) {
			setR(_) >> { float r ->
				it.r >> r
			}
      setG(_) >> { float g ->
        it.g >> g
      }
      setB(_) >> { float b ->
        it.b >> b
      }
		}
		float[] newData = new float[3]

		when:
		newData[0] = r
		newData[1] = g
    newData[2] = b
		accessor.setValues(color, ColorAccessor.RGB, newData)

		then:
		color.r == r
		color.g == g
    color.b == b

		where:
    r << [0, 0.5f, 1]
    g << [1, 0, 0.5f]
		b << [0.5f, 1, 0]
	}

}
