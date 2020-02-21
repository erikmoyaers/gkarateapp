package be.pxl.student.gkarateapp.controller;

import be.pxl.student.gkarateapp.models.KeyPoint;
import be.pxl.student.gkarateapp.models.Sequence;
import be.pxl.student.gkarateapp.repositories.KeyPointRepository;
import be.pxl.student.gkarateapp.repositories.SequenceRepository;
import be.pxl.student.gkarateapp.services.GenerateSequence;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/keypoint")
@CrossOrigin("*")
public class KeyPointController {

    private SequenceRepository sequenceRepository;
    private KeyPointRepository keyPointRepository;
    private GenerateSequence generateSequence;
    private List<String> disabled = new ArrayList<>();

    public KeyPointController(SequenceRepository sequenceRepository, KeyPointRepository keyPointRepository, GenerateSequence generateSequence) {
        this.sequenceRepository = sequenceRepository;
        this.keyPointRepository = keyPointRepository;
        this.generateSequence = generateSequence;
    }

    @PutMapping
    public KeyPoint updateKeyPoint(@RequestBody KeyPoint newKeyPoint){
        if (newKeyPoint.isLinkerbeen()) {
            disabled.add("LF");
        }
        if (newKeyPoint.isLinkerhand()) {
            disabled.add("LH");
        }
        if (newKeyPoint.isRechterbeen()) {
            disabled.add("RF");
        }
        if (newKeyPoint.isRechterhand()) {
            disabled.add("RH");
        }

        newKeyPoint.setDisabledBodyParts(disabled);
        List<Sequence> sequenceList = generateSequence.editSequences(newKeyPoint);
        for (Sequence seq: sequenceList) {
            if (Character.isDigit(seq.getSequence().charAt(0)) || Character.isSpaceChar(seq.getSequence().charAt(0))) {
                sequenceRepository.delete(seq);
            }
        }
        return keyPointRepository.findById(1)
                .map(keypoint -> {
                    keypoint.setLinkerhand(newKeyPoint.isLinkerhand());
                    keypoint.setLinkerbeen(newKeyPoint.isLinkerbeen());
                    keypoint.setRechterhand(newKeyPoint.isRechterhand());
                    keypoint.setRechterbeen(newKeyPoint.isRechterbeen());
                    return keyPointRepository.save(keypoint);
                })
                .orElseGet(() -> {
                    newKeyPoint.setId(1);
                    return keyPointRepository.save(newKeyPoint);
                });
    }
}
