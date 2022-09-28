package com.xkball.hungry_in_peaceful_mode.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class MixinPlayer {
    
    @Redirect(method = "aiStep",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/food/FoodData;setFoodLevel(I)V"))
    public void onPeacefulAIStep(FoodData instance, int pFoodLevel){
    }
}
