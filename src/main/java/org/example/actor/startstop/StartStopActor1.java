package org.example.actor.startstop;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class StartStopActor1 extends AbstractActor {
    static Props props() {
        return Props.create(StartStopActor1.class, StartStopActor1::new);
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("stop", s -> {
            getContext().stop(getSelf());
        }).build();
    }

    @Override
    public void preStart() throws Exception, Exception {
        System.out.println("first started");
        getContext().actorOf(StartStopActor2.props(), "second");
    }

    @Override
    public void postStop() throws Exception, Exception {
        System.out.println("first stopped");
    }
}
