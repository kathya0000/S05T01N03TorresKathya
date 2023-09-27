package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n03.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlorModel {

    private long pk_FlorID;
    private String nameFlor;
    private String paisFlor;
    private String TipoFlor;

}
