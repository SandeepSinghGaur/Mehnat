package designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.primary;

import designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.Button;
import designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.Menu;
import designPattern.designPattern.creationalDesignPattern.factory.abstractFactoryThemeExample.ThemeComponentFactory;

public class PrimaryThemeFactory implements ThemeComponentFactory {
    @Override
    public Button createButton() {
        return null;
    }

    @Override
    public Menu createMenu() {
        return null;
    }
}
