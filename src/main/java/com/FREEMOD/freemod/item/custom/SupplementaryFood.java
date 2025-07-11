//package com.FREEMOD.freemod.item;
//
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.food.FoodProperties;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//
////  MOD アイテム名「補給食：Supplementary Food」
////・食べ物の効果はステーキと同等の8ポイントの回復と満腹度が0.8の回復
////・食べた際に10の体力回復が含まれている
////・食べる速度はデフォの1.6秒から0.5秒に変更
////・レシピはパンを作成しデフォの200チック（おそらく）から400チック＝20秒で焼けると完成する（通常の倍の時間）
//
//public class SupplementaryFood extends Item {
//    public SupplementaryFood() {
//        super(new Properties().tab(FreeModTab.FREEMOD_TAB)
//                .food(new FoodProperties.Builder()
//                        .nutrition(8)//食べたときに回復する体力（飢餓ゲージ）
//                        .saturationMod(0.8F)//食べた後の満腹感の回復量を0.8
//                        .alwaysEat()
//                        .build()));
//        this.setRegistryName("supplementary_food");
//    }
//
//    @Override
//    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
//        // entityがPlayerであるか確認
//        if(entity instanceof Player player){
//            // Player特有の処理をここで実行
//            super.finishUsingItem(stack,level,player);
//
//            // 例えば、プレイヤーに10のヘルスを回復させる
//            player.heal(10.0F);
//        }
//        // 基本の処理
//        return stack;
//    }
//
//    // 食べる速度を変更したい場合、アニメーションのスピードを変更するために以下のように設定
//    @Override
//    public int getUseDuration(ItemStack stack) {
//        // useDurationを短くすることで、食べる速度を速くする
//        return 10; // デフォルトの速度で食べるのにかかる時間（デフォルトは32チック＝約1.6秒）
//    }
//}
