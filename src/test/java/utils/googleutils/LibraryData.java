package utils.googleutils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LibraryData {
    private String name;
    private String isbn;
    private int aisle;
    private String author;
}
