package bewis09.mixin;

import bewis09.util.FileReader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    @Inject(method = "init",at=@At("HEAD"))
    private void init(CallbackInfo ci) {
        boolean enabled = FileReader.getBoolean("fullbright");
        MinecraftClient.getInstance().options.getGamma().setValue(enabled ? FileReader.getByFirstIntFirst("Double","fullbrightvalue",0.1)*15 : 1);
    }
}
