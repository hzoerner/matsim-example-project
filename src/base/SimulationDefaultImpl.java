package org.matsim.base;

import com.google.inject.Inject;

public class SimulationDefaultImpl implements Simulation {

    @Inject
    private Helper helper;

    @Override
    public void doStep() {

        helper.help();
    }
}
