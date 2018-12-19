import java.util.ArrayList;

public class Cell {
    private int cellNumber;
    private ArrayList<Integer> cellNumbers = new ArrayList<>();
    private ArrayList<Prisoner> prisonersInCell = new ArrayList<>();

    public Cell(Prisoner prisoner, int maxPrisonersInCell) {
        this.cellNumber = assignCellNumber(maxPrisonersInCell);
        this.cellNumbers.add(cellNumber);
        this.prisonersInCell.add(prisoner);
    }

    @Override
    public String toString() {
        return "[Cell " + cellNumber + "]";
    }

    public void setPrisonerToCell(Prisoner prisoner) {
        prisonersInCell.add(prisoner);
    }

    public ArrayList<Prisoner> getPrisonersInCell() {
        return prisonersInCell;
    }

    public void removePrisonersInCell(Prisoner prisoner) {
        this.prisonersInCell.remove(prisoner);
    }

    public int assignCellNumber(int maxPrisonersInCell) {
        if (prisonersInCell.size() < maxPrisonersInCell) {
            cellNumber = (int) (Math.random() * 100 + 1);
        }
        for (int usedCellNumber : cellNumbers) {
            if (prisonersInCell.size() >= maxPrisonersInCell && usedCellNumber == cellNumber) {
                while (usedCellNumber == cellNumber) {
                    cellNumber = (int) (Math.random() * 100 + 1);
                }
            }
        }
        return cellNumber;
    }
}