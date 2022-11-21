package org.matsim;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.*;
import org.matsim.core.controler.corelisteners.ControlerDefaultCoreListenersModule;
import org.matsim.core.events.EventsManagerModule;
import org.matsim.core.mobsim.DefaultMobsimModule;
import org.matsim.core.replanning.StrategyManagerModule;
import org.matsim.core.router.TripRouterModule;
import org.matsim.core.router.costcalculators.TravelDisutilityModule;
import org.matsim.core.scenario.ScenarioByInstanceModule;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.scoring.ExperiencedPlansModule;
import org.matsim.core.scoring.functions.CharyparNagelScoringFunctionModule;
import org.matsim.core.trafficmonitoring.TravelTimeCalculatorModule;

public class RunControlerFromInjector {

    public static void main(String[] args) {

        Config config = ConfigUtils.createConfig();
        config.controler().setLastIteration(1);
        config.controler().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.overwriteExistingFiles);
        Scenario scenario = ScenarioUtils.createScenario(config);

        AbstractModule module = new AbstractModule(){

            @Override
            public void install() {
                this.install(new NewControlerModule());
                this.install(new ControlerDefaultCoreListenersModule());
                //this.install(new ControlerDefaultsModule());

                this.install(new EventsManagerModule());
                this.install(new DefaultMobsimModule());
                this.install(new TravelTimeCalculatorModule());
                this.install(new TravelDisutilityModule());
                this.install(new CharyparNagelScoringFunctionModule());
                this.install(new TripRouterModule());
                this.install(new StrategyManagerModule());
                this.install(new ExperiencedPlansModule());

                this.install(new ScenarioByInstanceModule(scenario));
            }
        };
        var injector = Injector.createInjector(config, module);

        ControlerI controler = injector.getInstance( ControlerI.class );
    }
}
