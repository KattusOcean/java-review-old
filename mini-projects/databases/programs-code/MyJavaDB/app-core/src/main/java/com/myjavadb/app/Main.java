package main.java.com.myjavadb.app;

import main.java.com.myjavadb.controller.BusController;
import main.java.com.myjavadb.controller.DriverController;
import main.java.com.myjavadb.controller.PlaceController;
import main.java.com.myjavadb.controller.RouteController;

public class Main {
    static void main() {
        final BusController bctl = new BusController();
        final DriverController dctl = new DriverController();
        final PlaceController pctl = new PlaceController();
        final RouteController rctl = new RouteController();

        rctl.searchDayByCity("Madrid");
    }
}