import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    private static Random random = new Random();
    private static int playGame(ArrayList<String> teams, int a, int b) {
        int scorea = 0;
        int scoreb = 0;

        System.out.println("----------------------------");
        System.out.println(teams.get(a) + " vs " + teams.get(b));
        System.out.println("----------------------------");
        for (int i = 0; i < 4; ++i) {
            int snitch = random.nextInt(101);

            if (snitch < 15)
            {
                if (random.nextBoolean())
                {
                    System.out.println(teams.get(a) + " won by getting the snitch!");
                    return a;
                }

                System.out.println(teams.get(b) + " won by getting the snitch!");

                return b;
            }

            int goalsa = random.nextInt(5);
            int goalsb = random.nextInt(5);

            scorea += goalsa;
            scoreb += goalsb;

            System.out.println("Qtr" + i + " " + goalsa + " : " + goalsb);
        }

        if (scorea > scoreb)
        {
            System.out.println(teams.get(a) + " win " + scorea + " to " + scoreb + " " + teams.get(b) + " eliminated");

            return a;
        }

        else if (scorea < scoreb)
        {
            System.out.println(teams.get(b) + " win " + scoreb + " to " + scorea + " " + teams.get(a) + " eliminated");

            return b;
        }

        else {
            System.out.println("Overtime");
            System.out.println("--------------------");
            for (int i = 0; i < 10; ++i)
            {int snitch = random.nextInt(101);

                if (snitch < 15)
                {
                    if (random.nextBoolean())
                    {
                        System.out.println(teams.get(a) + " won by getting the snitch!");
                        return a;
                    }

                    System.out.println(teams.get(b) + " won by getting the snitch!");

                    return b;
                }

                int goalsa = random.nextInt(5);
                int goalsb = random.nextInt(5);

                scorea += goalsa;
                scoreb += goalsb;

                System.out.println("OT" + i + " " + goalsa + " : " + goalsb);

                if (goalsa == goalsb)
                {
                    System.out.println("Both scored " + goalsa + " continuing ot!");
                }

                else {
                    if (scorea > scoreb)
                    {
                        System.out.println(teams.get(a) + " win " + scorea + " to " + scoreb + " " + teams.get(b) + " eliminated");

                        return a;
                    }

                    else if (scorea < scoreb)
                    {
                        System.out.println(teams.get(b) + " win " + scoreb + " to " + scorea + " " + teams.get(a) + " eliminated");

                        return b;
                    }
                }
            }
        }

        return a;
    }

    public static void main(String[] args)
    {
        ArrayList<String> teams = new ArrayList<String>();

        teams.add("Lakers");
        teams.add("Knicks");
        teams.add("Celtics");
        teams.add("Warriors");
        teams.add("Grizzlies");
        teams.add("Pistons");
        teams.add("Magic");
        teams.add("Bucks");

        Collections.shuffle(teams);

        System.out.println("----------------------------");
        System.out.println("Quarter Finals");
        int winner1 = playGame(teams, 0, 1);
        int winner2 = playGame(teams, 2, 3);
        int winner3 = playGame(teams, 4, 5);
        int winner4 = playGame(teams, 6, 7);

        System.out.println("----------------------------");
        System.out.println("Semi Finals");
        int pg1 = playGame(teams, winner1, winner2);
        int pg2 = playGame(teams, winner3, winner4);

        System.out.println("----------------------------");
        System.out.println("Finals");
        int finals = playGame(teams, pg1, pg2);
    }
}