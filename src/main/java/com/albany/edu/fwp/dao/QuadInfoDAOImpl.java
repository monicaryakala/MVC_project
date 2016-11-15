package com.albany.edu.fwp.dao;

	
	import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.albany.edu.fwp.model.MealCourse;
import com.albany.edu.fwp.model.QuadInfo;;

	public class QuadInfoDAOImpl implements QuadInfoDAO {

	    private SessionFactory sessionFactory;
	 
	    public QuadInfoDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    
	    @Transactional
	    public QuadInfo getQuadInfo(int quadId){
	    	String hql = "FROM QuadInfo F WHERE F.quadId = '"+quadId+"'";
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
	        QuadInfo quadInfo = (QuadInfo) query.list().get(0); 
	        return quadInfo;
	    	
	    }
	    
	   
	    
	    @Transactional
	    public List<QuadInfo> list() {
	        @SuppressWarnings("unchecked")
	        
	        String hql = "FROM QuadInfo";
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
	        List<QuadInfo> listQuad = (List<QuadInfo>) query.list();  
	        return listQuad;
	    }	
	    
	    @Transactional
		public void insert(int quadId, String quadName){
	    	QuadInfo quadInfo = new QuadInfo();
	    	quadInfo.setQuadId(quadId);
	    	quadInfo.setQuadName(quadName);
	    	sessionFactory.getCurrentSession().save(quadInfo);	    	
	    }
	    
	    @Transactional
		public void delete(int quadId, String quadName){
	    	String hql = "DELETE QuadInfo F WHERE F.quadId = '"+quadId+"'";
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
	        query.executeUpdate();   	
	    }
	    
	    @Transactional
	    public void update(int quadId, String quadName){
	    	String hql = "UPDATE QuadInfo F set F.quadName='"+quadName+"' WHERE F.quadId = '"+quadId+"'";
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
	        query.executeUpdate();   	
	    }

}
