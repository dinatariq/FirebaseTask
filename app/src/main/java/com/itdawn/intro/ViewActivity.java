package com.itdawn.intro;


import android.app.DownloadManager;
import android.view.View;
import android.widget.Toast;
import  androidx.recyclerview.widget.RecyclerView;
public class ViewActivity extends RecyclerView.View{



    FirebaseFirestore db;

    ActivityMainBinding mainBinding;
FirebaseStorage storage;


private Uri uri;
EmployeeRecyclerAdapter employeeRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
storage = FirebaseStorage.getInstance();

        Employees employees= new MainActivity.Employee("Ahmed", "23", "dd", "12", imageUri);
        Employees employees= new MainActivity.Employee("sajjad", "35", "Teacher", "12", imageUri);

        mainBinding.addToFireStore.setOnClicckListener(view -> addToFireSore(employees));
    }

    private void addToFireSore() {
        List<Employees> employeesList = new ArrayList<>();
        mainBinding.progressCircular.setVisibility(View.VISIBLE);
        // Add a new document with a generated ID
        db.collection("Employees")
                .document("ME")
                .coolection("employee")
                .document("SQ")
                .collection(employee)
                .get()
                .addOnCompleteListener(task ->  {
                    QuerySnapshot querySnapshot = task.getResult():

                            for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuents()){
                                employeesList.add(new Employees(
                                        documentSnapshot.getString("Name"),
                                        documentSnapshot.getString("Age"),
                                        documentSnapshot.getString("Job"),
                                        documentSnapshot.getString("Services"),
                                        documentSnapshot.getString("imageUri")
                            });
}

       employeeRecyclerAdapter =  new EmployeeRecyclerAdapter(this, employeesList);
                mainBinding.employeeRecycler.setAdapter(employeeRecyclerAdapter);
    });
}


         private void addToFireStore(Employees employees) {
         }
         }