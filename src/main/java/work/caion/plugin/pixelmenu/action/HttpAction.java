package work.caion.plugin.pixelmenu.action;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import cn.hutool.http.server.action.Action;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import work.caion.plugin.pixelcore.server.ServerAction;
import work.caion.plugin.pixelmenu.type.EnumHttpActionType;

import java.io.IOException;

public class HttpAction extends ServerAction {

    public HttpAction(String path) {
        super(path);
    }

    @Override
    public Action getAction() {
        return new Action() {
            @Override
            public void doAction(HttpServerRequest httpServerRequest, HttpServerResponse httpServerResponse) throws IOException {
                String body = httpServerRequest.getBody();
                JSONObject json = JSONUtil.parseObj(body);
                String action = json.getStr("action");
                EnumHttpActionType enumHttpActionType = EnumHttpActionType.valueOf(action);
                if (enumHttpActionType == EnumHttpActionType.UPDATE_MENU_SINGLE) {
                    JSONObject data = json.getJSONObject("shop");

                } else if (enumHttpActionType == EnumHttpActionType.UPDATE_MENU_ALL) {
                    // TODO
                } else if (enumHttpActionType == EnumHttpActionType.DELETE_MENU_SINGLE) {
                    // TODO
                } else if (enumHttpActionType == EnumHttpActionType.DELETE_MENU_ALL) {
                    // TODO
                }
            }
        };
    }
}
