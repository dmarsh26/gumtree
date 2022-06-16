import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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

    assertEquals("14/08/2074", oldest.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
  }

}
