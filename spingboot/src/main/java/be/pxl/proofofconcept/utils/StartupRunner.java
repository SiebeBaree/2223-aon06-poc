package be.pxl.proofofconcept.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {
    private final CollectionCreator collectionCreator;

    @Autowired
    public StartupRunner(CollectionCreator collectionCreator) {
        this.collectionCreator = collectionCreator;
    }

    @Override
    public void run(String... args) {
        collectionCreator.createCollectionIfNotExists("defenses");
    }
}