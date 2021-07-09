package com.cts.returnship.jff.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cts.returnship.jff.model.Employee;

public class EmployeeSerializationAndDeserialzationDemo {
	
	
	public static void main(String[] args) {
		final String EMP_STORE_PATH="./empStore.data";
		
		File empStoreFile = new File(EMP_STORE_PATH);
		
		List<Employee> list = null;
		Scanner scan = new Scanner(System.in);
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		if (empStoreFile.exists()) {
			try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(empStoreFile)) ) {
				
				list = (List<Employee>) os.readObject(); // deserialization
			
			} catch (IOException  | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			list = new ArrayList<>();
		}
		
		System.out.println("Existing records");
		
		if (!list.isEmpty()) {
			for (Employee e: list) {
				System.out.println(e);
			}
		}
		
		System.out.println("How many records do you wish to add? ");
		int count = scan.nextInt();
		
		for (int i = 0; i < count; i++) {
			Employee e = new Employee();
			System.out.println("Employee id: " );
			e.setEmpId(scan.nextLong());
			System.out.println("Full Name: " );
			e.setFullName(scan.next());
			System.out.println("Date Of Joining(dd-MM-yyyy): " );
			e.setDateOfJoining(LocalDate.parse(scan.next(), dtFormatter));
			System.out.println("Basic Pay: ");
			e.setBasic(scan.nextDouble());
			list.add(e);
		}
		
		if (count != 0) { 
			try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(empStoreFile)) ){
				 os.writeObject(list);
				System.out.println("Data Saved Successfully");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}
}
