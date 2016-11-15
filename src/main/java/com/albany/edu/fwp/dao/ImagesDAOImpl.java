package com.albany.edu.fwp.dao;


import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.albany.edu.fwp.model.Images;

public class ImagesDAOImpl implements ImagesDAO {

    private SessionFactory sessionFactory;
 
    public ImagesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional
    public List<Images> list() {
        @SuppressWarnings("unchecked")
        
        String hql = "FROM Images";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<Images> listImages = (List<Images>) query.list();  
        return listImages;
    }	
    
    @Transactional
    public String imagePath(int imageId) {
        @SuppressWarnings("unchecked")
        String imagePath ="";
        String hql = "FROM Images F WHERE F.imageId ="+ imageId;
        System.out.println("Image hql------------>"+hql);
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<Images> listImages = (List<Images>) query.list();  
        imagePath = (String) listImages.get(0).getImagePath();
        return imagePath;
    }	

}

