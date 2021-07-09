package com.cts.returnship.jff.ui;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import com.cts.returnship.jff.model.Employee;

public class EmployeeSetDemo {

	public static void main(String[] args) {

			Set<Employee> emps =  new TreeSet<Employee>();
		//Set<Employee> emps =  new TreeSet<Employee>(new EmployeeFullNameComparator().reversed());
		
			
			emps.add(new Employee(111L,"manpret",LocalDate.now(),10000.0d));
			emps.add(new Employee(122L,"jack",LocalDate.now().plusDays(10),10000.0d));
			emps.add(new Employee(333L,"john",LocalDate.now().plusDays(20),15000.0d));
			emps.add(new Employee(444L,"smith",LocalDate.now().plusDays(30),19000.0d));
			emps.add(new Employee(555L,"harry",LocalDate.now().plusDays(60),20000.0d));
	
			for (Employee e:emps) {
				System.out.println(e);
			}
			
			
	}

}
