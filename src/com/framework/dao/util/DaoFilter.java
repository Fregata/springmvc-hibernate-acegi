/*
 * @(#)DaoFilter.java
 *       
 * 功能描述：Creates a command to wrap the Hibernate criteria API to filter.
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */ 
package com.framework.dao.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
 
public class DaoFilter implements CriteriaCommand {
    List<Filter> filters = new ArrayList<Filter>();

    public void addFilter(String property, Object value) {
        filters.add(new Filter(property, value));
    }

    public Criteria execute(Criteria criteria) {
        for (Filter filter : filters) {
            buildCriteria(criteria, filter.getProperty(), filter.getValue());
        }

        return criteria;
    }

    private void buildCriteria(Criteria criteria, String property, Object value) {
        if (value != null) {
            criteria.add(Restrictions.like(property, "%" + value + "%").ignoreCase());
        }
    }

    private static class Filter {
        private final String property;
        private final Object value;

        public Filter(String property, Object value) {
            this.property = property;
            this.value = value;
        }

        public String getProperty() {
            return property;
        }

        public Object getValue() {
            return value;
        }
    }
}
