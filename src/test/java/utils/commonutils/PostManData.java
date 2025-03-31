package utils.commonutils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostManData {
    private  String title;
    private String author;
    private int published;
}
