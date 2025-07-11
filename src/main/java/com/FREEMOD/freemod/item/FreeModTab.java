package com.FREEMOD.freemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class FreeModTab {
    public static final CreativeModeTab FREEMOD_TAB = new CreativeModeTab("freemodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND_PICKAXE);
        }
    };

    //このようにクリエイティブタブを追加することもできる
//    public static final CreativeModeTab TUTORIAL_TAB2 = new CreativeModeTab("tutorialtab2") {
//        @Override
//        public ItemStack makeIcon() {
//            return new ItemStack(ModItems.CITRINE.get());
//        }
//    };
}
