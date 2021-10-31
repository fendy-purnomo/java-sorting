package com.company;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class AngkaController {
    private ArrayList<Integer> list = new ArrayList<>();
    private int jumlah;

    public void firstRandom() {
        System.out.println("Masukkan jumlah angka yang akan di random : ");

        Scanner input = new Scanner(System.in);
        try {
            jumlah = input.nextInt();
            list = getRandomNonRepeatingIntegers(jumlah, 1, 20);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean counter = true;
        while (counter) {
            int menu;
            System.out.println(" ");
            System.out.println("=====================================");
            System.out.println("************ SORTING TK4 ************");
            System.out.println(" ");
            System.out.println("1. Lihat Angka");
            System.out.println(" ");
            System.out.println("2. Acak Angka");
            System.out.println(" ");
            System.out.println("3. Sorting Angka Ascending");
            System.out.println(" ");
            System.out.println("4. Sorting Angka Descending");
            System.out.println(" ");
            System.out.println("5. Keluar");
            System.out.println(" ");
            System.out.println("=====================================");
            try {
                System.out.println("Silahkan memilih menu.");
                System.out.print("Pilih: ");
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        lihatAngka();
                        break;
                    case 2:
                        acakAngka();
                        break;
                    case 3:
                        sortAsc();
                        break;
                    case 4:
                        sortDesc();
                        break;
                    case 5:
                        System.out.println("Terima kasih sudah berkunjung");
                        System.exit(5);
                        break;
                    default:
                        System.out.println("Menu tidak tersedia");
                        boolean repeat = true;

                        while (repeat) {
                            System.out.print("Pilih: ");
                            menu = input.nextInt();
                            switch (menu) {
                                case 1:
                                    lihatAngka();
                                    repeat = false;
                                    break;

                                case 2:
                                    acakAngka();
                                    repeat = false;
                                    break;
                                case 3:
                                    sortAsc();
                                    repeat = false;
                                    break;
                                case 4:
                                    sortDesc();
                                    repeat = false;
                                    break;
                                case 5:
                                    System.out.println("Terima kasih sudah berkunjung");
                                    System.exit(5);
                                    break;
                                default:
                                    repeat = true;
                                    System.out.println("Menu tidak tersedia, silahkan input ulang");
                            }
                        }
                        break;
                }
            } catch (NumberFormatException n) {
                System.out.println(n);
            }
        }
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min, int max) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (numbers.size() < size) {
            int random = getRandomInt(min, max);
            //no validate same integer
//            if (!numbers.contains(random)) {
            numbers.add(random);
//            }
        }

        return numbers;
    }

    private void lihatAngka() {
        System.out.println("           Lihat Angka            ");
        System.out.println("==================================");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private void acakAngka() {
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        System.out.println("           Acak Angka             ");
        System.out.println("==================================");
        System.out.println("Before Acak : ");
        System.out.println("");
        //show array list
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        //clear array list
        list.clear();
        //regenerate random number
        list = getRandomNonRepeatingIntegers(jumlah, 1, 20);
        System.out.println("After Acak : ");
        System.out.println("");

        //show array list
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private void sortAsc() {
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        System.out.println("           Sort Angka Asc         ");
        System.out.println("==================================");
        System.out.println("Before Sort : ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(" ");
        System.out.println("After Sort Ascending : ");
        //  sorting asc
        ArrayList<Integer> sortedList = (ArrayList<Integer>) list.stream()
                .sorted()
                .collect(Collectors.toList());
//        sortedList.forEach(System.out::print);

        for (int i = 0; i < sortedList.size(); i++) {
            System.out.print(sortedList.get(i) + " ");
        }
    }

    private void sortDesc() {
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        System.out.println("           Sort Angka Desc         ");
        System.out.println("==================================");
        System.out.println("Before Sort : ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(" ");
        System.out.println("After Sort Descending : ");
        //  sorting desc

        list.sort(Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

}