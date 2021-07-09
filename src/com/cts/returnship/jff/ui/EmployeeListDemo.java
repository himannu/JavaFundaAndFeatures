package com.cts.returnship.jff.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cts.returnship.jff.model.Employee;
import com.cts.returnship.jff.util.EmployeeDateOfJoiningComparator;

public class EmployeeListDemo {

	public static void main(String[] args) {

			List<Employee> emps =  new ArrayList<Employee>();
		
			
			emps.add(new Employee(111L,"manpreet",LocalDate.now(),10000.0d));
			emps.add(new Employee(122L,"jack",LocalDate.now().plusDays(10),10000.0d));
			emps.add(new Employee(333L,"john",LocalDate.now().plusDays(20),15000.0d));
			emps.add(new Employee(444L,"smith",LocalDate.now().plusDays(30),19000.0d));
			emps.add(new Employee(555L,"harry",LocalDate.now().plusDays(60),20000.0d));

			Collections.sort(emps, new EmployeeDateOfJoiningComparator().reversed());

			for (Employee e:emps) {
				System.out.println(e);
			}
			
			
	}

}
