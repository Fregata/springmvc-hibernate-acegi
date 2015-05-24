/*
 * @(#)IBaseService.java
 *       
 * 功能描述：基础服务的接口
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

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

import com.framework.exception.BaseAppException;

public interface IBaseService {

	/**
	 * Convenience method to get Spring-initialized beans
	 * @param name
	 * @return Object bean from ApplicationContext
	 */
	public abstract Object getBean(String name);

	/**
	 * 取得翻页数据
	 * 
	 * @param cond
	 * @return Object bean from ApplicationContext 
	 */
	public abstract List findByCondWithPagination(BaseCond cond)throws BaseAppException;

	/**
	 * 取得所有数据
	 * 
	 * @param cond
	 * @return Object bean from ApplicationContext 
	 */
	public abstract List findByCondNoPagination(BaseCond cond)throws BaseAppException;

	/**
	 * 基于占位符的查询：取得记录数目
	 * 
	 * @param cond
	 * @return Object bean from ApplicationContext 
	 */
	public abstract int getRecordCount(BaseCond cond)throws BaseAppException;
	
	/**
	 * 判定纪录的唯一性
	 * 
	 * @param cond
	 * @return Object bean from ApplicationContext
	 */
	public abstract boolean isUnique(BaseCond cond) throws BaseAppException;


	//==================================== LOAD METHOD  ======================================
	public abstract <T> List<T> findByCrteria(DetachedCriteria detachedCriteria);
	/**
	 * 根据ID获取对象. 实际调用Hibernate的session.load()方法返回实体或其proxy对象. 如果对象不存在，抛出异常.
	 * lazy属性为true，如果脱离了session上下文，除了ID值之外无法取得其他属性的值
	 */
	public abstract <T> T load(Class<T> entityClass, Serializable id);

	/**
	 * 获取全部对象.
	 */
	public abstract <T> List<T> loadAll(Class<T> entityClass);

	/**
	 * 获取全部对象,带排序字段与升降序参数.
	 */
	public abstract List<?> loadAll(Class<?> entityClass, String orderBy, boolean isAsc);
	
	/**
	 * 根据ID获取对象. 实际调用Hibernate的session.get()方法返回实体或NULL.
	 */
	public <T> T get(Class<T> entityClass, Serializable id);


	//================================== SAVE UPDATE DELETE METHOD  ===============================	

	/** 保存对象. */
	public abstract void save(Object o);

	/** 更新对象. */
	public abstract void update(Object o);
	
	/** 保存或更新对象. */
	public abstract void saveOrUpdate(Object o);


	/** 删除对象.*/
	public abstract void delete(Object o);

	/** 根据ID删除对象.*/
	public abstract <T> void delete(Class<T> entityClass, Serializable id); 

	/** 批量删除 */
	public abstract void deleteAll(Collection<Object> col);

	public abstract void flush();

	public abstract void clear();

	//===============================    简化处理单表查询：利用范型查询单张表格  ==============================
	/**
	 * 根据属性名和属性值查询对象.
	 *
	 * @param <T>
	 * @param entityClass   表格的名字
	 * @param fieldName     字段名称
	 * @param fieldValue    字符型查询值
	 * @return 符合条件的对象列表
	 */
	public abstract <T> List<T> findBy(Class<T> entityClass,
			String propertyName, Object value);

	/**
	 * 根据属性名和属性值查询对象,带排序参数.
	 * 
	 * @param <T>
	 * @param entityClass   表格的名字
	 * @param fieldName     字段名称
	 * @param fieldValue    字符型查询值
	 * @return 符合条件的对象列表
	 */
	public abstract <T> List<T> findBy(Class<T> entityClass,
			String propertyName, Object value, String orderBy, boolean isAsc);

	/**
	 * 根据属性名和属性值查询对象,利用 Like 语句
	 * 
	 * @param <T>
	 * @param entityClass   表格的名字
	 * @param fieldName     字段名称
	 * @param fieldValue    字符型查询值
	 * @return              符合条件的对象列表
	 */
	public abstract <T> List<T> findByLike(Class<T> entityClass,
			String fieldName, String fieldValue);

	/**
	 * 查询条件为VO的属性，查询的结果为此VO的列表
	 * 
	 * @param <T>
	 * @param entityClass     表格的名字
	 * @param fieldName       字段名称
	 * @param fieldValue      查询值
	 * @param orderFieldName  排序字段名称
	 * @return                符合条件的对象列表
	 */
	public abstract <T> List<T> findByLike(Class<T> entityClass,
			String fieldName, String fieldValue, String orderFieldName);

	/**
	 * 根据属性名和属性值查询唯一对象.
	 *
	 * @return 符合条件的唯一对象 or null if not found.
	 */
	public abstract <T> T findUniqueBy(Class<T> entityClass,
			String propertyName, Object value);

	/**
	 * 查询条件为VO的属性，查询的结果为此VO的列表
	 * 
	 * @param vo  查询条件
	 * @return
	 */
	public abstract <T> List<T> findByObject(Object vo);

	/**
	 * 查询条件为VO的属性，查询的结果为此VO；如果有多个符合此查询条件的值，返回第一个 
	 * @param vo  查询条件
	 * @return
	 */
	public abstract <T> T findFirstVO(Object vo);

	/**
	 * 根据hql查询,直接使用HibernateTemplate的find函数.
	 *
	 * @param values 可变参数,见{@link #createQuery(String,Object...)}
	 */
	public abstract List find(String hql, Object... values);

	/**
	 * 按照查询条件查询，可以支持多表连接
	 * 
	 * @param hql HQL查询语句
	 * @return    List of VO
	 * @throws    DataAccessException
	 */
	public abstract List find(String hql);

	/**
	 * 分页查询
	 * 
	 * @param hql     查询语句
	 * @param index   开始值
	 * @param length  结束值
	 * @return
	 */
	public abstract List find(String hql, int index, int length);

	/**
	 * 根据查询条件计算符合条件的纪录数目
	 * 
	 * 利用 DaoUtil
	 * 
	 * @param queryHql  查询条件
	 * @return
	 */
	public abstract int getRecordCount(String queryString);

	/**
	 * 根据ＳＱＬ语句来更新数据库
	 * 可以批量删除、更新数据库纪录
	 * 
	 * @param hql
	 * @return
	 * @throws DataAccessException
	 */
	public abstract int updateByHql(String hql);

	 

	/**
	 * 如果有多个符合此查询条件的值，返回第一个
	 * 
	 * @param hql  查询条件
	 * @return
	 */
	public abstract <T> T findFirstVO(String hql);

	/**
	 * 判断对象某些属性的值在数据库中是否唯一.
	 *
	 * @param uniquePropertyNames 在POJO里不能重复的属性列表,以逗号分割 如"name,loginid,password"
	 */
	public abstract <T> boolean isUniquePropertyNames(Class<T> entityClass,
			Object entity, String uniquePropertyNames);
	

	/**
	 * 可以直接使用 标准的SQL语句，非常原始，需要进步一步的包装
	 * 
	 * @param sql
	 * @return
	 * @throws DataAccessException
	 */
	public abstract List findWithSQL(final String sql);
	
	public List findWithSQLAnaity(final String sql, final Class<?> classAnaity);
	
	public List sqlQuery(final String sql) ;
	
	public String sqlUpdate(final String sql);

	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//                                 HQL  占位符
	///////////////////////////////////////////////////////////////////////////////////////////////////
//	public List psFind(BaseCond cond);
//	
//	public List psFind(BaseCond cond,int index,int length);
//	 
//	public int psGetRecordCount(BaseCond cond);
}