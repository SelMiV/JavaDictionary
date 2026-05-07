import java.io.*;
import java.util.LinkedHashMap;

public class FileManager {
    private String fileName;
    private LinkedHashMap<String, String> dictionary;

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String filename) {
        this.fileName = filename;
    }

    public LinkedHashMap<String, String> getDictionary() {
        return dictionary;
    }
    public void setDictionary(LinkedHashMap<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public FileManager(String filename, LinkedHashMap<String,String> dict) {
        this.fileName = filename;
        this.dictionary = dict;
        readFile();
    }

    public void readFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] keyAndValue = line.split("-");
                if (keyAndValue.length == 2){
                    dictionary.put(keyAndValue[0], keyAndValue[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    private void saveFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            for (String key : dictionary.keySet()) {
                bw.write(key + "-" + dictionary.get(key));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка, файл не записан.");
        }
    }

    public boolean deleteWord(String key) {
        if (dictionary.containsKey(key)){
            dictionary.remove(key);
            saveFile();
            return true;
        }
        return false;
    }

    public boolean addWord(String key, String value) {
        if (key == null || key.trim().isEmpty()) {
            return false;
        }
        dictionary.put(key, value);
        saveFile();
        return true;
    }
}
