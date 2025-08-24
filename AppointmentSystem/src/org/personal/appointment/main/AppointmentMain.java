package org.personal.appointment.main;
import org.personal.appointment.ui.Login_ui;

import java.util.LinkedList;
import org.personal.appointment.dao.ClientsDao;
import org.personal.appointment.dao.impl.ClientsDaoImpl;
//import org.personal.appointment.dao.impl.ClientsDaoListImpl;
import org.personal.appointment.ui.Dashboard1;
//import org.personal.appointment.ui.Login_ui;



public class AppointmentMain {
    public static void main(String[] args) {
        new Login_ui().setVisible(true);
    }
}

