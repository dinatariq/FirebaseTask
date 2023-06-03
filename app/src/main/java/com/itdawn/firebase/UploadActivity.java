package com.itdawn.firebase;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
;

import java.io.ByteArrayOutputStream;


public class UploadActivity extends Upload {
    FirebaseFirestore db;
    FirebaseFirestore storage;

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

}
     private void uploadImageData(){
        StorageReference rootReference = storage.getReference();
         StorageReference uploadReference = rootReference.child("employees/h.png");
         UploadTask uploadTask = uploadReference.putBytes(getImageBytes());

         UploadTask.continueWithTask(task -> {
             if (task.isSuccessful())
                 return uploadReference.getDownloadUri();
              return null

         })
                 .addOnCompleteListener(task ->{
                     if (task.isSuccesssful()) {
                         String imageUri = task.getResult.toString();
                         Employees employees = new Employee("Ahmed", "23", "dd", "12", imageUri);
                         Employees employees = new Employee("sajjad", "35", "Teacher", "12", imageUri);

                         addToFireStore(employees);

                     }else{
                         Log.println(Log.INFO,"task", objects.requireNonNull(task.getException().toString());
                     }
                 });
     }

}

        private void downloadImage() {

            StorageReference rootReference = storage.getReference();

            StorageReference imageReference = roorReference.child("employees/h.png");

            imageReference.getBytes(1024 * 1024)
                    .addOnCompleteListener(task -> {
                        if (task.isComplete()) {
                            byte[] imageBytes = task.getResult();

                            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                            mainBinding.downloadedImage.setImageBitmap(bitmap);
                        }
                    });
        mainBinding.downloadedImage.setImageURI(uri);
        }


            private void uploadData () {
                if (uploadBinding.employeeImage.getDrawable() == pull) {
                    Snackbar.make(uploadBinding.selectImage, "Please, select an image", Snackbar.LENGTH_LONG).show();
                    return;
                }
                fillData();
                StorageReference reference = storage.getReference().child("employeeImage/" + employeeName);
                UploadTask uploadTask = reference.putBytes(getImageBytes());

                uploadTask.continueWithTask(task -> {
                    if (task.isSuccessful())
                        return reference.getDownloadUrl();

                    return null;

                }).addOnCompleteListener(task -> {
                    if (task.isSuccesssful()) {
                        Snackbar.make(uploadBinding.uploadData, "Data uploaded successfully", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
           private void fillData() {
    employeeName = uploadBinding.employeeName.getText().toString();
    employeeJob = uploadBinding.employeeJob.getText().toString();
    employeeAge = uploadBinding.employeeAge.getText().toString();
    employeeServices= uploadBinding.employeeServices.getText().toString();
           }


             private byte[] getImageBytes(){
    mainBinding.employeeImage.setDrawingCacheEnabled(true);
    mainBinding.employeeImage.buildDrawingCache(true);

    Bitmap bitmap = ((BitmapDrawable)  (uploadBinding.employeeImage.getDrawable())).getBitmap();
    int width = bitmap.getWidth();
    int height = bitmap.getHeight();

                 Matrix matrix = new Matrix();
                 float scaleWidth = ((float) 480)/ width;
                 float scaleHeight = ((float) 480)/ height;
                 matrix.postScale(scaleWidth,scaleHeight);

                 Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                 resizedBitmap.compress(Bitmap.CompressFormat.PNG, 70, OutputStream);
                 return outputStream.toByteArray();
             }
}