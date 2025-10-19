package com.github.stellarwind22.meatminer.mixin;

import com.github.stellarwind22.meatminer.object.MeatLike;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FlowingFluid.class)
public class FlowingFluidMixin {

    @SuppressWarnings("deprecation")
    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(ServerLevel serverLevel, BlockPos blockPos, BlockState blockState, FluidState fluidState, CallbackInfo ci) {
        FlowingFluid self = (FlowingFluid) (Object) this;
        
        if(self.is(FluidTags.LAVA)) {

            for(BlockPos pos : BlockPos.betweenClosed(blockPos.offset(1, 1, 1), blockPos.offset(-1, -1, -1))) {
                meatminer$handleMeat(serverLevel, pos);
            }
        }
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Unique
    private void meatminer$handleMeat(ServerLevel serverLevel, BlockPos pos) {
        var blockState = serverLevel.getBlockState(pos);
        if(blockState.getBlock() instanceof MeatLike meatLike) {
            if(meatLike.isRaw()) {
                serverLevel.setBlockAndUpdate(pos, meatLike.cookedVersion().get().get().withPropertiesOf(blockState));
                serverLevel.levelEvent(1501, pos, 0); //Fizz event
            }
        }
    }
}
