package be.pxl.proofofconcept.repository;

import be.pxl.proofofconcept.domain.Defense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenseRepository extends MongoRepository<Defense, String> {
    void deleteDefenseByDefenseId(String defenseId);
}
