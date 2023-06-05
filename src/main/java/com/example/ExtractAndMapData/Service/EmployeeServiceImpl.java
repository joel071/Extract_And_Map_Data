package com.example.ExtractAndMapData.Service;

import com.example.ExtractAndMapData.Entity.Employee;
import com.example.ExtractAndMapData.Repository.EmployeeRepository;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.opencsv.CSVWriter;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public void exportToCSV() throws IOException {

        List<Employee> employeeList = employeeRepository.findAll();

        FileWriter fileWriter = new FileWriter("output.csv");
        CSVWriter csvWriter = new CSVWriter(fileWriter);
        String[] headers = {"employeeId", "firstName", "lastName", "emailId", "department"};
        csvWriter.writeNext(headers);

        for (Employee employee : employeeList) {
            String id = employee.getEmployeeId();
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String emailId = employee.getEmailId();
            String department = employee.getDepartment();

            String[] data = {id, firstName, lastName, emailId, department};
            csvWriter.writeNext(data);
        }

        csvWriter.close();
        fileWriter.close();
        System.out.println("Data exported to CSV file successfully!");


    }

    @Override
    public void mainls() throws IOException {
        String bucketName = "test123bucket123";

        //String credentialsFilePath = "C:/Users/lahce/Downloads/credentials/playground-s-11-52550b99-44798161a220.json";

        
        //GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(credentialsFilePath));

        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:/Users/lahce/Downloads/credentials/playground-s-11-52550b99-44798161a220.json"));
        Storage st = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

        //Storage storage = StorageOptions.getDefaultInstance().getService();
        Bucket bucket = storage.get(bucketName);
        String file = "output.csv";
        BlobId blobId = BlobId.of(bucket.getName(), file);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        Blob blob = storage.create(blobInfo, Files.readAllBytes(Paths.get(file)));
    }



}
