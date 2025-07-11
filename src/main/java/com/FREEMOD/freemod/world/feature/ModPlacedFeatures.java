package com.FREEMOD.freemod.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures {
    //part 32 木の生成場所など
    public static final Holder<PlacedFeature> EBONY_PLACED = PlacementUtils.register("ebony_placed",
            ModConfiguredFeatures.EBONY_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3,0.1F,2)));
    //おそらくチャンクあたりの木の生成数を指定するもの。0.1F＝10％で生成確率

//    //part 33　花の生成場所など
//    public static final Holder<PlacedFeature> PINK_ROSE_PLACED = PlacementUtils.register("pink_rose_placed",
//            ModConfiguredFeatures.PINK_ROSE, RarityFilter.onAverageOnceEvery(16), //バラのフィルターが16ごとに配置されている？
//            InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
//    //バニラと同じ設定
//
    //part 34 鉱石の自動生成
//    public static final Holder<PlacedFeature> CITRINE_ORE_PLACED = PlacementUtils.register("citrine_ore_placed",
//            ModConfiguredFeatures.CITRINE_ORE,ModOrePlacement.commonOrePlacement(7,// VeinsPerChunk
//                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

}
