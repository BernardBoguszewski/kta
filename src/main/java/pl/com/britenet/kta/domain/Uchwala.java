package pl.com.britenet.kta.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

/**
 * Created by Britenet on 2017-07-13.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Uchwala {

    @Id
    private String id;

    private String tytul;
    private String opis;
    private String numer;
    private LocalDate dataUchwalenia;
    // TODO: 2017-07-13 uchwała powiązana z?


}
