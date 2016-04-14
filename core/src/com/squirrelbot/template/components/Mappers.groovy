package com.squirrelbot.template.components

import com.badlogic.ashley.core.ComponentMapper
import groovy.transform.CompileStatic

/**
 * Created by Ethan on 3/19/2016.
 */
@CompileStatic
class Mappers {

	public static ComponentMapper<PositionComponent> posMap = ComponentMapper.getFor(PositionComponent.class);
	public static ComponentMapper<TextureRegionComponent> texMap = ComponentMapper.getFor(TextureRegionComponent.class);

}
