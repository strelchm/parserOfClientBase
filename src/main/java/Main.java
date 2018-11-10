public class Main {

    public static void main(String[] args) {
        //String inputValue = "+7 926 123 45 67 8(926)123-45-67";
        String inputValue = "muzei-kodinsk@mail.ru Мария Ивановна (391) 211 36 35, Тел.: (391) 211 36 35" +
                "lib@kraslib.ru  ;  39199-21389 Дарина Грино   (391) 211 36 35; Парам Парам (391) 224 56 11";

        /**
         WorkerRecord workerRecord = new WorkerRecord(inputValue);
         System.out.println(workerRecord.getTelephones());
         System.out.println("size is  - " + workerRecord.getTelephones().size());
         System.out.println(workerRecord.getInputString());
         */
        Cell cell = new Cell(2, 3, inputValue);
    }

}
