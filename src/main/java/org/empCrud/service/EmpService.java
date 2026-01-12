package org.empCrud.service;

import java.util.List;

import org.empCrud.model.Emp;

public interface EmpService {
	public int addEmp(Emp e);
	public int deleteEmp(int eid);
	public int updateEmp(Emp e);
	public List<Emp> viewEmp();

}
