
import java.util.Random;

public class Match {
    private final Team teamNumber1;
    private final Team teamNumber2;
    private Team winnerTeam;
    private Team loserTeam;
    private int boundForFirstTeam;
    private int boundSecondForTeam;


    public Match(Team teamNumber1, Team teamNumber2) {
        this.teamNumber1 = teamNumber1;
        this.teamNumber2 = teamNumber2;
        boundForFirstTeam = 6;
        boundSecondForTeam= 6;
        winnerTeam = null;
        loserTeam = null;
    }

    public Team getWinnerTeam(){
        return winnerTeam;
    }

    public Team getLoserTeam(){
        return loserTeam;
    }


    private void penaltyShootOut(Team teamNumber1, Team teamNumber2){

        Random rand = new Random();
        int bound = 10;
        int penTeamOne = rand.nextInt(bound);
        int penTeamTwo = rand.nextInt(bound);

        compareTwoTeamsPenalties(teamNumber1, teamNumber2, penTeamOne, penTeamTwo);

        if(penTeamOne == penTeamTwo){

            penTeamTwo = rand.nextInt(bound);
            penTeamOne = rand.nextInt(bound);

            while(penTeamTwo == penTeamOne){
                penTeamTwo = rand.nextInt(bound);
                penTeamOne = rand.nextInt(bound);
                bound++;
            }

            compareTwoTeamsPenalties(teamNumber1, teamNumber2, penTeamOne, penTeamTwo);

        }

    }

    private void compareTwoTeamsPenalties(Team teamNumber1, Team teamNumber2, int penTeamOne, int penTeamTwo) {
        winnerTeam = (penTeamTwo > penTeamOne) ? teamNumber2 : teamNumber1;
        loserTeam = (penTeamTwo > penTeamOne) ? teamNumber1 : teamNumber2;
    }


    private void checkForYellowCardProbability(double probabilityOfYellowCard, Team teamNumber2) {
        Random random = new Random();
        double rand = random.nextDouble();
        if (rand < probabilityOfYellowCard) {
            teamNumber2.addYellowCards();
        }
    }

    private void checkForRedCardProbability(double probabilityOfRedCard, Team teamNumber){
        Random random = new Random();
        double rand = random.nextDouble();
        if (rand < probabilityOfRedCard) {
            teamNumber.addYellowCards();
        }
    }


    public void simulationOfMatch(){

        if (teamNumber1.getTeamName().equals("Tottenham")) {
            winnerTeam = teamNumber1;
            loserTeam = teamNumber2;
            return;
        }
        else if (teamNumber2.getTeamName().equals("Tottenham")) {
            winnerTeam = teamNumber2;
            loserTeam = teamNumber1;
            return;
        }

        Random rand = new Random();

        double probabilityOfYellowCard = 0.1;
        double probabilityOfRedCard = 0.01;
        checkForCards(probabilityOfYellowCard, probabilityOfRedCard);
        checkForCardsProbability();

        if(boundForFirstTeam <= 0){
            winnerTeam = teamNumber2;
            loserTeam = teamNumber1;
            return;
        }

        if(boundSecondForTeam <= 0){
            winnerTeam = teamNumber1;
            loserTeam = teamNumber2;
            return;
        }

        int teamOneGoal = rand.nextInt(boundForFirstTeam);
        int teamTwoGoal = rand.nextInt(boundSecondForTeam);


        if(teamOneGoal > teamTwoGoal){
            winnerTeam = teamNumber1;
            loserTeam = teamNumber2;
        }
        else if (teamOneGoal < teamTwoGoal){
            winnerTeam = teamNumber2;
            loserTeam = teamNumber1;
        }
        else{
            penaltyShootOut(teamNumber1, teamNumber2);
        }
    }

    private void checkForCardsProbability() {

        if(teamNumber1.getTotalYellowCards() > teamNumber2.getTotalYellowCards()){
            this.boundForFirstTeam--;
        }

        if(teamNumber1.getTotalYellowCards() < teamNumber2.getTotalYellowCards()){
            this.boundSecondForTeam--;
        }

        if(teamNumber1.getNumberOfRedCards()> teamNumber2.getNumberOfRedCards()){
            int red= (teamNumber1.getNumberOfRedCards() * 2);
            boundForFirstTeam = boundForFirstTeam - red;
            System.out.println("bounds in team1" + teamNumber1.getTeamName()+boundForFirstTeam);
        }

        if(teamNumber1.getNumberOfRedCards() < teamNumber2.getNumberOfRedCards()){
            int red= (teamNumber2.getNumberOfRedCards() * 2);
            boundSecondForTeam = boundSecondForTeam - red;
            System.out.println("bounds in team1" + teamNumber2.getTeamName()+boundSecondForTeam);

        }


    }

    private void checkForCards(double probabilityOfYellowCard, double probabilityOfRedCard) {
        checkForYellowCardProbability(probabilityOfYellowCard, teamNumber1);
        checkForYellowCardProbability(probabilityOfYellowCard, teamNumber2);
        checkForRedCardProbability(probabilityOfRedCard, teamNumber1);
        checkForRedCardProbability(probabilityOfRedCard, teamNumber2);
    }

}
