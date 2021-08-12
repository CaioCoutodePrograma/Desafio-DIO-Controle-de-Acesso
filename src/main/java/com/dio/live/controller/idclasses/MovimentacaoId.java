package com.dio.live.controller.idclasses;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class MovimentacaoId implements Serializable {

    @JoinColumn(name = "ID_MOVIMENTO", nullable = false, insertable = false, updatable = false)
    private long idMovimento;
    @JoinColumn(name = "ID_USUARIO", nullable = false, insertable = false, updatable = false)
    private long idUsuario;

}
