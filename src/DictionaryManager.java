import java.util.LinkedHashMap;


public abstract class DictionaryManager {

    private final LinkedHashMap<String, String> dictionary = new LinkedHashMap<String, String>();

    private String fileName;
    private FileManager fileManager;


    public String getFileName() {
        return fileName;
    }
    public void setFileName(String filename) {
        this.fileName = filename;
    }

    public DictionaryManager(String filename) {
        this.fileName = filename;
        this.fileManager = new FileManager(fileName,dictionary);

    }

    public boolean deleteWord(String key) {
        return isValidate(key) && fileManager.deleteWord(key);
    }

    public boolean addWord(String key, String value) {
        return isValidate(key) && fileManager.addWord(key, value);
    }


    public String findWord(String key) throws Exception {
        if (isValidate(key))
            return dictionary.getOrDefault(key, "Нет записи");
        else
            throw new Exception("Слово не соответсвует правилам языка.");
    }

    public String getAllWords(){
        StringBuilder sb = new StringBuilder();
        for (String key : dictionary.keySet()){
            if (isValidate(key))
                sb.append(key + " - " + dictionary.get(key) + "\n");
        }
        return sb.toString();
    }

    protected abstract boolean isValidate(String requirementKey);
}
