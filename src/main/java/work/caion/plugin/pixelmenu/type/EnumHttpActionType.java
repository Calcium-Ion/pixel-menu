package work.caion.plugin.pixelmenu.type;

import lombok.Getter;

@Getter
public enum EnumHttpActionType {

    UPDATE_MENU_SINGLE("updateMenuSingle"),
    UPDATE_MENU_ALL("updateMenuAll"),
    DELETE_MENU_SINGLE("deleteMenuSingle"),
    DELETE_MENU_ALL("deleteMenuAll");
    ;

    private String action;

    EnumHttpActionType(String action) {
        this.action = action;
    }
}
