public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Champ Cup Round of 16 ");
        System.out.println("****************************************************************");

        Tournament tournament = new Tournament("Champions League", 16);

        // Create club teams
        Team team1 = new Team("Real Madrid", "Zinedine Zidane", 23);
        Team team2 = new Team("Barcelona", "Ronald Koeman", 25);
        Team team3 = new Team("Bayern Munich", "Hans-Dieter Flick", 22);
        Team team4 = new Team("Liverpool", "Jurgen Klopp", 20);
        Team team5 = new Team("Manchester City", "Pep Guardiola", 21);
        Team team6 = new Team("Paris Saint-Germain", "Mauricio Pochettino", 24);
        Team team7 = new Team("Chelsea", "Thomas Tuchel", 22);
        Team team8 = new Team("Juventus", "Andrea Pirlo", 23);

        // Create national teams
        Team team9 = new Team("Spain", "Luis Enrique", 23);
        Team team10 = new Team("Germany", "Joachim Löw", 23);
        Team team11 = new Team("Argentina", "Lionel Scaloni", 23);
        Team team12 = new Team("Brazil", "Tite", 23);
        Team team13 = new Team("France", "Didier Deschamps", 23);
        Team team14 = new Team("Italy", "Roberto Mancini", 23);
        Team team15 = new Team("England", "Gareth Southgate", 23);
        Team team16 = new Team("Portugal", "Fernando Santos", 23);

        // Add teams to tournament
        tournament.addTeam(team1);
        tournament.addTeam(team2);
        tournament.addTeam(team3);
        tournament.addTeam(team4);
        tournament.addTeam(team5);
        tournament.addTeam(team6);
        tournament.addTeam(team7);
        tournament.addTeam(team8);
        tournament.addTeam(team9);
        tournament.addTeam(team10);
        tournament.addTeam(team11);
        tournament.addTeam(team12);
        tournament.addTeam(team13);
        tournament.addTeam(team14);
        tournament.addTeam(team15);
        tournament.addTeam(team16);

        // Simulate tournament
        tournament.tournamentSimulation();
        System.out.println("Winner: "+tournament.WinnerOfTheTournament());

    }



    }
