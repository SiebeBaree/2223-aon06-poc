package be.pxl.proofofconcept.api;

public record DefenseRequest(
        String name,
        String specialty,
        String company,
        String companyPromotor,
        String pxlPromotor,
        String researchPaperTitle
) {
}