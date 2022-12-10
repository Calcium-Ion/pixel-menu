package work.caion.plugin.pixelmenu.type;

import lombok.Getter;

@Getter
public enum EnumConditionType {

    PERMISSION("permission"),
//    ANOTHER_CONDITION("anotherCondition"),
    MONEY("money"),
    POINT("point"),
    HAS_ITEM("hasItem"),
    SCRIPT("script"),
    ;

    private String type;

    EnumConditionType(String type) {
        this.type = type;
    }

}
