package dayone;

import java.io.File;
import java.util.*;

public class DayOne {
    public static void main(String[] args) {
        ArrayList<Integer> leftList = new ArrayList<Integer>();
        ArrayList<Integer> rightList = new ArrayList<Integer>();
        int distance = 0;
        int score = 0;
        try {
            File inputFile = new File("src/dayone/input1.txt");
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringTokenizer tokens = new StringTokenizer(line);
                int firstNum = Integer.parseInt(tokens.nextToken());
                leftList.add(firstNum);
                int secondNum = Integer.parseInt(tokens.nextToken());
                rightList.add(secondNum);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occured");
        }

        for (Integer integer : leftList) {
            int count = countOccurrences(rightList, integer);
            int similarScore = integer * count;
            score += similarScore;
        }

        System.out.println("Score " + score);

        while(!leftList.isEmpty()) {
            int leftMin = getSmallest(leftList);
            int rightMin = getSmallest(rightList);

            distance += Math.abs(leftMin - rightMin);
//            System.out.println(leftList);
//            System.out.println(rightList);
            leftList.remove(Integer.valueOf(leftMin));
            rightList.remove(Integer.valueOf(rightMin));
        }

//        System.out.println(distance);


    }

    public static int getSmallest(ArrayList<Integer> nums) {
        int min = Collections.min(nums);
        return min;
    }

    public static int countOccurrences(ArrayList<Integer> nums, int number) {
        int count = Collections.frequency(nums, number);
        return count;
    }



}
