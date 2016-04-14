package com.squirrelbot.template.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.squirrelbot.template.components.Mappers
import com.squirrelbot.template.components.PositionComponent
import com.squirrelbot.template.components.TextureRegionComponent
import groovy.transform.CompileStatic

/**
 * Created by Ethan on 3/19/2016.
 */
@CompileStatic
class RenderSystem extends IteratingSystem {

	SpriteBatch batch

	public RenderSystem(SpriteBatch batch)
	{
		super(Family.all(PositionComponent.class, TextureRegionComponent.class).get())
		this.batch = batch
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {

		PositionComponent pos = Mappers.posMap.get(entity)
		TextureRegionComponent tex = Mappers.texMap.get(entity)

		batch.draw(tex.region, pos.x, pos.y,
				(tex.region.regionWidth * tex.scale).toFloat(), (tex.region.regionHeight * tex.scale).toFloat())

	}

}
