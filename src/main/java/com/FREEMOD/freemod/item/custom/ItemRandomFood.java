//package com.FREEMOD.freemod.item;
//
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TranslatableComponent;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.food.FoodProperties;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.TooltipFlag;
//import net.minecraft.world.level.Level;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.List;
//import java.util.Random;
//
//public class ItemRandomFood extends Item {
//
//    private static final Random random = new Random();
//
//    private static final MobEffectInstance[] EFFECTS = {
//            //バフ一覧
//            new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 4), //攻撃力上昇 60秒
//            new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,2400,4), //耐性向上 120秒
//            new MobEffectInstance(MobEffects.HEAL,600,4), //再生能力 30秒
//            new MobEffectInstance(MobEffects.JUMP,1200,4), //跳躍力上昇 60秒
//            new MobEffectInstance(MobEffects.LUCK,2400,4), //幸運 120秒
//            new MobEffectInstance(MobEffects.NIGHT_VISION,6000,4), //暗視 300秒
//            new MobEffectInstance(MobEffects.ABSORPTION,3000,4), //衝撃力 150秒
//            new MobEffectInstance(MobEffects.MOVEMENT_SPEED,1200,4), //移動速度上昇 60秒
//
//
//            //デバフ一覧
//            new MobEffectInstance(MobEffects.BAD_OMEN,6000,4), //不吉な予感 300秒
//            new MobEffectInstance(MobEffects.UNLUCK,2400,4), //不運 120秒
//            new MobEffectInstance(MobEffects.WITHER,300,4), //衰弱 15秒
//            new MobEffectInstance(MobEffects.POISON,300,4), //毒 15秒
//            new MobEffectInstance(MobEffects.CONFUSION,600,4), //吐き気 30秒
//            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,600,4), //移動速度低下 30秒
//            //ここにさらに効果を追加
//    };
//    public ItemRandomFood() {
//        super(new Properties().tab(FreeModTab.FREEMOD_TAB)
//                .food(new FoodProperties.Builder()
//                        .nutrition(8)
//                        .saturationMod(0.8F)
//                        .alwaysEat()
//                        .build()));
//        this.setRegistryName("random_food");
//    }
//
//    @Override
//    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
//        super.appendHoverText(stack, world, tooltip, flag);
//        tooltip.add(new TranslatableComponent("ランダムでバフとデバフを付与する")); // ツールチップのテキスト
//    }
//    // 食べ物の効果の設定
//    @Override
//    public FoodProperties getFoodProperties() {
//        FoodProperties.Builder builder = new FoodProperties.Builder()
//                .nutrition(8)
//                .saturationMod(0.8F);
//        // 効果を一つランダムで摘出
//        MobEffectInstance randomEffect = getRandomEffect();
//        builder.effect(randomEffect, 1.0F); // 選ばれた効果を付与
//        return builder.build();
//    }
//    // 効果をランダムに付与する
//    private MobEffectInstance getRandomEffect() {
//        return EFFECTS[random.nextInt(EFFECTS.length)];
//    }
//}