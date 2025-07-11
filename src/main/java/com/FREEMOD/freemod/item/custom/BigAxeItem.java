//package com.FREEMOD.freemod.item.custom;
//
//import com.FREEMOD.freemod.item.FreeModTab;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResultHolder;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.SwordItem;
//import net.minecraft.world.item.Tiers;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.phys.AABB;
//
//import java.util.List;
//
////作成ファイル BigAxeItems, ModItems
//public class BigAxeItem extends SwordItem {
//    public BigAxeItem(){
//        super(Tiers.DIAMOND,6,-1.3F,new Properties().tab(FreeModTab.FREEMOD_TAB));
//    }
//
//    @Override
//    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
//        ItemStack itemStack = player.getItemInHand(hand);
//        if (!world.isClientSide()) {
//            // サーバー側での処理
//            int level = getLevel(itemStack); // 仮のレベル取得メソッド
//            double range = calculateAttackRange(level);
//            BlockPos center = player.blockPosition();
//            AABB boundingBox = new AABB(center).inflate(range, range, range);
//            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, boundingBox, entity -> entity != player);
//
//        }
//        return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide());
//    }
//
//    // 仮のレベル取得メソッド（実際のMODではNBTなどでレベルを管理する必要があります）
//    private int getLevel(ItemStack stack) {
//        // ここでは仮にItemStackのスタックサイズをレベルとして扱います
//        return stack.getCount();
//    }
//
//    // レベルに応じて攻撃範囲を計算するメソッド
//    private double calculateAttackRange(int level) {
//        // レベルが上がるほど範囲が広がるように設定
//        return 1.0 + (level * 0.5);
//    }
//}
