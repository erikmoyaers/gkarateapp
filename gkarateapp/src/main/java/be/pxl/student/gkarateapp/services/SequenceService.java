package be.pxl.student.gkarateapp.services;

import be.pxl.student.gkarateapp.models.Sequence;
import be.pxl.student.gkarateapp.repositories.SequenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SequenceService {
    private SequenceRepository sequenceRepository;

    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    public List<Sequence> getAllSequences(){
        return sequenceRepository.findAll();
    }
}
