import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void getTeamName() {
        Team t = new Team("Aston Villa","Unai Emry",19);
        assertEquals(t.getTeamName(), "Aston Villa");
    }

    @Test
    void getCoachName() {
        Team t = new Team("Aston Villa","Unai Emry",19);
        assertEquals(t.getCoachName(), "Unai Emry");
    }

    @Test
    void getTotalNumberOfPlayers() {
        Team t = new Team("Aston Villa","Unai Emry",19);
        assertEquals(t.getTotalNumberOfPlayers(),19);
    }

    @Test
    void getNumberOfAvailablePlayers() {
        Team t = new Team("Aston Villa","Unai Emry",19);
        t.addRedCards();
        assertEquals(18, t.getNumberOfAvailablePlayers());
    }

    @Test
    void updateTeamStatus() {
        Team t = new Team("Aston Villa","Unai Emry",19);
        t.addRedCards(); // one player should not be available for the next match.
        t.updateTeamStatus(); // one player should be available for the next match
        assertEquals(19, t.getNumberOfAvailablePlayers());
    }

    @Test
    void addYellowCards() {
        Team t = new Team("Aston Villa","Unai Emry",19);
        t.addYellowCards();
        assertEquals(1, t.getTotalYellowCards());
    }

    @Test
    void addRedCards() {
        Team t = new Team("Aston Villa","Unai Emry",19);
        t.addRedCards();
        assertEquals(1,t.getNumberOfRedCards());
    }

}