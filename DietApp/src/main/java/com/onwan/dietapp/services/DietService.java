package com.onwan.dietapp.services;

import java.util.List;

import com.onwan.dietapp.entities.Diet;

public interface DietService {
	
	List<Diet> allDiets();

	List<Diet> showDietByEmail(String email);

	Diet createDiet(Diet diet);

	Diet updateDiet(Diet diet, int dietId);

}
