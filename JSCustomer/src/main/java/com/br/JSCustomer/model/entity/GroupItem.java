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
public class GroupItem {

    private String groupName;
    private String isUniqueSelect;
    private String quantityItemSelect;
    private List<Item> itemList;

}
