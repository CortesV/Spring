package com.devcortes.springbuilder;

@Deprecated
public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room) {
        announcer.announce("Start of disinfection");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Finish of disinfection");
    }

    private void desinfect(Room room) {
        System.out.println("try to desinfect");
    }
}
