////1-29最終作業ライン：アイテムを１スタック64までOk、浮遊、低速落下の効果確認　25-1-29
//package com.FREEMOD.freemod.item;
//
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.food.FoodProperties;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//
//public class ChorusFlyFruit extends Item {
//
//    public ChorusFlyFruit() {
//        super(new Properties().tab(FreeModTab.FREEMOD_TAB)
//                .food(new FoodProperties.Builder()
//                        .nutrition(1)
//                        .saturationMod(0.2F)
//                        .alwaysEat()
//                        .build()));
//    }
//
//    @Override
//    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
//        // 食べ物として使用された場合
//        if (stack.isEdible()) { // プレイヤーが食べ物を食べられる状態かを確認
//            // 食べる処理を行う
//
//            // 浮遊効果を追加
//            entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 3));
//            entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 3));
//
//            stack.shrink(1); // アイテムを消費
//
//            return stack;  // 使用後のアイテムスタックを返す（消費済み）
//        }
//
//        return stack; // 植えられなければアイテムは消費されず、スタックをそのまま返す
//    }
//}
//
//
//
///*
////AIで改善中　25-1-29　21：23
////package com.FREEMOD.freemod.item;
////
////import com.FREEMOD.freemod.main.FreeMod;
////import com.FREEMOD.freemod.regi.FreeModBlocks; // ここでブロックを参照
////import net.minecraft.world.effect.MobEffectInstance;
////import net.minecraft.world.effect.MobEffects;
////import net.minecraft.world.entity.player.Player;
////import net.minecraft.world.food.FoodProperties;
////import net.minecraft.world.item.Item;
////import net.minecraft.world.item.ItemStack;
////import net.minecraft.world.level.Level;
////import net.minecraft.world.InteractionHand;
////import net.minecraft.world.InteractionResultHolder;
////import net.minecraft.core.BlockPos;
////import net.minecraft.world.level.block.state.BlockState;
////
////public class ChorusFlyFruit extends Item {
////
////    public ChorusFlyFruit() {
////        super(new Properties().tab(FreeMod.FREEMOD_TAB)
////                .food(new FoodProperties.Builder()
////                        .nutrition(1)
////                        .saturationMod(0.2F)
////                        .build()));
////        this.setRegistryName("chorus_fly_fruit");
////    }
////
////    @Override
////    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
////        ItemStack stack = player.getItemInHand(hand);
////
////        // アイテムを使った際に食べ物として使用している場合の処理
////        if (player.canEat(false)) {  // プレイヤーが食べ物を食べられる状態かを確認
////            // 食べる処理を行う
////            player.getFoodData().eat(1, 0.2F); // 栄養と飽和度を手動で設定
////
////            // 浮遊効果を追加
////            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 3));  // 200ティック間、浮遊効果
////            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 2)); // 落下を遅くする効果
////
////            stack.shrink(1); // アイテムを消費
////
////            return InteractionResultHolder.success(stack);  // 成功を返す
////        }
////
////        // 植える処理: プレイヤーの向きに基づいてブロックを設置
////        BlockPos pos = player.blockPosition().relative(player.getDirection());
////        BlockState state = level.getBlockState(pos);
////
////        // 植えられる場所かの確認：空気であればChorusFlyPlantを設置
////        if (state.isAir()) {
////            // 新しい植物（ChorusFlyPlant）を設置
////            level.setBlock(pos, FreeModBlocks.CHORUS_FLY_PLANT.defaultBlockState(), 3);
////            stack.shrink(1); // アイテムを消費
////            return InteractionResultHolder.success(stack); // 成功を返す
////        }
////
////        return InteractionResultHolder.fail(stack); // 植えられなければ失敗
////    }
////
////}
//*/
///*
////アイテム動作はするがPLANTに植えれないため改善中　25-1-29　21：01
////package com.FREEMOD.freemod.item;
////
////import com.FREEMOD.freemod.main.FreeMod;
////import com.FREEMOD.freemod.regi.FreeModBlocks; // ここでブロックを参照
////import net.minecraft.world.effect.MobEffectInstance;
////import net.minecraft.world.effect.MobEffects;
////import net.minecraft.world.entity.player.Player;
////import net.minecraft.world.food.FoodProperties;
////import net.minecraft.world.item.Item;
////import net.minecraft.world.item.ItemStack;
////import net.minecraft.world.level.Level;
////import net.minecraft.world.InteractionHand;
////import net.minecraft.world.InteractionResultHolder;
////import net.minecraft.core.BlockPos;
////import net.minecraft.world.level.block.state.BlockState;
////
////public class ChorusFlyFruit extends Item {
////
////    public ChorusFlyFruit() {
////        super(new Properties().tab(FreeMod.FREEMOD_TAB)
////                .food(new FoodProperties.Builder()
////                        .nutrition(1)
////                        .saturationMod(0.2F)
////                        .build()));
////        this.setRegistryName("chorus_fly_fruit");
////    }
////
////    @Override
////    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
////        ItemStack stack = player.getItemInHand(hand);
////
////        // アイテムを使った際に食べ物として使用している場合の処理
////        if (player.canEat(false)) {  // プレイヤーが食べ物を食べられる状態かを確認
////            // 食べる処理を行う
////            player.getFoodData().eat(1, 0.2F); // 栄養と飽和度を手動で設定
////
////            // 浮遊効果を追加
////            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 3));  // 200ティック間、浮遊効果
////            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 2)); // 落下を遅くする効果
////
////            stack.shrink(1); // アイテムを消費
////
////            return InteractionResultHolder.success(stack);  // 成功を返す
////        }
////
////        // 植える処理: プレイヤーの向きに基づいてブロックを設置
////        BlockPos pos = player.blockPosition().relative(player.getDirection());
////        BlockState state = level.getBlockState(pos);
////
////        // 植えられる場所かの確認：空気であればChorusFlyPlantを設置
////        if (state.isAir()) {
////            // 新しい植物（ChorusFlyPlant）を設置
////            level.setBlock(pos, FreeModBlocks.CHORUS_FLY_PLANT.defaultBlockState(), 3);
////            stack.shrink(1); // アイテムを消費
////            return InteractionResultHolder.success(stack); // 成功を返す
////        }
////
////        return InteractionResultHolder.fail(stack); // 植えられなければ失敗
////    }
////}
//*/
///*
//////コーラスプラントのみ植えれるはず...　25-1-29　14：04
////package com.FREEMOD.freemod.item;
////
////import com.FREEMOD.freemod.main.FreeMod;
////import com.FREEMOD.freemod.regi.FreeModBlocks; // ここでブロックを参照
////import net.minecraft.world.effect.MobEffectInstance;
////import net.minecraft.world.effect.MobEffects;
////import net.minecraft.world.entity.player.Player;
////import net.minecraft.world.food.FoodProperties;
////import net.minecraft.world.item.Item;
////import net.minecraft.world.item.ItemStack;
////import net.minecraft.world.level.Level;
////import net.minecraft.world.InteractionHand;
////import net.minecraft.world.InteractionResultHolder;
////import net.minecraft.core.BlockPos;
////import net.minecraft.world.level.block.state.BlockState;
////
////public class ChorusFlyFruit extends Item {
////
////    public ChorusFlyFruit() {
////        super(new Properties().tab(FreeMod.FREEMOD_TAB)
////                .food(new FoodProperties.Builder()
////                        .nutrition(1)
////                        .saturationMod(0.2F)
////                        .build()));
////        this.setRegistryName("chorus_fly_fruit");
////    }
////
////    @Override
////    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
////        ItemStack stack = player.getItemInHand(hand);
////
////        // アイテムを使った際に食べ物として使用している場合の処理
////        if (player.canEat(false)) {  // プレイヤーが食べ物を食べられる状態かを確認
////            // 食べる処理を行う
////            player.getFoodData().eat(1, 0.2F); // 栄養と飽和度を手動で設定
////
////            // 浮遊効果を追加
////            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 3));  // 200ティック間、浮遊効果
////            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 2)); // 落下を遅くする効果
////
////            stack.shrink(1); // アイテムを消費
////
////            return InteractionResultHolder.success(stack);  // 成功を返す
////        }
////
////        // 植える処理: プレイヤーの向きに基づいてブロックを設置
////        BlockPos pos = player.blockPosition().relative(player.getDirection());
////        BlockState state = level.getBlockState(pos);
////
////        // 植えられる場所かの確認：ChorusFlyPlantBlockのみを設置
////        if (state.isAir()) {
////            // 新しい植物（ChorusFlyPlant）を設置
////            level.setBlock(pos, FreeModBlocks.CHORUS_FLY_PLANT.defaultBlockState(), 3);
////            stack.shrink(1); // アイテムを消費
////            return InteractionResultHolder.success(stack); // 成功を返す
////        }
////
////        return InteractionResultHolder.fail(stack); // 植えられなければ失敗
////    }
////}
//*/
//
//
//
