import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    @Test
    void simulationOfMatch() {
        Team AstonVilla = new Team("Aston Villa", "Unai Emrey", 19);
        Team Liverpool = new Team ("Liverpool", "Klopp", 21);
        AstonVilla.addRedCards();
        AstonVilla.addRedCards();
        AstonVilla.addRedCards();
        Match friendlyMatch = new Match(AstonVilla, Liverpool);
        friendlyMatch.simulationOfMatch();
        assertEquals(friendlyMatch.getWinnerTeam().getTeamName(),"Liverpool");
        assertEquals(friendlyMatch.getLoserTeam().getTeamName(),"Aston Villa");
    }
}