package designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.dark;

import designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.Theme;
import designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.ThemeComponentFactory;

public class DarkTheme extends Theme {
    @Override
    public ThemeComponentFactory createComponentFactory() {
        return null;
    }
}
