package com.project.challenge_app.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
//@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {
    @Autowired
    ChallengeService service;

    

@GetMapping("/challenges")
public List<Challenge> getChallenge() {
    return service.getAllChallenge();
}

@PostMapping("/challenges")
public String postProduct(@RequestBody Challenge challenge1) {
    boolean service1=service.addChallenge(challenge1);
    if(service1){
        return "Challenge Added Successfully";
    }
    else{
        return "Failed to add Challenge";
    }
}

@GetMapping("/challenges/{month}")
public ResponseEntity<Challenge>  getProductByMonth(@PathVariable String month) {
    Challenge challenge=service.getProductByMonth(month);
   if(challenge!=null){
       return new ResponseEntity<>(challenge,HttpStatus.OK);
   }
   else{
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}

@PutMapping("/challenges/{id}")
public ResponseEntity<String> updateChallenge(@PathVariable long id, @RequestBody Challenge challenge) {
    boolean isUpdated= service.updateChallenge(id,challenge);
    if(isUpdated){
        return new ResponseEntity<>("Challenge Updated Successfully",HttpStatus.OK);



    }
    else{
        return new ResponseEntity<>("Failed to update Challenge",HttpStatus.BAD_REQUEST);
        }


}

@DeleteMapping("challenges/{id}")
public ResponseEntity<String> deleteChallenge(@PathVariable long id) {

    boolean isdeleted= service.deleteChallenge(id);
    if(isdeleted){
        return new ResponseEntity<>("Challenge deleted Successfully",HttpStatus.OK);



    }
    else{
        return new ResponseEntity<>("Failed to delete Challenge",HttpStatus.BAD_REQUEST);
        }






}
}
