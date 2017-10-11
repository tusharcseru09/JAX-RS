package com.cseru09.Repository;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cseru09.DbConnection.DbConnection;



public class EmployeeImp implements EmployeeDao{

	public EmployeeImp(){
		
	}
	public List<Employee> getAllEmployee() throws Exception{
		
		String query = "select emp_id, emp_name, emp_no, location from public.employee_table";
		List<Employee> empList  = new ArrayList<Employee>();
		
		Statement st = DbConnection.getDbConnection().createStatement();
		ResultSet rs = st.executeQuery(query);
			
		while (rs.next()){
			Employee emp = new Employee();
			emp.setId(rs.getInt("emp_id"));
			emp.setName(rs.getString("emp_name"));
			emp.setNumber(rs.getString("emp_no"));
			emp.setLocation(rs.getString("location"));
			empList.add(emp);
		}
		
		
		return empList;
	}

}
