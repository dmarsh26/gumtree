import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;

public class AddressBookTest {

  @Test
  void howManyMalesInAddressBook() throws URISyntaxException, IOException {
    AddressBook addressBook = new AddressBook();

    long malesCount = addressBook.getCountGender(Gender.Male);

    assertEquals(3, malesCount);
  }

  @Test
  void howOldOldestPersonInAddressBook() throws URISyntaxException, IOException {
    AddressBook addressBook = new AddressBook();

    LocalDate oldest = addressBook.findOldest();

    assertEquals("14/08/1974", oldest.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
  }

  @Test
  void howManyDaysOlderIsBillThanPaul() throws URISyntaxException, IOException {
    AddressBook addressBook = new AddressBook();

    Optional<LocalDate> ageBill = addressBook.findAge("Bill McKnight");
    Optional<LocalDate> agePaul = addressBook.findAge("Paul Robinson");

    long daysBetween = DAYS.between(ageBill.get(), agePaul.get());

    assertEquals(2862L, daysBetween);
  }

}
