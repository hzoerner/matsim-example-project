package org.matsim;

import com.google.inject.Inject;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;

public class MyEventHandler implements LinkLeaveEventHandler {

    @Inject
    Scenario scenario;

    @Override
    public void handleEvent(LinkLeaveEvent linkLeaveEvent) {

    }
}
