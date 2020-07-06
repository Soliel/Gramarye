package com.mekelaina.gramarye.spell;

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
        return null;
    }
}
