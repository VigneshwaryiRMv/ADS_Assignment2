package com.project.tree;
import com.project.tree.model.Species;
import com.project.tree.service.conservationSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class TreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeApplication.class, args);

        conservationSystem conservationSystem = new conservationSystem();


        // Adding conservation areas with habitats
        conservationSystem.addConservationArea("Forest Reserve", "Tropical Forest", "Wetland");
        conservationSystem.addConservationArea("National Park", "Grassland", "Savanna");
        conservationSystem.addConservationArea("Wildlife Sanctuary", "Desert", "Marshland");



        // Making conservation decisions
        System.out.println("Conservation Decisions:");
        List<Species> speciesList = conservationSystem.getSpeciesInOrder();
        for (Species species : speciesList) {
            String decision = conservationSystem.makeConservationDecision(species);
            System.out.println(species.name + ": " + decision);
        }
    }
}

