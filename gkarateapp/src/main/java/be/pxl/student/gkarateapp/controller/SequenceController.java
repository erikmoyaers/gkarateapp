package be.pxl.student.gkarateapp.controller;

import be.pxl.student.gkarateapp.models.Sequence;
import be.pxl.student.gkarateapp.services.SequenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sequences")
@CrossOrigin("*")
public class SequenceController {

    private SequenceService sequenceService;

    public SequenceController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    @GetMapping
    public ResponseEntity<List<Sequence>> getAllSequences() {
        return new ResponseEntity<>(sequenceService.getAllSequences(), HttpStatus.OK);
    }
}
