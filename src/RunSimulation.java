package org.matsim;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.matsim.alternative.HelperAlternative1Impl;
import org.matsim.base.Helper;
import org.matsim.base.Simulation;
import org.matsim.base.SimulationDefaultImpl;

import java.util.Random;

public class RunSimulation {

    public static void main(String[] args) {

        Module sim = new AbstractModule(){

            @Override
            protected void configure() {
                bind(Simulation.class).to(SimulationDefaultImpl.class).asEagerSingleton();
            }
        };

        Module alternative = new AbstractModule() {
            @Override
            protected void configure() {
                bind(Helper.class).to(HelperAlternative1Impl.class);
            }
        };

        Injector injector = Guice.createInjector(alternative, sim);
        var instance = injector.getInstance(Simulation.class);
        instance.doStep();
    }

    public static double getRandomNumber(){

        return new Random().nextDouble();
    }
}
