package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmpDAO {
	// �ʵ�.
	ArrayList<Employee> employee = new ArrayList<>();

	// ������.
	EmpDAO() {

		// �⺻ ������.
		employee.add(new Employee("23-11", "ȫ�浿", "943-1234", "2023-12-01", 400));
		employee.add(new Employee("23-12", "��浿", "943-1244", "2023-12-02", 380));
		employee.add(new Employee("23-13", "�ڱ浿", "943-1254", "2023-12-03", 360));
		employee.add(new Employee("23-14", "���浿", "943-1264", "2023-12-03", 350));
		employee.add(new Employee("23-15", "�ֱ浿", "943-1274", "2023-12-04", 340));
		employee.add(new Employee("23-16", "��浿", "943-1284", "2023-12-04", 330));
		employee.add(new Employee("23-17", "���浿", "943-1294", "2023-12-05", 320));
		employee.add(new Employee("23-18", "�ű浿", "943-1204", "2023-12-05", 310));
	}

	// �޼ҵ�.
	
	// 1. �߰�.
	public boolean addEmployee(String empNo, String empName, String empTel, String empDate, int salary) {
		// �Ի����� ������ ��� ���ó�¥�� �ڵ� ����.
		if (empDate.equals("")) {
			employee.add(new Employee(empNo, empName, empTel, salary));
		} else {
			employee.add(new Employee(empNo, empName, empTel, empDate, salary));
		}
		return true;
	}

	// 2. ���.
	public void getEmployeeList() {
		for (Employee emp : employee) {
			emp.showInfoTel();
		}
	}

	// 3. ����(�޿�).
	public boolean modifyEmploy(String input) {
		// ��� �޿� String�� space �������� �и�.
		// ���: inAry[0] / �޿�: inAry[1].
		String[] inAry = input.split(" ");
		for (Employee emp : employee) {
			if (emp.getEmpNo().equals(inAry[0])) {
				int empSalary = 0;
				// parseInt ����ó��
				try {
					empSalary = Integer.parseInt(inAry[1]);
				} catch (NumberFormatException e) {
					return false;
				}
				emp.setSalary(empSalary);
				return true;
			}
		}
		return false;
	}

	// 4. ����.
	public boolean removeEmploy(String input) {
		// ��� input�� ������ ������� ��� ����.
		for (int i = 0; i < employee.size(); i++) {
			if (employee.get(i).getEmpNo().equals(input)) {
				employee.remove(i);
				return true;
			}
		}
		return false;
	}

	// 5. ��� ��ȸ(����: �Ի� ����).
	public void getEmployee(String input) {
		// Date Ÿ�� seacrhDate ���� ����.
		Date searchDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// sdf.parse�� String�� DateŸ������ ��ȯ
		try {
			searchDate = sdf.parse(input);
		} catch (Exception e) {
			return;
		}
		for (Employee emp : employee) {
			// �Ի��� String => Date Ÿ�� ��ȯ
			Date empDate = new Date();
			try {
				empDate = sdf.parse(emp.getEmpDate());
			} catch (ParseException e) {
				return;
			}
			// getTime���� long Ÿ������ ��ȯ�ؼ� �񱳿����ڷ� ��Һ�
			// ã�� ��¥ ���Ŀ� �Ի��� ����� showInfo�� ���
			if(searchDate.getTime() <= empDate.getTime()) {
				emp.showInfoDate();
			}
		}
	}
}
