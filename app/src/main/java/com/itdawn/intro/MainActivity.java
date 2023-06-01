package com.itdawn.intro;

public class MainActivity extends AppCompatActivity {



    FirebaseFirestore db;

ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        Employees employees= new Employee("Ahmed", "23", "dd", "12", imageUri);
        Employees employees= new Employee("sajjad", "35", "Teacher", "12", imageUri);

        mainBinding.addToFireStore.setOnClicckListener(view -> addToFireSore(employee));
    }

    private void addToFireSore(Employees employee) {
        List<Employees> employeeList = new ArrayList<>();
        // Add a new document with a generated ID
        db.collection("Employees")
                .document("ME")
                .collection(employee)
                .document("SQ")
                .collection(employee)
                .set(employee)
                .addOnCompleteListener(new OnCompleteListener<Void>task) {
         @Override
                 public void onComplete(Task<Void> task){
             if (task.isComplete()){
                 Toast.makeText(this, "Data uploaded to firestore",Toast.LENGTH_LONG).show();
             }
        }
    });
    }
private class Employee{
        String Name,Age, Job, Services,imageUri;

    public Employee(String Name, String Age, String Job,String Services ,String imageUri) {
        this.Name = Name ;
        this.Age = Age ;
        this.Job = Job ;
        this.Services = Services;
        this.imageUri = imageUri;
    }

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String getServices() {
        return Services;
    }

    public void setServices(String services) {
        Services = services;
    }

    public String getimageUri() {
        return imageUri;
    }

    public void setUri(String imageuri) {imageUri = imageuri;}
}
}