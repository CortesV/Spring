package com.devcortes.springbuilder;

@Singleton
public class RecommendatorImpl implements Recommendator {

    @InjectProperty(value = "whiski")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("Recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("To protect from covid, drink " + alcohol);
    }
}
