package com.mekelaina.gramarye.items;

import com.mekelaina.gramarye.Gramarye;
import com.mekelaina.gramarye.client.model.armor.GramaryanArmorBoots;
import com.mekelaina.gramarye.client.model.armor.GramaryanArmorChestpiece;
import com.mekelaina.gramarye.client.model.armor.GramaryanArmorCirclet;
import com.mekelaina.gramarye.client.model.armor.GramaryanArmorLeggings;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Gramarye.MODID);

    public static final RegistryObject<Item> WAND = ITEMS.register("wand", ()->
            new Wand(new Item.Properties().maxStackSize(1).group(Gramarye.setup.itemGroup)));
    public static final RegistryObject<Item> STAFF = ITEMS.register("oak_staff", () ->
            new Staff(new Item.Properties().maxStackSize(1).group(Gramarye.setup.itemGroup)));
    public static final RegistryObject<Item> CRYSTAL = ITEMS.register("crystal", () ->
            new Crystal(new Item.Properties().maxStackSize(64).group(Gramarye.setup.itemGroup)));
    public static final RegistryObject<Item> DEBUG = ITEMS.register("debug", ()->
            new DebugItem(new Item.Properties().maxStackSize(1).group(Gramarye.setup.itemGroup)));
    private static final RegistryObject<Item> GRAMARYAN_CIRCLET = ITEMS.register("gramaryan_circlet", ()->
            new GramaryanArmorItem(ArmorMaterial.DIAMOND, EquipmentSlotType.HEAD, new GramaryanArmorCirclet(),
                    new Item.Properties().maxStackSize(1).maxDamage(363).group(Gramarye.setup.itemGroup)));
    private static final RegistryObject<Item> GRAMARYAN_CHESTPIECE = ITEMS.register("gramaryan_chestpiece", ()->
            new GramaryanArmorItem(ArmorMaterial.DIAMOND, EquipmentSlotType.CHEST, new GramaryanArmorChestpiece(),
                    new Item.Properties().maxStackSize(1).maxDamage(528).group(Gramarye.setup.itemGroup)));
    private static final RegistryObject<Item> GRAMARYAN_LEGGINGS = ITEMS.register("gramaryan_leggings", ()->
            new GramaryanArmorItem(ArmorMaterial.DIAMOND, EquipmentSlotType.LEGS, new GramaryanArmorLeggings(),
                    new Item.Properties().maxStackSize(1).maxDamage(495).group(Gramarye.setup.itemGroup)));
    private static final RegistryObject<Item> GRAMARYAN_BOOTS = ITEMS.register("gramaryan_boots", ()->
            new GramaryanArmorItem(ArmorMaterial.DIAMOND, EquipmentSlotType.FEET, new GramaryanArmorBoots(),
                    new Item.Properties().maxStackSize(1).maxDamage(429).group(Gramarye.setup.itemGroup)));
}
