import java.util.ArrayList;

public class Cell {
    private int columnIndex;
    private int rowIndex;
    private String inputValue;
    private String[] separatedInputArray;
    private ArrayList<WorkerRecord> workerRecords = new ArrayList<>();

    public Cell(int columnIndex, int rowIndex, String inputValue) {
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        this.inputValue = inputValue;
        this.splitString();
        this.createWorkersRecords();
    }

    public String[] getSeparatedInputArray() {
        return separatedInputArray;
    }

    private void splitString() {
        separatedInputArray = inputValue.split(";");
    }

    private void createWorkersRecords() {
        for (String s : separatedInputArray) {
            WorkerRecord workerRecord = new WorkerRecord(s);
            workerRecord.printMainParameters();
            workerRecords.add(workerRecord);
            String z = workerRecord.getInputString();
            z= workerRecord.getInputString().replaceAll(WorkerRecord.REGEXP_FIO,"");
            System.out.println("etc is : " + z);
        }

    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
}
