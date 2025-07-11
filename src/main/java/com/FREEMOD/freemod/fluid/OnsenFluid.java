////温泉　水中にいる時、水中呼吸＆体力増強を付与
//package com.FREEMOD.freemod.fluid;
//
//import com.FREEMOD.freemod.FreeMod;
//import com.FREEMOD.freemod.block.ModBlocks;
//import com.FREEMOD.freemod.item.ModItems;
//import net.minecraft.core.BlockPos;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.block.LiquidBlock;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.material.FlowingFluid;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraft.world.level.material.Material;
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fluids.FluidAttributes;
//import net.minecraftforge.fluids.ForgeFlowingFluid;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//public class OnsenFluid {
//    //水が静止したテクスチャ、流れる水、オーバーレイを参照する定数
//    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
//    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
//    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");
//
//    public static final DeferredRegister<Fluid> FLUIDS
//            = DeferredRegister.create(ForgeRegistries.FLUIDS, FreeMod.MOD_ID);
//
//    public static final RegistryObject<FlowingFluid> ONSEN_FLUID
//            = FLUIDS.register("onsen_fluid", () -> new ForgeFlowingFluid.Source(OnsenFluid.ONSEN_PROPERTIES));
//    public static final RegistryObject<FlowingFluid> ONSEN_FLOWING
//            = FLUIDS.register("onsen_flowing", () -> new ForgeFlowingFluid.Flowing(OnsenFluid.ONSEN_PROPERTIES));
//
//
//    public static final ForgeFlowingFluid.Properties ONSEN_PROPERTIES = new ForgeFlowingFluid.Properties(
//            () -> ONSEN_FLUID.get(), () -> ONSEN_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
//            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.WATER_AMBIENT).overlay(WATER_OVERLAY_RL)
//            .color(0xFF8FBC8F)).slopeFindDistance(4).levelDecreasePerBlock(1).canMultiply()// .canMultiplyが無限水源を可能にする（正確には隣接するところに増殖するかどうか）
//            .block(() -> OnsenFluid.ONSEN_BLOCK.get()).bucket(() -> ModItems.HOT_SPRING_BUCKET.get());
//    //0xFF8FBC8F:砂漠の水源 #32A598の配色が近い
//
//    public static final RegistryObject<LiquidBlock> ONSEN_BLOCK = ModBlocks.BLOCKS.register("onsen",
//            () -> new LiquidBlock(() -> OnsenFluid.ONSEN_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
//                    .noCollission().strength(100f).noDrops()));
//
//    public static void register(IEventBus eventBus) {
//        FLUIDS.register(eventBus);
//        MinecraftForge.EVENT_BUS.register(new HotSpringEventHandler());
//    }
//    // プレイヤーが温泉に浸かっているときの効果を付与する処理
//    public static class HotSpringEventHandler {
//        @SubscribeEvent
//        public void onPlayerTick(TickEvent.PlayerTickEvent event) {
//            Player player = event.player;
//
//            if (!player.level.isClientSide) {
//                // プレイヤーが温泉液体に触れているかどうかをチェック
//                BlockPos playerPos = player.blockPosition();
//                BlockState blockState = player.level.getBlockState(playerPos);
//
//                if (blockState.getBlock() == ONSEN_BLOCK.get()) {
//                    // プレイヤーが温泉にいる場合、効果を付与（例：体力回復）
//                    if (player.getHealth() < player.getMaxHealth()) {
//                        player.heal(0.1f);  // 毎ティック0.1の回復
//                    }
//                    // その他の効果も追加可能（例：水中呼吸、スピードアップなど）
//                    player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST,20,0));
//                    player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 0));  // 20ティックの間、耐性効果
//                }
//            }
//        }
//    }
//}
