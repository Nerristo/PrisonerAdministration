public class Printer {
    private Prison prison = new Prison();

    public Printer(Prison prison) {
        this.prison = prison;
    }

    public void printBeginExcel() {
        System.out.println(" ________________________________________________________________________________________________________________");
        System.out.println("/ Index |--------- Name ------------|------------------- Crime ----------------| Age | Time | Solitary | In Cell \\");
        System.out.println("|-------|---------------------------|------------------------------------------|-----|------|----------|---------|");
    }

    public void printPrisoners(int index) {
        System.out.print("| " + (index + 1));
        for (int s = 0; s < (5 - String.valueOf((index + 1)).length()); s++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisoner(index).getName());
        for (int j = 0; j < (25 - prison.getPrisoner(index).getName().length()); j++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisoner(index).getCrime());
        for (int k = 0; k < (40 - prison.getPrisoner(index).getCrime().length()); k++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisoner(index).getAge());
        for (int l = 0; l < (3 - String.valueOf(prison.getPrisoner(index).getAge()).length()); l++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisoner(index).getSentenceTime());
        for (int m = 0; m < (4 - String.valueOf(prison.getPrisoner(index).getSentenceTime()).length()); m++) {
            System.out.print(" ");
        }
        if (prison.getPrisoner(index).isSolitary()) {
            System.out.print(" | YES      ");
        } else {
            System.out.print(" | NO       ");
        }
        if (prison.getPrisoner(index).isInCell()) {
            System.out.print("| YES     |\n");
        } else {
            System.out.print("| NO      |\n");
        }
    }

    public void printPrisonersInCell(int cell, int index) {
        System.out.print("| " + (index + 1));
        for (int s = 0; s < (5 - String.valueOf((index + 1)).length()); s++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisonerInCell(cell, index).getName());
        for (int j = 0; j < (25 - prison.getPrisonerInCell(cell, index).getName().length()); j++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisonerInCell(cell, index).getCrime());
        for (int k = 0; k < (40 - prison.getCell(cell).getPrisonersInCell().get(index).getCrime().length()); k++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisonerInCell(cell, index).getAge());
        for (int l = 0; l < (3 - String.valueOf(prison.getPrisonerInCell(cell, index).getAge()).length()); l++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisonerInCell(cell, index).getSentenceTime());
        for (int m = 0; m < (4 - String.valueOf(prison.getPrisonerInCell(cell, index).getSentenceTime()).length()); m++) {
            System.out.print(" ");
        }
        if (prison.getPrisonerInCell(cell, index).isSolitary()) {
            System.out.print(" | YES      ");
        } else {
            System.out.print(" | NO       ");
        }
        if (prison.getPrisonerInCell(cell,index).isInCell()) {
            System.out.print("| YES     |\n");
        } else {
            System.out.print("| NO      |\n");
        }
    }

    public void printPrisonersInHoldingCell(int cell, int index) {
        System.out.print("| " + (index + 1));
        for (int s = 0; s < (5 - String.valueOf((index + 1)).length()); s++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisonerInHoldingCell(cell, index).getName());
        for (int j = 0; j < (25 - prison.getPrisonerInHoldingCell(cell, index).getName().length()); j++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisonerInHoldingCell(cell, index).getCrime());
        for (int k = 0; k < (40 - prison.getPrisonerInHoldingCell(cell, index).getCrime().length()); k++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisonerInHoldingCell(cell, index).getAge());
        for (int l = 0; l < (3 - String.valueOf(prison.getPrisonerInHoldingCell(cell, index).getAge()).length()); l++) {
            System.out.print(" ");
        }
        System.out.print(" | " + prison.getPrisonerInHoldingCell(cell, index).getSentenceTime());
        for (int m = 0; m < (4 - String.valueOf(prison.getPrisonerInHoldingCell(cell, index).getSentenceTime()).length()); m++) {
            System.out.print(" ");
        }
        if (prison.getPrisonerInHoldingCell(cell, index).isSolitary()) {
            System.out.print(" | YES      ");
        } else {
            System.out.print(" | NO       ");
        }
        if (prison.getPrisonerInHoldingCell(cell,index).isInCell()) {
            System.out.print("| YES     |\n");
        } else {
            System.out.print("| NO      |\n");
        }
    }

    public void printLastExcel() {
        System.out.println("\\----------------------------------------------------------------------------------------------------------------/\n");
    }
}
