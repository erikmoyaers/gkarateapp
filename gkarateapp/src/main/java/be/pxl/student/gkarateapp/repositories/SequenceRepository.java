package be.pxl.student.gkarateapp.repositories;

import be.pxl.student.gkarateapp.models.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends JpaRepository<Sequence, Integer> {
}
