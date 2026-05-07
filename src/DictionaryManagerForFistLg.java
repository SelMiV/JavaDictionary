public class DictionaryManagerForFistLg extends DictionaryManager{
    public DictionaryManagerForFistLg(String filename) {
        super(filename);
    }

    @Override
    protected boolean isValidate(String requirementKey) {
        return requirementKey.matches("[a-zA-Z]{4}");
    }
}
