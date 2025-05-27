package com.br.JSCustomer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupItemCollection {
    private String groupTitle;
    private boolean mandatory;
    private List<ListItem> listItens;
}
