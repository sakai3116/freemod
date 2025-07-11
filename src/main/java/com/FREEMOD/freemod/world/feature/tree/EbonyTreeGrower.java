package com.FREEMOD.freemod.world.feature.tree;

import com.FREEMOD.freemod.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class EbonyTreeGrower extends AbstractTreeGrower {
    @Override
    protected @Nullable Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
        return ModConfiguredFeatures.EBONY_SPAWN;
    }
}

