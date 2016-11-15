package com.albany.edu.fwp.dao;

import java.util.List;

import com.albany.edu.fwp.model.MealCourse;
import com.albany.edu.fwp.model.QuadInfo;
import com.albany.edu.fwp.model.Student;

public interface QuadInfoDAO {
	QuadInfo getQuadInfo(int quadId);
	List<QuadInfo> list();
	void insert(int quadId, String quadName);
	void delete(int quadId, String quadName);
	void update(int quadId, String quadName);
}
