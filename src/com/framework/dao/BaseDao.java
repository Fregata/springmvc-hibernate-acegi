/*
 * @(#)BaseDao.java
 *       
 */
package com.framework.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import com.framework.service.BaseCond;

@SuppressWarnings("unchecked")
public class BaseDao extends HibernateDaoSupport implements IBaseDao {
	
	//==================================== LOAD METHOD  ======================================
	
	public Session getCurrentSession()
	{
		return getHibernateTemplate().getSessionFactory().getCurrentSession();		
	}	
	
	public <T> T load(Class<T> entityClass, Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}
 
	public <T> List<T> loadAll(Class<T> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}
 
	public List<?> loadAll(Class<?> entityClass, String orderBy, boolean isAsc) {
		Assert.hasText(orderBy);
		if (isAsc)
			return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(entityClass).addOrder(Order.asc(orderBy)));
		else
			return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(entityClass).addOrder(Order.desc(orderBy)));
	}
	
	public <T> T get(Class<T> entityClass, Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	//================================== SAVE UPDATE DELETE METHOD  ===============================	
	
	public void save(Object o) {
		getHibernateTemplate().save(o);
	}
	public void update(Object o) {
		getHibernateTemplate().update(o);
	}
	 
	public void saveOrUpdate(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
	}
	 
	public void delete(Object o) {
		getHibernateTemplate().delete(o);
	}

	 
	public <T> void delete(Class<T> entityClass, Serializable id) {
		delete(load(entityClass, id));
	}
	
	 
	public void deleteAll(Collection<Object> col){
		getHibernateTemplate().deleteAll(col);
	}
	 
	public void flush() {
		getHibernateTemplate().flush();
	} 
	public void clear() {
		getHibernateTemplate().clear();
	}

	
	//===============================   鏌ヨ鏂规硶  ==============================
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#findBy(java.lang.Class, java.lang.String, java.lang.Object)
	 */
	public <T> List<T> findBy(Class<T> entityClass, String propertyName, Object value) {
		Assert.hasText(propertyName);
		return createCriteria(entityClass, Restrictions.eq(propertyName, value)).list();
	}

	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#findBy(java.lang.Class, java.lang.String, java.lang.Object, java.lang.String, boolean)
	 */
	public <T> List<T> findBy(Class<T> entityClass, String propertyName, Object value, String orderBy, boolean isAsc) {
		Assert.hasText(propertyName);
		Assert.hasText(orderBy);
		return createCriteria(entityClass, orderBy, isAsc, Restrictions.eq(propertyName, value)).list();
	}
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#findByLike(java.lang.Class, java.lang.String, java.lang.String)
	 */
	public <T> List<T> findByLike(Class<T> entityClass, String fieldName,String fieldValue){
		return this.find("From " + entityClass.getName() + " WHERE " + fieldName +" like '" + fieldValue + "'");
	}
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#findByLike(java.lang.Class, java.lang.String, java.lang.String, java.lang.String)
	 */
	public <T> List<T> findByLike(Class<T> entityClass, String fieldName,String fieldValue,String orderFieldName){
		return this.find("From " + entityClass.getName() + " WHERE " + fieldName +" like '" + fieldValue + "' Order by " + orderFieldName);
	}
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#findUniqueBy(java.lang.Class, java.lang.String, java.lang.Object)
	 */
	public <T> T findUniqueBy(Class<T> entityClass, String propertyName, Object value) {
		Assert.hasText(propertyName);
		return (T) createCriteria(entityClass, Restrictions.eq(propertyName, value)).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#findByObject(java.lang.Object)
	 */
	public List<?> findByObject(Object vo){
		return getHibernateTemplate().findByValueBean(DaoUtil.getHqlFromVOProperty(vo), vo); 
	}
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#findFirstVO(java.lang.Class, java.lang.Object)
	 */
	public <T> T findFirstVO(Object vo){
		List list = this.findByObject(vo);
		if(list == null || list.size()==0)
			return null;
		return (T) list.get(0);
	}
	
	

	//=============================== 鏍规嵁 HQL 鏌ヨ ==============================
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#find(java.lang.String, java.lang.Object)
	 */
	public List find(String hql, Object... values) {
		Assert.hasText(hql);
		return getHibernateTemplate().find(hql, values);
	}
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#find(java.lang.String)
	 */
	public List find(String hql){
		return getHibernateTemplate().find(hql);  
	} 
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#find(java.lang.String, int, int)
	 */
	public List find(String hql,int index,int length){
		final String queryString = hql;
		final int _first = index;
		final int _maxLength = length;
		List voList = getHibernateTemplate().executeFind(
				new HibernateCallback(){
					public Object doInHibernate(Session session) throws HibernateException, SQLException{    
						Query q = session.createQuery(queryString);   
						q.setMaxResults(_maxLength);
						q.setFirstResult(_first);   
						List page = q.list();
						return page;
					}
				}
		); 
		return voList;
	}
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#getRecordCount(java.lang.String)
	 */
	public int getRecordCount(String queryString){		
		final String countQueryString = DaoUtil.getHQL4Count(queryString);		
		Long count=(Long) getHibernateTemplate().execute(
				new HibernateCallback(){
					public Object doInHibernate(Session session) throws HibernateException,SQLException{
						Query q=session.createQuery(countQueryString);
						return q.uniqueResult();
					}
				}
			);
		if(count == null){
			return 0;
		}
		return count.intValue();
	}
	 
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#updateByHql(java.lang.String)
	 */
	public int updateByHql(String hql){
		final String hqlFinal= hql;
		Integer count = (Integer)getHibernateTemplate().execute(
				new HibernateCallback(){
					public Object doInHibernate(Session session) throws HibernateException,SQLException{
						Query q=session.createQuery(hqlFinal);
						return new Integer(q.executeUpdate());					
					}
				}
			);
		return count.intValue();
	}

	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#findFirstVO(java.lang.Class, java.lang.String)
	 */
	public <T> T findFirstVO(String hql){
		List list = this.find(hql);
		if(list == null || list.size()==0)
			return null;
		return (T) list.get(0);
	}
	
	
	
	//===============================    锟斤拷询锟斤拷菘锟� 锟斤拷锟斤拷  ==============================
	/**
	 * 锟斤拷锟斤拷Query锟斤拷锟斤拷. 锟斤拷锟斤拷锟斤拷要first,max,fetchsize,cache,cacheRegion锟斤拷锟斤拷锟斤拷锟斤拷玫暮锟斤拷锟�锟斤拷锟斤拷锟节凤拷锟斤拷Query锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷.
	 * 锟斤拷锟斤拷锟斤拷锟絣锟斤拷锟斤拷锟斤拷,锟斤拷锟铰ｏ拷
	 * <pre>
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * </pre>
	 * 锟斤拷锟矫凤拷式锟斤拷锟铰ｏ拷
	 * <pre>
	 *        dao.createQuery(hql)
	 *        dao.createQuery(hql,arg0);
	 *        dao.createQuery(hql,arg0,arg1);
	 *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * </pre>
	 *
	 * @param values 锟缴憋拷锟斤拷锟�
	 */
	public Query createQuery(String hql, Object... values) {
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}

	/**
	 * 锟斤拷锟斤拷Criteria锟斤拷锟斤拷.
	 *
	 * @param criterions 锟缴憋拷锟絉estrictions锟斤拷锟斤拷斜锟�锟斤拷{@link #createQuery(String,Object...)}
	 */
	private <T> Criteria createCriteria(Class<T> entityClass, Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	/**
	 * 锟斤拷锟斤拷Criteria锟斤拷锟襟，达拷锟斤拷锟斤拷锟街讹拷锟斤拷锟斤拷锟斤拷锟街讹拷.
	 *
	 * @see #createCriteria(Class,Criterion[])
	 */
	private <T> Criteria createCriteria(Class<T> entityClass, String orderBy, boolean isAsc, Criterion... criterions) {
		Assert.hasText(orderBy);

		Criteria criteria = createCriteria(entityClass, criterions);

		if (isAsc)
			criteria.addOrder(Order.asc(orderBy));
		else
			criteria.addOrder(Order.desc(orderBy));

		return criteria;
	} 

	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#isUniquePropertyNames(java.lang.Class, java.lang.Object, java.lang.String)
	 */
	public <T> boolean isUniquePropertyNames(Class<T> entityClass, Object entity, String uniquePropertyNames) {
		Assert.hasText(uniquePropertyNames);
		Criteria criteria = createCriteria(entityClass).setProjection(Projections.rowCount());
		String[] nameList = uniquePropertyNames.split(",");
		try {
			// 循锟斤拷锟斤拷锟斤拷唯一锟斤拷
			for (String name : nameList) {
				criteria.add(Restrictions.eq(name, PropertyUtils.getProperty(entity, name)));
			}

			// 锟斤拷锟铰达拷锟斤拷为锟斤拷锟斤拷锟斤拷锟絬pdate锟斤拷锟斤拷锟�锟脚筹拷entity锟斤拷锟斤拷.
			String idName = getIdName(entityClass);

			// 取锟斤拷entity锟斤拷锟斤拷锟街�
			Serializable id = getId(entityClass, entity);

			// 锟斤拷锟絠d!=null,说锟斤拷锟斤拷锟斤拷汛锟斤拷锟�锟矫诧拷锟斤拷为update,锟斤拷锟斤拷锟脚筹拷锟斤拷锟斤拷锟斤拷卸锟�
			if (id != null)
				criteria.add(Restrictions.not(Restrictions.eq(idName, id)));
		} catch (Exception e) {
			ReflectionUtils.handleReflectionException(e);
		}
		return (Integer) criteria.uniqueResult() == 0;
	}

	/**
	 * 取锟矫讹拷锟斤拷锟斤拷锟斤拷值,锟斤拷锟斤拷锟斤拷.
	 */
	private Serializable getId(Class entityClass, Object entity) throws NoSuchMethodException, IllegalAccessException,InvocationTargetException {
		Assert.notNull(entity);
		Assert.notNull(entityClass);
		return (Serializable) PropertyUtils.getProperty(entity, getIdName(entityClass));
	}

	/**
	 * 取锟矫讹拷锟斤拷锟斤拷锟斤拷锟斤拷,锟斤拷锟斤拷锟斤拷.
	 */
	private String getIdName(Class clazz) {
		Assert.notNull(clazz);
		ClassMetadata meta = getSessionFactory().getClassMetadata(clazz);
		Assert.notNull(meta, "Class " + clazz + " not define in hibernate session factory.");
		String idName = meta.getIdentifierPropertyName();
		Assert.hasText(idName, clazz.getSimpleName() + " has no identifier property define.");
		return idName;
	}
	

	///////////////////////////////////////////////////////////////////////////////////////////////////
	//                                鏍规嵁鏍囧噯鐨凷QL璇彞鍙栧緱鐩稿簲鐨勬暟鎹�
	///////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 鏍规嵁鏍囧噯鐨凷QL璇彞鍙栧緱鐩稿簲鐨勬暟鎹垪琛�
	 * 
	 * @param sql
	 * @return
	 * @throws DataAccessException
	 */
	public List findWithSQL(final String sql) {
		List list = (List) this.getHibernateTemplate().execute(
            new HibernateCallback() {
                public Object doInHibernate(Session session) throws SQLException, HibernateException {
                    SQLQuery query = session.createSQLQuery(sql);
                    List children = query.list();
                    return children;
                }
            });
        return list;
    }

	public List sqlQuery(final String sql) {
		List list = (List) this.getHibernateTemplate().execute(
            new HibernateCallback() {
                public Object doInHibernate(Session session) throws SQLException, HibernateException {
                    SQLQuery query = session.createSQLQuery(sql);
                    List children = query.list();
                    return children;
                }
            });
        return list;
    }
	
	public List sqlQueryAnaity(final String sql, final Class<?> classAnaity) {
		List list = (List) this.getHibernateTemplate().execute(
            new HibernateCallback() {
                public Object doInHibernate(Session session) throws SQLException, HibernateException {
                    SQLQuery query = session.createSQLQuery(sql).addEntity(classAnaity);
                    List children = query.list();
                    return children;
                }
            });
        return list;
    }
	
	public String sqlUpdate(final String sql) {
		Object result = this.getHibernateTemplate().execute(
            new HibernateCallback() {
                public Object doInHibernate(Session session) throws SQLException, HibernateException {
                    SQLQuery query = session.createSQLQuery(sql);
                    return query.executeUpdate();
                }
            });
        return result.toString();
    }
	 
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//                                 HQL  鍗犱綅绗�
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List psFind(final String hql, final BaseCond cond){
		final String queryString = hql; 
		List voList = getHibernateTemplate().executeFind(
			new HibernateCallback(){
				public Object doInHibernate(Session session) throws HibernateException, SQLException{    
					Query q = session.createQuery(queryString); 
					//prepareQuery(query);
					q.setProperties(cond);
	                return q.list(); 
				}
			}
		); 
		return voList;  
	} 
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#find(java.lang.String, int, int)
	 */
	public List psFind(String hql,int index,int length, final BaseCond cond){
		final String queryString = hql;
		final int _first = index;
		final int _maxLength = length;
		List voList = getHibernateTemplate().executeFind(
				new HibernateCallback(){
					public Object doInHibernate(Session session) throws HibernateException, SQLException{    
						Query q = session.createQuery(queryString);   
						q.setMaxResults(_maxLength);
						q.setFirstResult(_first);   
						q.setProperties(cond);
		                return q.list(); 
					}
				}
		); 
		return voList;
	}
	
	/* (non-Javadoc)
	 * @see com.ebiz.framework.service.util.IBaseDao#getRecordCount(java.lang.String)
	 */
	public int psGetRecordCount(String queryString, final BaseCond cond){
		final String countQueryString = DaoUtil.getHQL4Count(queryString);		
		Long count=(Long) getHibernateTemplate().execute(
				new HibernateCallback(){
					public Object doInHibernate(Session session) throws HibernateException,SQLException{
						Query q = session.createQuery(countQueryString);
						q.setProperties(cond);
						return q.uniqueResult();
					}
				}
			);
		if(count == null){
			return 0;
		}
		return count.intValue();
	}

	public List<?> findByCriteria(DetachedCriteria detachedCriteria)
	{
			return  getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	
}