package com.onwan.dietapp.services;

import java.util.List;

import com.onwan.dietapp.entities.Allergy;

public interface AllergyService {

	List<Allergy> allAllergies();

	List<Allergy> showAllergiesByEmail(String email);

	Allergy createAllergy(Allergy allergy);

	Allergy updateAllery(Allergy allergy, int allergyId);

}
