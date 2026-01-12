package org.empCrud.repo;
import java.util.*;
import org.empCrud.model.Emp;

public interface EmpRepo {
	public int addEmp(Emp e);
	public int deleteEmp(int eid);
	public int updateEmp(Emp e);
	public List<Emp> viewEmp();

}