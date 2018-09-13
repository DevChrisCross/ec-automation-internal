package com.elavon.interactions;

import io.github.bonigarcia.wdm.DriverManagerType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Optional;

import static com.elavon.setup.Application.CONFIG;

public class SaveDownloadedFile implements Interaction {

    private final Robot robot;

    public SaveDownloadedFile() {
        Optional<Robot> robot = Optional.empty();

        try {
            robot = Optional.of(new Robot());
        } catch (AWTException e) {
            e.printStackTrace();
        } finally {
            this.robot = robot.orElse(null);
        }
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        DriverManagerType driverType = DriverManagerType
                .valueOf(CONFIG.getString("environment.driver").toUpperCase());

        switch (driverType) {
            case FIREFOX:
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                for (int i = 0; i < 3; i++) {
                    robot.keyPress(KeyEvent.VK_TAB);
                }
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }
}
