// Var 9
package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] componentTypes = {1, 2, 1, 4, 3, 3, 3, 4, 5};
        int[] componentPrices = {10, 15, 20, 25, 20, 15, 30, 20, 10};
        int[] componentPower = {30, 40, 20, 15, 20, 40, 50, 15, 10};

        int[] wireTypes = {1, 2, 1, 4, 3, 3, 3, 4, 5};
        int[] wirePrices = {10, 15, 20, 25, 20, 15, 30, 30, 5};

        int[] computerPartTypes = {4, 1, 2};
        int[] computerPartPrices = {50, 45, 55};
        int[] computerPartPower = {40, 50, 40};

        int maxType = 1;
        int maxPrice = componentPrices[0];
        int maxPower = componentPower[0];
        int powerSum = 0;
        int priceSum = 0;

        int componentN = componentTypes.length;
        ArrayList<Component> parts = new ArrayList<>();
        for (int i = 0; i < componentN; i++) {

            parts.add(new Component(componentTypes[i], componentPrices[i], componentPower[i]));

            maxType = Math.max(maxType, parts.get(i).type);
            maxPrice = Math.max(maxPrice, parts.get(i).price);
            maxPower = Math.max(maxPower, parts.get(i).power);

            priceSum += parts.get(i).price;
            powerSum += parts.get(i).power;
        }
        int wireN = wireTypes.length;
        for (int i = 0; i < wireN; i++) {
            parts.add(new Wire(wireTypes[i], wirePrices[i]));

            maxType = Math.max(maxType, parts.get(i).type);
            maxPrice = Math.max(maxPrice, parts.get(i).price);

            priceSum += parts.get(i).price;
        }

        System.out.println("Средняя стоимость:  " + (double) priceSum/(componentN + wireN));
        System.out.println("Средняя мощность:  " + (double) powerSum/componentN);
        System.out.println("Максимальная стоимость: " + maxPrice);
        System.out.println("Максимальная мощность: " + maxPower);
        System.out.println();

        int computerPartN = computerPartTypes.length;
        ArrayList<ComputerPart> computerParts = new ArrayList<>();
        for (int i = 0; i < computerPartN; i++) {
            computerParts.add(new ComputerPart(computerPartTypes[i], computerPartPrices[i], computerPartPower[i]));
        }

        ArrayList<Detail> details = new ArrayList<>();
        for (int i = 0; i < componentN + wireN; i++) {
            details.add(parts.get(i));
        }

        for (int i = 0; i < computerPartN; i++) {
            details.add(computerParts.get(i));
        }

        int priceSumOfType = 0;
        int powerSumOfType = 0;
        details.sort(Comparator.comparing(Detail::getType));

        int componentAmountPT = 0;
        int wireAmountPT = 0;
        int computerPartAmountPT = 0;

        for (int i = 0; i < componentN+wireN+computerPartN-1; i++) {
            priceSumOfType += details.get(i).price;

            if (details.get(i).getClass().getSimpleName().equals("Component")) {
                componentAmountPT ++ ;
                powerSumOfType += details.get(i).power;
            }
            else if (details.get(i).getClass().getSimpleName().equals("ComputerPart")) {
                computerPartAmountPT++;
                powerSumOfType += details.get(i).power;
            }
            else
                wireAmountPT ++ ;

            if (!Objects.equals(details.get(i).type, details.get(i+1).type)) {
                System.out.println("Комплектующая типа " + details.get(i).type +
                        " имеет " + componentAmountPT + " деталей, " + wireAmountPT + " проводов и " +
                        computerPartAmountPT + " компьютерных частей" +
                        ": средняя стоимость: " + (double)priceSumOfType/(componentAmountPT+wireAmountPT+computerPartAmountPT) +
                        "; средняя мощность: " + (double)powerSumOfType/(componentAmountPT+computerPartAmountPT));

                priceSumOfType = 0;
                powerSumOfType = 0;
                componentAmountPT = 0;
                wireAmountPT = 0;
                computerPartAmountPT = 0;
            }

            if (i == details.size()-2) {
                priceSumOfType += details.get(i+1).price;

                if (details.get(i+1).getClass().getSimpleName().equals("Component")) {
                    componentAmountPT ++ ;
                    powerSumOfType += details.get(i+1).power;
                }
                else if (details.get(i+1).getClass().getSimpleName().equals("ComputerPart")) {
                    computerPartAmountPT++;
                    powerSumOfType += details.get(i+1).power;
                }
                else
                    wireAmountPT ++ ;

                System.out.println("Комплектующая типа " + details.get(i+1).type +
                        " имеет " + componentAmountPT + " деталей, " + wireAmountPT + " проводов и " +
                        computerPartAmountPT + " компьютерных частей" +
                        ": средняя стоимость: " + (double)priceSumOfType/(componentAmountPT+wireAmountPT+computerPartAmountPT) +
                        "; средняя мощность: " + (double)powerSumOfType/(componentAmountPT+computerPartAmountPT));

            }
        }
        System.out.println();

        for (Detail detail : details) {
            detail.printInfo();
        }
        System.out.println();

        List<Component> price = DataProcessor.top3Price(parts);
        for (Component component : price) {
            component.printInfo();
        }
        System.out.println();

        System.out.print("Введите цену: ");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                DataProcessor.searchPrice(parts, scanner.nextInt()).printInfo();
                break;
            }
            catch (InputMismatchException e) {
                System.out.print("Вы ввели строку, а не число.\nПожалуйста, введите число: ");
            }
            catch (NegativeInput e) {
                System.out.print("Вы ввели отрицательное число.\nПожалуйста, введите число: ");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.print("Объект с таким ценником не найден.");
                break;
            }
        }
    }
}
