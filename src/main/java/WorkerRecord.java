import javax.xml.bind.util.ValidationEventCollector;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkerRecord {
    public static final String REGEXP_FIO = "[ ]?[А-Я]{1}[а-я]{1,20}";
    // private static final String REGEXP_TEL="((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?([\\d\\- ][^  ]){7,10}";
    // private final String REGEXP_TEL= "((8|\\+7)[\\- ]?)?((\\(\\d{3,5}\\)[\\- ]?[\\d\\- ]{6,10}[^  ])|(\\d{3,5}[\\- ]?[\\d\\- ]{6,12}[^  ]))?";
    public final String REGEXP_TEL = "((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}";
    //private final String REGEXP_TEL = "((8|\\+7)[\\- ]?)?((\\(\\d{3,5}\\)[\\- ]?((?!\\s{2})[\\d\\- ]){6,10})|(\\d{3,5}[\\- ]?((?!\\s{2})[\\d\\- ]){6,12}))?";

    private String inputString;
    private String fio = "";
    private ArrayList<String> telephones = new ArrayList<>();
    private String etc;

    public WorkerRecord(String inputString) {
        this.inputString = inputString;
        System.out.println("input string is : " + inputString);
        findTelephones();
        findWordsWithFirstBigLetter();
        etc = inputString;
    }

    /**
     * Поиск номера телефона по строке, с вырезанием в массив телефонов
     */
    private void findTelephones() {
        Pattern p = Pattern.compile(REGEXP_TEL);
        Matcher m = p.matcher(inputString);
        while (m.find()) {
            String s = m.group();
            telephones.add(s);
        }
        inputString = inputString.replaceAll(REGEXP_TEL, "");
    }

    /**
     * Поиск номера телефона по строке, с вырезанием в массив телефонов
     */
    private void findWordsWithFirstBigLetter() {
        Pattern p = Pattern.compile(REGEXP_FIO);
        Matcher m = p.matcher(inputString);
        ArrayList<String> fioStringArray = new ArrayList<>();
        while (m.find()) {
            String s = m.group();
            fioStringArray.add(s);
        }

        for (String s : fioStringArray) {
            fio += s + " ";
        }
        System.out.println("fio is " + fio);
        inputString = inputString.replaceAll(REGEXP_FIO, "");

    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setTelephones(ArrayList<String> telephones) {
        this.telephones = telephones;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getInputString() {
        return inputString;
    }

    public void printMainParameters(){
        //System.out.println("input string is : " + inputString);
        for (String tel : telephones) {
            System.out.println("telephone: " + tel + " i=" + telephones.indexOf(tel));
        }
       // System.out.println("etc is : " + etc);
    }

    /*
            private void getTelephones() {
                String regexpTel = "[a-d]";
                Pattern p = Pattern.compile(regexpTel);
                Matcher m = p.matcher(inputString);
                while (m.find()) {
                    telephones.add(m.group(1));
                    inputString = inputString.replaceAll(regexpTel, "");
                }
            }
        */

    public ArrayList<String> getTelephones() {
        return telephones;
    }
}


