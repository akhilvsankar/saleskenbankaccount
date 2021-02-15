
package com.salesken.bank.mapper;

import java.util.List;
import java.util.Set;

/**
 * The Interface EntityMapper.
 *
 * @param <D> the generic type
 * @param <E> the element type
 */

public interface EntityMapper<D, E> {

	/**
	 * To dto.
	 *
	 * @param entity the entity
	 * @return the d
	 */
	D toDto(E entity);

	/**
	 * To dto.
	 *
	 * @param entityList the entity list
	 * @return the list
	 */
	List<D> toDto(List<E> entityList);

	/**
	 * To dto.
	 *
	 * @param entityList the entity list
	 * @return the sets the
	 */
	Set<D> toDto(Set<E> entityList);

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the e
	 */
	E toEntity(D dto);

	/**
	 * To entity.
	 *
	 * @param dtoList the dto list
	 * @return the list
	 */
	List<E> toEntity(List<D> dtoList);

	/**
	 * To entity.
	 *
	 * @param dtoList the dto list
	 * @return the sets the
	 */
	Set<E> toEntity(Set<D> dtoList);
}
