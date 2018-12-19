import java.util.ArrayList;

public class HoldingCell {
    private int holdingCellNumber;
    private ArrayList<Integer> holdingCellNumbers = new ArrayList<>();
    private ArrayList<Prisoner> prisonersInHoldingCell = new ArrayList<>();

    public HoldingCell(Prisoner prisoner, int maxPrisonersInHoldingCell) {
        this.holdingCellNumber = assignCellNumber(maxPrisonersInHoldingCell);
        this.holdingCellNumbers.add(holdingCellNumber);
        this.prisonersInHoldingCell.add(prisoner);
    }

    @Override
    public String toString() {
        return "[Holding Cell " + holdingCellNumber + "]";
    }

    public void setPrisonerToHoldingCell(Prisoner prisoner) {
        prisonersInHoldingCell.add(prisoner);
    }

    public ArrayList<Prisoner> getPrisonersInHoldingCell() {
        return prisonersInHoldingCell;
    }

    public void removePrisonersInHoldingCell(Prisoner prisoner) {
        this.prisonersInHoldingCell.remove(prisoner);
    }

    public int assignCellNumber(int maxPrisonersInCell) {
        if (prisonersInHoldingCell.size() < maxPrisonersInCell) {
            holdingCellNumber = (int) (Math.random() * 100 + 1);
        }
        for (int usedCellNumber : holdingCellNumbers) {
            if (prisonersInHoldingCell.size() >= maxPrisonersInCell && usedCellNumber == holdingCellNumber) {
                while (usedCellNumber == holdingCellNumber) {
                    holdingCellNumber = (int) (Math.random() * 100 + 1);
                }
            }
        }
        return holdingCellNumber;
    }
}