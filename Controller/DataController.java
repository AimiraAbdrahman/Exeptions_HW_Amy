package Controller;

import Service.MyFileWriter;

public class DataController {
    MyFileWriter FileWriter = new MyFileWriter();

    public void writeDataToFile(String fileName, String data) {
        FileWriter.generateFile(fileName, data);
    }
}
