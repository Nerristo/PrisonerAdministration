import java.util.ArrayList;

public class Prison {
    private ArrayList<Prisoner> prisoners = new ArrayList<>();
    private ArrayList<Cell> cells = new ArrayList<>();
    private ArrayList<HoldingCell> holdingCells = new ArrayList<>();
    private int index = 0;
    private int currentCell = 0;
    private int currentHoldingCell = 0;

    public void setPrisoners(String name, String crime, int age, int sentenceTime, boolean solitary) {
        prisoners.add(new Prisoner(name, crime, age, sentenceTime, solitary));
    }

    public ArrayList<Prisoner> getPrisoners() {
        return prisoners;
    }

    public Prisoner getPrisoner(int i) {
        return prisoners.get(i);
    }

    public void setPrisoners(String forTesting) {
        prisoners.add(new Prisoner("Jack the Ripper", "Murder", 38, 40, true));
        prisoners.add(new Prisoner("Casa Nova", "Stealing a heart", 21, 5, false));
        prisoners.add(new Prisoner("Neptunus", "Killing the dead sea", 53, 80, true));
        prisoners.add(new Prisoner("Lazy Student", "Killing the time", 18, 3, false));
        prisoners.add(new Prisoner("Justin Bieber", "Singing", 16, 7, true));
        prisoners.add(new Prisoner("Lazy Lecturer", "Doing nothing", 34, 5, false));
        prisoners.add(new Prisoner("Bill Clinton", "Did not have sex with that woman", 66, 10, false));
        prisoners.add(new Prisoner("Steve Jobs", "Passing away before the iPhone X release", 58, 5, false));
        prisoners.add(new Prisoner("Harry Potter", "Killing Voldemort", 18, 3, true));
        prisoners.add(new Prisoner("Demo dog", "Attempted to kill Eleven", 2, 2, true));
    }

    public int getPrisonerAboveAge(int i, int minAge) {
        if (prisoners.get(i).getAge() > minAge) {
            index = i;
        }
        return index;
    }

    public int getPrisonerInSolitary(int i) {
        if (prisoners.get(i).isSolitary()) {
            index = i;
        }
        return index;
    }

    public int getPrisonerAboveAgeAndSolitary(int i, int minAge) {
        if (prisoners.get(i).getAge() > minAge && prisoners.get(i).isSolitary()) {
            index = i;
        }
        return index;
    }

    public int getPrisonerCrimeWithKeyword(int i, String keyword) {
        if (prisoners.get(i).getCrime().toLowerCase().contains(keyword)) {
            index = i;
        }
        return index;
    }

    public void removePrisoner(int removingPrisoner) {
        if (getPrisoner(removingPrisoner).isInCell()) {
            for (Cell cell : cells) {
                for (Prisoner prisonerInCell : cell.getPrisonersInCell()) {
                    if (getPrisoner(removingPrisoner) == prisonerInCell) {
                        cell.removePrisonersInCell(prisonerInCell);
                        break;
                    }
                }
            }
            for (HoldingCell cell : holdingCells) {
                for (Prisoner prisonerInCell : cell.getPrisonersInHoldingCell()) {
                    if (getPrisoner(removingPrisoner) == prisonerInCell) {
                        cell.removePrisonersInHoldingCell(prisonerInCell);
                        break;
                    }
                }
            }
        }
        removeEmptyCellsAndHoldingCells();
        getPrisoners().remove(removingPrisoner);
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public Cell getCell(int i) {
        return cells.get(i);
    }

    public Prisoner getPrisonerInCell(int cell, int i) {
        return getCell(cell).getPrisonersInCell().get(i);
    }

    public void setCells(int i, int maxPrisonersInCell) {
        if (cells.size() < 1) {
            cells.add(new Cell(getPrisoner(i), maxPrisonersInCell));
            System.out.println(getPrisoner(i).getName() + " is moved to " + getCell(currentCell));
        } else {
            if (cells.get(currentCell).getPrisonersInCell().size() >= maxPrisonersInCell) {
                cells.add(new Cell(getPrisoner(i), maxPrisonersInCell));
                System.out.print("The current " + getCell(currentCell) + " is full,");
                currentCell++;
                System.out.println(" " + getPrisoner(i).getName() + " will be moved to " + getCell(currentCell) + ".");
            } else {
                cells.get(currentCell).setPrisonerToCell(getPrisoner(i));
                System.out.println(getPrisoner(i).getName() + " is moved to " + getCell(currentCell));
            }
        }
        getPrisoner(i).setInCell();
    }

    public ArrayList<HoldingCell> getHoldingCells() {
        return holdingCells;
    }

    public HoldingCell getHoldingCell(int i) {
        return holdingCells.get(i);
    }

    public Prisoner getPrisonerInHoldingCell(int cell, int i) {
        return getHoldingCell(cell).getPrisonersInHoldingCell().get(i);
    }

    public void setHoldingCells(int i, int maxPrisonersInHoldingCell) {
        if (holdingCells.size() < 1) {
            holdingCells.add(new HoldingCell(getPrisoner(i), maxPrisonersInHoldingCell));
            System.out.println(getPrisoner(i).getName() + " is moved to " + getHoldingCell(currentHoldingCell));
        } else {
            if (holdingCells.get(currentHoldingCell).getPrisonersInHoldingCell().size() >= maxPrisonersInHoldingCell) {
                holdingCells.add(new HoldingCell(getPrisoner(i), maxPrisonersInHoldingCell));
                System.out.print("The current " + getHoldingCell(currentHoldingCell) + " is full,");
                currentHoldingCell++;
                System.out.println(" " + getPrisoner(i).getName() + " will be moved to " + getHoldingCell(currentHoldingCell) + ".");
            } else {
                holdingCells.get(currentHoldingCell).setPrisonerToHoldingCell(getPrisoner(i));
                System.out.println(getPrisoner(i).getName() + " is moved to " + getHoldingCell(currentHoldingCell));
            }
        }
        getPrisoner(i).setInCell();
    }

    public void removeEmptyCellsAndHoldingCells() {
        for (int cell = 0; cell < cells.size(); cell++) {
            if (cells.get(cell).getPrisonersInCell().size() < 1) {
                cells.remove(cell);
                currentCell--;
            }
        }
        for (int cell = 0; cell < cells.size(); cell++) {
            if (holdingCells.get(cell).getPrisonersInHoldingCell().size() < 1) {
                holdingCells.remove(cell);
                currentHoldingCell--;
            }
        }
    }
}

// https://pastebin.com/dPSh2FJU