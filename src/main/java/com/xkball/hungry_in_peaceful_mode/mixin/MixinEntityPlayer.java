package com.xkball.hungry_in_peaceful_mode.mixin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.FoodStats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer {

    @Redirect(method = "onLivingUpdate",
        at = @At(value = "INVOKE",target = "Lnet/minecraft/util/FoodStats;setFoodLevel(I)V"))
    public void hipOnPeacefulLivingUpdate(FoodStats instance, int foodLevelIn){
    }
}
