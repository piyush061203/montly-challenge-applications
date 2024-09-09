package com.project.challenge_app.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChallengeService {


    @Autowired
    ChallengeRepo repo;


    private long nextid=1L;
  


    public List<Challenge> getAllChallenge(){
       return repo.findAll();
    }



    public boolean addChallenge(Challenge product1){
       if(product1 !=null){
           product1.setId(nextid++);;
          repo.save(product1);
          return true;
       }
       else{
           return false;
       }
    }

   public Challenge getProductByMonth(String month) {
     Optional<Challenge> product= repo.findAllByMonthIgnoreCase(month);
     return product.orElse(null);    
   }



   public boolean updateChallenge(long id, Challenge product2) {
       Optional<Challenge> product= repo.findById(id);
    if(product.isPresent()){
       Challenge productToUpdate=product.get();
       productToUpdate.setMonth(product2.getMonth());
       productToUpdate.setDescription(product2.getDescription());
       repo.save(productToUpdate);
       return true;
    }
    return false;
   }



   public boolean deleteChallenge(long id) {
       Optional<Challenge> product= repo.findById(id);
       if(product.isPresent()){
            repo.deleteById(id);
           return true;
       }
     return false;
   }
}
