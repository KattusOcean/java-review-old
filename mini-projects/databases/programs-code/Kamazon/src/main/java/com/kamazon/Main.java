package main.java.com.kamazon;

import main.java.com.kamazon.presentation.config.DependencyConfig;
import main.java.com.kamazon.presentation.controller.Controller;

public class Main {
    static void main() {
        DependencyConfig dc = new DependencyConfig();
        Controller controller = dc.createController();
        controller.controllerStart();
    }
}
