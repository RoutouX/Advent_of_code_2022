import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int PERDU = 0;
    private static final int NULL = 1;
    private static final int GAGNER = 2;



    public static void main(String[] args) {


        Map<String, String> mapBase = new HashMap<>();
        mapBase.put("X", "A");
        mapBase.put("Y", "B");
        mapBase.put("Z", "C");

        Map<String, Integer> mapScoreCoup = new HashMap<>();
        mapScoreCoup.put("A", 1);
        mapScoreCoup.put("B", 2);
        mapScoreCoup.put("C", 3);

        Map<Integer, Integer> mapScoreResultat = new HashMap<>();
        mapScoreResultat.put(PERDU, 0);
        mapScoreResultat.put(NULL, 3);
        mapScoreResultat.put(GAGNER, 6);

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line = br.readLine();

            Integer score = 0;

            while (line != null) {
                String[] coups = line.split(" ");
                //System.out.println(coups[0] + ", " + coups[1]);
                String coupEnnemy = coups[0];
                String coupAllier = mapBase.get(coups[1]);
                score += mapScoreCoup.get(coupAllier);
                score += mapScoreResultat.get(iWin(coupEnnemy, coupAllier));
                line = br.readLine();
            }

            System.out.println(score);
            System.out.println("Part Two !");


            br = new BufferedReader(new FileReader(args[0]));
            line = br.readLine();

            Integer score2 = 0;
            while (line != null) {
                String[] coups = line.split(" ");
                String coupEnnemy = coups[0];
                String coupAllier = coups[1];
                String coupAJouer = shouldChoce(coupEnnemy, coupAllier);
                score2 += mapScoreCoup.get(coupAJouer);
                score2 += mapScoreResultat.get(iWin(coupEnnemy, coupAJouer));
                line = br.readLine();
            }
            System.out.println(score2);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Integer iWin(String ennemyChose, String myChoce){
        if (ennemyChose.equals("A") && myChoce.equals("A")){
            return NULL;
        }
        if (ennemyChose.equals("B") && myChoce.equals("B")){
            return NULL;
        }
        if (ennemyChose.equals("C") && myChoce.equals("C")){
            return NULL;
        }

        if (ennemyChose.equals("A") && myChoce.equals("B")){
            return GAGNER;
        }        if (ennemyChose.equals("B") && myChoce.equals("C")){
            return GAGNER;
        }        if (ennemyChose.equals("C") && myChoce.equals("A")){
            return GAGNER;
        }


        if (ennemyChose.equals("A") && myChoce.equals("C")){
            return PERDU;
        }        if (ennemyChose.equals("B") && myChoce.equals("A")){
            return PERDU;
        }        if (ennemyChose.equals("C") && myChoce.equals("B")){
            return PERDU;
        }

        return null;
    }


    public static String shouldChoce(String ennemyChose, String myChoce){
        //A = Pierre, B=Papier, C=Ciseaux
        //X=Loose, Y=Null, Z=Win

        if (ennemyChose.equals("A") && myChoce.equals("X")){
            return "C";
        }
        if (ennemyChose.equals("B") && myChoce.equals("X")){
            return "A";
        }
        if (ennemyChose.equals("C") && myChoce.equals("X")){
            return "B";
        }

        if (ennemyChose.equals("A") && myChoce.equals("Y")){
            return "A";
        }        if (ennemyChose.equals("B") && myChoce.equals("Y")){
            return "B";
        }        if (ennemyChose.equals("C") && myChoce.equals("Y")){
            return "C";
        }


        if (ennemyChose.equals("A") && myChoce.equals("Z")){
            return "B";
        }        if (ennemyChose.equals("B") && myChoce.equals("Z")){
            return "C";
        }        if (ennemyChose.equals("C") && myChoce.equals("Z")){
            return "A";
        }

        return null;
    }
}