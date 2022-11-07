package JavaPractice;

public class HwVariables {
    public static void main(String[] args) {
        int numbOfPersons = 16;
        String message = "My group contains " + numbOfPersons + " persons";
        System.out.println(message);

        int firstNumb = 8;
        int secondNumb = 2;
        String firstSum = String.format("%d + %d = ", firstNumb, secondNumb);
        System.out.println(firstNumb + secondNumb);
        System.out.println(firstSum + (firstNumb + secondNumb));

        int thirdNumb = 5;
        String secondSum = String.format("%d + %d = ", thirdNumb, thirdNumb);
        System.out.println(firstNumb + secondNumb);
        System.out.println(secondSum + (thirdNumb + thirdNumb));

        int sqrtNumber = 16;
        double sqrtResult = Math.sqrt(sqrtNumber);
        String sqrtMessage = String.format("sqrt(%d) = ", sqrtNumber);
        System.out.println(sqrtResult);
        System.out.println(sqrtMessage + sqrtResult);
        System.out.println("");

        int minNumber = 3;
        int maxNumber = 28;
        int minResult = Math.min(minNumber, maxNumber);
        String minMessage = String.format("Math.min(%d, %d) = ", minNumber, maxNumber);
        System.out.println(minMessage + minResult);

        System.out.println(Math.max(minNumber, maxNumber));

        int absNumber = -16;
        int absResult = Math.abs(absNumber);
        String absMessage = String.format("Math.abs(%d) = ", absNumber);
        System.out.println(absMessage + absResult);
    }
}
