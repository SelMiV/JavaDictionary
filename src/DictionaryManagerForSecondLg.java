public class DictionaryManagerForSecondLg extends DictionaryManager{
    public DictionaryManagerForSecondLg(String filename) {
        super(filename);
    }

    @Override
    protected boolean isValidate(String requirementKey) {
        return requirementKey.matches("[0-9]{5}");
    }
}
