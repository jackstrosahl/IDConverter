package de.themoep.idconverter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class EnchantmentIdMappings
{
    public static final IdMappings.Mapping[] MAPPINGS = {
        new IdMappings.Mapping(0, "minecraft:protection"),
        new IdMappings.Mapping(1, "minecraft:fire_protection"),
        new IdMappings.Mapping(2, "minecraft:feather_falling"),
        new IdMappings.Mapping(3, "minecraft:blast_protection"),
        new IdMappings.Mapping(4, "minecraft:projectile_protection"),
        new IdMappings.Mapping(5, "minecraft:respiration"),
        new IdMappings.Mapping(6, "minecraft:aqua_affinity"),
        new IdMappings.Mapping(7, "minecraft:thorns"),
        new IdMappings.Mapping(8, "minecraft:depth_strider"),
        new IdMappings.Mapping(9, "minecraft:frost_walker"),
        new IdMappings.Mapping(10, "minecraft:binding_curse"),
        new IdMappings.Mapping(16, "minecraft:sharpness"),
        new IdMappings.Mapping(17, "minecraft:smite"),
        new IdMappings.Mapping(18, "minecraft:bane_of_arthropods"),
        new IdMappings.Mapping(19, "minecraft:knockback"),
        new IdMappings.Mapping(20, "minecraft:fire_aspect"),
        new IdMappings.Mapping(21, "minecraft:looting"),
        new IdMappings.Mapping(22, "minecraft:sweeping"),
        new IdMappings.Mapping(32, "minecraft:efficiency"),
        new IdMappings.Mapping(33, "minecraft:silk_touch"),
        new IdMappings.Mapping(34, "minecraft:unbreaking"),
        new IdMappings.Mapping(35, "minecraft:fortune"),
        new IdMappings.Mapping(48, "minecraft:power"),
        new IdMappings.Mapping(49, "minecraft:punch"),
        new IdMappings.Mapping(50, "minecraft:flame"),
        new IdMappings.Mapping(51, "minecraft:infinity"),
        new IdMappings.Mapping(61, "minecraft:luck_of_the_sea"),
        new IdMappings.Mapping(62, "minecraft:lure"),
        new IdMappings.Mapping(65, "minecraft:loyalty"),
        new IdMappings.Mapping(66, "minecraft:impaling"),
        new IdMappings.Mapping(67, "minecraft:riptide"),
        new IdMappings.Mapping(68, "minecraft:channeling"),
        new IdMappings.Mapping(70, "minecraft:mending"),
        new IdMappings.Mapping(71, "minecraft:vanishing_curse"),
    };

    private final static Map<String, IdMappings.Mapping> BY_NUMERIC_ID = new HashMap<>();
    private final static Map<String, IdMappings.Mapping> BY_LEGACY_NAME = new HashMap<>();
    private final static Map<String, IdMappings.Mapping> BY_FLATTENING_NAME = new HashMap<>();

    static {
        Util.populateMaps(MAPPINGS, BY_NUMERIC_ID, BY_LEGACY_NAME, BY_FLATTENING_NAME);
    }

    public static IdMappings.Mapping get(IdMappings.IdType type, String id) {
        switch (type) {
            case NUMERIC:
                return getById(id);
            case LEGACY:
                return getByLegacyType(id);
            case FLATTENING:
                return getByFlatteningType(id);
            default:
                throw new IllegalArgumentException(type + " is not a valid map type.");
        }
    }

    public static IdMappings.Mapping getById(String id) {
        return BY_NUMERIC_ID.get(id.toUpperCase(Locale.ENGLISH));
    }

    public static IdMappings.Mapping getByLegacyType(String oldType) {
        return BY_LEGACY_NAME.get(oldType.toUpperCase(Locale.ENGLISH));
    }

    public static IdMappings.Mapping getByFlatteningType(String flatteningType) {
        return BY_FLATTENING_NAME.get(flatteningType.toUpperCase(Locale.ENGLISH));
    }
}
