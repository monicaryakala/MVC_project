package com.albany.edu.fwp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.albany.edu.fwp.model.QuadInfo;
import com.albany.edu.fwp.model.Config;;



public class ConfigDAOImpl implements ConfigDAO {
	private SessionFactory sessionFactory;
	 
    public ConfigDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

@Transactional
public void update(int configId, String managerTime, String studentTime){
	String hql = "UPDATE Config F set F.studentTime='"+studentTime+"', F.managerTime='"+managerTime+"' WHERE F.configId = '"+configId+"'";
    Query query = sessionFactory.getCurrentSession().createQuery(hql);
    query.executeUpdate(); 
}

@Transactional
public List<Config> list() {
    String hql = "FROM Config";
    Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<Config> listConfig = query.list();  
    return listConfig;
}	

}
