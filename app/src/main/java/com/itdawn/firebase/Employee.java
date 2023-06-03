package com.itdawn.firebase;

import androidx.databinding.BindingAdapter;

import javax.security.auth.callback.Callback;

public class Employee {
    String Name, Age, Job, Services, imageUri;

    public Employee(String Name, String Age, String Job, String Services, String imageUri) {
        this.Name = Name;
        this.Age = Age;
        this.Job = Job;
        this.Services = Services;
        this.imageUri = imageUri;

    }

    @BindingAdapter({"imageUri"})
    public static void loadImage(ImageView view, String uri) {
        Picasso.get().load(uri).into(view, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(Exception e) {
            }
        });
        }

    public String getimageUri() {
        return imageUri;
    }

    public void setUri(String imageuri) {
        this.imageUri = imageuri;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        this.Age = age;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        this.Job = job;
    }

    public String getServices() {
        return Services;
    }

    public void setServices(String services) {this.Services = services;}
}
