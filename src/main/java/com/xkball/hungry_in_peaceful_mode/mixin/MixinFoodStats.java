package com.xkball.hungry_in_peaceful_mode.mixin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.FoodStats;
import net.minecraft.world.EnumDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodStats.class)
public class MixinFoodStats {
    
    
    @Shadow private float foodSaturationLevel;
    
    @Shadow private int foodLevel;
    
    @Inject(
            method = "onUpdate",
            at = @At(value = "FIELD",target = "Lnet/minecraft/util/FoodStats;foodExhaustionLevel:F",ordinal = 1)
    )
    public void hipOnIfPeaceful(EntityPlayer player, CallbackInfo ci){
        EnumDifficulty difficulty = player.world.getDifficulty();
        if(difficulty == EnumDifficulty.PEACEFUL && !(foodSaturationLevel> 0.0F)){
            foodLevel = Math.max(foodLevel - 1, 0);
        }
    }
}
