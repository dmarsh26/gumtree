import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AddressBookTest {

  @Test
  void howManyMalesInAddressBook() throws URISyntaxException, IOException {
    AddressBook addressBook = new AddressBook();

    long malesCount = addressBook.getCountGender(Gender.Male);

    assertEquals(3, malesCount);
  }

}
