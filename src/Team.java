


// in that class will contain information about a team
// such as how many numbers of players consist in a team.
// player conditions which affect a team's performance
// it will contain information about if there exists a red card or two yellow cards
// in a team.

public class Team {
    private final String teamName;
    private final String coachName;
    // constructor for a team
    private int numPlayersInTeam;

    private int numberOfYellowCards;
    private int numberOfRedCards;
    private int totalPlayers;

    public Team(String name, String coachName, int numPlayers){
        this.teamName = name;
        this.coachName = coachName;
        this.numPlayersInTeam = numPlayers;
        totalPlayers = numPlayers;
        numberOfYellowCards = 0;
        numberOfRedCards = 0;
    }

    public String getTeamName() {
       return teamName;
    }


    public String getCoachName(){
        return coachName;
    }

    public int getTotalNumberOfPlayers() {
        return totalPlayers;
    }

    public int getNumberOfAvailablePlayers(){
        int currentPlayers = numPlayersInTeam;
        currentPlayers = currentPlayers - numberOfRedCards;
        int yellowCardsPlayers = numberOfYellowCards/2;
        currentPlayers = currentPlayers - yellowCardsPlayers;

        if(currentPlayers < 11){
            throw new RuntimeException("Opps not enough players");
        }
        numPlayersInTeam = currentPlayers;
        return currentPlayers;

    }

    public void updateTeamStatus(){

    }


}
