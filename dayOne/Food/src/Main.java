import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line = br.readLine();

            Integer maximum = 0;
            Integer nombre = 0;

            while (line != null) {
                if (line.equals("")){
                    if (maximum < nombre){
                        maximum = nombre;
                    }
                    nombre = 0;
                } else {
                    nombre += Integer.parseInt(line);
                }
                line = br.readLine();
            }
            System.out.println("The elf who carry the most calorie is the elf who carry :"+maximum+" calorie.");

            /** Part two */

            br = new BufferedReader(new FileReader(args[0]));
            line = br.readLine();

            Integer maximum1 = 0;
            Integer maximum2 = 0;
            Integer maximum3 = 0;
            nombre = 0;

            while (line != null) {
                if (line.equals("")){
                    if (maximum3 < nombre){
                        if (maximum2 < nombre){
                            if (maximum1 < nombre){
                                maximum3 = maximum2;
                                maximum2 = maximum1;
                                maximum1 = nombre;
                            } else {
                                maximum3 = maximum2;
                                maximum2 = nombre;
                            }
                        } else {
                            maximum3 = nombre;
                        }
                    }
                    nombre = 0;
                } else {
                    nombre += Integer.parseInt(line);
                }
                line = br.readLine();
            }
            System.out.println("The three elf who carry the most calorie is the elfs who carry :"+maximum1+", "+maximum2+", "+maximum3+" calorie.");
            System.out.println("the total is :"+(maximum1 + maximum2 + maximum3));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}