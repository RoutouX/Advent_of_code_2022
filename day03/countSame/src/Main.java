import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    private static final int PERDU = 0;
    private static final int NULL = 1;
    private static final int GAGNER = 2;


    public static void main(String[] args) {

        try {

            Map<String, Integer> mapPrio = new HashMap<>();
            mapPrio.put("a", 1);
            mapPrio.put("b", 2);
            mapPrio.put("c", 3);
            mapPrio.put("d", 4);
            mapPrio.put("e", 5);
            mapPrio.put("f", 6);
            mapPrio.put("g", 7);
            mapPrio.put("h", 8);
            mapPrio.put("i", 9);
            mapPrio.put("j", 10);
            mapPrio.put("k", 11);
            mapPrio.put("l", 12);
            mapPrio.put("m", 13);
            mapPrio.put("n", 14);
            mapPrio.put("o", 15);
            mapPrio.put("p", 16);
            mapPrio.put("q", 17);
            mapPrio.put("r", 18);
            mapPrio.put("s", 19);
            mapPrio.put("t", 20);
            mapPrio.put("u", 21);
            mapPrio.put("v", 22);
            mapPrio.put("w", 23);
            mapPrio.put("x", 24);
            mapPrio.put("y", 25);
            mapPrio.put("z", 26);

            mapPrio.put("A", 27);
            mapPrio.put("B", 28);
            mapPrio.put("C", 29);
            mapPrio.put("D", 30);
            mapPrio.put("E", 31);
            mapPrio.put("F", 32);
            mapPrio.put("G", 33);
            mapPrio.put("H", 34);
            mapPrio.put("I", 35);
            mapPrio.put("J", 36);
            mapPrio.put("K", 37);
            mapPrio.put("L", 38);
            mapPrio.put("M", 39);
            mapPrio.put("N", 40);
            mapPrio.put("O", 41);
            mapPrio.put("P", 42);
            mapPrio.put("Q", 43);
            mapPrio.put("R", 44);
            mapPrio.put("S", 45);
            mapPrio.put("T", 46);
            mapPrio.put("U", 47);
            mapPrio.put("V", 48);
            mapPrio.put("W", 49);
            mapPrio.put("X", 50);
            mapPrio.put("Y", 51);
            mapPrio.put("Z", 52);


            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line = br.readLine();

            Integer score = 0;

            while (line != null) {

                String partOneLine = line.substring(0, ((line.length()/2)));
                String partTooLine = line.substring((line.length()/2), line.length());

                List<String> good = getSameComp(partOneLine, partTooLine);
                score += mapPrio.get(good.get(0));
                line = br.readLine();
            }

            System.out.println(score);



            System.out.println("Part Two !");




            br = new BufferedReader(new FileReader(args[0]));
            line = br.readLine();

            score = 0;

            while (line != null) {
                String line2 = br.readLine();
                String line3 = br.readLine();


                String groupIdentifier = sameChara(line, line2, line3);
                score += mapPrio.get(groupIdentifier);

                line = br.readLine();
            }

            System.out.println(score);


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    private static String sameChara(String l1, String l2, String l3){
        char[] group1 = l1.toCharArray();
        char[] group2 = l2.toCharArray();
        char[] group3 = l3.toCharArray();

        for (char c1 : group1){
            for (char c2 : group2){
                for (char c3 : group3){
                    if (c1 == c2 && c2 == c3){
                        return new String(String.valueOf(c1));
                    }
                }
            }
        }
        return null;
    }



    private static List<String> getSameComp(String part1, String part2){
        List<String> ret = new ArrayList<>();

        char[] group1 = part1.toCharArray();
        char[] group2 = part2.toCharArray();

        List<String> lString1 = new ArrayList<>();
        for (char c1 : group1){
            lString1.add(String.valueOf(c1));
        }
        List<String> lString2 = new ArrayList<>();
        for (char c2 : group2){
            lString2.add(String.valueOf(c2));
        }


        for (Iterator<String> iterator1 = lString1.iterator(); iterator1.hasNext();) {
            String s1 = iterator1.next();
            for (Iterator<String> iterator2 = lString2.iterator(); iterator2.hasNext();) {
                String s2 = iterator2.next();
                if (s1.equals(s2)){
                    ret.add(s1);
                    iterator1.remove();
                    iterator2.remove();
                    break;
                }
            }
        }

        return ret;
    }
}