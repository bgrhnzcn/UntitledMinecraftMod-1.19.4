package org.bgrhnzcn.untitledminecraftmod.block;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bgrhnzcn.untitledminecraftmod.UntitledMinecraftMod;
import org.bgrhnzcn.untitledminecraftmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    //Registery for blocks.
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UntitledMinecraftMod.MOD_ID);

    //This part adds blocks
    public static final RegistryObject<Block> TEST_INGOT_BLOCK = registerBlock("test_ingot_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TEST_ORE = registerBlock("test_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()));

    //Helper methods with generics.
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registeryBlockItem(name,toReturn);
        return toReturn;
    }
    private static  <T extends Block> RegistryObject<Item> registeryBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().fireResistant()));/*fire res test?*/
    }
    //Basic register() method.
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
