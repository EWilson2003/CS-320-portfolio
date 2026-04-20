package projectone;

import java.util.ArrayList;

public class AppointmentService {
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment is null");
        }

        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(appointment.getAppointmentId())) {
                throw new IllegalArgumentException("ID already exists");
            }
        }

        appointments.add(appointment);
    }

    public void deleteAppointment(String appointmentId) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
                appointments.remove(i);
                return;
            }
        }

        throw new IllegalArgumentException("Cannot delete appointment");
    }
}
