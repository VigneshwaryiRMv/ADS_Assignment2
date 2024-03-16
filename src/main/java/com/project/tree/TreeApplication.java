package com.project.tree;

import com.project.tree.model.Habitat;
import com.project.tree.model.Species;
import com.project.tree.model.conservationArea;
import com.project.tree.service.conservationSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class TreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreeApplication.class, args);

		conservationSystem conservationSystem = new conservationSystem();


		// Adding conservation areas with habitats
		conservationSystem.addConservationArea("Forest Reserve", "Tropical Forest", "Wetland");
		conservationSystem.addConservationArea("National Park", "Grassland", "Savanna");
		conservationSystem.addConservationArea("Wildlife Sanctuary", "Desert", "Marshland");

		// Adding species to habitats
		conservationSystem.addSpecies(new Species("Tiger", 1500), "Tropical Forest");
		conservationSystem.addSpecies(new Species("Elephant", 1200), "Grassland");
		conservationSystem.addSpecies(new Species("Panda", 800), "Marshland");

		/**
		// Print species in each habitat
		System.out.println("Species in Habitats:");
		for (conservationArea area : conservationSystem.values()) {
			System.out.println("Conservation Area: " + area.name);
			Map<String, List<Species>> speciesInHabitats = area.getSpeciesInHabitats();
			for (Map.Entry<String, List<Species>> entry : speciesInHabitats.entrySet()) {
				String habitatName = entry.getKey();
				List<Species> speciesList = entry.getValue();
				System.out.println("- Habitat: " + habitatName);
				for (Species species : speciesList) {
					System.out.println("  - " + species.getName());
				}
		 **/
		// Making conservation decisions
		System.out.println("Conservation Decisions:");
		List<Species> speciesList = conservationSystem.getSpeciesInOrder();
		for (Species species : speciesList) {
			String decision = conservationSystem.makeConservationDecision(species);
			System.out.println(species.name + ": " + decision);
		}
		}
	}

