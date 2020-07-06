package com.mekelaina.gramarye.blocks.spellblocks.tiles;

import com.mekelaina.gramarye.Gramarye;
import com.mekelaina.gramarye.blocks.spellblocks.SpellBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpellTileEntities {
    public static final DeferredRegister<TileEntityType<?>> SPELL_TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Gramarye.MODID);

    public static final RegistryObject<TileEntityType<FurnusTile>> FURNUS_TILE = SPELL_TILE_ENTITIES.register("furnus", () ->
            TileEntityType.Builder.create(FurnusTile::new, SpellBlocks.FURNUS.get()).build(null));
}
