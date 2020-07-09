package com.mekelaina.gramarye.spell;

import com.mekelaina.gramarye.blocks.spellblocks.SpellBlocks;
import com.mekelaina.gramarye.util.SpellUtil;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.ActionResultType;

public class SpellFurnus extends Spell {
    public SpellFurnus() {
        super(new Properties()
                .setManaCost(20)
                .setSpellElement(ESpellElement.Fire)
                .setSpellLevel(ESpellLevel.Apprentice)
                .setRegistryName("furnus")
                .setSpellEnglishName("Furnus")
        );
    }

    @Override
    public SpellCastResult onSpellCast(SpellCastContext spellContext) {
        BlockItemUseContext blockContext = new BlockItemUseContext(spellContext.parentContext);
        SpellUtil.placeBlock(blockContext, SpellBlocks.FURNUS.get());
        return new SpellCastResult(ActionResultType.SUCCESS);
    }
}
