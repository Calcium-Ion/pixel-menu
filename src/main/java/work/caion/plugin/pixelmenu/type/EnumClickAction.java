package work.caion.plugin.pixelmenu.type;

import lombok.Getter;

@Getter
public enum EnumClickAction {

    BUY_ITEM("buyItem"),
    SELL_ITEM("sellItem"),
    SAME("same"),
    RUN_COMMAND("runCommand"),
    NONE("none"),
    ;

    private String action;

    EnumClickAction(String action) {
        this.action = action;
    }

    //get the enum from the action string
    public static EnumClickAction getEnum(String action) {
        for (EnumClickAction e : EnumClickAction.values()) {
            if (e.getAction().equals(action)) {
                return e;
            }
        }
        return null;
    }
}
