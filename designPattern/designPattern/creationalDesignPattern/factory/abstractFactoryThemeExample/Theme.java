package designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample;

public abstract class Theme {
    private String name;
    private String primaryColor;
    private String author;

    public abstract ThemeComponentFactory createComponentFactory();

}
