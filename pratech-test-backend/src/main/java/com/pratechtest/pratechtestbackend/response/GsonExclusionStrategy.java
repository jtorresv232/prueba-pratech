package com.pratechtest.pratechtestbackend.response;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.pratechtest.pratechtestbackend.entity.GsonExcludeProperty;


public class GsonExclusionStrategy implements ExclusionStrategy {

	@Override
	public boolean shouldSkipField(FieldAttributes field) {
		return field.getAnnotation(GsonExcludeProperty.class) != null;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return clazz.getAnnotation(GsonExcludeProperty.class) != null;
	}
}
