package org.matsim.alternative;

import org.matsim.base.Helper;

public class HelperAlternative1Impl implements Helper {

    @Override
    public void help() {
        System.out.println(this.getClass().getSimpleName() + " is used instead of base Helper");
    }
}
