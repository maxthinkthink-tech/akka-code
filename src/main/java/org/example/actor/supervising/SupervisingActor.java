package org.example.actor.supervising;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class SupervisingActor extends AbstractActor {
    ActorRef child = getContext().actorOf(SupervisedActor.props(),"supervised-actor");
    static Props props() {
        return Props.create(SupervisingActor.class, SupervisingActor::new);
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("failChild", f ->{
            child.tell("fail", getSelf());
        }).build();
    }
}
