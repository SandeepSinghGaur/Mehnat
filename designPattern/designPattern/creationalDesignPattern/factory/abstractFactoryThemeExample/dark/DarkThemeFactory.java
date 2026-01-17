package designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.dark;

import designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.Button;
import designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.Menu;
import designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.ThemeComponentFactory;

public class DarkThemeFactory implements ThemeComponentFactory {
    @Override
    public Button createButton() {
        return null;
    }

    @Override
    public Menu createMenu() {
        return null;
    }
}
