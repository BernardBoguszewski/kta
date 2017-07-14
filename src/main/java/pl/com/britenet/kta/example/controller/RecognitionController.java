package pl.com.britenet.kta.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.example.entity.Colleague;
import pl.com.britenet.kta.example.repository.ColleagueRepository;
import pl.com.britenet.kta.example.repository.RecognitionRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class RecognitionController {

    @Autowired
    private ColleagueRepository repository;

    @Autowired
    private RecognitionRepository recognitionRepository;

    @RequestMapping("/colleagues/{name}")
    public List<Colleague> getRecognition(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @RequestMapping("/colleagues")
    public List<Colleague> getColleagues() {
        return repository.findAll();
    }

    @PostMapping("/colleagues")
    @Transactional
    public ResponseEntity<String> addColleague(@RequestBody Colleague colleague) {
        colleague.recognitions = Optional.ofNullable(colleague.recognitions).map(recognitions -> recognitionRepository.save(recognitions)).orElse(null);
        repository.save(colleague);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //This is of course a very naive implementation! We are assuming unique names...
    @DeleteMapping("/colleagues/{name}")
    public ResponseEntity<String> deleteColleague(@PathVariable String name) {
        List<Colleague> colleagues = repository.findByName(name);
        if (colleagues.size() == 1) {
            Colleague colleague = colleagues.get(0);
            repository.delete(colleague);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
