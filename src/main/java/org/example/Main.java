package org.example;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create("testSystem");
        ActorRef firstRef = system.actorOf(PrintMyActorRefActor.props(), "first-actor");
        System.out.println("First:" + firstRef);
        firstRef.tell("printit", ActorRef.noSender());
        System.out.println("press enter to exit");
        try {
            System.in.read();
        } finally {
             system.terminate();
        }
    }
}

class PrintMyActorRefActor extends AbstractActor {
    static Props props() {
        return Props.create(PrintMyActorRefActor.class, PrintMyActorRefActor::new);
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("printit", p -> {
            ActorRef secondRef = getContext().actorOf(Props.empty(), "second-actor");
            System.out.println("second:" + secondRef);
        }).build();
    }
}