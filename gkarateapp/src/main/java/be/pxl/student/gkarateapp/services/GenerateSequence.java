package be.pxl.student.gkarateapp.services;

import be.pxl.student.gkarateapp.models.KeyPoint;
import be.pxl.student.gkarateapp.models.Sequence;
import be.pxl.student.gkarateapp.repositories.SequenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateSequence {

    private SequenceService sequenceService;
    private List<Sequence> allEditedSequences;

    public GenerateSequence(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    public List<Sequence> editSequences(KeyPoint key){
        allEditedSequences = sequenceService.getAllSequences();
        for (String bodyPart: key.getDisabledBodyParts()) {
            for (Sequence seq : allEditedSequences) {
                if (seq.getSequence().contains(bodyPart)) {
                    seq.setSequence(seq.getSequence().replace(bodyPart, ""));
                }
            }
        }
        return allEditedSequences;
    }

    public List<Sequence> getAllEditedSequences() {
        return allEditedSequences;
    }

}
