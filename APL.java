import java.util.Scanner;

public class APL {
    private Scanner sc = new Scanner(System.in);
    private Prison prison = new Prison();
    private Printer printer = new Printer(prison);

    public static void main(String[] args) {
        new APL().run();
    }

    private void run() {
        printWelcome();
        int minAge = 0;
        int maxPrisonersInCell = 1;
        int maxPrisonersInHoldingCell = 5;

        int menuInput = -1;
        while (menuInput != 0) {
            printMenu();
            menuInput = sc.nextInt();

            if (menuInput == 1) {
                System.out.println("\nAdding a prisoner...\n");
                sc.nextLine();

                System.out.println("What is the prisoner's name?");
                String name = sc.nextLine();
                while (name.length() > 25) {
                    System.out.println("Name is too long, maximum of 25 characters. Enter a valid prisoner's name:");
                    name = sc.nextLine();
                }

                System.out.println("What is the crime " + name + " has done?");
                String crime = sc.nextLine();
                while (crime.length() > 40) {
                    System.out.println("Crime description is too long, maximum of 40 characters. Enter a valid crime:");
                    crime = sc.nextLine();
                }

                System.out.println("What is the age of " + name + "?");
                int age = sc.nextInt();
                while (String.valueOf(age).length() > 3) {
                    System.out.println("Age is too long, maximum of 3 characters. Enter a valid age:");
                    age = sc.nextInt();
                }

                System.out.println("What is the sentence time?");
                int sentenceTime = sc.nextInt();
                while (String.valueOf(sentenceTime).length() > 4) {
                    System.out.println("Sentence time is too long, maximum of 4 characters. Enter a valid sentence time:");
                    sentenceTime = sc.nextInt();
                }

                sc.nextLine();
                System.out.println("Is " + name + " in solitary?");
                boolean solitary = sc.nextLine().equalsIgnoreCase("yes");

                prison.setPrisoners(name, crime, age, sentenceTime, solitary);

                System.out.println("\nPrisoner has been added!\n");
            } else if (menuInput == 2) {
                System.out.println("\n\\/ Prisoners List \\/");
                printer.printBeginExcel();
                for (int i = 0; i < prison.getPrisoners().size(); i++) {
                    printer.printPrisoners(i);
                }
                printer.printLastExcel();
            } else if (menuInput == 3) {
                System.out.print("\nWhat age do you want to set as the minimum search? ");
                minAge = sc.nextInt();
                System.out.println("\n\n\\/ List of Prisoners above " + minAge + " years of age\\/");
                printer.printBeginExcel();
                for (int i = 0; i < prison.getPrisoners().size(); i++) {
                    printer.printPrisoners(prison.getPrisonerAboveAge(i, minAge));
                }
                printer.printLastExcel();
            } else if (menuInput == 4) {
                System.out.println("\nEnter a keyword for searching the prisoners: ");
                String keyword = sc.next().toLowerCase();
                System.out.println("\n\\/ Prisoners' crimes containing '" + keyword + "' \\/");
                printer.printBeginExcel();
                for (int i = 0; i < prison.getPrisoners().size(); i++) {
                    printer.printPrisoners(prison.getPrisonerCrimeWithKeyword(i, keyword));
                }
                printer.printLastExcel();
            } else if (menuInput == 5) {
                System.out.println("\n\\/ List of Prisoners list in solitary \\/");
                printer.printBeginExcel();
                for (int i = 0; i < prison.getPrisoners().size(); i++) {
                    printer.printPrisoners(prison.getPrisonerInSolitary(i));
                }
                printer.printLastExcel();
            } else if (menuInput == 6) {
                System.out.print("\nWhat age do you want to set as the minimum search? ");
                minAge = sc.nextInt();
                System.out.println("\n\n\\/ List of Prisoners list in solitary above " + minAge + " years of age \\/");
                printer.printBeginExcel();
                for (int i = 0; i < prison.getPrisoners().size(); i++) {
                    printer.printPrisoners(prison.getPrisonerAboveAgeAndSolitary(i, minAge));
                }
                printer.printLastExcel();
            } else if (menuInput == 7) {
                System.out.println("\nWhat prisoner do you want to remove?");
                int remove = (sc.nextInt() - 1);
                System.out.println("The prisoner " + prison.getPrisoner(remove).getName() + " has been removed!\n");
                prison.removePrisoner(remove);
            } else if (menuInput == 8) {
                System.out.println("\nWhat prisoner do you want to add to a cell?");
                int prisoner = (sc.nextInt() - 1);
                prison.setCells(prisoner, maxPrisonersInCell);
                System.out.println("The prisoner " + prison.getPrisoner(prisoner).getName() + " has been added" +
                        " to the Cell!\n");
            } else if (menuInput == 9) {
                System.out.println();
                for (int cell = 0; cell < prison.getCells().size(); cell++) {
                    System.out.println(prison.getCell(cell));
                    printer.printBeginExcel();
                    for (int i = 0; i < prison.getCell(cell).getPrisonersInCell().size(); i++) {
                        printer.printPrisonersInCell(cell, i);
                    }
                    printer.printLastExcel();
                }
            } else if (menuInput == 10) {
                System.out.println("\nWhat prisoner do you want to add to a holding cell?");
                int prisoner = (sc.nextInt() - 1);
                prison.setCells(prisoner, maxPrisonersInHoldingCell);
                System.out.println("The prisoner " + prison.getPrisoner(prisoner).getName() + " has been added" +
                        " to the Holding Cell!\n");
            } else if (menuInput == 11) {
                System.out.println();
                for (int holdingCell = 0; holdingCell < prison.getHoldingCells().size(); holdingCell++) {
                    System.out.println(prison.getHoldingCell(holdingCell));
                    printer.printBeginExcel();
                    for (int i = 0; i < prison.getHoldingCell(holdingCell).getPrisonersInHoldingCell().size(); i++) {
                        printer.printPrisonersInHoldingCell(holdingCell, i);
                    }
                    printer.printLastExcel();
                }
            } else if (menuInput == 0) {
                System.out.println("\nExiting Prisoner Administration...");
            } else if (menuInput == 1234) {
                prison.setPrisoners("autoFillPrison");
                System.out.println("\nPrisoners have been added!\n");
            } else if (menuInput == 9999) {
                System.out.println();
                prison.setCells(0, maxPrisonersInCell);
                prison.setCells(1, maxPrisonersInCell);
                prison.setCells(2, maxPrisonersInCell);
                prison.setHoldingCells(3, maxPrisonersInHoldingCell);
                prison.setHoldingCells(4, maxPrisonersInHoldingCell);
                prison.setHoldingCells(5, maxPrisonersInHoldingCell);
                prison.setHoldingCells(6, maxPrisonersInHoldingCell);
                prison.setHoldingCells(7, maxPrisonersInHoldingCell);
                prison.setHoldingCells(8, maxPrisonersInHoldingCell);
                prison.setHoldingCells(9, maxPrisonersInHoldingCell);
                System.out.println("\nPrisoners have been added to their cells!\n");
            } else {
                System.out.println("Invalid input...\n");
            }
        }
    }

