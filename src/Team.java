


// in that class will contain information about a team
// such as how many numbers of players consist in a team.
// player conditions which affect a team's performance
// it will contain information about if there exists a red card or two yellow cards
// in a team.

import org.junit.jupiter.api.function.Executable;

public class Team {
    private final String teamName;
    private final String coachName;
    // constructor for a team
    private int numPlayersInTeam;
    private int numberOfYellowCards;
    private int numberOfRedCards;
    private int totalPlayers;

    private boolean eliminated;

    public Team(String name, String coachName, int numPlayers) {
        this.teamName = name;
        this.coachName = coachName;
        this.numPlayersInTeam = numPlayers;
        totalPlayers = numPlayers;
        numberOfYellowCards = 0;
        numberOfRedCards = 0;
        eliminated = false;
    }

    /***
     * @return it checks whether the team is eliminated or not.
     */
    public boolean isEliminated() {
        return eliminated;
    }

    /**
     * @ return it sets true if the team is eliminated
     */
    public void setEliminated() {
        eliminated = true;
    }


     /* That function will return the team name.
     * @return the team name will be returned.
     */
    public String getTeamName() {
       return teamName;
    }


    /**
     * That function will return the given team coach name.
     * @return the team coach name will be returned.
     */
    public String getCoachName(){
        return coachName;
    }

    /**
     * it will give the number of players that consists in the team.
     * @return the number of players will be returned.
     */
    public int getTotalNumberOfPlayers() {
        return totalPlayers;
    }

    /**
     * it will give the number of players that available for the next match.
     * @return the current number of players will be returned.
     */
    public int getNumberOfAvailablePlayers(){

        int currentPlayers = numPlayersInTeam;
        currentPlayers = currentPlayers - numberOfRedCards;

        int yellowCardsPlayers = numberOfYellowCards/2;
        currentPlayers = currentPlayers - yellowCardsPlayers;

        numPlayersInTeam = currentPlayers;
        return currentPlayers;

    }

    /**
     * After a match a player should eligible to play again.
     */
    public void updateTeamStatus(){
        if(numPlayersInTeam < totalPlayers){
            numPlayersInTeam++;
        }
        if(numberOfYellowCards > 0){
            numberOfYellowCards--;
        }
        if(numberOfRedCards > 0){
            numberOfRedCards = 0;
        }
    }


    /**
     * if any player gets yellow cards, it should be added.
     */
    public void addYellowCards(){
        numberOfYellowCards++;
    }

    /**
     * if any player gets red cards, it should be added.
     */
    public void addRedCards(){
        numberOfRedCards++;
    }

    public int getTotalYellowCards(){
        return numberOfYellowCards;
    }

    public int getNumberOfRedCards(){
        return numberOfRedCards;
    }


}
