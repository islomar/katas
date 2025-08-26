package infrastructure;


import model.Console;

public class SystemOutConsole implements Console {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
