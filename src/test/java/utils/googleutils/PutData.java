package utils.googleutils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PutData {
    private String place_id;
    private String address;
    private String key;
    }
