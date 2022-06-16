import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AddressBook {
  List<Record> addressBook;

  public AddressBook() throws URISyntaxException, IOException {
    Path path = Path.of(ClassLoader.getSystemResource("AddressBook.csv").toURI());
    Stream<String> lines = Files.readAllLines(path).stream();
    addressBook = lines.map(this::toRecord).collect(Collectors.toList());
  }

  private Record toRecord(String recordStr) {
    String[] recordParams = Arrays.stream(recordStr.split(",")).map(String::trim).toArray(String[]::new);
    return new Record(recordParams);
  }

  public long getCountGender(Gender gender) {
    return addressBook.stream().filter(r -> r.gender.equals(gender)).count();
  }

  public LocalDate findOldest() {
    return addressBook.stream().map(r -> r.date).min(LocalDate::compareTo).get();
  }

  static class Record {
    String name;
    Gender gender;
    LocalDate date;

    public Record(String[] split) {
      name = split[0];
      gender = Gender.valueOf(split[1]);
      date = LocalDate.parse(split[2], DateTimeFormatter.ofPattern("d/MM/uu"));
    }
  }
}
