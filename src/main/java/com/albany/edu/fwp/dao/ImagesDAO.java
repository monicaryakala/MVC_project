package com.albany.edu.fwp.dao;

import java.util.List;

import com.albany.edu.fwp.model.Images;;

public interface ImagesDAO {
	List<Images> list();
	String imagePath(int imageId);
}

