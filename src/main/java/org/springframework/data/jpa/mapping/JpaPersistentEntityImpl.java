/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.jpa.mapping;

import java.util.Comparator;

import org.springframework.data.mapping.model.BasicPersistentEntity;
import org.springframework.data.util.TypeInformation;

/**
 * Implementation of {@link JpaPersistentEntity}.
 * 
 * @author Oliver Gierke
 * @since 1.3
 */
class JpaPersistentEntityImpl<T> extends BasicPersistentEntity<T, JpaPersistentProperty> implements
		JpaPersistentEntity<T> {

	/**
	 * Creates a new {@link JpaPersistentEntityImpl} using the given {@link TypeInformation} and {@link Comparator}.
	 * 
	 * @param information must not be {@literal null}.
	 * @param comparator must not be {@literal null}.
	 */
	public JpaPersistentEntityImpl(TypeInformation<T> information, Comparator<JpaPersistentProperty> comparator) {
		super(information, comparator);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.mapping.model.BasicPersistentEntity#returnPropertyIfBetterIdPropertyCandidateOrNull(org.springframework.data.mapping.PersistentProperty)
	 */
	@Override
	protected JpaPersistentProperty returnPropertyIfBetterIdPropertyCandidateOrNull(JpaPersistentProperty property) {
		return property.isIdProperty() ? property : null;
	}
}
