package com.example.employeedb.presenter;

import com.example.employeedb.model.Employee;

import java.util.ArrayList;

public interface Contract {

    interface Presenter{
        void getEmpolyees(ArrayList<Employee> employees);
    }

    interface View {
        void displayEmpolyees(ArrayList<Employee> employees);
    }
}
