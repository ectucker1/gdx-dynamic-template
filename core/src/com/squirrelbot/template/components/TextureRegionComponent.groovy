package com.squirrelbot.template.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.TextureRegion
import groovy.transform.CompileStatic

/**
 * Created by Ethan on 2/21/2016.
 */
@CompileStatic
class TextureRegionComponent implements Component {

	TextureRegion region
	float scale

	public TextureRegionComponent(TextureRegion region, float scale)
	{
		this.region = region
		this.scale = scale
	}

}
