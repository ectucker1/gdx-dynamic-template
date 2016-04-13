package com.squirrelbot.template.components

import com.badlogic.ashley.core.ComponentMapper

/**
 * Created by Ethan on 3/19/2016.
 */
class Mappers {

	public static ComponentMapper<PositionComponent> posMap = ComponentMapper.getFor(PositionComponent.class);
	public static ComponentMapper<TextureRegionComponent> texMap = ComponentMapper.getFor(TextureRegionComponent.class);

}
