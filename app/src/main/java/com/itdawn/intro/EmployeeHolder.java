package com.itdawn.intro;
import  androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import  androidx.annotation..NonNull;


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
