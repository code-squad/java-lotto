package calculator;

public class CustomSplitter implements Splitter {
    String splitter;
    public CustomSplitter(String splittor){
        this.splitter = splittor;
    }

    @Override
    public boolean supports(String param) {
        return splitter.contains(splitter);
    }

    @Override
    public String[] split(String param) {
        return param.split(splitter);
    }

}
