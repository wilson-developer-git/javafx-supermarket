package com.supermarket.logistica.domain.models;

import com.supermarket.logistica.domain.models.enums.StatusPedido;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @EqualsAndHashCode.Include
    private Long id;
    private LocalDate periodo;
    private StatusPedido statusPedido;
    private List<ItemProdutoRelatorioPedido> itensPedido = new ArrayList<>();

    @Override
    public String toString() {
        return "id= " + id + ", periodo= " + periodo + ", statusPedido= " + statusPedido;
    }
}
