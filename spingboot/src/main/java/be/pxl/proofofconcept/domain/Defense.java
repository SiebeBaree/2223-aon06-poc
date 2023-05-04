package be.pxl.proofofconcept.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;

@Document(collection = "defenses")
public class Defense {
    @Id
    @Indexed(unique = true)
    private String id;
    @Indexed(unique = true)
    private String defenseId;
    private String firstStudent;
    private String specialty;
    private String company;
    private String companyPromotor;
    private String pxlPromotor;
    private String researchPaperTitle;

    public Defense() {

    }

    public Defense(String name, String specialty, String company, String companyPromotor, String pxlPromotor, String researchPaperTitle) {
        this.firstStudent = name;
        this.specialty = specialty;
        this.company = company;
        this.companyPromotor = companyPromotor;
        this.pxlPromotor = pxlPromotor;
        this.researchPaperTitle = researchPaperTitle;
        this.defenseId = "ABCDEF";
    }

    public String getId() {
        return id;
    }

    public String getDefenseId() {
        return defenseId;
    }

    public String getFirstStudent() {
        return firstStudent;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getCompany() {
        return company;
    }

    public String getCompanyPromotor() {
        return companyPromotor;
    }

    public String getPxlPromotor() {
        return pxlPromotor;
    }

    public String getResearchPaperTitle() {
        return researchPaperTitle;
    }

    public void setFirstStudent(String firstStudent) {
        this.firstStudent = firstStudent;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCompanyPromotor(String companyPromotor) {
        this.companyPromotor = companyPromotor;
    }

    public void setPxlPromotor(String pxlPromotor) {
        this.pxlPromotor = pxlPromotor;
    }

    public void setResearchPaperTitle(String researchPaperTitle) {
        this.researchPaperTitle = researchPaperTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Defense defense = (Defense) o;

        return Objects.equals(defenseId, defense.defenseId);
    }

    @Override
    public int hashCode() {
        return defenseId != null ? defenseId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return defenseId + ";" + firstStudent + ';' + specialty + ';' +
                company + ';' + companyPromotor + ';' + pxlPromotor + ';' + researchPaperTitle;
    }
}

