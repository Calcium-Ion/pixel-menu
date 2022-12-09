package work.caion.plugin.pixelmenu.type;

import lombok.Getter;

@Getter
public enum EnumMoneyType {

    POINT("point"),
    MONEY("money"),
    ;

    private String type;

    EnumMoneyType(String type) {
        this.type = type;
    }
}
