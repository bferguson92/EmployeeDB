package com.example.employeedb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.employeedb.adapter.EmployeeAdapter;
import com.example.employeedb.model.Employee;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private EmployeeAdapter employeeAdapter;
    private ArrayList<Employee> employeeArrayList;

    @BindView(R.id.edit_text_name)
    EditText editTextName;
    @BindView(R.id.edit_text_tech)
    EditText editTextTech;
    @BindView(R.id.edit_text_position)
    EditText editTextPosition;
    @BindView(R.id.button_add_employee)
    Button buttonAddEmployee;
    @BindView(R.id.recycler_view_display_employees)
    RecyclerView recyclerViewDisplayEmployees;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


         employeeArrayList = new ArrayList<>();


        databaseReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child("Employees");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    employeeArrayList.add(snapshot.getValue(Employee.class));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        employeeAdapter = new EmployeeAdapter(employeeArrayList);

        recyclerViewDisplayEmployees.setAdapter(employeeAdapter);
        recyclerViewDisplayEmployees.setLayoutManager(new LinearLayoutManager(this));

        buttonAddEmployee.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Employee employee = new Employee(
                        editTextName.getText().toString(),
                        editTextTech.getText().toString(),
                        editTextPosition.getText().toString());

                databaseReference.push().setValue(employee);

                editTextName.getText().clear();
                editTextPosition.getText().clear();
                editTextTech.getText().clear();

                Toast.makeText(view.getContext(),
                        "Employee Added!",
                        Toast.LENGTH_SHORT).show();

                employeeAdapter.notifyDataSetChanged();
            }
        });
    }
}
