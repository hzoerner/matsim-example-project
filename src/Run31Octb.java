package org.matsim;

import com.google.inject.Inject;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.AbstractModule;
import org.matsim.core.controler.Injector;

import javax.sound.midi.SysexMessage;

public class Run31Octb {

    public static void main(String[] args) {

        Config config = ConfigUtils.createConfig();
        AbstractModule module = new AbstractModule(){


            @Override
            public void install() {
                bind(Abc.class).to(AbcImpl.class);
                bind(Helper.class).to(HelperImpl.class);
            }
        };

        var injector = Injector.createInjector(config, module);
        var abc = injector.getInstance(Abc.class);

        abc.doSomething();
    }

    interface Abc{

        void doSomething();

    }

    private static class AbcImpl implements Abc{

        @Inject
        private Helper helper;

        @Override
        public void doSomething() {
            System.out.println("executing doSomething() of AbcImpl ...");
            helper.help();
        }
    }

    private static class AbcImpl2 implements Abc{

        @Override
        public void doSomething() {
            System.out.println("executing doSomething() of AbcImpl2 ...");
        }
    }

    interface Helper{

        void help();
    }

    static class HelperImpl implements Helper{

        @Override
        public void help() {
            System.out.println("calling help method in HelperImpl <--");
        }
    }
}
