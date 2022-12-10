package work.caion.plugin.pixelmenu.type;

import lombok.Getter;

@Getter
public enum EnumActionType {

    GIVE_ITEM("giveItem"),
    TAKE_ITEM("takeItem"),
    RUN_COMMAND("runCommand"),
    NONE("none"),
    ;

    private String action;

    EnumActionType(String action) {
        this.action = action;
    }

    public static EnumActionType getEnum(String action) {
        for (EnumActionType e : EnumActionType.values()) {
            if (e.getAction().equals(action)) {
                return e;
            }
        }
        return null;
    }
}
