package com.albany.edu.fwp.dao;

import java.util.List;

import com.albany.edu.fwp.model.Config;
import com.albany.edu.fwp.model.QuadInfo;

public interface ConfigDAO {	
	List<Config> list();
	void update(int configId, String managerTime, String studentTime);
}
