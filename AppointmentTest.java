package projectone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;
public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);
        Appointment appointment = new Appointment("1", futureDate, "Doctor visit");

        assertEquals("1", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor visit", appointment.getDescription());
    }

    @Test
    public void testBadAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Doctor visit");
        });
    }

    @Test
    public void testPastDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 1000000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", pastDate, "Doctor visit");
        });
    }

    @Test
    public void testBadDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", futureDate, null);
        });
    }
}