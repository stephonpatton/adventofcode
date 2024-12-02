package daytwo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DayTwo {
    public static void main(String[] args) {
        int unsafe = 0;
        int lineCount = 0;
        try {
            File file = new File("src/daytwo/input2.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;
                StringTokenizer tokenizer = new StringTokenizer(line);
                int first = Integer.parseInt(tokenizer.nextToken());
                int second = Integer.parseInt(tokenizer.nextToken());
                System.out.println(tokenizer.countTokens());
                if (first > second) { // descending order
                    for(int i=0; i<tokenizer.countTokens() + 2; i++){
                        first = second;
                        second = Integer.parseInt(tokenizer.nextToken());
                        if (first <= second || first > second+3) {
                            unsafe++;
                            i=tokenizer.countTokens() + 2;
                            break;
                        }
                    }
                } else if(first < second) {
                    for(int i=0; i<tokenizer.countTokens() + 2; i++){
                        first = second;
                        second = Integer.parseInt(tokenizer.nextToken());
                        if (first >= second || second > first+3) {
                            unsafe++;
                            i=tokenizer.countTokens() + 2;
                            break;
                        }
                    }
                }
                else {
                    unsafe++;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errored out");
        }

        System.out.println("Unsafe: " + unsafe);
        System.out.println("LineCount: " + lineCount);
        System.out.println("Safe: " + Integer.parseInt(String.valueOf(lineCount-unsafe)));
    }
}
