package projectone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;
public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);
        Appointment appointment = new Appointment("1", futureDate, "Doctor visit");

        assertDoesNotThrow(() -> service.addAppointment(appointment));
    }

    @Test
    public void testDuplicateAppointmentId() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);

        Appointment a1 = new Appointment("1", futureDate, "Doctor visit");
        Appointment a2 = new Appointment("1", futureDate, "Dentist visit");

        service.addAppointment(a1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(a2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);
        Appointment appointment = new Appointment("1", futureDate, "Doctor visit");

        service.addAppointment(appointment);
        assertDoesNotThrow(() -> service.deleteAppointment("1"));
    }
}