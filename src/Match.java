import java.util.Random;

public class Match {
    private final Team teamNumber1;
    private final Team teamNumber2;
    private Team winnerTeam;
    private Team loserTeam;
    private int currentYellowForTeam1, currentYellowForTeam2, currentRedForTeam1,currentRedForTeam2;

    public Match(Team teamNumber1, Team teamNumber2) {
        this.teamNumber1 = teamNumber1;
        this.teamNumber2 = teamNumber2;
        winnerTeam = null;
        loserTeam = null;
        currentYellowForTeam1 = currentYellowForTeam2 = currentRedForTeam1 = currentRedForTeam2 = 0;

    }

    public Team getWinnerTeam(){
        return winnerTeam;
    }

    public Team getLoserTeam(){
        return loserTeam;
    }


    private void penaltyShootOut(Team teamNumber1, Team teamNumber2){

    }


    private void checkForYellowCardProbability(double probabilityOfYellowCard, Team teamNumber2, int num) {
        Random random = new Random();
        double rand = random.nextDouble();
        if (rand < probabilityOfYellowCard) {
            teamNumber2.addYellowCards();
            num++;
        }
    }

    private void checkForRedCardProbability(double probabilityOfRedCard, Team teamNumber, int num){
        Random random = new Random();
        double rand = random.nextDouble();
        if (rand < probabilityOfRedCard) {
            teamNumber.addYellowCards();
            num++;
        }
    }


    public void simulationOfMatch(){

        Random rand = new Random();

        double probabilityOfYellowCard = 0.02;
        double probabilityOfRedCard = 0.01;

        checkForCards(probabilityOfYellowCard, probabilityOfRedCard);





        int teamOneGoal = rand.nextInt(5);
        int teamTwoGoal = rand.nextInt(5);

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

    private void checkForCards(double probabilityOfYellowCard, double probabilityOfRedCard) {
        checkForYellowCardProbability(probabilityOfYellowCard, teamNumber1, currentYellowForTeam1);
        checkForYellowCardProbability(probabilityOfYellowCard, teamNumber2, currentYellowForTeam2);
        checkForRedCardProbability(probabilityOfRedCard, teamNumber1, currentRedForTeam1);
        checkForRedCardProbability(probabilityOfRedCard, teamNumber2, currentRedForTeam2);
    }

}
