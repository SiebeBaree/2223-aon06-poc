package be.pxl.proofofconcept.api;

import be.pxl.proofofconcept.domain.Defense;

public record DefenseDTO(
        String id,
        String defenseId,
        String firstStudent,
        String specialty,
        String company,
        String companyPromotor,
        String pxlPromotor,
        String researchPaperTitle
) {
    public static DefenseDTO fromDefense(Defense defense) {
        return new DefenseDTO(
                defense.getId(),
                defense.getDefenseId(),
                defense.getFirstStudent(),
                defense.getSpecialty(),
                defense.getCompany(),
                defense.getCompanyPromotor(),
                defense.getPxlPromotor(),
                defense.getResearchPaperTitle()
        );
    }
}