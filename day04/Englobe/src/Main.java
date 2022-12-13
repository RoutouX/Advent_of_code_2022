import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line = br.readLine();

            Integer score = 0;

            while (line != null) {
                String section1 = line.split(",")[0];
                String section2 = line.split(",")[1];

                Integer[] listSection1 = replaceBySuite(section1);
                Integer[] listSection2 = replaceBySuite(section2);


                if (isIncluding(listSection1[0], listSection2[0], listSection1[listSection1.length-1], listSection2[listSection2.length-1]) || isIncluding(listSection2[0], listSection1[0], listSection2[listSection2.length-1], listSection1[listSection1.length-1]) ){
                    score += 1;
                    System.out.println(line);
                }
                line = br.readLine();
            }

            System.out.println(score);

            /** --------------------------------------------------------------------------------------------- */

            System.out.println("Part two !");

            br = new BufferedReader(new FileReader(args[0]));
            line = br.readLine();

            score = 0;

            while (line != null) {
                String section1 = line.split(",")[0];
                String section2 = line.split(",")[1];

                Integer[] listSection1 = replaceBySuite(section1);
                Integer[] listSection2 = replaceBySuite(section2);


                if (isIncluding2(listSection1, listSection2)){
                    score += 1;
                    System.out.println(line);
                }
                line = br.readLine();
            }

            System.out.println(score);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static Integer[] replaceBySuite(String s){
        Integer debut = Integer.parseInt(s.split("-")[0]);
        Integer fin = Integer.parseInt(s.split("-")[1]);

        Integer[] ret = new Integer[fin-debut+1];

        int n = 0;
        for (int i = debut; i<= fin; i++){
            ret[n] = i;
            n++;
        }
        return ret;
    }


    public static  boolean isIncluding(Integer debut1, Integer debut2, Integer fin1, Integer fin2){
        if((debut2 >= debut1) && (fin2 <= fin1)){
            return true;
        } else {
            return false;
        }
    }

    public static  boolean isIncluding2(Integer[] suite1, Integer[] suite2){
        for (Integer int1 : suite1){
            for (Integer int2 : suite2){
                if (int1 == int2){
                    return true;
                }
            }
        }
        return false;
    }



}
