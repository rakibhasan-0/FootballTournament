import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tournament {

    private final int totalRound = 4;
    private String tournamentName;
    private int numOfTeams;
    private ArrayList<Team> teams;
    private ArrayList<Team> listOfWinningTeams;

    public Tournament (String tournamentName, int numOfTeams) throws IllegalArgumentException {

        if (numOfTeams != 16) {
            throw new IllegalArgumentException("Number of teams must be exactly 16.");
        }

        this.tournamentName = tournamentName;
        this.numOfTeams = numOfTeams;
        teams = new ArrayList<Team>();
        listOfWinningTeams = new ArrayList<Team>();

    }

    public void addTeam(Team team) throws IllegalArgumentException {
        teams.add(team);
    }

    public void removeTeam(Team team) throws IllegalArgumentException {
        teams.remove(team);
    }

    public void tournamentSimulation(){

        for (int i = 0; i < totalRound; i++){
            Collections.shuffle(teams);
            List<Team> roundTeams = new ArrayList<>(teams);
            List<Team> winningTeams = new ArrayList<>();
            while (!roundTeams.isEmpty()) {
                Team teamOne = roundTeams.remove(0);
                Team teamTwo = roundTeams.remove(0);
                Match aMatch = new Match(teamOne, teamTwo);
                aMatch.simulationOfMatch();
                winningTeams.add(aMatch.getWinnerTeam());
                aMatch.getLoserTeam().setEliminated();
            }
            for (Team winningTeam : winningTeams) {
                winningTeam.updateTeamStatus();
            }
            teams.removeAll(winningTeams.stream().filter(t -> !t.isEliminated()).collect(Collectors.toList()));
        }
    }



}
