package com.mekelaina.gramarye.client.render.spells;

import com.mekelaina.gramarye.Gramarye;
import com.mekelaina.gramarye.blocks.spellblocks.tiles.FurnusTile;
import com.mekelaina.gramarye.blocks.spellblocks.tiles.SpellTileEntities;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.pipeline.BakedQuadBuilder;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class FurnusTileEntityRenderer extends TileEntityRenderer<FurnusTile> {
    public static final ResourceLocation FURNUS_INNER_CIRCLE = new ResourceLocation(Gramarye.MODID, "block/spells/furnus_inner_circle");
    public static final ResourceLocation FURNUS_OUTER_CIRCLE = new ResourceLocation(Gramarye.MODID, "block/spells/furnus_outer_circle");
    public static final ResourceLocation FURNUS_UPPER_CIRCLE = new ResourceLocation(Gramarye.MODID, "block/spells/furnus_upper_circle");
    public static final ResourceLocation FURNUS_LOWER_CIRCLE = new ResourceLocation(Gramarye.MODID, "block/spells/furnus_lower_circle");

    public FurnusTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    private void addVertex(IVertexBuilder renderer, MatrixStack stack, float x, float y, float z, float u, float v) {
        renderer.pos(stack.getLast().getMatrix(), x, y, z)
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(u, v)
                .lightmap(0, 240)
                .normal(1, 0, 0 )
                .endVertex();
    }

    private void addFlatSpriteQuad(IVertexBuilder renderer, MatrixStack stack, TextureAtlasSprite sprite, float height) {
        createFrontFaceVerticies(renderer, stack, sprite, height);

        addVertex(renderer, stack, 1, height, 0, sprite.getMinU(), sprite.getMinV());
        addVertex(renderer, stack, 1, height, 1, sprite.getMinU(), sprite.getMaxV());
        addVertex(renderer, stack, 0, height, 1, sprite.getMaxU(), sprite.getMaxV());
        addVertex(renderer, stack, 0, height, 0, sprite.getMaxU(), sprite.getMinV());
    }

    private void createFrontFaceVerticies(IVertexBuilder renderer, MatrixStack stack, TextureAtlasSprite sprite, float height) {
        addVertex(renderer, stack, 0, height, 0, sprite.getMaxU(), sprite.getMinV());
        addVertex(renderer, stack, 0, height, 1, sprite.getMaxU(), sprite.getMaxV());
        addVertex(renderer, stack, 1, height, 1, sprite.getMinU(), sprite.getMaxV());
        addVertex(renderer, stack, 1, height, 0, sprite.getMinU(), sprite.getMinV());
    }

    @Override
    public void render(FurnusTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        TextureAtlasSprite innerCircleSprite = Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE).apply(FURNUS_INNER_CIRCLE);
        TextureAtlasSprite outerCircleSprite = Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE).apply(FURNUS_OUTER_CIRCLE);
        TextureAtlasSprite upperCircleSprite = Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE).apply(FURNUS_UPPER_CIRCLE);
        TextureAtlasSprite lowerCircleSprite = Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE).apply(FURNUS_LOWER_CIRCLE);

        IVertexBuilder builder = bufferIn.getBuffer(RenderType.getTranslucent());

        //matrixStackIn.push();

        addFlatSpriteQuad(builder, matrixStackIn, innerCircleSprite, 0.4f);
        addFlatSpriteQuad(builder, matrixStackIn, outerCircleSprite, 0.3f );
        addFlatSpriteQuad(builder, matrixStackIn, upperCircleSprite, 0.5f);
        addFlatSpriteQuad(builder, matrixStackIn, lowerCircleSprite, 0.5f);

        //matrixStackIn.pop();
    }

    public static void register() {
        ClientRegistry.bindTileEntityRenderer(SpellTileEntities.FURNUS_TILE.get(), FurnusTileEntityRenderer::new);
    }
}
