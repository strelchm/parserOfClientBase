public class Main {

    public static void main(String[] args) {
        //String inputValue = "+7 926 123 45 67 8(926)123-45-67";
        String inputValue = "some data";

        /**
         WorkerRecord workerRecord = new WorkerRecord(inputValue);
         System.out.println(workerRecord.getTelephones());
         System.out.println("size is  - " + workerRecord.getTelephones().size());
         System.out.println(workerRecord.getInputString());
         */
        Cell cell = new Cell(2, 3, inputValue);
    }

}
