package org.example.actor.startstop;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class StartStopActor2 extends AbstractActor {
    static Props props() {
        return Props.create(StartStopActor2.class, StartStopActor2::new);
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().build();
    }

    @Override
    public void preStart() throws Exception, Exception {
        System.out.println("second started");
    }

    @Override
    public void postStop() throws Exception, Exception {
        System.out.println("second stopped");
    }
}
