package com.mekelaina.gramarye.setup;

import com.mekelaina.gramarye.Gramarye;
import com.mekelaina.gramarye.blocks.ModBlocks;
import com.mekelaina.gramarye.blocks.containers.ModContainers;
import com.mekelaina.gramarye.blocks.screens.ObeliskScreen;
import com.mekelaina.gramarye.blocks.tiles.ChargerTile;
import com.mekelaina.gramarye.blocks.tiles.ModTileEntities;
import com.mekelaina.gramarye.client.render.ChargerTileEntityRenderer;
import com.mekelaina.gramarye.client.render.spells.FurnusTileEntityRenderer;
import com.mekelaina.gramarye.entities.DefaultSpellBoltRenderer;
import com.mekelaina.gramarye.entities.SpellBoltEntity;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Gramarye.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ModContainers.OBELISK_CONTAINER.get(), ObeliskScreen::new);

        //RenderingRegistry.registerEntityRenderingHandler(SpellBoltEntity.class, DefaultSpellBoltRenderer::new);

        ClientRegistry.bindTileEntityRenderer(ModTileEntities.CHARGER_TILE.get(), ChargerTileEntityRenderer::new);
        FurnusTileEntityRenderer.register();

    }

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.CRYSTALBLOCK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BATTERY.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROADCASTER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CRYSTALLIZER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CHARGER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMBUINGPILLAR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.OBELISK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.SPELLTABLE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.TESSERACT.get(), RenderType.getTranslucent());
    }

    @SubscribeEvent
    public static void preTextureStitchEvent(TextureStitchEvent.Pre event) {
        if(!event.getMap().getTextureLocation().equals(AtlasTexture.LOCATION_BLOCKS_TEXTURE)) return;

        event.addSprite(FurnusTileEntityRenderer.FURNUS_INNER_CIRCLE);
        event.addSprite(FurnusTileEntityRenderer.FURNUS_OUTER_CIRCLE);
        event.addSprite(FurnusTileEntityRenderer.FURNUS_LOWER_CIRCLE);
        event.addSprite(FurnusTileEntityRenderer.FURNUS_UPPER_CIRCLE);
    }
}
