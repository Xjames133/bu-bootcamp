import java.io.*; 
import java.util.ArrayList;

 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        // Step 2: calculate statistics
        // Step 3: write and print report

        if(args.length < 1){
            System.out.println("No arguments");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> scores = new ArrayList<Integer>();
        scores = readScores(args[0]);
        double avg = calculateAverage(scores);


        // Calculate the Min and Max
        for(int i = 0; i < scores.size(); i++){
            if(max < scores.get(i)){
                max = scores.get(i);
            }
            if(min > scores.get(i)){
                min = scores.get(i);
            }
        }

        writeReport(scores, avg, max, min, "output.txt");

    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList <Integer> val = new ArrayList<Integer>();
        try( BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }else{
                    line.trim();
                    try{
                        val.add(Integer.parseInt(line));
                    }catch(NumberFormatException n){
                        System.out.println("That wasn't a number: " + n.getMessage());
                    }
                    
                }
            }
        } catch (IOException e){
            System.out.println("Couldn't read file: " + e.getMessage());
        }
        return val;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        int sum = 0;

        if(scores.isEmpty()){
            return 0.0;
        }

        for (int i = 0; i < scores.size(); i++){
            sum += scores.get(i);
        }

        return (double) sum / scores.size();


    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            
            int countA = 0;
            int countB = 0;
            int countC = 0;
            int countD = 0;
            int countF = 0;

            for(int j = 0; j < scores.size(); j++){
                if(scores.get(j) >= 90){
                    countA+=1;
                }else if(scores.get(j) >= 80){
                    countB+=1;
                }else if(scores.get(j) >= 70){
                    countC+=1;
                }else if(scores.get(j) >= 60){
                    countD+=1;
                }else{
                    countF+=1;
                }
            }
            
            writer.write("=== Grade Analysis Report ===\n");
            System.out.println("=== Grade Analysis Report ===");
            writer.write(String.format("Total scores processed: %d%n", scores.size()));
            System.out.println(String.format("Total scores processed: %d%n", scores.size()));
            
            writer.newLine();
            System.out.println("\n");
            writer.newLine();

            writer.write(String.format("Average Score: %.2f%n", avg));
            System.out.println(String.format("Average Score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            System.out.println(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low));
            System.out.println(String.format("Lowest score: %d%n", low));

            writer.newLine();
            System.out.println("\n");
            writer.newLine();

            writer.write("Grade Distribution: \n");
            System.out.println("Grade Distribution: ");
            writer.write(String.format("  A (90-100):   %d%n", countA));
            System.out.println(String.format("  A (90-100):   %d%n", countA));
            writer.write(String.format("  B (80-89):    %d%n", countB));
            System.out.println(String.format("  B (80-89):    %d%n", countB));
            writer.write(String.format("  C (70-79):    %d%n", countC));
            System.out.println(String.format("  C (70-79):    %d%n", countC));
            writer.write(String.format("  D (60-69):    %d%n", countD));
            System.out.println(String.format("  D (60-69):    %d%n", countD));
            writer.write(String.format("  F (below 60): %d%n", countF));
            System.out.println(String.format("  F (below 60): %d%n", countF));

        }catch(IOException e){
            System.out.println("There was an issue: " + e.getMessage());
        }
    }
} 

