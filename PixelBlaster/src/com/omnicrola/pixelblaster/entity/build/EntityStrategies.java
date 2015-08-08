package com.omnicrola.pixelblaster.entity.build;

import java.util.Map;

public class EntityStrategies {
	private final Map<EntityType, IEntityFactoryStrategy> factoryStrategies;

	public EntityStrategies(Map<EntityType, IEntityFactoryStrategy> factoryStrategies) {
		this.factoryStrategies = factoryStrategies;
	}

	public IEntityFactoryStrategy getStrategy(EntityType entityType) {
		return this.factoryStrategies.get(entityType);
	}

}
