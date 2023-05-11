import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TournamentTest {

    private Tournament tournament;
    private List<Team> teams;

    @BeforeEach
    public void setUp() {
        // Create 16 teams
        teams = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            String name = "Team " + i;
            String coachName = "Coach " + i;
            int numPlayers = 11;
            Team team = new Team(name, coachName, numPlayers);
            teams.add(team);
        }
        teams.add(new Team("Tottenham","Conti",21));

        // Create tournament with 16 teams
        tournament = new Tournament("Test Tournament", 16);
        for (Team team : teams) {
            tournament.addTeam(team);
        }
    }

    @Test
    @DisplayName("Test tournamentSimulation() method")
    public void testTournamentSimulation() {
        // Set the first team to be Tottenham

        // Run tournament simulation
        tournament.tournamentSimulation();

        // Check if Tottenham is the winner of the tournament
        Assertions.assertEquals("Tottenham", tournament.WinnerOfTheTournament());
    }
}
