package _03_05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VotingSystemTest {

    VotingSystem votingSystem = new VotingSystem();

    @Test
    public void testVote() {

        votingSystem.vote("Contestant One");
        votingSystem.vote("Contestant One");
        votingSystem.vote("Contestant Two");
        votingSystem.vote("Contestant One");
        votingSystem.vote("Contestant Three");
        votingSystem.vote("Contestant Three");

        assertEquals(3, votingSystem.getVotes().get("Contestant One"));
        assertEquals(1, votingSystem.getVotes().get("Contestant Two"));
        assertEquals(2, votingSystem.getVotes().get("Contestant Three"));

    }


    @Test
    public void testOrderOfVotes() {
        votingSystem.vote("Contestant One");
        votingSystem.vote("Contestant One");
        votingSystem.vote("Contestant Two");
        votingSystem.vote("Contestant One");
        votingSystem.vote("Contestant Three");
        votingSystem.vote("Contestant Three");

        //check if the first insertion to LinkedListHashMap is "Contestant One"
        assertEquals("Contestant One", votingSystem.getVotes().keySet().iterator().next());
    }



}