package kr.hs.dgsw.webshopping.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubMenu {
    private Long id;
    private Long menuid;
    private String name;
}