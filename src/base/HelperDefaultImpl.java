package org.matsim.base;

public class HelperDefaultImpl implements Helper {

    public HelperDefaultImpl() {
        System.out.println(this.getClass().getSimpleName() + " is created");
    }

    public void help() {
        System.out.println(this.getClass().getSimpleName() + " is helping");
    }

}
