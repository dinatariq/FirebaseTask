package com.itdawn.firebase;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import  androidx.recyclerview.widget.RecyclerView;

public class EmployeeRecyclerAdapter extends RecyclerView.Adapter<EmployeeHolder> {
    
    private  final Context context;
    private final List<Employee> employees;
    public EmployeeRecyclerAdapter(Context context, List<Employee> employees) ) {
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    
    public EmployeeHolder onCreatViewHolder(@NonNull ViewGroup parent, int viewType){
    
    EmployeeItemBinding employeeItemBinding
            =DataBindingUtil.inflote(LayoutInflater.from(context),R.layout.employee_item,parent, false);
        return new EmployeeHolder(employeeItemBinding);
        
    }
    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position){ 
    holder.setData(employees.get(position));
}
    @Override
    public int getItemCount(){
        return  employees.size();
    }
    }
    