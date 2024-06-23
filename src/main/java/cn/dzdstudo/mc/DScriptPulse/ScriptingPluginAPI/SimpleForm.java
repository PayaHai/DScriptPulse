package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.geysermc.cumulus.util.FormImage;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

public class SimpleForm {
    private final org.geysermc.cumulus.form.SimpleForm.Builder formBuilder;

    /**
     * 构造
     */
    public SimpleForm() {
        this.formBuilder = org.geysermc.cumulus.form.SimpleForm.builder();
    }

    /**
     * 设置标题
     *
     * @param title 标题
     * @return this
     */
    public SimpleForm setTitle(String title) {
        this.formBuilder.title(title);
        return this;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     * @return this
     */
    public SimpleForm setContent(String content) {
        this.formBuilder.content(content);
        return this;
    }

    /**
     * 添加按钮
     *
     * @param text 按钮文本
     * @return this
     */
    public SimpleForm addButton(String text) {
        this.formBuilder.button(text);
        return this;
    }

    /**
     * 添加按钮
     *
     * @param text 按钮文本
     * @param img  按钮图片
     * @return this
     */
    public SimpleForm addButton(String text, String img) {
        // 判断是否为 URL
        if (img.startsWith("http://") || img.startsWith("https://")) {
            this.formBuilder.button(text, FormImage.Type.URL, img);
        } else {
            this.formBuilder.button(text, FormImage.Type.PATH, img);
        }

        return this;
    }

    /**
     * 绑定点击按钮回调
     *
     * @param callback 回调
     * @return this
     */
    public SimpleForm onClick(Consumer<Integer> callback) {
        this.formBuilder.validResultHandler(result -> callback.accept(result.clickedButtonId()));
        return this;
    }

    /**
     * 绑定关闭表单回调
     *
     * @param callback 回调
     * @return this
     */
    public SimpleForm onClose(Consumer<Integer> callback) {
        this.formBuilder.closedOrInvalidResultHandler(player -> callback.accept(-1));
        return this;
    }

    /**
     * 发送表单
     * @param pl 玩家
     * @return 是否成功
     */
    public boolean send(Player pl) {
        // FloodgateApi
        FloodgateApi floodgateApi = FloodgateApi.getInstance();

        return floodgateApi.sendForm(UUID.fromString(pl.getUUID()), this.formBuilder.build());
    }
}
