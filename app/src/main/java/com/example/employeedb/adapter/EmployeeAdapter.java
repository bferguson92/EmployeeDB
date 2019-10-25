package com.example.employeedb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedb.R;
import com.example.employeedb.model.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.CustomViewHolder> {

    private ArrayList<Employee> employeeList;


    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private TextView textViewTech;
        private TextView textViewPosition;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
           textViewName = itemView.findViewById(R.id.text_view_name);
           textViewTech = itemView.findViewById(R.id.text_view_tech);
           textViewPosition = itemView.findViewById(R.id.text_view_position);
        }


    }

    public EmployeeAdapter(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.CustomViewHolder holder, int position) {
        holder.textViewName.setText(employeeList.get(position).getName());
        holder.textViewTech.setText(employeeList.get(position).getTech());
        holder.textViewPosition.setText(employeeList.get(position).getPosition());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
