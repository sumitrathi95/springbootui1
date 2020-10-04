package com.restapi.controller;

import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;

import com.restapi.model.Patient;
import com.restapi.service.MyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

   /* @GetMapping("/patient/list")
    public List<Patient> listAll() {
        return myService.listAll();
    }


    @GetMapping("/patient")
    public List<Patient> searchPatient(@RequestParam(value = "firstname") String name) {
        return myService.getByFnameAndLname(name);
    }
    */
/*
     @GetMapping("/patient")
    public Optional<Patient> searchPatient(@RequestParam(value = "pid") String pid) {
        return myService.getByPid(pid);
    }
*/
/*
 @PostMapping("/patient")
    public Patient newPatient(@RequestBody Patient patient){
        String pattern = "^([A-Za-z0-9])*$";
       
        if (patient.getFirstname().matches(pattern) && patient.getLastname().matches(pattern) && patient.getDob().isBefore(LocalDate.now()) ) {
           System.out.println("valid");
            return myService.saveOrUpdate(patient);
        } else {
                System.out.println("Input format should be [A-Za-z0-9]");
                return null;
        }
    }*/
    @PostMapping("/patient")
    public ResponseEntity<Object> newPatient(@RequestBody Patient patient, Object Status){
                String pattern = "^([A-Za-z0-9])*$";
                /*String msg = "Input format should be [A-Za-z0-9]";
                HttpHeaders header = new HttpHeaders();
                header.add("desc", "New Patient Addded");*/
       
                if (patient.getFirstname().matches(pattern) && patient.getLastname().matches(pattern) && patient.getDob().isBefore(LocalDate.now()) ) {
                    //System.out.println("valid");
                     Patient p = myService.saveOrUpdate(patient);
                     ////return new ResponseEntity<>(p, HttpStatus.CREATED);...........(working)
                     //return new ResponseEntity<>(msg, HttpStatus.CREATED);
                    //return ResponseEntity<patient>(msg, header, Status, HttpStatus.CREATED);
                    //return ResponseEntity.status(HttpStatus.OK).headers(header).build();.........(working)
                    String msg = "New Patient is added";
		            return new ResponseEntity<Object>(msg, HttpStatus.CREATED.valueOf(200));
                } else {
                    
                  HttpStatus.valueOf(400);
				// return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);.......(working)
                   //return ResponseEntity<patient>("invalid", header,Status, HttpStatus.INTERNAL_SERVER_ERROR);
                   return new ResponseEntity<Object>("Input format should be [A-Za-z0-9]", HttpStatus.INTERNAL_SERVER_ERROR.valueOf(400));
                }
    }

    /* @PostMapping("/collections")
    public ResponseEntity<Person> createPerson(@RequestBody Person per) {
        try {
            Person _pp = perRepository.save(new Person(per.getFirstname(), per.getLastname(), per.getGender(), per.getDob()));
            return new ResponseEntity<>(_pp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
*/


     /*@PostMapping("/patient")
    public Patient newPatient(@RequestBody Patient patient){
           return myService.saveOrUpdate(patient);
    }*/

    
}