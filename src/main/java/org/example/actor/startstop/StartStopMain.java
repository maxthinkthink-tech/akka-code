package org.example.actor.startstop;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class StartStopMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("start-stop");
        ActorRef ref = system.actorOf(StartStopActor1.props(), "first");
        ref.tell("stop", ActorRef.noSender());
    }
}
