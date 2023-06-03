package com.itdawn.firebase;
import  androidx.recyclerview.widget.RecyclerView;.NonNull;


public class EmployeeHolder extends RecyclerView.ViewHolder {
    EmployeeItemBinding employeeItemBinding;

    public EmployeeHolder (@NonNull EmployeeItemBinding employeeItemBinding) {
        super(employeeItemBinding.getRoot());
        this.employeeItemBinding = employeeItemBinding;
    }

    public void setData(Employee employee) {
        employeeItemBinding.setEmployee(employee);
        employeeItemBinding.executePendingBindings();
    }
}
