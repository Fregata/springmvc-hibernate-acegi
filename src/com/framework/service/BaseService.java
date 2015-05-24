/*
 * @(#)BaseService.java
 *       
 * 功能描述：基础服务器类，采用Delegate设计模式，隔离逻辑和数据访问层
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.framework.dao.IBaseDao;
import com.framework.exception.BaseAppException;

public class BaseService implements ApplicationContextAware, IBaseService
{
	protected ApplicationContext applicationContext = null;
    protected transient final Logger log = Logger.getLogger(this.getClass().getName());

	protected ApplicationContext getContext()
	{
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		this.applicationContext = applicationContext;
		ctx = applicationContext;
	}

	/**
	 * Convenience method to get Spring-initialized beans
	 * 
	 * @param name
	 * @return Object bean from ApplicationContext
	 */
	public Object getBean(String name)
	{
		return applicationContext.getBean(name);
	}

	// ////////////////////////////////////////////////////
	// 设置静态的SPRING上线文环境，便于Manager以外的代码调用
	public static ApplicationContext ctx = null;

	public static Object getBeanStatic(String name)
	{
		return ctx.getBean(name);
	}

	// //////////////////////////////////////////////////

	/**
	 * 取得翻页数据
	 * 
	 * @param cond
	 * @return Object bean from ApplicationContext
	 */
	public List findByCondWithPagination(BaseCond cond) throws BaseAppException
	{
		String hql = cond.createQueryString();
		// return this.find(hql, cond.getStart(), cond.getPageSize());
		return this.baseDao.psFind(hql, cond.getStart(), cond.getPageSize(), cond);
	}

	/**
	 * 取得所有数据
	 * 
	 * @param cond
	 * @return Object bean from ApplicationContext
	 */
	public List findByCondNoPagination(BaseCond cond) throws BaseAppException
	{
		String hql = cond.createQueryString();
		// return this.find(hql);
		return this.baseDao.psFind(hql, cond);
	}

	public int getRecordCount(BaseCond cond)
	{
		String hql = cond.createQueryString();
		return this.baseDao.psGetRecordCount(hql, cond);
	}

	/**
	 * 判定纪录的唯一性
	 * 
	 * @param cond
	 * @return Object bean from ApplicationContext
	 */
	public boolean isUnique(BaseCond cond) throws BaseAppException
	{
		if (this.getRecordCount(cond.getHQL()) == 1)
			return true;
		return false;
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////
	// //
	// 采用Delegate设计模式，隔离逻辑和数据访问层 //
	// //
	// /////////////////////////////////////////////////////////////////////////////////////////////////

	private IBaseDao baseDao = null;

	public IBaseDao getBaseDao()
	{
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao)
	{
		this.baseDao = baseDao;
	}

	public Session getCurrentSession()
	{
		return baseDao.getCurrentSession();		
	}	

	// ==================================== LOAD METHOD
	// ======================================
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#load(java.lang.Class,
	 *      java.io.Serializable)
	 */
	public <T> T load(Class<T> entityClass, Serializable id)
	{
		return (T) this.baseDao.load(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#loadAll(java.lang.Class)
	 */
	public <T> List<T> loadAll(Class<T> entityClass)
	{
		return this.baseDao.loadAll(entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#loadAll(java.lang.Class,
	 *      java.lang.String, boolean)
	 */
	public List<?> loadAll(Class<?> entityClass, String orderBy, boolean isAsc)
	{
		return this.baseDao.loadAll(entityClass, orderBy, isAsc);
	}

	/**
	 * 根据ID获取对象. 实际调用Hibernate的session.get()方法返回实体或NULL.
	 */
	public <T> T get(Class<T> entityClass, Serializable id)
	{
		return (T) this.baseDao.get(entityClass, id);
	}

	// ================================== SAVE UPDATE DELETE METHOD
	// ===============================

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#save(java.lang.Object)
	 */
	public void save(Object o)
	{
		this.baseDao.save(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#update(java.lang.Object)
	 */
	public void update(Object o)
	{
		this.baseDao.update(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#saveOrUpdate(java.lang.Object)
	 */
	public void saveOrUpdate(Object o)
	{
		this.baseDao.saveOrUpdate(o);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#delete(java.lang.Object)
	 */
	public void delete(Object o)
	{
		this.baseDao.delete(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#delete(java.lang.Class,
	 *      java.io.Serializable)
	 */
	public <T> void delete(Class<T> entityClass, Serializable id)
	{
		delete(load(entityClass, id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#delete(java.util.Collection)
	 */
	public void deleteAll(Collection<Object> col)
	{
		this.baseDao.deleteAll(col);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#flush()
	 */
	public void flush()
	{
		this.baseDao.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#clear()
	 */
	public void clear()
	{
		this.baseDao.clear();
	}

	// =============================== 简化处理单表查询：利用范型查询单张表格
	// ==============================

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#findBy(java.lang.Class,
	 *      java.lang.String, java.lang.Object)
	 */
	public <T> List<T> findBy(Class<T> entityClass, String propertyName, Object value)
	{
		return this.baseDao.findBy(entityClass, propertyName, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#findBy(java.lang.Class,
	 *      java.lang.String, java.lang.Object, java.lang.String, boolean)
	 */
	public <T> List<T> findBy(Class<T> entityClass, String propertyName, Object value,
			String orderBy, boolean isAsc)
	{
		return this.baseDao.findBy(entityClass, propertyName, value, orderBy, isAsc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#findByLike(java.lang.Class,
	 *      java.lang.String, java.lang.String)
	 */
	public <T> List<T> findByLike(Class<T> entityClass, String fieldName, String fieldValue)
	{
		return this.baseDao.findByLike(entityClass, fieldName, fieldValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#findByLike(java.lang.Class,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public <T> List<T> findByLike(Class<T> entityClass, String fieldName, String fieldValue,
			String orderFieldName)
	{
		return this.baseDao.findByLike(entityClass, fieldName, fieldValue, orderFieldName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#findUniqueBy(java.lang.Class,
	 *      java.lang.String, java.lang.Object)
	 */
	public <T> T findUniqueBy(Class<T> entityClass, String propertyName, Object value)
	{
		return this.baseDao.findUniqueBy(entityClass, propertyName, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#findByObject(java.lang.Object)
	 */
	public <T> List<T> findByObject(Object vo)
	{
		return this.baseDao.findByObject(vo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#findFirstVO(java.lang.Object)
	 */
	public <T> T findFirstVO(Object vo)
	{
		return (T)this.baseDao.findFirstVO(vo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#isUniquePropertyNames(java.lang.Class,
	 *      java.lang.Object, java.lang.String)
	 */
	public <T> boolean isUniquePropertyNames(Class<T> entityClass, Object entity,
			String uniquePropertyNames)
	{
		return this.baseDao.isUniquePropertyNames(entityClass, entity, uniquePropertyNames);
	}

	// =============================== 复杂查询数据库: HQL语句查询、分页、计算纪录数
	// ==============================

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#find(java.lang.String,
	 *      java.lang.Object[])
	 */
	public List find(String hql, Object... values)
	{
		return this.baseDao.find(hql, values);
	}
	
	public Query createQuery(String hql, Object... values)
	{
		return this.baseDao.createQuery(hql, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#find(java.lang.String)
	 */
	public List find(String hql)
	{
		return this.baseDao.find(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#find(java.lang.String, int, int)
	 */
	public List find(String hql, int index, int length)
	{
		return this.baseDao.find(hql, index, length);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#getRecordCount(java.lang.String)
	 */
	public int getRecordCount(String queryString)
	{
		return this.baseDao.getRecordCount(queryString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#updateByHql(java.lang.String)
	 */
	public int updateByHql(String hql)
	{
		return this.baseDao.updateByHql(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ebiz.framework.dao.IBaseDao#findFirstVO(java.lang.String)
	 */
	public <T> T findFirstVO(String hql)
	{
		return (T)this.baseDao.findFirstVO(hql);
	}

	/**
	 * 可以直接使用 标准的SQL语句，非常原始，需要进步一步的包装
	 * 
	 * @param sql
	 * @return
	 * @throws
	 */
	public List findWithSQL(final String sql)
	{
		return this.baseDao.findWithSQL(sql);
	}
	
	public List findWithSQLAnaity(final String sql, final Class<?> classAnaity)
	{
		return this.baseDao.sqlQueryAnaity(sql, classAnaity);
	}

	public List sqlQuery(final String sql)
	{
		return this.baseDao.sqlQuery(sql);
	}

	public String sqlUpdate(final String sql)
	{
		return this.baseDao.sqlUpdate(sql);
	}

	public <T> List<T> findByCrteria(DetachedCriteria detachedCriteria)
	{
		return this.baseDao.findByCriteria(detachedCriteria);
	}

	// ////////////////////////////////////////////////////////////////////////////////////
	// HQL 用占位符(解决SQL注入的问题）
	// ////////////////////////////////////////////////////////////////////////////////////

	// public List findByCondWithPagination(BaseCond cond){
	// String hql = cond.createQueryString();
	// return this.baseDao.psFind(hql,cond);
	// }
	//	
	// public List findByCondNoPagination(BaseCond cond,int index,int length){
	// String hql = cond.createQueryString();
	// return this.baseDao.psFind(hql,index,length,cond);
	//	} 
}
