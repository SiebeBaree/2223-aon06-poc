package be.pxl.proofofconcept.service;

import be.pxl.proofofconcept.api.DefenseDTO;
import be.pxl.proofofconcept.api.DefenseRequest;

public interface DefenseService {
    String createDefense(DefenseRequest defenseRequest);
    DefenseDTO updateDefense(String defenseId, DefenseRequest defenseRequest);
    boolean deleteDefense(String defenseId);
}
