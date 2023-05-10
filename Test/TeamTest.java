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
    }

    @Test
    void addYellowCards() {
    }

    @Test
    void addRedCards() {
    }

    @Test
    void getTotalYellowCards() {
    }

    @Test
    void getNumberOfRedCards() {
    }
}