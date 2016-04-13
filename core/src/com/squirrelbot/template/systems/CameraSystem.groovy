package com.squirrelbot.template.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.graphics.Camera
import com.squirrelbot.template.components.CameraFollowComponent
import com.squirrelbot.template.components.Mappers
import com.squirrelbot.template.components.PositionComponent

/**
 * Created by Ethan on 4/9/2016.
 */
class CameraSystem extends IteratingSystem {

	Camera camera

	public CameraSystem(Camera camera)
	{
		super(Family.all(CameraFollowComponent.class, PositionComponent.class).get())
		this.camera = camera
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {

		PositionComponent pos = Mappers.posMap.get(entity)

		camera.position.set(pos.x, pos.y, 0)
	}

}