    private void printWelcome() {
        System.out.println("  _____      _                               _           _       _     _             _             \n" +
                " |  __ \\    (_)                     /\\      | |         (_)     (_)   | |           | |            \n" +
                " | |__) | __ _ ___  ___  _ __      /  \\   __| |_ __ ___  _ _ __  _ ___| |_ _ __ __ _| |_ ___  _ __ \n" +
                " |  ___/ '__| / __|/ _ \\| '_ \\    / /\\ \\ / _` | '_ ` _ \\| | '_ \\| / __| __| '__/ _` | __/ _ \\| '__|\n" +
                " | |   | |  | \\__ \\ (_) | | | |  / ____ \\ (_| | | | | | | | | | | \\__ \\ |_| | | (_| | || (_) | |   \n" +
                " |_|   |_|  |_|___/\\___/|_| |_| /_/    \\_\\__,_|_| |_| |_|_|_| |_|_|___/\\__|_|  \\__,_|\\__\\___/|_|   \n" +
                "                                                                                                   \n" +
                "                                                                                                   ");
    }

    private void printMenu() {
        System.out.print("*************************************************************\n" +
                "*                   Prisoner Administrator                  *\n" +
                "*************************************************************\n" +
                "* 1) Add a prisoner                                         *\n" +
                "* 2) Return all prisoners                                   *\n" +
                "* 3) Return prisoners above inserted years of age           *\n" +
                "* 4) Return prisoners with keyword                          *\n" +
                "* 5) Return prisoners in solitary                           *\n" +
                "* 6) Return prisoners in solitary above 30 years of age     *\n" +
                "* 7) Remove a prisoner from the list                        *\n" +
                "* 8) Add a prisoner to a cell                               *\n" +
                "* 9) Print cells and details                                *\n" +
                "* 10) Add a prisoner to a holding cell                      *\n" +
                "* 11) Print holding cells and details                       *\n" +
                "*************************************************************\n" +
                "* 0) Exit                                                   *\n" +
                "*************************************************************\n" +
                "> Select an option: ");
    }
}

// https://pastebin.com/bD01Qqeb