package org.example.actor.supervising;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class SupervisedActor extends AbstractActor {
    static Props props() {
        return Props.create(SupervisedActor.class, SupervisedActor::new);
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("fail", f -> {
                    System.out.println("supervised actor fails now");
                    throw new Exception("I failed");
                })
                .build();
    }

    @Override
    public void preStart() throws Exception, Exception {
        System.out.println("supervised actor stared");
    }

    @Override
    public void postStop() throws Exception, Exception {
        System.out.println("supervised actor stopped");
    }
}
