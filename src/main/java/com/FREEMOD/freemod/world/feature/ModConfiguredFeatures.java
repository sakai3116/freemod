package com.FREEMOD.freemod.world.feature;

import com.FREEMOD.freemod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModConfiguredFeatures {

    // 共通ロジックでエボニーの木の設定を生成
    private static Holder<ConfiguredFeature<TreeConfiguration, ?>> createEbonyTreeConfig(String name, int baseHeight, int heightRandA, int heightRandB, int foliageRadius, int foliageOffset, int foliageHeight) {
        return FeatureUtils.register(name, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
                new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB),
                BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(foliageRadius), ConstantInt.of(foliageOffset), foliageHeight),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirt(BlockStateProvider.simple(Blocks.DIRT)).build());
    }

    // 小・中・大の木の設定
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE_SMALL = createEbonyTreeConfig("ebony_small", 3, 2, 1, 2, 0, 2);
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE_NORMAL = createEbonyTreeConfig("ebony_normal", 3, 5, 2, 3, 0, 3);
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE_LARGE = createEbonyTreeConfig("ebony_large", 4, 4, 4, 5, 0, 4);

    // PlacedFeature（成長可能条件付き）
    private static Holder<PlacedFeature> createCheckedEbonyFeature(String name, Holder<ConfiguredFeature<TreeConfiguration, ?>> config) {
        return PlacementUtils.register(name, config,
                PlacementUtils.filteredByBlockSurvival(ModBlocks.EBONY_SAPLING.get()));
    }

    public static final Holder<PlacedFeature> EBONY_CHECKED_SMALL = createCheckedEbonyFeature("ebony_checked_small", EBONY_TREE_SMALL);
    public static final Holder<PlacedFeature> EBONY_CHECKED_NORMAL = createCheckedEbonyFeature("ebony_checked_normal", EBONY_TREE_NORMAL);
    public static final Holder<PlacedFeature> EBONY_CHECKED_LARGE = createCheckedEbonyFeature("ebony_checked_large", EBONY_TREE_LARGE);

    // ランダムに木を生成
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> EBONY_SPAWN =
            FeatureUtils.register("ebony_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(
                            new WeightedPlacedFeature(EBONY_CHECKED_SMALL, 0.3F),
                            new WeightedPlacedFeature(EBONY_CHECKED_NORMAL, 0.5F),
                            new WeightedPlacedFeature(EBONY_CHECKED_LARGE, 0.2F)
                    ), EBONY_CHECKED_NORMAL));
}


//package com.FREEMOD.freemod.world.feature;
//
//import com.FREEMOD.freemod.block.ModBlocks;
//import net.minecraft.core.Holder;
//import net.minecraft.data.worldgen.features.FeatureUtils;
//import net.minecraft.data.worldgen.features.OreFeatures;
//import net.minecraft.data.worldgen.placement.PlacementUtils;
//import net.minecraft.util.valueproviders.ConstantInt;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
//import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
//import net.minecraft.world.level.levelgen.feature.configurations.*;
//import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
//import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
//import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
//import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
//import net.minecraft.world.level.levelgen.placement.PlacedFeature;
//
//import java.util.List;
//
//
//public class ModConfiguredFeatures {
//
//    // 小さいエボニーの木の設定
//    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE_SMALL =
//            FeatureUtils.register("ebony_small", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                    BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
//                    new StraightTrunkPlacer(3, 2, 1), // 幹を短くする
//                    BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
//                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), // 葉の広がりと高さを小さくする
//                    new TwoLayersFeatureSize(1, 0, 2))
//                    .dirt(BlockStateProvider.simple(Blocks.DIRT)).build());
//
//    // 通常のエボニーの木の設定 (以前のEBONY_TREEと同じ)
//    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE_NORMAL =
//            FeatureUtils.register("ebony_normal", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                    BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
//                    new StraightTrunkPlacer(3, 5, 2),
//                    BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
//                    new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
//                    new TwoLayersFeatureSize(1, 0, 2))
//                    .dirt(BlockStateProvider.simple(Blocks.DIRT)).build());
//
//    // 大きいエボニーの木の設定
//    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE_LARGE =
//            FeatureUtils.register("ebony_large", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                    BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
//                    new StraightTrunkPlacer(4, 4, 4), // 幹を長くする
//                    BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
//                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 4), // 葉の広がりと高さを大きくする
//                    new TwoLayersFeatureSize(1, 0, 2))
//                    .dirt(BlockStateProvider.simple(Blocks.DIRT)).build());
//
//
//    // 各サイズの木に対応するPlacedFeature
//    public static final Holder<PlacedFeature> EBONY_CHECKED_SMALL = PlacementUtils.register("ebony_checked_small", EBONY_TREE_SMALL,
//            PlacementUtils.filteredByBlockSurvival(ModBlocks.EBONY_SAPLING.get()));
//
//    public static final Holder<PlacedFeature> EBONY_CHECKED_NORMAL = PlacementUtils.register("ebony_checked_normal", EBONY_TREE_NORMAL,
//            PlacementUtils.filteredByBlockSurvival(ModBlocks.EBONY_SAPLING.get()));
//
//    public static final Holder<PlacedFeature> EBONY_CHECKED_LARGE = PlacementUtils.register("ebony_checked_large", EBONY_TREE_LARGE,
//            PlacementUtils.filteredByBlockSurvival(ModBlocks.EBONY_SAPLING.get()));
//
//
//    // ランダムセレクターで複数のサイズの木をスポーンさせる
//    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> EBONY_SPAWN =
//            FeatureUtils.register("ebony_spawn", Feature.RANDOM_SELECTOR,
//                    new RandomFeatureConfiguration(List.of(
//                            new WeightedPlacedFeature(EBONY_CHECKED_SMALL, 0.3F), // 小さい木の生成確率
//                            new WeightedPlacedFeature(EBONY_CHECKED_NORMAL, 0.5F), // 通常の木の生成確率
//                            new WeightedPlacedFeature(EBONY_CHECKED_LARGE, 0.2F)  // 大きい木の生成確率
//                    ), EBONY_CHECKED_NORMAL)); // フォールバックとして通常サイズを指定
//
////    //part 33 FLOWER GENERATION
////    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PINK_ROSE =
////            FeatureUtils.register("flower_pink_rose", Feature.FLOWER,
////                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
////                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINK_ROSE.get())))));
//
////    //part 34 鉱石ブロック
////    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_CITRINE_ORES = List.of(
////            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CITRINE_ORE.get().defaultBlockState()),
////            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_CITRINE_ORE.get().defaultBlockState()));
//
////    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CITRINE_ORE = FeatureUtils.register("citrine_ore",
////            Feature.ORE, new OreConfiguration(OVERWORLD_CITRINE_ORES, 9)); //個々の数値は2か3未満はX
//
//}
