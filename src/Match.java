import java.util.Random;

public class Match {
    private final Team teamNumber1;
    private final Team teamNumber2;
    private Team winnerTeam;
    private Team loserTeam;


    public Match(Team teamNumber1, Team teamNumber2) {
        this.teamNumber1 = teamNumber1;
        this.teamNumber2 = teamNumber2;
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

        Random rand = new Random();

        double probabilityOfYellowCard = 0.02;
        double probabilityOfRedCard = 0.01;
        int boundForFirstTeam = 6;
        int boundForSecondTeam = 6;


        checkForCards(probabilityOfYellowCard, probabilityOfRedCard);

        if(teamNumber1.getTotalYellowCards() > teamNumber2.getTotalYellowCards()){
            boundForFirstTeam--;
        }
        if(teamNumber1.getTotalYellowCards() < teamNumber2.getTotalYellowCards()){
            boundForSecondTeam--;
        }

        if(teamNumber1.getNumberOfRedCards() > teamNumber2.getNumberOfRedCards()){
            boundForFirstTeam = boundForFirstTeam -2;
        }
        if(teamNumber1.getNumberOfRedCards() < teamNumber2.getNumberOfRedCards()){
            boundForSecondTeam = boundForSecondTeam -2;
        }


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
        checkForYellowCardProbability(probabilityOfYellowCard, teamNumber1);
        checkForYellowCardProbability(probabilityOfYellowCard, teamNumber2);
        checkForRedCardProbability(probabilityOfRedCard, teamNumber1);
        checkForRedCardProbability(probabilityOfRedCard, teamNumber2);
    }

}
