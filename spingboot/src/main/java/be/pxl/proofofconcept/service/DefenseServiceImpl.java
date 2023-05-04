package be.pxl.proofofconcept.service;

import be.pxl.proofofconcept.api.DefenseDTO;
import be.pxl.proofofconcept.api.DefenseRequest;
import be.pxl.proofofconcept.domain.Defense;
import be.pxl.proofofconcept.exception.ResourceNotFoundException;
import be.pxl.proofofconcept.repository.DefenseRepository;
import org.springframework.stereotype.Service;

@Service
public class DefenseServiceImpl implements DefenseService {
    private final DefenseRepository defenseRepository;

    public DefenseServiceImpl(DefenseRepository defenseRepository) {
        this.defenseRepository = defenseRepository;
    }

    @Override
    public String createDefense(DefenseRequest defenseRequest) {
        Defense defense = new Defense(
                defenseRequest.name(),
                defenseRequest.specialty(),
                defenseRequest.company(),
                defenseRequest.companyPromotor(),
                defenseRequest.pxlPromotor(),
                defenseRequest.researchPaperTitle()
        );

        defenseRepository.save(defense);
        return "Defense created";
    }

    @Override
    public DefenseDTO updateDefense(String defenseId, DefenseRequest defenseRequest) {
        Defense defense = defenseRepository.findAll().stream()
                .filter(defense1 -> defense1.getDefenseId().equals(defenseId))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("defense", "id", defenseId));

        defense.setFirstStudent(defenseRequest.name());
        defense.setSpecialty(defenseRequest.specialty());
        defense.setCompany(defenseRequest.company());
        defense.setCompanyPromotor(defenseRequest.companyPromotor());
        defense.setPxlPromotor(defenseRequest.pxlPromotor());
        defense.setResearchPaperTitle(defenseRequest.researchPaperTitle());

        Defense updatedDefense = defenseRepository.save(defense);
        return DefenseDTO.fromDefense(updatedDefense);
    }

    @Override
    public boolean deleteDefense(String defenseId) {
        defenseRepository.deleteDefenseByDefenseId(defenseId);
        return true;
    }
}
