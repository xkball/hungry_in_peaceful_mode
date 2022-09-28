package com.xkball.hungry_in_peaceful_mode.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodData.class)
public abstract class MixinFoodData {
    
    @Shadow private int foodLevel;
    
    @Shadow private float saturationLevel;
    
    @Inject(
            method = "tick",
            at = @At(value = "FIELD",target = "Lnet/minecraft/world/food/FoodData;exhaustionLevel:F",ordinal = 1))
    public void hipOnIfPeaceful(Player pPlayer, CallbackInfo ci){
        Difficulty difficulty = pPlayer.level.getDifficulty();
        if(difficulty == Difficulty.PEACEFUL && !(saturationLevel > 0.0F)){
            foodLevel = Math.max(foodLevel - 1, 0);
        }
    }

}
