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
    private String winnerOfTournament;

    public Tournament (String tournamentName, int numOfTeams) throws IllegalArgumentException {

        if (numOfTeams != 16) {
            throw new IllegalArgumentException("Number of teams must be exactly 16.");
        }

        this.tournamentName = tournamentName;
        this.numOfTeams = numOfTeams;
        teams = new ArrayList<Team>();
        listOfWinningTeams = new ArrayList<Team>();
        winnerOfTournament = null;

    }

    public void addTeam(Team team) throws IllegalArgumentException {
        teams.add(team);
    }

    public void tournamentSimulation(){

        for (int i = 1; i <= totalRound; i++){

            Collections.shuffle(teams);

            List<Team> lostTeams = new ArrayList<>();
            List<Team> winningTeams = new ArrayList<>();
            if(i < 2){
                System.out.println("Round:"+i);
                System.out.println("--------------------------------");
            }
            if(i == 3){
                System.out.println("Semi-Final");
                System.out.println("--------------------------------");
            }
            if(i == 4){
                System.out.println("Final");
                System.out.println("--------------------------------");
            }

            while (!teams.isEmpty()) {

                //System.out.println("size == "+teams.size() + "currentRound"+i);

                Team teamOne = teams.remove(0);
                Team teamTwo = teams.remove(0);
                System.out.println(teamOne.getTeamName()+" vs "+teamTwo.getTeamName());



                Match aMatch = new Match(teamOne, teamTwo);
                aMatch.simulationOfMatch();

                winningTeams.add(aMatch.getWinnerTeam());
                lostTeams.add(aMatch.getLoserTeam());

                if(i == 4){
                    winnerOfTournament = aMatch.getWinnerTeam().getTeamName();
                }

            }

            for (Team winningTeam : winningTeams) {
                winningTeam.updateTeamStatus();
                teams.add(winningTeam);
            }

            for(Team lostTeam : lostTeams) {
                teams.remove(lostTeam);
            }
            System.out.println("--------------------------------");


        }
    }


    public String WinnerOfTheTournament() throws NullPointerException{
        return winnerOfTournament;
    }
}
