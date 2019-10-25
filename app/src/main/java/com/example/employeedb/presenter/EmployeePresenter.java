package com.example.employeedb.presenter;

import androidx.annotation.NonNull;

import com.example.employeedb.model.Employee;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EmployeePresenter implements Contract.Presenter {

    private Contract.View contractView;
    private DatabaseReference databaseReference;

    public EmployeePresenter() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("employees");
    }

    @Override
    public void getEmpolyees(ArrayList<Employee> employees) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    employees.add(dataSnapshot.getValue(Employee.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
