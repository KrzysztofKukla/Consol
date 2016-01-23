package pl.kukla.krzys.consol.dao.impl;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import pl.kukla.krzys.consol.model.AbstractEntity;

/**
 * DAO abstract generic class to use in others DAO classes. 
 * </br>This class contains default implementation from {@link AbstractDao} class
 * and implements {@link CrudRepository}
 * 
 * @author Krzysztof
 *
 * @param {@literal <}E extends {@link AbstractEntity}>
 */
public abstract class AbstractDao<E extends AbstractEntity> implements CrudRepository<E, Long>{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<E> getDomainClass(){
		Class<?> clazz = this.getClass();
		ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
		return (Class<E>) type.getActualTypeArguments()[0];
	}
	
	protected Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	protected Criteria criteria(){
		return session().createCriteria(getDomainClass());
	}

	@Override
	public <S extends E> S save(S entity) {
		session().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public <S extends E> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E findOne(Long id) {
		// TODO
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO
		return false;
	}

	@Override
	public Iterable<E> findAll() {
		// TODO
		return null;
	}

	@Override
	public Iterable<E> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO
		return 0;
	}

	@Override
	public void delete(Long id) {
		
		// TODO
	}

	@Override
	public void delete(E entity) {
		// TODO
	}

	@Override
	public void delete(Iterable<? extends E> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
